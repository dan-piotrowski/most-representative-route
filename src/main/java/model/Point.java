package model;

public class Point {

	private double longitude;
	private double latitude;
	private long timestamp;
	private double speed;
	
	public Point(double longitude, double latitude, long timestamp, double speed) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
		this.timestamp = timestamp;
		this.speed = speed;
	}
	
	public Point() {
	}
	
	@Override
	public String toString() {
		return "Point [longitude=" + longitude + ", latitude=" + latitude + ", timestamp=" + timestamp + ", speed="
				+ speed + "]";
	}

	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
}
