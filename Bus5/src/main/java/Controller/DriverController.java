package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import DAO.DriverDAO;
import Model.Driver;
import java.io.IOException;

@WebServlet ("/DriverController")
public class DriverController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String action="", forward="";
	private static String LIST ="listDriver.jsp";
	private static String VIEW ="viewDriver.jsp";
	private static String UPDATE ="updateDriver.jsp";
	private DriverDAO dao;
	private int driver_id;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DriverController() {
		super();
		dao = new DriverDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		action = request.getParameter("action");

		//Complete action for view driver
		if(action.equalsIgnoreCase("view")) {
			forward = VIEW;
			driver_id = Integer.parseInt(request.getParameter("driver_id"));
			request.setAttribute("d", DriverDAO.getDriver(driver_id));

		}
		
		//Complete action for list driver
		if(action.equalsIgnoreCase("list")) {
			forward = LIST;
			request.setAttribute("drivers", DriverDAO.getDrivers());
	
		}
		
		//Complete action for delete driver
		if(action.equalsIgnoreCase("delete")) {
			forward = LIST;
			driver_id = Integer.parseInt(request.getParameter("driver_id"));
			dao.deleteDriver(driver_id);
			request.setAttribute("drivers", DriverDAO.getDrivers());
			RequestDispatcher view = request.getRequestDispatcher("listDriver.jsp");
			view.forward(request, response);
		}

		//Complete action for update

			if(action.equalsIgnoreCase("update")) {
			forward = UPDATE;
			driver_id = Integer.parseInt(request.getParameter("driver_id"));
			request.setAttribute("d", DriverDAO.getDriver(driver_id));
		
		}
		
			RequestDispatcher view = request.getRequestDispatcher(forward);
			view.forward(request, response);
			

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Driver d = new Driver();

		//retrieve from HTML and set the values
		d.setDriver_name(request.getParameter("driver_name"));
		d.setDriver_email(request.getParameter("driver_email"));
		d.setDriver_icno(request.getParameter("driver_icno"));
		d.setDriver_phoneno(request.getParameter("driver_phoneno"));
		d.setDriver_address(request.getParameter("driver_address"));
		d.setDriver_licenseno(request.getParameter("driver_licenseno"));
		//d.setStaff_id(Integer.parseInt(request.getParameter("staff_id")));
		
		

		//invoke method addDriver
		String driver_id= request.getParameter("driver_id");
		if(driver_id==null || driver_id.isEmpty()) {
			dao.addDriver(d);
		}
		//invoke method updateDriver
		else {
			
			d.setDriver_id(Integer.parseInt(driver_id));
			dao.updateDriver(d);
		}
		 
		
	   //set attribute to a servlet request and call getDriver method
		forward =LIST;
		request.setAttribute("drivers", DriverDAO.getDrivers());
	

		//forward the request to listOrder.jsp
		RequestDispatcher view = request.getRequestDispatcher("listDriver.jsp");
		view.forward(request, response);
		
	}
}
