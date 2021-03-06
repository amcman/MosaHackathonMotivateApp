package backend;
/*	-Holds all information pertinent 
 * to the user (array list of messages, 
 * goal due date, name, number   
 * of days until goal completed,
 *  preference for frequency of messages, 
 *  and phone number) 
 */

//make all instance variables private 
//make all method public 

import java.util.*; 

public class User {
	
	//variables 
	private String name; 
	private ArrayList<String> messages = new ArrayList<String>();
	private Date startDate; 
	private Date endDate; 
	private String dailyFreq;
	private String goal; 
	private String phone; 
	
	
	//constructor
	public User() {
	}
	
	//getters and setters 
	
	public String getName() {
		return this.name; 
	}
	
	public void setName(String n) {
		this.name = n;
	}
	
	public ArrayList<String> getMsg(){
		return this.messages; 
	}
	
	public void setMsg(String s) {
		this.messages.add(s); 
	}
	
	//Optional: will wipe out current arraylist of messages. 
	public void deleteMsg(ArrayList<String> m) {
		this.messages = new ArrayList<String> (); 
	}
	
	public Date getStartDate() {
		return this.startDate; 
	}
	
	public void setStartDate(Date d) {
		this.startDate = d;
	}
	
	public Date getEndDate() {
		return this.endDate; 
	}
	
	public void setEndDate(Date d) {
		this.endDate = d;
	}
	
	public String getdailyFreq() {
		return this.dailyFreq; 
	}
	
	public void setdailyFreq(String d) {
		this.dailyFreq = d;
	}
	
	public String getGoal() {
		return this.goal; 
	}
	
	public void setGoal(String g) {
		this.goal = g; 
	}
	
	public String getPhone() {
		return this.phone; 
	}
	
	public void setPhone(String p) {
		this.phone = p; 
	}
	
	
	
}
