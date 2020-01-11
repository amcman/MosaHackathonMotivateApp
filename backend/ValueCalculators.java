package backend;

import java.util.concurrent.TimeUnit;

public class ValueCalculators {

	User user; 
	
	public ValueCalculators(User u) {
		this.user = u; 
	}
		
	// Calculates the number of days the goal will last 
	public int getNumOfDays() {
		long durationInMilliSec = user.getEndDate().getTime() - user.getStartDate().getTime();
		return (int) TimeUnit.MILLISECONDS.toDays(durationInMilliSec); 
	}
	
	// Helper method to convert frequency from String to int
	public double getFreqNum() {
		
		double freq=0; 
		
		switch(user.getdailyFreq()) {
		case "Twice a day":
			freq = 2;
			break;
		case "Once a day":
			freq = 1;
			break;
		case "Every other day":
			freq = 0.5;
			break;
		case "Once a week":
			freq = (1.0/7.0);
			break;
		}
		
		return freq; 
		
	}
	
	// Calculates the number of msgs needed/to be sent
	public int getNumOfMsgs() {
			
		return (int) (getNumOfDays() * getFreqNum()); 
	}
	
	// TO DO for Helen
		// Calculate the sleep cycle: goal duration / frequency (in milliseconds)
	public int calcSleepCycle() {
		return 0; 
	}
	
	// TO DO for Xunjing
	// Generates a random duration in milliseconds within the desired time window
	public int getRandomDuration(){
			
		return 0; 
	}
	
}
