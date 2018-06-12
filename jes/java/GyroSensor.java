
public class GyroSensor extends DigitalSensor {
	private double drift;
	private long time;
	private double heading;
	public GyroSensor(double heading) {
		super(2);
		drift = 0;
		time = System.nanoTime();
		this.heading = heading;
	}
	public GyroSensor(double drift, double heading) {
		super(2);
		this.drift = drift;
		time = System.nanoTime();
		this.heading = heading;
	}
	public GyroSensor(int portNumber, double drift, double heading) {
		super(portNumber);
		this.drift = drift;
		time = System.nanoTime();
		this.heading = heading;
	}
	public GyroSensor(int portNumber, double heading) {
		super(portNumber);
		drift = 0;
		time = System.nanoTime();
		this.heading = heading;
	}
	public void reset(double heading) {
		time = System.nanoTime();
		this.heading = heading;
	}
	public double getHeading() {
		return heading;
	}
}
