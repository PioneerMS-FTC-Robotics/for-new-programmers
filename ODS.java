package org.firstinspires.ftc.teamcode;



import com.qualcomm.robotcore.eventloop.opmode.linearOpmode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.until.ElapsedTime


@TeleOp (name = "ODS10620", group = "PioneerMiddleSchool")
public class ODS10620 extends LinearOpMode
{
    OpticalDistanceSensor ods;

    
    @override
    public void runOpMode()
    {
        telemetry.addData("status", "initialized");
        telemetry.update();
        
        ods = hardwareMap.OpticalDisanceSensor.get("ods");
        
        waitforstart();
        runtime.reset
        
        while(OpModeisActive())
        {
            
            
            
            idle();
        }
    }
}
