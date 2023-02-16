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

import DAO.VehiclesDAO;
import Model.Vehicles;


@WebServlet("/UpdateVehicleController")
public class UpdateVehicleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VehiclesDAO dao;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateVehicleController() {
        super();
        dao = new VehiclesDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int vec_id = Integer.parseInt(request.getParameter("vec_id"));
		request.setAttribute("vehicle", VehiclesDAO.getVehicle(vec_id));
		RequestDispatcher view = request.getRequestDispatcher("UpdateVehicle.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date1 = null;
		try {
			date1 = formatter.parse(request.getParameter("vec_rtdate"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Vehicles vehicle = new Vehicles();
		vehicle.setVec_id(Integer.parseInt(request.getParameter("vec_id")));
		vehicle.setVec_rtdate(date1);
		
		dao.updateVehicle(vehicle); 
		
		request.setAttribute("vehicles", VehiclesDAO.getVehicles());
		RequestDispatcher view = request.getRequestDispatcher("ListVehicle.jsp");
		view.forward(request, response);
	}

}
