
/*

Definition: -

Define an interface for creating an object, but let subclasses decide which class to instantiate.
 Factory Method lets a class defer instantiation to subclasses.

*/



/*

Simple Factory :- 
                    There will be interface of base and there will be different implementation of 
                    different class but we dont need to create and maintain objects we have to design 
                    a factory that gives the objects when we ask with user input

    *) Single factory makes all Concrete types of beans 
    *) Properly it is not a design pattern it is a kind of Principle

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

abstract class NotificationFactory {

    abstract public NotificationStrategy createNotification();
    
    public void notifyUser(String reciept, String message) {
        
        NotificationStrategy strategy = createNotification();
        strategy.send(reciept, message);
    }

}

class SMSNotificationFactory extends NotificationFactory{

    @Override
    public NotificationStrategy createNotification(){

        return new SMSNotificationStrategy();
    }
}

class EmailNotificationFactory extends NotificationFactory{

    @Override
    public NotificationStrategy createNotification(){
        return new EmailNotificationStrategy();
    }
}

class PushNotificationFractory extends NotificationFactory {

    @Override
    public NotificationStrategy createNotification(){
        return new PushNotificationStrategy();
    }
}

class NotificationService {

    public static void alertUser(NotificationFactory factory, String reciept, String message) {

        NotificationStrategy strategy = factory.createNotification();
        strategy.send(reciept,message);
    }
}

public class FactoryDesignPattern {

    public static void main(String[] args) {

        NotificationFactory factory = new SMSNotificationFactory();
        NotificationService.alertUser(factory,"Reciept id is OXAJNONA33423", "hi prashanth");
    }
    
}

