package model;

import java.util.List;

import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByName;

import csv.TextToPoint;

public class Route {

	@CsvBindByName
	private String id;
	@CsvBindByName(column = "from_seq")
	private String fromSeq;
	@CsvBindByName(column = "to_seq")
	private String toSeq;
	@CsvBindByName(column = "from_port")
	private String fromPort;
	@CsvBindByName(column = "to_port")
	private String toPort;
	@CsvBindByName(column = "leg_duration")
	private long legDuration;
	@CsvBindByName(column = "count")
	private int count;
	@CsvBindAndSplitByName(elementType=Point.class, splitOn = "\\], \\[", converter = TextToPoint.class)
	private List<Point> points;
	
	public Route() {
	}
	
	@Override
	public String toString() {
		return "Route [id=" + id + ", fromSeq=" + fromSeq + ", toSeq=" + toSeq + ", fromPort=" + fromPort + ", toPort="
				+ toPort + ", legDuration=" + legDuration + ", count=" + count + "]";
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFromSeq() {
		return fromSeq;
	}
	public void setFromSeq(String fromSeq) {
		this.fromSeq = fromSeq;
	}
	public String getToSeq() {
		return toSeq;
	}
	public void setToSeq(String toSeq) {
		this.toSeq = toSeq;
	}
	public String getFromPort() {
		return fromPort;
	}
	public void setFromPort(String fromPort) {
		this.fromPort = fromPort;
	}
	public String getToPort() {
		return toPort;
	}
	public void setToPort(String toPort) {
		this.toPort = toPort;
	}
	public long getLegDuration() {
		return legDuration;
	}
	public void setLegDuration(long legDuration) {
		this.legDuration = legDuration;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<Point> getPoints() {
		return points;
	}
	public void setPoints(List<Point> points) {
		this.points = points;
	}
}
