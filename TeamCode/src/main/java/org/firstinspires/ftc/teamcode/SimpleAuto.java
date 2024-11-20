package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous (name="SimpleAuto", group="Robot")
public class SimpleAuto extends LinearOpMode {

    DcMotor lf, rf, lb, rb;


    public void moveStraight(double SPEED) {
        lf.setPower(SPEED);
        rf.setPower(SPEED);
        lb.setPower(SPEED);
        rb.setPower(SPEED);
    }

    public void moveSide(double SIDE_SPEED) {
        lf.setPower(SIDE_SPEED);
        rf.setPower(-SIDE_SPEED);
        lb.setPower(-SIDE_SPEED);
        rb.setPower(SIDE_SPEED);

    }

    public void moveTurn(double TURN_SPEED) {
        lf.setPower(TURN_SPEED);
        rf.setPower(-TURN_SPEED);
        lb.setPower(TURN_SPEED);
        rb.setPower(-TURN_SPEED);
    }

    @Override
    public void runOpMode() {
        lf = hardwareMap.get(DcMotor.class, "lf");
        rf = hardwareMap.get(DcMotor.class, "rf");
        lb = hardwareMap.get(DcMotor.class, "lb");
        rb = hardwareMap.get(DcMotor.class, "rb");

        waitForStart();
        while (opModeIsActive()) {

            moveStraight(0.5);
            sleep(1000);
            moveStraight(0);
            sleep(2000);
            moveTurn(1);
            sleep(500);
            moveTurn(0);
            sleep(2000);
            moveStraight(0.7);
            sleep(1000);
            moveStraight(0);
            sleep(2000);
            moveSide(0.8);
            sleep(1000);
            moveSide(0);
            sleep(5000);

        }
    }
}
