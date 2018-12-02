package aod.task.staff.subordinates;

import aod.task.staff.StaffMember;

/**
 * class employee
 * 
 * @author vahagn
 *
 */
public class Employee extends StaffMember {

	private static final int UP_SALARY_PERCENT = 3;
	private static final int MAX_SALARY = 30;

	/**
	 * default constructor
	 */
	public Employee() {
		upSalaryPercent = UP_SALARY_PERCENT;
		maxSalary = MAX_SALARY;
		canBeSupervisor = false;
	}

}
