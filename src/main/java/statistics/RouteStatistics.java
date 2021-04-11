package statistics;

import java.util.List;

public class RouteStatistics {

	private double avgDuration;
	private double avgCount;
	private double avgSpeed;
	private double avgLongitude;
	private double avgLatitude;
	private double avgPath;
	
	public void initialize(List<RouteStatisticsWrapper> routeStatisticsWrappers) {
		double durationSum = 0;
		double countSum = 0;
		double speedSum = 0;
		double longitudeSum = 0;
		double latitudeSum = 0;
		double pathSum = 0;
		
		for(RouteStatisticsWrapper rsw: routeStatisticsWrappers) {
			durationSum += rsw.getRoute().getLegDuration();
			countSum += rsw.getRoute().getCount();
			speedSum += rsw.getAvgRouteSpeed();
			longitudeSum += rsw.getAvgRouteLongitude();
			latitudeSum += rsw.getAvgRouteLatitude();
			pathSum += rsw.getRoutePath();
		}
		
		int routeCount = routeStatisticsWrappers.size();
		avgDuration = durationSum / routeCount;
		avgCount = countSum / routeCount;
		avgSpeed = speedSum / routeCount;
		avgLongitude = longitudeSum / routeCount;
		avgLatitude = latitudeSum / routeCount;
		avgPath = pathSum / routeCount;
	}

	public double getAvgDuration() {
		return avgDuration;
	}

	public double getAvgCount() {
		return avgCount;
	}

	public double getAvgSpeed() {
		return avgSpeed;
	}

	public double getAvgLongitude() {
		return avgLongitude;
	}

	public double getAvgLatitude() {
		return avgLatitude;
	}

	public double getAvgPath() {
		return avgPath;
	}
}
