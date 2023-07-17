package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ExampleSubsystem {

    //Declare motor and servo objects
    private  DcMotor myMotor;
    private Servo myServo;

    //Define positions and other variables of the subsystem
    private double downPosition = 0.1;
    private double upPosition = 0.5;

    /**
     * This is the initializer of the subsystem
     * This is the function that will be run when the subsystem is created,
     * which happens at the beginning of the program.
     * The initializer should have the same name as the class (ExampleSubsystem in this case)
     *
     * @param hardwareMap This is the input of the initializer, which will be used
     *                    to link the motors and servos in the code to the motors and servos
     *                    on the actual robot
     */
    public ExampleSubsystem(HardwareMap hardwareMap){
        /*
        * This lines of code links the DcMotor 'myMotor' to the port on the control/expansion hub
        * labeled "motor1"
        * This 'labeling' can be done on the Driver Station by clicking on the three dots
        * in the upper right corner and then going to 'Configure Robot'
         */
        myMotor = hardwareMap.get(DcMotor.class, "motor1");

        /*
        * Normally a DC motors runs in the clockwise direction for positive values
        * If positive values need to correspond to counter clockwise rotation,
        * for example for a drivetrain, the motor can be reversed
         */
        myMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        // Servos can also be extracted from the hardwareMap similar to DC motors
        myServo = hardwareMap.get(Servo.class, "servo1");
    }

    /*
    * After the initializer the functions of the subsystem can be defined.
    * For this example subsystems the functions are:
    * flipDown,
    * flipUp,
    * setMotorSpeed
     */


    /**
     * Example of a function which moves a servo to a certain position
     */
    public void flipDown(){
        myServo.setPosition(downPosition);
    }

    /**
     * Example of a function which moves a servo to a certain position
     */
    public void flipUp(){
        myServo.setPosition(upPosition);
    }

    /**
     * Example of a function to set a motor to a certain speed
     *
     * @param speed Desired speed of the motor
     *              -1 corresponds to full power backwards
     *              1 corresponds to full power forwards
     */
    public void setMotorSpeed(double speed){
        myMotor.setPower(speed);
    }

}
