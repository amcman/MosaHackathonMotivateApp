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
	
	// Calculates the number of msgs needed/to be sent
	public int getNumOfMsgs(String fS) {
		
		//nF is numerical daily frequency 
		double nF=0;
		
		switch(fS) {
		case "Twice a day":
			nF = 2;
			break;
		case "Once a day":
			nF = 1;
			break;
		case "Every other day":
			nF = 0.5;
		case "Once a week":
			nF = (1/7)*1.0;
		}
		
		
		return (int) (getNumOfDays() * nF); 
	}
	
	
}
