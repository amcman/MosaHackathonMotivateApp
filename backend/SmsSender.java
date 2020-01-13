package backend;

import java.util.ArrayList;
import java.util.Random;

//Install the Java helper library from twilio.com/docs/libraries/java
import com.twilio.Twilio; 
import com.twilio.rest.api.v2010.account.Message; 
import com.twilio.type.PhoneNumber;

public class SmsSender {
	
	User user; 
	ArrayList<String> motiMsgs;
	
	public SmsSender(User u) {
		this.user = u; 
		this.motiMsgs = user.getMsg();
	}
		
	// Find your Account Sid and Auth Token at twilio.com/console
	public static final String ACCOUNT_SID =
		      "AC0adc56719ee8405ae27948c292d0456a";
	public static final String AUTH_TOKEN =
		      "087e44ec23a27114251f484858c706f4";
    // Text the user the initial welcome message
    public void sendWelcome() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber(user.getPhone()), // to
                        new PhoneNumber("+13605295695" + 
                        		""), // from
                        "Welcome to Motivate! Let's accomplish your goal!")
                .create();

        System.out.println(message.getSid());
    }
    
    
    // Text the user a random motivational message
    public void sendSms() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber(user.getPhone()), // to
                        new PhoneNumber("+13605295695" + 
                        		""), // from
                        getRandomMessage())
                .create();

        System.out.println(message.getSid());
    }
    
    // Generate a random message from the ArrayList of motivational messages the user entered
    public String getRandomMessage() {
    	
    	Random r = new Random(); 
    	int randomIndex = r.nextInt(motiMsgs.size());
    	
		return motiMsgs.get(randomIndex);
    	
    }
}
