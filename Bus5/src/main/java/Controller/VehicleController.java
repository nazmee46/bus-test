package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import DAO.VehiclesDAO;
import Model.Vehicles;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Servlet implementation class OrdersController
 */
@WebServlet ("/VehicleController")
public class VehicleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String action="", forward="";
	private static String LIST ="ListVehicle.jsp";
	private static String VIEW ="ViewVehicle.jsp";
	private static String UPDATE ="UpdateVehicle.jsp";
	private VehiclesDAO dao;
	private int vec_id;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VehicleController() {
		super();
		dao = new VehiclesDAO();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		action = request.getParameter("action");

		//Complete action for view order
		if(action.equalsIgnoreCase("view")) {
			forward = VIEW;
			int vec_id = Integer.parseInt(request.getParameter("vec_id"));
			request.setAttribute("vehicle", VehiclesDAO.getVehicle(vec_id));
		}
		
		//Complete action for list order
		// for all order have been inserted
		if(action.equalsIgnoreCase("list")) {
			forward = LIST;
			request.setAttribute("vehicles", VehiclesDAO.getVehicles());
		}

		//Complete action for delete order
		if(action.equalsIgnoreCase("delete")) {
			forward = LIST;
			int vec_id = Integer.parseInt(request.getParameter("vec_id"));
			dao.deleteVehicle(vec_id);
			request.setAttribute("vehicles", VehiclesDAO.getVehicles());
			RequestDispatcher view = request.getRequestDispatcher("ListVehicle.jsp");
		}

		//forward the request
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date1;
		
		try {
			Vehicles vehicle = new Vehicles();
			date1 = formatter.parse(request.getParameter("vec_rtdate"));

			//retrieve from HTML and set the values
			vehicle.setVec_plateno(request.getParameter("vec_plateno"));
			vehicle.setVec_name(request.getParameter("vec_name"));
			vehicle.setVec_rtdate(date1);
			

			//invoke method addOrder() in VehiclesDAO
			String vec_id = request.getParameter("vec_id");
			
			if(vec_id == null || vec_id.isEmpty()) {
				dao.addVehicle(vehicle);
			}
			
			//set attribute to a servlet request and call getVehicles() method
			request.setAttribute("vehicles", VehiclesDAO.getVehicles());
			
		}catch(Exception e) {
			e.printStackTrace();
		}

		
		
		//forward the request to ListVehicle.jsp
		forward = LIST;
		RequestDispatcher LIST = request.getRequestDispatcher("ListVehicle.jsp");
		LIST.forward(request, response);
		
	}
}
