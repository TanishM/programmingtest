

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;


public class drivetrain extends SubsystemBase {
    public CANSparkMax frontLeft;
    public CANSparkMax frontRight;
    public CANSparkMax backLeft;
    public CANSparkMax backRight;
    public MotorControllerGroup rightWheels;
    public MotorControllerGroup leftWheels;
    private DifferentialDrive differentialDriveTrain;

    public drivetrain() {
        frontLeft = new CANSparkMax(1, null);
        frontRight = new CANSparkMax(2, null);
        backLeft = new CANSparkMax(3, null);
        backRight = new CANSparkMax(4, null);
        rightWheels = new MotorControllerGroup(frontRight, backRight);
        leftWheels = new MotorControllerGroup(frontLeft, backLeft);

        differentialDriveTrain = new DifferentialDrive(leftWheels, rightWheels);  
    }

    @Override
    public void periodic() {
      
    }

    @Override
    public void simulationPeriodic() {
       
    }

    public void drive(double speed, double rotation) {
        differentialDriveTrain.arcadeDrive(speed, rotation);

    }
}
