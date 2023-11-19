

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import frc.robot.commands.AutoCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.drivetrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.GyroSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.InstantCommand;


public class RobotContainer {
    private final drivetrain m_drivetrain = new drivetrain();
    private Joystick m_joystick = new Joystick(0);
    private GyroSubsystem m_gyro = new GyroSubsystem();
    private Elevator m_elevator = new Elevator();    

    private final AutoCommand m_autoCommand = new AutoCommand(m_drivetrain, m_gyro);

    public RobotContainer() {
      configureButtonBindings();
      m_drivetrain.setDefaultCommand(new DriveCommand(m_drivetrain, () -> m_joystick.getY(), () -> m_joystick.getX()));
    }

    private void configureButtonBindings() {
      new JoystickButton(m_joystick, 1).onTrue(new InstantCommand(() -> m_elevator.raiseOrLower())); //raising or lowering elevator when button press
    }

    public double getHeading() {
      return m_gyro.getHeading();
    }
    
    public Elevator getElevator() {
      return m_elevator;
    }
    
    public Command getAutonomousCommand() {
      
      return m_autoCommand;
    }
}
