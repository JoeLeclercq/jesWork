
public class DigitalSensor extends Sensor {
	public double error;
	public DigitalSensor(int portNumber) {
		super(portNumber);
		error = 0;
	}
	public void setError(double error) {
		this.error = error;
	}
	public double getError() {
		return error;
	}
}
