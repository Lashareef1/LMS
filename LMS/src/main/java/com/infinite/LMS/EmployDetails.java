package com.infinite.LMS;

import java.sql.Date;

public class EmployDetails {

	private int empno;
	private String empName;
	private String empMail;
	private String empPhone;
	private Date joiningDate;
	private String dept;
	private int managerId;
	private int leaveBalance;
	
	
	public EmployDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EmployDetails(int empno, String empName, String empMail, String empPhone, Date joiningDate, String dept,
			int managerId, int leaveBalance) {
		super();
		this.empno = empno;
		this.empName = empName;
		this.empMail = empMail;
		this.empPhone = empPhone;
		this.joiningDate = joiningDate;
		this.dept = dept;
		this.managerId = managerId;
		this.leaveBalance = leaveBalance;
	}


	@Override
	public String toString() {
		return "EmployDetails [empno=" + empno + ", empName=" + empName + ", empMail=" + empMail + ", empPhone="
				+ empPhone + ", joiningDate=" + joiningDate + ", dept=" + dept + ", managerId=" + managerId
				+ ", leaveBalance=" + leaveBalance + "]";
	}


	public int getEmpno() {
		return empno;
	}


	public void setEmpno(int empno) {
		this.empno = empno;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getEmpMail() {
		return empMail;
	}


	public void setEmpMail(String empMail) {
		this.empMail = empMail;
	}


	public String getEmpPhone() {
		return empPhone;
	}


	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}


	public Date getJoiningDate() {
		return joiningDate;
	}


	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	public int getManagerId() {
		return managerId;
	}


	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}


	public int getLeaveBalance() {
		return leaveBalance;
	}


	public void setLeaveBalance(int leaveBalance) {
		this.leaveBalance = leaveBalance;
	}
}
