package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="SimpleTele", group="Robot")
public class SimpleTele extends LinearOpMode {

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

            if(gamepad1.dpad_up) {
                moveStraight(1);
            }
            else if(gamepad1.dpad_down) {
                moveStraight(-1);
            }

            else if(gamepad1.dpad_right) {
                moveSide(1);
            }
            else if(gamepad1.dpad_left) {
                moveSide(-1);
            }

            else if(gamepad1.right_bumper) {
                moveTurn(1);
            }
            else if(gamepad1.left_bumper) {
                moveTurn(-1);
            }
            else {
                lf.setPower(0);
                rf.setPower(0);
                lb.setPower(0);
                rb.setPower(0);
            }

        }

    }
}
