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
	private ArrayList<String> messages;
	private String dueDate; 
	private double numDays; 
	private int dailyFreq;
	private String phone; 
	
	
	//constructors 
	public User(String n, ArrayList<String> msg, String dD, double nD,
			int dF, String p) {
		
		this.name = n;
		this.messages = msg; 
		this.dueDate = dD; 
		this.numDays = nD; 
		this.dailyFreq = dF;
		this.phone = p; 
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
	
	public void setMsg(ArrayList<String> m) {
		this.messages = m; 
	}
	
	public String getdueDate() {
		return this.dueDate; 
	}
	
	public void setdueDate(String d) {
		this.dueDate = d;
	}
	
	public double getnumDays() {
		return this.numDays; 
	}
	
	public void setnumDays(double d) {
		this.numDays = d; 
	}
	
	public int getdailyFreq() {
		return this.dailyFreq; 
	}
	
	public void setdailyFreq(int d) {
		this.dailyFreq = d;
	}
	
	public String getPhone() {
		return this.phone; 
	}
	
	public void setPhone(String p) {
		this.phone = p; 
	}
	
	
	
}
