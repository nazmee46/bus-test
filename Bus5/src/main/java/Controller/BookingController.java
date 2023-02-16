package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import DAO.BookingsDAO;
import Model.Bookings;

/**
 * Servlet implementation class BookingController
 */
@WebServlet ("/BookingController")
public class BookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String action="", forward="";
	private static String LIST ="ListBooking.jsp";
	private static String VIEW ="ViewBooking.jsp";
	private BookingsDAO dao;
	private int book_id;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingController() {
        super();
        dao = new BookingsDAO();
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
			int book_id = Integer.parseInt(request.getParameter("book_id"));
			request.setAttribute("booking", BookingsDAO.getCustomerBooking(book_id));
		}
		
		//Complete action for list order
		// for all order have been inserted
		if(action.equalsIgnoreCase("list")) {
			forward = LIST;
			request.setAttribute("bookings", BookingsDAO.getCustomerBookings());
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
		
		java.util.Date bdate;
		try {
			Bookings booking = new Bookings();
			
			bdate = formatter.parse(request.getParameter("book_date"));
		
			//retrieve from JSP and set values
			booking.setBook_name(request.getParameter("book_name"));
			booking.setBook_phoneno(request.getParameter("book_phoneno"));
			booking.setBook_date(bdate);
			//booking.setBook_time(request.getParameter("book_time"));
			booking.setBook_route(request.getParameter("book_route"));
			booking.setBook_seat(Integer.parseInt(request.getParameter("book_seat")));
			//booking.setBook_price(Double.parseDouble(request.getParameter("book_price")));
			
			//invoke method addBooking() in BookingsDAO
			String book_id = request.getParameter("book_id");
			
			if(book_id == null || book_id.isEmpty()) {
				dao.addBooking(booking);
			}
			
			//set attribute to a servlet request and call getCustomerBookings() method
			request.setAttribute("bookings", BookingsDAO.getCustomerBookings());
			
			
			//forward the request to listOrder.jsp
			forward = LIST;
			RequestDispatcher LIST = request.getRequestDispatcher("ListBooking.jsp");
			LIST.forward(request, response);
		
			} catch(Exception e) {
			e.printStackTrace();				
			}
			
	}

}
