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

import javafx.scene.control.DatePicker; 

public class User {
	
	//variables 
	private String name; 
	private ArrayList<String> messages;
	private DatePicker startDate; 
	private DatePicker endDate; 
	private String dailyFreq;
	private String goal; 
	private String phone; 
	
	
	//constructor
	public User() {//String n, ArrayList<String> msg, String dD,
			//String dF, String p) {
		
		//this.name = n;
		//this.messages = msg; 
		//this.dueDate = dD;  
		//this.dailyFreq = dF;
		//this.phone = p; 
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
	
	//to to: modify this to add msg to the arraylist. 
	public void setMsg(ArrayList<String> m) {
		this.messages = m; 
	}
	
	public String getdueDate() {
		return this.dueDate; 
	}
	
	public void setdueDate(String d) {
		this.dueDate = d;
	}
	
	public String getdailyFreq() {
		return this.dailyFreq; 
	}
	
	public void setdailyFreq(String d) {
		this.dailyFreq = d;
	}
	
	public String getPhone() {
		return this.phone; 
	}
	
	public void setPhone(String p) {
		this.phone = p; 
	}
	
	
	
}
