package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.vuforia.HINT;
import com.vuforia.Vuforia;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;


@Autonomous(name = "Vuforia")
public class VuforiaDemo extends LinearOpMode
{
    
	private VuforiaLocalizer vuforiaLocalizer;
	private VuforiaLocalizer.Parameters parameters;
	private VuforiaTrackables visionTargets;
	private VuforiaTrackable target;
	private VuforiaTrackableDefaultListener listener;

	private OpenGLMatrix lastKnownLocation;
	private OpenGLMatrix phoneLocation;

	private static final String VUFORIA_KEY = "";

	private float robotX = 0;
	private float robotY = 0;
	private float robotAngle = 0;

	public void runOpMode() throws InterruptedException
	{
		setupVuforia();


		lastKnownLocation = createMatrix(0, 0, 0, 0, 0, 0);

		waitForStart();

		
		visionTargets.activate();

		while(opModeIsActive())
		{
	
			OpenGLMatrix latestLocation = listener.getUpdatedRobotLocation();

			
			if(latestLocation != null)
				lastKnownLocation = latestLocation;

			float[] coordinates = lastKnownLocation.getTranslation().getData();

			robotX = coordinates[0];
			robotY = coordinates[1];
			robotAngle = Orientation.getOrientation(lastKnownLocation, AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES).thirdAngle;

			
			telemetry.addData("Tracking " + target.getName(), listener.isVisible());
			telemetry.addData("Last Known Location", formatMatrix(lastKnownLocation));

			telemetry.update();
			idle();
		}
	}

	private void setupVuforia()
	{

		parameters = new VuforiaLocalizer.Parameters(R.id.cameraMonitorViewId);
		parameters.vuforiaLicenseKey = VUFORIA_KEY;
		parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
		parameters.useExtendedTracking = false;
		vuforiaLocalizer = ClassFactory.createVuforiaLocalizer(parameters);


		visionTargets = vuforiaLocalizer.loadTrackablesFromAsset("");
		Vuforia.setHint(HINT.HINT_MAX_SIMULTANEOUS_IMAGE_TARGETS, 4);

		target = visionTargets.get(0); 
		target.setName("");
		target.setLocation(createMatrix(0, 500, 0, 90, 0, 90));

	
		phoneLocation = createMatrix(0, 225, 0, 90, 0, 0);

		listener = (VuforiaTrackableDefaultListener) target.getListener();
		listener.setPhoneInformation(phoneLocation, parameters.cameraDirection);
	}

	
	private OpenGLMatrix createMatrix(float x, float y, float z, float u, float v, float w)
	{
		return OpenGLMatrix.translation(x, y, z).
				multiplied(Orientation.getRotationMatrix(
						AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES, u, v, w));
	}

	private String formatMatrix(OpenGLMatrix matrix)
	{
		return matrix.formatAsTransform();
	}
}
