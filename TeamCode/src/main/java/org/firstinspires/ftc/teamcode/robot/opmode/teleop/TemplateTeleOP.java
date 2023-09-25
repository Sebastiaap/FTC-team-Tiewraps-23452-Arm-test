package org.firstinspires.ftc.teamcode.robot.opmode.teleop;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.lib.geometry.Rotation2d;
import org.firstinspires.ftc.teamcode.lib.kinematics.ChassisSpeeds;
import org.firstinspires.ftc.teamcode.robot.subsystem.ExampleMecanumDrivetrain;
import org.firstinspires.ftc.teamcode.robot.subsystem.ExampleSubsystem;
import org.firstinspires.ftc.teamcode.robot.subsystem.ExampleTankDrivetrain;

/**
 * This file is a template for an "OpMode".
 * An OpMode is a 'program' that runs in either the autonomous or the teleop period of an FTC match.
 * The names of OpModes appear on the menu of the FTC Driver Station.
 * When a selection is made from the menu, the corresponding OpMode
 * is put on the Robot Controller and executed.
 *
 * This particular OpMode contains a template to structure your code with subsystems.
 *
 */

/*
* After the @TeleOp, the name of the TeleOP is defined which is displayed on the Driver Station
* The group can be filled in to group different Opmodes on the phone
* The // before @Disabled can be removed to hide the Opmode on the Driver Station
 */
@TeleOp(name="Template TeleOP", group="Iterative Opmode")
//@Disabled
public class TemplateTeleOP extends OpMode
{
    // Declare timer to keep track of how long the program has been running
    private final ElapsedTime runtime = new ElapsedTime();

    /*
    * Declare subsystems
    * This means that we will say that certain subsystems exist and give them a name,
    * but not yet create them, this will happen in the init() function.
     */
    private ExampleSubsystem exampleSubsystem;
    private ExampleMecanumDrivetrain exampleMecanumDrivetrain;
    private ExampleTankDrivetrain exampleTankDrivetrain;

    /**
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        // Telemetry.addData is used to display variables and text on the Driver Station
        telemetry.addData("Status", "Initializing");

        /*
         * Create all the subsystems
         * Go to the folder 'subsystems' to view the subsystems, which contain more information
         */
        exampleSubsystem = new ExampleSubsystem(hardwareMap);
        exampleMecanumDrivetrain = new ExampleMecanumDrivetrain(hardwareMap);
        exampleTankDrivetrain = new ExampleTankDrivetrain(hardwareMap);

        // Tell the driver that initialization is complete via the Driver Station
        telemetry.addData("Status", "Initialized");
    }

    /**
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
    }

    /**
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        // Restart the timer
        runtime.reset();
    }

    /**
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {

        /*
         * Execute the functions of the example subsystem based on controller input
         */

        //If a is pressed on the 1st controller, the example subsystem has to execute the function 'flipDown'
        if (gamepad1.a){
            exampleSubsystem.flipDown();
        }
        //If a is not pressed, but b is pressed, the example subsystem has to execute the function 'flipUp'
        else if(gamepad1.b){
            exampleSubsystem.flipUp();
        }

        //The example subsystem also has a motor which can be set to a certain speed
        //This speed is determined by the left stick of the 2nd controller
        //The y position of the stick is the input of the function
        exampleSubsystem.setMotorSpeed(gamepad2.left_stick_y);

        /*
         * Several examples to control different drivetrains will be discussed below
         * Remember that you only need to use one way to control your drivetrain,
         * so you don't have to leave all examples in this file, you can delete the parts below
         * that you don't want to use
         */

        //Control the drivetrain using the two joysticks of the 1st controller
        //The ChassisSpeeds object will be used to store the desired speeds of the robot
        double forwardSpeed = gamepad1.left_stick_x;
        double sidewaysSpeed = -gamepad1.left_stick_y;  //Pushing the stick forward gives negative values, so the Y value should be inverted
        double rotationalSpeed = gamepad1.right_stick_x;
        ChassisSpeeds chassisSpeeds = new ChassisSpeeds(forwardSpeed, sidewaysSpeed, rotationalSpeed);

        //The chassisSpeeds can be used as input for the mecanumDrive function to control the drivetrain
        exampleMecanumDrivetrain.mecanumDrive(chassisSpeeds);

        //In the code above, the robot will drive forward if the stick is pushed forward,
        //but the robot can also be controlled relative to the field.
        //In that case, the robot will always move away from the driver if the joystick is pushed up,
        //no matter the orientation of the robot
        //To do this, the rotation of the robot must be known, luckily the Control Hub has a sensor
        //which can measure the angle of the robot, called the IMU
        //How exactly to read out the IMU can be found in the UTIL folder
        //How to use the Rotation2d object is also shown there
        //For now we will just take a random value (10 in this case)
        Rotation2d exampleRobotAngle = Rotation2d.fromDegrees(10);

        double xSpeed = gamepad1.left_stick_x;
        double ySpeed = -gamepad1.left_stick_y; //Pushing the stick forward gives negative values, so the Y value should be inverted
        double rotationalSpeed1 = gamepad1.right_stick_x;

        ChassisSpeeds chassisSpeedsFromFieldRelative = ChassisSpeeds.fromFieldRelativeSpeeds(xSpeed, ySpeed, rotationalSpeed1, exampleRobotAngle);

        //The ChassisSpeeds can now be used in the same way as before
        exampleMecanumDrivetrain.mecanumDrive(chassisSpeedsFromFieldRelative);

        //For a tank drivetrain, its a little bit easier
        //Here, we will use the left stick for forward/backward
        double forward = -gamepad1.left_stick_y; //Pushing the stick forward gives negative values, so the Y value should be inverted
        double rotation = gamepad1.right_stick_x;

        exampleTankDrivetrain.tankDrive(forward, rotation);

        // Show the elapsed game time and wheel power.
        telemetry.addData("Status", "Run Time: " + runtime.toString());
    }

    /**
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }

}
