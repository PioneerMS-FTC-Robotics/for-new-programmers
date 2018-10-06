package org.firstinspires.ftc.teamcode;



import com.qualcomm.robotcore.eventloop.opmode.linearOpmode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp (name = "TeleOp10620", group = "PioneerMiddleSchool")
public class TeleOp10620 extends LinearOpMode
{
	private DcMotor motorLeft;
	private DcMotor motorRight;
	private DcMotor hexMotor;
  
	@override
	public void runOpMode() throws InterruptedException
	{
		
		motorLeft = hardwaremap.dcmotor.get("motorLeft");
		motorRight = hardwaremap.dcmotor.get("motorRight");
    hexMotor = hardwaremap.dcmotor.get("hexMotor")
		
		motorLeft.setDirection(DcMotor.Direction.REVERSE);
		
		waitforstart();
		
		while(OpModeisActive())
		{
			
			motorLeft.setPower(-gamepad1.left_stick_y);
			motorRight.setPower(-gamepad1.left_stick_y);
			
			if(gamepad1.a)
			{
				motorLeft.setPower(0);
				motorRight.setPower(0);
			}
			
			if(gamepad1.y)
			{
				motorLeft.setPower(0.9);
				motorRight.setPower(0.9);
			}
			
			if(gamepad2.right_bumper)
			{
				hexMotor.setPower(0.8)
			}
			
			if(gamepad2.left_bumper)
			{
				hexMototr.setPower(-0.8);
			}



			
			idle();
		}
	}
}
