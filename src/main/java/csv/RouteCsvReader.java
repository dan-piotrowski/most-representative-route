package csv;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import model.Route;

public class RouteCsvReader {

	public List<Route> readRoutesFromCsv(String fileName) {
		List<Route> routes = new ArrayList<>();
		
		InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
		
		if(is != null) {
			routes = new CsvToBeanBuilder<Route>(new InputStreamReader(is))
				       .withType(Route.class).build().parse();
		}
		
		return routes;
	}
}
