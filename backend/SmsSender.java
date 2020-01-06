package backend;

//Install the Java helper library from twilio.com/docs/libraries/java
import com.twilio.Twilio; 
import com.twilio.rest.api.v2010.account.Message; 
import com.twilio.type.PhoneNumber;

public class SmsSender {
	// Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID =
            "AC0adc56719ee8405ae27948c292d0456a";
    public static final String AUTH_TOKEN =
            "469722a6cbeb5a8c44d5917e4ef87fa4";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message
                .creator(new PhoneNumber("+19086721894"), // to
                        new PhoneNumber("+13605295695" + 
                        		""), // from
                        "Welcome to Motivate! Let's accomplish your goal!")
                .create();

        System.out.println(message.getSid());
    }
}
