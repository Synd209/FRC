package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class Robot extends TimedRobot {
  DifferentialDrive __drive;
  Joystick __joystick;

  @Override
  public void robotInit() {
    __drive = new DifferentialDrive(new PWMSparkMax(0), new PWMSparkMax(1));
    __joystick = new Joystick(0);
  }

  @Override
  public void teleopPeriodic() {
    __drive.arcadeDrive(-__joystick.getY(), __joystick.getX());
  }
}
