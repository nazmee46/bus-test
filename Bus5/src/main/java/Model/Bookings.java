package Model;

import java.sql.Time;
import java.util.Date;

public class Bookings {
	
	private int book_id;
	private String book_name;
	private String book_phoneno;
	Date book_date;
	Time book_time;
	private String book_route;
	private int book_seat;
	private double book_price;
	private int vec_id;
	
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_phoneno() {
		return book_phoneno;
	}
	public void setBook_phoneno(String book_phoneno) {
		this.book_phoneno = book_phoneno;
	}
	public Date getBook_date() {
		return book_date;
	}
	public void setBook_date(Date book_date) {
		this.book_date = book_date;
	}
	public Time getBook_time() {
		return book_time;
	}
	public void setBook_time(Time book_time) {
		this.book_time = book_time;
	}
	public String getBook_route() {
		return book_route;
	}
	public void setBook_route(String book_route) {
		this.book_route = book_route;
	}
	public int getBook_seat() {
		return book_seat;
	}
	public void setBook_seat(int book_seat) {
		this.book_seat = book_seat;
	}
	public double getBook_price() {
		return book_price;
	}
	public void setBook_price(double book_price) {
		this.book_price = book_price;
	}
	public int getVec_id() {
		return vec_id;
	}
	public void setVec_id(int vec_id) {
		this.vec_id = vec_id;
	}
	
	

}
