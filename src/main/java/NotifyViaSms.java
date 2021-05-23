import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;

//basic code to send sms using amazonaws-sns service
public class NotifyViaSms {
    public static void main(String[] args) {
        // Your Credentials
        String ACCESS_KEY = "YOUR_API_KEY";
        String SECRET_KEY = "YOUR_SECRET_KEY";
        AmazonSNSClient snsClient = new AmazonSNSClient(new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY));
        String message = "YOUR MESSAGE";
        String phoneNumber = "PHONE_NUMBER";  // Ex: +91XXX4374XX
        sendSMSMessage(snsClient, message, phoneNumber);
    }

    // Send SMS to a Phone Number
    public static void sendSMSMessage(AmazonSNSClient snsClient,
                                      String message, String phoneNumber) {
        PublishResult result = snsClient.publish(new PublishRequest()
                .withMessage(message)
                .withPhoneNumber(phoneNumber));
        System.out.println(result); // Prints the message ID.
    }
}
