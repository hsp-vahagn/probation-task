package aod.task;

import java.time.LocalDate;
import java.time.Month;

import aod.task.staff.StaffMember;
import aod.task.staff.factory.CompanyMember;
import aod.task.staff.factory.FactoryMethod;
import aod.task.staff.utils.MathUtil;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	public void testEmployeeSalary() {
		StaffMember emp1 = initMember("Employee", LocalDate.of(2017, Month.SEPTEMBER, 25), CompanyMember.EMPLOYEE);
		double salary = MathUtil.round(emp1.calculateSalary(LocalDate.now()), 2);

		// salary 1 year
		assertEquals(51500, salary, 0);

		StaffMember emp2 = initMember("EmployeeMaxSalary", LocalDate.of(1017, Month.SEPTEMBER, 25),
				CompanyMember.EMPLOYEE);
		salary = MathUtil.round(emp2.calculateSalary(LocalDate.now()), 2);

		// max salary
		assertEquals(65000, salary, 0);
	}

	/**
	 * 
	 * @param name
	 * @param joinDate
	 * @param type
	 * @return
	 */
	public StaffMember initMember(String name, LocalDate joinDate, CompanyMember type) {
		StaffMember member = FactoryMethod.createStaffMemberObject(type);
		member.setName(name);
		member.setJoinDate(joinDate);
		return member;
	}
}
