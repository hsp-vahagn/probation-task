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
public abstract class StaffMember {

	private static final double DEFAULT_SALARY = 50000;

	protected String name;
	protected LocalDate joinDate;
	protected double salary;

	protected int upSalaryPercent;
	protected int maxSalary;
	protected boolean canBeSupervisor;
	protected StaffMember supervisor;
	protected StaffMember sub;
	protected List<StaffMember> subordinates = new ArrayList<>();

	/**
	 * default constructor
	 */
	public StaffMember() {
		salary = DEFAULT_SALARY;
	}

	/**
	 * calculate salary by given year
	 * 
	 * @param currentDateSalary
	 * @return
	 */
	public double calculateSalary(LocalDate currentDateSalary) {
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
		return successCase > DEFAULT_SALARY + MathUtil.getPercentByGiven(DEFAULT_SALARY, maxSalary);
	}

	/**
	 * initialization supervisor
	 * 
	 * @param supervisor
	 */
	public void initSupervisors(StaffMember supervisor) {
		this.supervisor = supervisor;
		if (supervisor.canBeSupervisor) {
			supervisor.addSubordinates(this);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((joinDate == null) ? 0 : joinDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StaffMember other = (StaffMember) obj;
		if (joinDate == null) {
			if (other.joinDate != null)
				return false;
		} else if (!joinDate.equals(other.joinDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		return true;
	}

	/**
	 * add new subordinate
	 * 
	 * @param subordinate
	 */
	public void addSubordinates(StaffMember subordinate) {
		subordinates.add(subordinate);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the joinDate
	 */
	public LocalDate getJoinDate() {
		return joinDate;
	}

	/**
	 * @param joinDate
	 *            the joinDate to set
	 */
	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary
	 *            the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

}
