package main;
import java.util.List;

import csv.RouteCsvReader;
import model.Route;
import statistics.RouteDeviationCalculator;
import statistics.RouteStatistics;
import statistics.RouteStatisticsWrapper;

public class Application {

	private static final String ROUTES_CSV = "DEBRV_DEHAM_historical_routes.csv";

	public static void main(String[] args) {
		List<Route> routes = new RouteCsvReader().readRoutesFromCsv(ROUTES_CSV);
		
		List<RouteStatisticsWrapper> routeStatisticsWrappers = RouteStatisticsWrapper.mapRoutesToRouteStatisticsWrappers(routes);
		RouteStatistics routeStatistics = new RouteStatistics();
		routeStatistics.initialize(routeStatisticsWrappers);
		
		RouteDeviationCalculator routeDeviationCalculator = new RouteDeviationCalculator();
		routeDeviationCalculator.updateRouteDeviationsFromAverage(routeStatisticsWrappers, routeStatistics);
		
		RouteStatisticsWrapper mostRepresentativeRoute = RouteStatisticsWrapper.getMostRepresentativeRoute(
				routeStatisticsWrappers);
		System.out.println("The most representative route is: " + mostRepresentativeRoute.getRoute());
	}
}
