package Controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DAO.DriverDAO;
import Model.Driver;


@WebServlet("/UpdateDriverController")
public class UpdateDriverController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DriverDAO dao;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDriverController() {
        super();
        dao = new DriverDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int driver_id = Integer.parseInt(request.getParameter("driver_id"));
		request.setAttribute("d", DriverDAO.getDriver(driver_id));
		RequestDispatcher view = request.getRequestDispatcher("updateDriver.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		Driver d = new Driver();
		
		d.setDriver_id(Integer.parseInt(request.getParameter("driver_id")));
		d.setDriver_email(request.getParameter("driver_email"));
		d.setDriver_phoneno(request.getParameter("driver_phoneno"));
		d.setDriver_address(request.getParameter("driver_address"));
		
		
		dao.updateDriver(d); 
		
		request.setAttribute("drivers", DriverDAO.getDrivers());
		RequestDispatcher view = request.getRequestDispatcher("listDriver.jsp");
		view.forward(request, response);
	}

}
