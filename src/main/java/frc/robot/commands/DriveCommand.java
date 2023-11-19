package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.drivetrain;

public class DriveCommand extends CommandBase{

    DoubleSupplier mX_supp;
    DoubleSupplier mY_supp;
    drivetrain m_drivetrain;

    public DriveCommand(drivetrain drivetrain, DoubleSupplier y_supp, DoubleSupplier x_supp) {
        mX_supp = x_supp;
        mY_supp = y_supp;
        m_drivetrain = drivetrain;
    }

    @Override
    public void initialize() {

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_drivetrain.drive(mY_supp.getAsDouble(), mX_supp.getAsDouble());
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
