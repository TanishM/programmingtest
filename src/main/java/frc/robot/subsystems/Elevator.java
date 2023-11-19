package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase{
    DigitalInput topSwitch; //using two limit switches to determine when to stop elevator at top and bottom
    DigitalInput bottomSwitch;

    private CANSparkMax leftMotor;
    private CANSparkMax rightMotor;
    boolean down;

    public Elevator() {
        topSwitch = new DigitalInput(3);
        bottomSwitch = new DigitalInput(4);
        leftMotor = new CANSparkMax(0, null);
        rightMotor = new CANSparkMax(1, null);
        down = true;
    }

    public void raiseOrLower() {
        if (down) {
            while (!topSwitch.get()) {
                leftMotor.set(0.5);
                rightMotor.set(0.5);
            }
            down = false;
        } else {
            while (!bottomSwitch.get()) {
                leftMotor.set(-0.5);
                rightMotor.set(-0.5);
            }
        }

    }

    @Override
    public void periodic() {
      
    }

    @Override
    public void simulationPeriodic() {
       
    }
}
