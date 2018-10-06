package org.firstinspires.ftc.teamcode;



import com.qualcomm.robotcore.eventloop.opmode.linearOpmode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;


@Autonomous (name = "Auton10620")
public class Auton10620 extends LinearOpMode
{
	private DcMotor motorLeft;
	private DcMotor motorRight;
	
	@override public void runOpMode() throws InteruptedException
	{
		
		motorLeft = hardware.dcmotor.get("motorLeft");
		motorRight = hardware.dcmotor.get("motorRight");
		
		motorLeft.setChannleMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODER);
		motorRight.setChannleMode(DcMotorController.RunMode.RUN_WITHOUT_ENCODER);
		
		motorLeft.setDirection(DcMotor.Direction.REVERSE);
		
		waitforstart();
		
		DriveForwardTime(DRIVE_POWER, 4000);
		TurnLeftTime(DRIVE_POWER, 500);
		DriveForwardTime(DRIVE_POWER, 4000);
		TurnRightTime(DRIVE_POWER, 500);
		DriveForwardTime(DRIVE_POWER, 4000);
		stopDriving();
		
		double DRIVE_POWER(1.0);
		
		public void DriveForward(double power);
		{
			motorLeft.setPower(power);
			motorRight.setPower(power);
		}
		
		public void DriveForwardTime(double power, long time) throws InterruptedException
		{
			DriveForward(power);
			Thread.sleep(time);
		}
		
		public void StopDriving()
		{
			DriveForward(0.0);
		}
		
		public void TurnLeft(double power);
		{
		 motorLeft.setPower(-power);
		 motorRight.setPower(power);
		}
		
		public void TurnLeftTime(double power, long time) throws InterruptedException
		{
			TurnLeft(power);
			Thread.sleep(time);
		}
		
		 public void DriveForward(double power);
		{
			motorLeft.setPower(power);
			motorRight.setPower(power);
		}
		
		public void DriveForwardTime(double power, long time) throws InterruptedException
		{
			DriveForward(power);
			Thread.sleep(time);
		}
		
		public void StopDriving()
		{
			DriveForward(0.0);
		}
		
		public void TurnRight(double power);
		{
		 motorLeft.setPower(power);
		 motorRight.setPower(-power);
		}
		
		public void TurnRightTime(double power, long time) throws InterruptedException
		{
			TurnRight(power);
			Thread.sleep(time);
		}
		
		 public void DriveForward(double power);
		{
			motorLeft.setPower(power);
			motorRight.setPower(power);
		}
		
		public void DriveForwardTime(double power, long time) throws InterruptedException
		{
			DriveForward(power);
			Thread.sleep(time);
		}
		
		public void StopDriving()
		{
			DriveForward(0.0);
		}
		
		while(OpModeisActive());
		{
			
			
			idle();
		}
	}
}
