package Model;

import java.util.Date;

public class Vehicles {
	
	private int vec_id; 
	private String vec_plateno;
	private String vec_name;
	private Date vec_rtdate;
	private int driver_id;
	private int staff_id;
	
	public int getVec_id() {
		return vec_id;
	}
	public void setVec_id(int vec_id) {
		this.vec_id = vec_id;
	}
	public int getDriver_id() {
		return driver_id;
	}
	public void setDriver_id(int driver_id) {
		this.driver_id = driver_id;
	}
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	
	public String getVec_plateno() {
		return vec_plateno;
	}
	public void setVec_plateno(String vec_plateno) {
		this.vec_plateno = vec_plateno;
	}
	public String getVec_name() {
		return vec_name;
	}
	public void setVec_name(String vec_name) {
		this.vec_name = vec_name;
	}
	public Date getVec_rtdate() {
		return vec_rtdate;
	}
	public void setVec_rtdate(Date vec_rtdate) {
		this.vec_rtdate = vec_rtdate;
	}
	
	
	
	

}
