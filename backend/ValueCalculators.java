package backend;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ValueCalculators {

	User user; 
	
	public ValueCalculators() {
		this.user = new User(); 
	}
	
	Date startDate = user.getStartDate(); 
	Date endDate = user.getEndDate();
	
	//TO MODIFY
	String frequency = user.getdailyFreq();
	
	// Calculates the number of days the goal will last 
	public long getNumOfDays() {
		long durationInMilliSec = endDate.getTime() - startDate.getTime();
		return TimeUnit.MILLISECONDS.toDays(durationInMilliSec); 
	}
	
	//TO MODIFY
	// Calculates the number of msgs needed/to be sent
	public int getNumOfMsgs() {
		
		return 0; 
	}
	
	
}
