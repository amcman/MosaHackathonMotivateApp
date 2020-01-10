package backend;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ValueCalculators {

	User user; 
	
	public ValueCalculators(User u) {
		this.user = u; 
	}
	
	Date startDate = user.getStartDate(); 
	Date endDate = user.getEndDate();
	String frequencyStr = user.getdailyFreq();
	
	// Calculates the number of days the goal will last 
	public int getNumOfDays() {
		long durationInMilliSec = endDate.getTime() - startDate.getTime();
		return (int) TimeUnit.MILLISECONDS.toDays(durationInMilliSec); 
	}
	
	//TO MODIFY by Helen
	// Calculates the number of msgs needed/to be sent
	public int getNumOfMsgs() {
		
		return getNumOfDays() * 1 ; 
	}
	
	
}
