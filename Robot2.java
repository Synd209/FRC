package frc.robot;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class Robot2 extends TimedRobot {
    PWMSparkMax __arm_motor;
    Encoder __arm_encoder;
    PIDController __pid_controller;

    static final double kP = 0.05;
    static final double kI = 0.0;
    static final double kD = 0.01;
    static final double __target__ang = 90.0; // Hedef açı (derece)
    static final double __dist_per_pulse = 0.15;

    @Override
    public void robotInit() {
        __arm_motor = new PWMSparkMax(2);
        __arm_encoder = new Encoder(0, 1);

        __arm_encoder.setDistancePerPulse(__dist_per_pulse);

        __pid_controller = new PIDController(kP, kI, kD);
        __pid_controller.setSetpoint(__target__ang); // Hedef açıyı belirle
    }

    @Override
    public void teleopPeriodic() {
      double currentAngle = __arm_encoder.getDistance();
      __arm_motor.set(__pid_controller.calculate(currentAngle));
    }
}
