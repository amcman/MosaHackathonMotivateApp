package backend;

import java.util.concurrent.TimeUnit;

public class ValueCalculators {

	User user; 
	String frequencyStr; 
	
	public ValueCalculators(User u) {
		this.user = u; 
		this.frequencyStr = user.getdailyFreq();
	}
		
	// Calculates the number of days the goal will last 
	public int getNumOfDays() {
		long durationInMilliSec = user.getEndDate().getTime() - user.getStartDate().getTime();
		return (int) TimeUnit.MILLISECONDS.toDays(durationInMilliSec); 
	}
	
	// Calculates the number of msgs needed/to be sent
	public int getNumOfMsgs() {
		
		//nF is numerical daily frequency 
		double frequencyNum=0;
		
		switch(frequencyStr) {
		case "Twice a day":
			frequencyNum = 2;
			break;
		case "Once a day":
			frequencyNum = 1;
			break;
		case "Every other day":
			frequencyNum = 0.5;
		case "Once a week":
			frequencyNum = (1/7)*1.0;
		}
			
		return (int) (getNumOfDays() * frequencyNum); 
	}
	
	
}
