package org.firstinspires.ftc.teamcode.robot.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;


/**
 * This file is an example of how to define a mecanum drivetrain in your code.
 * It is structured in the same way as the ExampleSubsystem
 *
 * Different functions of the drivetrain have been defined, but not yet fully worked out
 */
public class ArmTest {

    //Declare motor and servo objects
    private DcMotorEx upperMotor;
    private DcMotorEx lowerMotor;

//    public static final double NEW_P = 10;
//    public static final double NEW_I = 0;
//    public static final double NEW_D = 0;
//    public static final double NEW_F = 0;




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
    public ArmTest(HardwareMap hardwareMap){
        /*
         * These lines of code links the DcMotors to the ports on the control/expansion hub
         * with the corresponding labels (deviceName)
         * This 'labeling' can be done on the Driver Station by clicking on the three dots
         * in the upper right corner and then going to 'Configure Robot'
         */
        upperMotor = hardwareMap.get(DcMotorEx.class, "motor1");
        lowerMotor =  hardwareMap.get(DcMotorEx.class, "motor0");

        /*
         * Normally a DC motors runs in the clockwise direction for positive values
         * If positive values need to correspond to counter clockwise rotation,
         * for example for a drivetrain, the motor can be reversed
         * Usually the left side of the drivetrain needs to be reversed,
         * but this should always be checked to be sure
         */

        /*
         * Tell the motors to use the integrated encoders
         * This gives a bit more precision while controlling the motors
         */
        upperMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lowerMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        upperMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lowerMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        lowerMotor.setDirection(DcMotorSimple.Direction.REVERSE);

//        PIDFCoefficients pidNew = new PIDFCoefficients(NEW_P, NEW_I, NEW_D, NEW_F);


//        lowerMotor.setPIDFCoefficients(DcMotor.RunMode.RUN_TO_POSITION, pidNew);
//        upperMotor.setPIDFCoefficients(DcMotor.RunMode.RUN_TO_POSITION, pidNew);

    }

    /*
     * After the constructor the functions of the subsystem can be defined.
     * The main function of a drivetrain is, of course, driving.
     * This has been defined below for different types of drivetrains
     */





    public void upperArmControl(){
        upperMotor.setTargetPosition(20);
        upperMotor.setPower(0.7);
        upperMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    public void lowerArmControl(){
        lowerMotor.setTargetPosition(20);
        lowerMotor.setPower(0.7);
        lowerMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    /**
     * Stop all motors of the drivetrain
     */
    public void stop(){
        upperMotor.setPower(0);
        lowerMotor.setPower(0);

    }
}
