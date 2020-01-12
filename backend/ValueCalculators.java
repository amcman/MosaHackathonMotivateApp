package backend;

import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ValueCalculators {

	User user; 
	long twelveHrMillisec = TimeUnit.HOURS.toMillis(12);
	Random r = new Random();
	
	public ValueCalculators(User u) {
		this.user = u; 
	}
	
	
	// Calculates the number of days the goal will last 
	public int getNumOfDays() {
		long durationInMilliSec = user.getEndDate().getTime() - user.getStartDate().getTime();
		return (int) TimeUnit.MILLISECONDS.toDays(durationInMilliSec); 
	}
	
	// Helper method to convert frequency from String to Double
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
	
	// Converts the frequency to milliseconds
	public long getFreqMillisec () {
		long freqMillisec = 0;
		
		switch(user.getdailyFreq()) {
		case "Twice a day":
			freqMillisec = TimeUnit.HOURS.toMillis(12); // 12 hours to milliseconds
			break;
		case "Once a day":
			freqMillisec = TimeUnit.DAYS.toMillis(1); // 1 day to milliseconds
			break;
		case "Every other day":
			freqMillisec = TimeUnit.DAYS.toMillis(2); // 2 days to milliseconds
			break;
		case "Once a week":
			freqMillisec = TimeUnit.DAYS.toMillis(7); // 7 days to milliseconds
			break;
		}
		return freqMillisec;
	}
	
	// Generates a random duration in milliseconds within the desired time window (8am-8pm)
	public long getRandomDuration(){
		long randomDuration = 0; 
		int randomMillisec = r.nextInt((int)twelveHrMillisec); // Generates a random duration within the 12 hour window (8am-8pm)
		int hourOfDay  = Calendar.HOUR_OF_DAY; // 24 hour clock
		
		if (hourOfDay < 20 && hourOfDay >= 8) {	
			randomDuration = (long)randomMillisec; 
		} else if (hourOfDay < 8) {
			randomDuration = (8 - hourOfDay)*3600000 + randomMillisec; 
		} else {
			randomDuration = (23 - hourOfDay + 8)*3600000 + randomMillisec; 
		}
		return randomDuration; 
	}
	
}
