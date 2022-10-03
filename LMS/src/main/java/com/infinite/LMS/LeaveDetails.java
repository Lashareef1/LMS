package com.infinite.LMS;

import java.sql.Date;

public class LeaveDetails {

	
	private int leaveId;
	private int empNo;
	private int managerId;
	private Date leaveStartDate;
	private Date leaveEndDate;
	private int numberOfDays;
	private LeaveType leaveType;
	private LeaveStatus leaveStatus;
	private int leaveBalance;
	private String leaveReason;
	private String managerComment;


	public LeaveDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


	public LeaveDetails(int leaveId, int empNo, int managerId, Date leaveStartDate, Date leaveEndDate, int numberOfDays,
			LeaveType leaveType, LeaveStatus leaveStatus, int leaveBalance, String leaveReason, String managerComment) {
		super();
		this.leaveId = leaveId;
		this.empNo = empNo;
		this.managerId = managerId;
		this.leaveStartDate = leaveStartDate;
		this.leaveEndDate = leaveEndDate;
		this.numberOfDays = numberOfDays;
		this.leaveType = leaveType;
		this.leaveStatus = leaveStatus;
		this.leaveBalance = leaveBalance;
		this.leaveReason = leaveReason;
		this.managerComment = managerComment;
	}


	@Override
	public String toString() {
		return "LeaveDetails [leaveId=" + leaveId + ", empNo=" + empNo + ", managerId=" + managerId
				+ ", leaveStartDate=" + leaveStartDate + ", leaveEndDate=" + leaveEndDate + ", numberOfDays="
				+ numberOfDays + ", leaveType=" + leaveType + ", leaveStatus=" + leaveStatus + ", leaveBalance="
				+ leaveBalance + ", leaveReason=" + leaveReason + ", managerComment=" + managerComment + "]";
	}


	public int getLeaveId() {
		return leaveId;
	}


	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}


	public int getEmpNo() {
		return empNo;
	}


	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}


	public int getManagerId() {
		return managerId;
	}


	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}


	public Date getLeaveStartDate() {
		return leaveStartDate;
	}


	public void setLeaveStartDate(Date leaveStartDate) {
		this.leaveStartDate = leaveStartDate;
	}


	public Date getLeaveEndDate() {
		return leaveEndDate;
	}


	public void setLeaveEndDate(Date leaveEndDate) {
		this.leaveEndDate = leaveEndDate;
	}


	public int getNumberOfDays() {
		return numberOfDays;
	}


	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}


	public LeaveType getLeaveType() {
		return leaveType;
	}


	public void setLeaveType(LeaveType leaveType) {
		this.leaveType = leaveType;
	}


	public LeaveStatus getLeaveStatus() {
		return leaveStatus;
	}


	public void setLeaveStatus(LeaveStatus leaveStatus) {
		this.leaveStatus = leaveStatus;
	}


	public int getLeaveBalance() {
		return leaveBalance;
	}


	public void setLeaveBalance(int leaveBalance) {
		this.leaveBalance = leaveBalance;
	}


	public String getLeaveReason() {
		return leaveReason;
	}


	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}


	public String getManagerComment() {
		return managerComment;
	}


	public void setManagerComment(String managerComment) {
		this.managerComment = managerComment;
	}
}
