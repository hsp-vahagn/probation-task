package aod.task.staff.supervisors;

import java.time.LocalDate;

import aod.task.staff.StaffMember;
import aod.task.staff.utils.MathUtil;

/**
 * class sales
 * 
 * @author vahagn
 *
 */
public class Sales extends StaffMember {

	private static final int UP_SALARY_PERCENT = 1;
	private static final int MAX_SALARY = 35;
	private static final double SALARY_OF_SUBORDINATE = 0.3;

	/**
	 * default constructor
	 */
	public Sales() {
		upSalaryPercent = UP_SALARY_PERCENT;
		maxSalary = MAX_SALARY;
		canBeSupervisor = true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see aod.task.staff.StaffMembers#calculateSalary(java.time.LocalDate)
	 */
	public double calculateSalary(LocalDate currentDateSalary) {
		double salary = super.calculateSalary(currentDateSalary);
		for (StaffMember subordinate : subordinates) {
			salary += MathUtil.getPercentByGiven(subordinate.calculateSalary(currentDateSalary), SALARY_OF_SUBORDINATE);
		}
		
		return salary;
	}
}
