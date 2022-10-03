package com.infinite.LMS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class LeaveDetailsDAO {
	Connection connection;
	PreparedStatement preparedStatement;
	
	public EmployDetails searchEmployDAO(int empno) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		preparedStatement = connection.prepareStatement("select * from employee where emp_id=?");
		preparedStatement.setInt(1, empno);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		EmployDetails employDetails = null;
		if (resultSet.next()) {
			employDetails = new EmployDetails();
			employDetails.setLeaveBalance(resultSet.getInt("EMP_AVAIL_LEAVE_BAL"));
			employDetails.setManagerId(resultSet.getInt("EMP_MANAGER_ID"));
		}
		return employDetails;
	}

	public LeaveDetails searchLeaveDAO(int leaveId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		preparedStatement = connection.prepareStatement("Select * from leave_history where leave_id = ?");
		preparedStatement.setInt(1, leaveId);
		ResultSet resultSet = preparedStatement.executeQuery();

		LeaveDetails leaveDetails = null;

		if (resultSet.next()) {
			leaveDetails = new LeaveDetails();
			leaveDetails.setLeaveId(leaveId);
			leaveDetails.setEmpNo(resultSet.getInt("emp_id"));
			leaveDetails.setLeaveStartDate(resultSet.getDate("leave_start_date"));
			leaveDetails.setLeaveEndDate(resultSet.getDate("leave_end_date"));
			leaveDetails.setLeaveType(LeaveType.valueOf(resultSet.getString("leave_type").toString()));
			leaveDetails.setLeaveStatus(LeaveStatus.valueOf(resultSet.getString("leave_status").toString()));
			leaveDetails.setNumberOfDays(resultSet.getInt("LEAVE_NO_OF_DAYS"));
			leaveDetails.setLeaveReason(resultSet.getString("leave_reason"));
			leaveDetails.setManagerComment(resultSet.getString("LEAVE_MNGR_COMMENTS"));
		}
		return leaveDetails;
	}

	public String addLeaveDAO(LeaveDetails leaveDetails) throws ClassNotFoundException, SQLException {
		long miliSeconds = leaveDetails.getLeaveEndDate().getTime() - leaveDetails.getLeaveStartDate().getTime();
	    int days = (int) miliSeconds / (1000 * 24 * 60 * 60);
	    
	    days = days + 1;
	    leaveDetails.setLeaveType(LeaveType.EL);
	    leaveDetails.setLeaveStatus(LeaveStatus.PENDING);
	    
	    EmployDetails employDetails = searchEmployDAO(leaveDetails.getEmpNo());
	    int leaveBalance = employDetails.getLeaveBalance();
	    
	    if (employDetails.getManagerId() == 0) {
			leaveDetails.setLeaveStatus(LeaveStatus.APPROVED);
		}else {
			leaveDetails.setLeaveStatus(LeaveStatus.PENDING);
		}
	    
	    if (leaveBalance < days) {
			return "You don't have sufficiant Leave Balance";
		}else if (new Date().after(leaveDetails.getLeaveStartDate())) {
			return "Leave Start date can't be a PAST date.";
		}else if (new Date().after(leaveDetails.getLeaveEndDate())) {
			return "Leave End date can't be a PAST date.";
		}else if (days < 0) {
			return "Leave Start Date can't be lesser than the Leave End Date.";
		}else {
			connection = ConnectionHelper.getConnection();
			preparedStatement = connection.prepareStatement(
					"insert into leave_history (LEAVE_NO_OF_DAYS, EMP_ID, LEAVE_START_DATE, LEAVE_END_DATE, LEAVE_TYPE, LEAVE_STATUS, LEAVE_REASON) values(?, ?, ?, ?, ?, ?, ?)");
			
			preparedStatement.setInt(1, days);
			preparedStatement.setInt(2, leaveDetails.getEmpNo());
			preparedStatement.setDate(3, leaveDetails.getLeaveStartDate());
			preparedStatement.setDate(4, leaveDetails.getLeaveEndDate());
			preparedStatement.setString(5, leaveDetails.getLeaveType().toString());
			preparedStatement.setString(6, leaveDetails.getLeaveStatus().toString());
			preparedStatement.setString(7, leaveDetails.getLeaveReason());
			preparedStatement.executeUpdate();
			
			preparedStatement = connection.prepareStatement("Update Employee set EMP_AVAIL_LEAVE_BAL=? WHERE EMP_ID=?");
			preparedStatement.setInt(1, (leaveBalance - days));
			preparedStatement.setInt(2, leaveDetails.getEmpNo());
			preparedStatement.executeUpdate();
			
			return "Leave Applied Successfully.";
		}
	}
}