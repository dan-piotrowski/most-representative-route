package csv;

import com.opencsv.bean.AbstractCsvConverter;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

import model.Point;

public class TextToPoint extends AbstractCsvConverter {

	@Override
	public Object convertToRead(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
		value = value.replace("[[", "");
		value = value.replace("]]", "");
		Point point = new Point();
		String[] split = value.split(", ");
		point.setLongitude(Double.valueOf(split[0]));
		point.setLatitude(Double.valueOf(split[1]));
		point.setTimestamp(Long.valueOf(split[2]));
		point.setSpeed("null".equals(split[3]) ? 0.0 : Double.valueOf(split[3]));
		return point;
	}
}
