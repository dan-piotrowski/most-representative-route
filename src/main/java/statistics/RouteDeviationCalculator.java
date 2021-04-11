package statistics;

import java.util.List;

public class RouteDeviationCalculator {

	private static final double DURATION_WEIGHT = 1.0;
	private static final double COUNT_WEIGHT = 0.25;
	private static final double SPEED_WEIGHT = 1.0;
	private static final double LONGITUDE_WEIGHT = 1.0;
	private static final double LATITUDE_WEIGHT = 1.0;
	private static final double PATH_WEIGHT = 1.0;
	
	public void updateRouteDeviationsFromAverage(List<RouteStatisticsWrapper> routeStatisticsWrappers,
			RouteStatistics routeStatistics) {
		for(RouteStatisticsWrapper rsw: routeStatisticsWrappers) {
			rsw.setDeviationFromAverage(calculateRouteDeviationFromAverage(rsw, routeStatistics));
		}
	}
	
	private double calculateRouteDeviationFromAverage(RouteStatisticsWrapper rsw,
			RouteStatistics routeStatistics) {
		
		double durationNormDev = calculateNormalizedDeviation(rsw.getRoute().getLegDuration(), 
				routeStatistics.getAvgDuration());
		double countNormDev = calculateNormalizedDeviation(rsw.getRoute().getCount(), 
				routeStatistics.getAvgCount());
		double speedNormDev = calculateNormalizedDeviation(rsw.getAvgRouteSpeed(), 
				routeStatistics.getAvgSpeed());
		double longitudeNormDev = calculateNormalizedDeviation(rsw.getAvgRouteLongitude(), 
				routeStatistics.getAvgLongitude());
		double latitudeNormDev = calculateNormalizedDeviation(rsw.getAvgRouteLatitude(), 
				routeStatistics.getAvgLatitude());
		double pathNormDev = calculateNormalizedDeviation(rsw.getRoutePath(), 
				routeStatistics.getAvgPath());
		
		return DURATION_WEIGHT * durationNormDev
				+ COUNT_WEIGHT * countNormDev
				+ SPEED_WEIGHT * speedNormDev
				+ LONGITUDE_WEIGHT * longitudeNormDev
				+ LATITUDE_WEIGHT * latitudeNormDev
				+ PATH_WEIGHT * pathNormDev;
	}
	
	private double calculateNormalizedDeviation(double value, double average) {
		return Math.abs(average - value) / average;
	}
}
