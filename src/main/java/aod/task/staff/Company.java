package aod.task.staff;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import aod.task.staff.factory.CompanyMember;
import aod.task.staff.factory.FactoryMethod;

/**
 * class company which contains staff members
 * 
 * @author vahagn
 *
 */
public class Company {

	private List<StaffMember> members = new ArrayList<>();

	/**
	 * add new member by type
	 * 
	 * @param name
	 * @param joinDate
	 * @param type
	 * @return
	 */
	public StaffMember addMember(String name, LocalDate joinDate, CompanyMember type) {
		StaffMember staffMember = FactoryMethod.createStaffMemberObject(type);
		staffMember.setName(name);
		staffMember.setJoinDate(joinDate);

		members.add(staffMember);

		return staffMember;

	}

	/**
	 * @return the members
	 */
	public List<StaffMember> getMembers() {
		return members;
	}

	/**
	 * @param members
	 *            the members to set
	 */
	public void setMembers(List<StaffMember> members) {
		this.members = members;
	}
}
