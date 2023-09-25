package org.firstinspires.ftc.teamcode.robot.subsystem;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.lib.kinematics.ChassisSpeeds;


/**
 * This file is an example of how to define a tank drivetrain in your code.
 * It is structured in the same way as the ExampleSubsystem
 *
 * Different functions of the drivetrain have been defined, but not yet fully worked out
 */
public class ExampleTankDrivetrain {

    //Declare motor and servo objects
    private DcMotor rightMotor;
    private DcMotor leftMotor;


    /**
     * This is the constructor of the subsystem
     * This is the function that will be run when the subsystem is created,
     * which happens at the beginning of an OpMode.
     * The constructor should have the same name as the class (ExampleTankDrivetrain in this case).
     *
     * @param hardwareMap This is the input of the constructor, which will be used
     *                    to link the motors and servos in the code to the motors and servos
     *                    on the actual robot
     */
    public ExampleTankDrivetrain(HardwareMap hardwareMap){
        /*
         * These lines of code links the DcMotors to the ports on the control/expansion hub
         * with the corresponding labels (deviceName)
         * This 'labeling' can be done on the Driver Station by clicking on the three dots
         * in the upper right corner and then going to 'Configure Robot'
         */
        rightMotor = hardwareMap.get(DcMotor.class, "right_front");
        leftMotor =  hardwareMap.get(DcMotor.class, "left_front");

        /*
         * Normally a DC motors runs in the clockwise direction for positive values
         * If positive values need to correspond to counter clockwise rotation,
         * for example for a drivetrain, the motor can be reversed
         * Usually the left side of the drivetrain needs to be reversed,
         * but this should always be checked to be sure
         */
        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        /*
         * Tell the motors to use the integrated encoders
         * This gives a bit more precision while controlling the motors
         */
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    /*
     * After the constructor the functions of the subsystem can be defined.
     * The main function of a drivetrain is, of course, driving.
     * This has been defined below for different types of drivetrains
     */


    /**
     * Function to make the robot drive forward/backward and possibly rotate
     *
     * @param forwardSpeed How fast the robot needs to move forward (use negative speeds to go backward)
     * @param rotationSpeed How fast the robot needs to rotate (positive is clockwise)
     */
    public void tankDrive(double forwardSpeed, double rotationSpeed){

        // Calculate the motor speed for left and right based on the forward and rotation speed
        double rightPower = forwardSpeed - rotationSpeed;
        double leftPower = forwardSpeed + rotationSpeed;

        rightMotor.setPower(rightPower);
        leftMotor.setPower(leftPower);
    }

    /**
     * Stop all motors of the drivetrain
     */
    public void stop(){
        rightMotor.setPower(0);
        leftMotor.setPower(0);
    }
}
