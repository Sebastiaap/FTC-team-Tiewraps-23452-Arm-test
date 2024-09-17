package org.firstinspires.ftc.teamcode.robot.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;


/**
 * This file is an example of how to define a mecanum drivetrain in your code.
 * It is structured in the same way as the ExampleSubsystem
 *
 * Different functions of the drivetrain have been defined, but not yet fully worked out
 */
public class MecanumDrivetrain {

    //Declare motor and servo objects
    private DcMotor rightFront;
    private DcMotor leftFront;
    private DcMotor rightBack;
    private DcMotor leftBack;


    /**
     * This is the constructor of the subsystem
     * This is the function that will be run when the subsystem is created,
     * which happens at the beginning of an OpMode.
     * The constructor should have the same name as the class (ExampleMecanumDrivetrain in this case).
     *
     * @param hardwareMap This is the input of the constructor, which will be used
     *                    to link the motors and servos in the code to the motors and servos
     *                    on the actual robot
     */
    public MecanumDrivetrain(HardwareMap hardwareMap){
        /*
         * These lines of code links the DcMotors to the ports on the control/expansion hub
         * with the corresponding labels (deviceName)
         * This 'labeling' can be done on the Driver Station by clicking on the three dots
         * in the upper right corner and then going to 'Configure Robot'
         */
        rightFront = hardwareMap.get(DcMotor.class, "motor0");
        leftFront =  hardwareMap.get(DcMotor.class, "motor1");
        rightBack =  hardwareMap.get(DcMotor.class, "motor2");
        leftBack =  hardwareMap.get(DcMotor.class, "motor3");

        /*
         * Normally a DC motors runs in the clockwise direction for positive values
         * If positive values need to correspond to counter clockwise rotation,
         * for example for a drivetrain, the motor can be reversed
         * Usually the left side of the drivetrain needs to be reversed,
         * but this should always be checked to be sure
         */
        leftBack.setDirection(DcMotorSimple.Direction.REVERSE);
        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);

        /*
         * Tell the motors to use the integrated encoders
         * This gives a bit more precision while controlling the motors
         */
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    /*
     * After the constructor the functions of the subsystem can be defined.
     * The main function of a drivetrain is, of course, driving.
     * This has been defined below for different types of drivetrains
     */





    public void mecanumDrive(double x, double y, double rx){
        leftFront.setPower((y + x + rx));
        leftBack.setPower((y - x + rx));
        rightFront.setPower((y - x - rx));
        rightBack.setPower((y + x - rx));
    }
    /**
     * Stop all motors of the drivetrain
     */
    public void stop(){
        rightFront.setPower(0);
        leftFront.setPower(0);
        rightBack.setPower(0);
        leftBack.setPower(0);
    }
    public void setLeftBackSpeed(double speed){leftBack.setPower(speed);}
    public void setRightBackSpeed(double speed){rightBack.setPower(speed);}
    public void setLeftFrontSpeed(double speed){leftFront.setPower(speed);}
    public void setRightFrontSpeed(double speed){rightFront.setPower(speed);}
}
