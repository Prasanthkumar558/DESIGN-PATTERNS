
/*

Definition: -

Define a family of algorithms, encapsulate each one, and make them interchangeable.
 Strategy lets the algorithm vary independently from clients that use it.

*/




interface NotificationStrategy {

    void send(String reciept, String message);
}

class SMSNotificationStrategy implements NotificationStrategy {

    @Override
    public void send(String reciept, String message){
        System.out.println("Sending sms notification "+message);
    }
}

class EmailNotificationStrategy implements NotificationStrategy {

    @Override
    public void send(String reciept, String message){
        System.out.println("Sending email notification "+message);
    }
}

class PushNotificationStrategy implements NotificationStrategy {

    @Override
    public void send(String reciept, String message){
        System.out.println("Sending push notification "+message);
    }
}

class NotificationService {

    NotificationStrategy strategy;


    public NotificationService(){}

    public NotificationService(NotificationStrategy strategy){
        this.strategy = strategy;
    }

    public void setStrategy(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    public void sendAlert(String reciept, String message) throws Exception{
        
        if(strategy == null) {
            throw new Exception("Error occured because strategy not defined");
        }
    }

}

class client {

    public static void main(String[] args) {

        NotificationService notificationService = new NotificationService(new EmailNotificationStrategy());
        try{
            notificationService.sendAlert("ABC","Your password is 12231121543");
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        notificationService.setStrategy(new SMSNotificationStrategy());
        
        try{
            notificationService.sendAlert("DEF","Your password is 08898778768767");
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }
}



public class StrategyDesignPattern {
    
    
}

/*

Mainly to change behaviour dynamically

*/