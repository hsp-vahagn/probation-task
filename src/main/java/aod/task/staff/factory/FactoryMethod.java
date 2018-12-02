package aod.task.staff.factory;

import aod.task.staff.StaffMember;
import aod.task.staff.exception.NotMemberFoundException;
import aod.task.staff.subordinates.Employee;
import aod.task.staff.supervisors.Manager;
import aod.task.staff.supervisors.Sales;

/**
 * factory method design pattern for encapsulate object's creating
 * 
 * @author vahagn
 *
 */
public class FactoryMethod {
	/**
	 * factory method
	 * 
	 * @param type
	 * @return
	 */
	public static StaffMember createStaffMemberObject(CompanyMember type) {
		switch (type) {
		case EMPLOYEE: {
			return new Employee();

		}
		case MANAGER: {
			return new Manager();

		}
		case SALES: {
			return new Sales();

		}
		}
		throw new NotMemberFoundException();
	}

}
