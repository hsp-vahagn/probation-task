package aod.task.staff;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import aod.task.staff.utils.DateUtil;
import aod.task.staff.utils.MathUtil;

/**
 * Staff members are characterized by their name, date when they joined the
 * company, and base salary
 * 
 * @author vahagn
 *
 */
public abstract class StaffMembers {

	private static final double DEFAULT_SALARY = 50000;

	protected String name;
	protected LocalDate joinDate;

	protected int upSalaryPercent;
	protected int maxSalary;
	protected boolean canBeSupervisor;
	protected StaffMembers supervisor;
	List<StaffMembers> subordinates = new ArrayList<>();

	/**
	 * calculate salary by given year
	 */
	protected double calculateSalary(LocalDate currentDateSalary) {
		long workYear = DateUtil.countWorkYear(joinDate, currentDateSalary);
		double currentYaerSalary = DEFAULT_SALARY;

		for (int i = 0; i < workYear; i++) {
			double salary = currentYaerSalary + MathUtil.getPercentByGiven(DEFAULT_SALARY, upSalaryPercent);
			if (isGreater(salary)) {
				return MathUtil.getPercentByGiven(DEFAULT_SALARY, maxSalary) + DEFAULT_SALARY;
			}
			currentYaerSalary = salary;
		}
		return currentYaerSalary;
	}

	/**
	 * is given money greater then maximum salary
	 * 
	 * @param successCase
	 * @return
	 */
	private boolean isGreater(double successCase) {
		return successCase > MathUtil.getPercentByGiven(DEFAULT_SALARY, maxSalary) + DEFAULT_SALARY;
	}

	/**
	 * 
	 * @param supervisor
	 */
	public void initSupervisors(StaffMembers supervisor, StaffMembers subordinate) {
		this.supervisor = supervisor;
		if (canBeSupervisor) {
			addSubordinates(subordinate);
		}
	}

	/**
	 * add new subordinate
	 * 
	 * @param subordinate
	 */
	public StaffMembers addSubordinates(StaffMembers subordinate) {
		for (StaffMembers sub : subordinates) {
			subordinate = sub;
		}
		return subordinate;
	}
}
