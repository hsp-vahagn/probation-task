package aod.task.staff;

import java.time.LocalDate;
import java.time.Month;

import aod.task.staff.factory.CompanyMember;
import aod.task.staff.utils.MathUtil;

/**
 * testing my task...
 * 
 * @author vahagn
 *
 */
public class Demonstration {

	public static void main(String[] args) {
		Company company = new Company();
		StaffMember employee = company.addMember("Employee", LocalDate.of(2017, Month.APRIL, 30),
				CompanyMember.EMPLOYEE);

		StaffMember sales = company.addMember("Sales", LocalDate.of(2017, Month.APRIL, 30), CompanyMember.SALES);
		StaffMember manager = company.addMember("Manager", LocalDate.of(2017, Month.APRIL, 30), CompanyMember.MANAGER);

		employee.initSupervisors(sales);
		manager.initSupervisors(employee);

		LocalDate currentDate = LocalDate.now();
		for (StaffMember member : company.getMembers()) {
			double salary = MathUtil.round(member.calculateSalary(currentDate), 2);
			System.out.println(member.getName() + " " + salary);
		}
	}

}
