package aod.task.staff.utils;

/**
 * class which contains mathematics logics
 * 
 * @author vahagn
 *
 */
public final class MathUtil {

	/**
	 * default constructor
	 */
	private MathUtil() {

	}

	/**
	 * return percent of given number
	 * 
	 * @param number1
	 * @param number2
	 * @return
	 */
	public static double getPercentByGiven(double number1, double number2) {
		return number1 * number2 / 100;
	}

	/**
	 * get round of given number
	 * 
	 * @param number
	 * @param degree
	 * @return
	 */
	public static double round(double number, int degree) {
		return Math.round(number * Math.pow(10, degree)) / Math.pow(10, degree);
	}
}
