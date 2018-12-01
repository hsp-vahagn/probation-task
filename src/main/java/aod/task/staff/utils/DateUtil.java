package aod.task.staff.utils;

import java.time.LocalDate;
import java.time.Period;

/**
 * utility class
 * 
 * @author vahagn
 *
 */
public final class DateUtil{

	/**
	 * default constructor
	 */
	private DateUtil() {

	}

	/**
	 * get years difference
	 * 
	 * @param fromYear
	 * @param toYear
	 */
	public static long countWorkYear(LocalDate fromYear, LocalDate toYear) {
		return Period.between(fromYear, toYear).getYears();
	}
}
