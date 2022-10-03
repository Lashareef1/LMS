package com.infinite.LMS;
import java.sql.Date;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddLeaveServlet
 */
public class AddLeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLeaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @throws IOException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		LeaveDetails leaveDetails = new LeaveDetails();
		
		leaveDetails.setEmpNo(Integer.parseInt(request.getParameter("employId")));
		
		leaveDetails.setLeaveStartDate(Date.valueOf(request.getParameter("leaveStartDate")));
		leaveDetails.setLeaveEndDate(Date.valueOf(request.getParameter("leaveEndDate")));
		
		leaveDetails.setLeaveType(LeaveType.valueOf(request.getParameter("leaveType").toUpperCase()));
		leaveDetails.setLeaveReason(request.getParameter("leaveReason"));
		
		LeaveDetailsDAO dao = new LeaveDetailsDAO();
		try {
			out.println(dao.addLeaveDAO(leaveDetails));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}