package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.sensors.PigeonIMU;

public class GyroSubsystem extends SubsystemBase{
    private PigeonIMU gyroSensor;
    private double heading;

    public GyroSubsystem() {
        gyroSensor = new PigeonIMU(1);
        
    }
    @Override
    public void periodic() {
        heading = gyroSensor.getCompassHeading();
        
    }

    public double getHeading() {
        return heading;
    }
    @Override
    public void simulationPeriodic() {
       
    }
}
