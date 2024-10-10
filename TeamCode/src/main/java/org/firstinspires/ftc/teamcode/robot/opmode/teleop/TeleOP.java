package org.firstinspires.ftc.teamcode.robot.opmode.teleop;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.robot.subsystem.ArmTest;

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
*  After the @TeleOp, the name of the TeleOP is defined which is displayed on the Driver Station
* The group can be filled in to group different Opmodes on the phone
* The // before @Disabled can be removed to hide the Opmode on the Driver Station
 */
@TeleOp(name="TeleOP-intoTheDeep-", group="Iterative Opmode")
//@Disabled
public class TeleOP extends OpMode
{
    // Declare timer to keep track of how long the program has been running
    private final ElapsedTime runtime = new ElapsedTime();

    /*
    * Declare subsystems
    * This means that we will say that certain subsystems exist and give them a name,
    * but not yet create them, this will happen in the init() function.
     */
    private ArmTest armTest;

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
        armTest = new ArmTest(hardwareMap);

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
        // one revolution = 288 counts
        if (gamepad1.a) {armTest.upperArmControl();}
        if (gamepad1.b) {armTest.lowerArmControl();}



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
