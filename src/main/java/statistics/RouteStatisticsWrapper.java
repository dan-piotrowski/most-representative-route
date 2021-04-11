package statistics;

import java.util.List;
import java.util.stream.Collectors;

import model.Point;
import model.Route;

public class RouteStatisticsWrapper {

	private Route route;
	private double avgRouteLongitude;
	private double avgRouteLatitude;
	private double avgRouteSpeed;
	private double routePath;
	private double deviationFromAverage;
	
	public RouteStatisticsWrapper(Route route, double avgRouteLongitude, double avgRouteLatitude,
			double avgRouteSpeed, double routePath) {
		this.route = route;
		this.avgRouteLongitude = avgRouteLongitude;
		this.avgRouteLatitude = avgRouteLatitude;
		this.avgRouteSpeed = avgRouteSpeed;
		this.routePath = routePath;
	}

	public Route getRoute() {
		return route;
	}
	
	public double getAvgRouteLongitude() {
		return avgRouteLongitude;
	}
	
	public double getAvgRouteLatitude() {
		return avgRouteLatitude;
	}
	
	public double getAvgRouteSpeed() {
		return avgRouteSpeed;
	}

	public double getRoutePath() {
		return routePath;
	}

	public double getDeviationFromAverage() {
		return deviationFromAverage;
	}

	public void setDeviationFromAverage(double deviationFromAverage) {
		this.deviationFromAverage = deviationFromAverage;
	}
	
	public static List<RouteStatisticsWrapper> mapRoutesToRouteStatisticsWrappers(List<Route> routes){
		return routes
				.stream()
				.map(RouteStatisticsWrapper::mapRouteToRouteStatisticsWrapper)
				.collect(Collectors.toList());
	}
	
	private static RouteStatisticsWrapper mapRouteToRouteStatisticsWrapper(Route route) {
		double routeLongitudeSum = 0;
		double routeLatitudeSum = 0;
		double routeSpeedSum = 0;
		int pointCount = route.getCount();
		
		for(Point point: route.getPoints()) {
			routeLongitudeSum += point.getLongitude();
			routeLatitudeSum += point.getLatitude();
			routeSpeedSum += point.getSpeed();
		}
		
		double routeAvgSpeed = routeSpeedSum / pointCount;
		return new RouteStatisticsWrapper(route, routeLongitudeSum / pointCount, 
				routeLatitudeSum / pointCount, routeAvgSpeed, routeAvgSpeed * route.getLegDuration());
	}
	
	public static RouteStatisticsWrapper getMostRepresentativeRoute(
			List<RouteStatisticsWrapper> routeStatisticsWrappers) {
		RouteStatisticsWrapper mostRepresentativeRoute = routeStatisticsWrappers.get(0);
		double minDeviation = Double.MAX_VALUE;
		for(RouteStatisticsWrapper rsw: routeStatisticsWrappers) {
			if(rsw.getDeviationFromAverage() < minDeviation) {
				minDeviation = rsw.getDeviationFromAverage();
				mostRepresentativeRoute = rsw;
			}
		}
		return mostRepresentativeRoute;
	}
}
