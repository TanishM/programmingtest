package frc.robot.commands;

import java.util.Timer;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drivetrain;
import frc.robot.subsystems.GyroSubsystem;

public class AutoCommand extends CommandBase{
    private drivetrain m_drivetrain;
    private GyroSubsystem m_gyro;

    public AutoCommand(drivetrain drivetrain, GyroSubsystem gyro) {
        m_drivetrain = drivetrain;
        m_gyro = gyro;
    }

    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis()-start <10000) {
            m_drivetrain.drive(1, 0);
        }
        double startHeading = m_gyro.getHeading();
        while(m_gyro.getHeading() - startHeading <90) {
            m_drivetrain.drive(0, 1);
        }

        
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}
