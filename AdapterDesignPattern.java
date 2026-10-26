
/*

Defination:- 

Convert the interface of a class into another interface clients expect.
Adapter lets classes work together that couldn't otherwise because of incompatible interfaces.

*/




interface PaymentProcessor {

    void processPayment(double amount);
}

// Normal payment when both are compatable
class CreditCardProcessor implements PaymentProcessor{

    public void processPayment(double amount) {
        System.out.println("Charged through CreditCard "+amount);
    }
}


// this is legacy third party module
class PaypalProcessor {

    public void makePayment(String currencyCode, double amount) {
        System.out.println("Paypal charged "+amount+" currency of "+currencyCode);
    }
}

class PaypalAdapter implements PaymentProcessor{

    PaypalProcessor paypalProcessor;

    public PaypalAdapter(PaypalProcessor paypalProcessor){
        this.paypalProcessor = paypalProcessor;
    }

    public void processPayment(double amount) {
        
        System.out.println("Paypal charging through adapter");
        paypalProcessor.makePayment("INR",amount);
    }
}


public class AdapterDesignPattern {
    
    PaymentProcessor paymentProcessor;

    public AdapterDesignPattern(PaymentProcessor paymentProcessor){
        this.paymentProcessor = paymentProcessor;
    }

    public void checkOut(double amount){
        paymentProcessor.processPayment(amount);
    }   

    public static void main(String[] args) {
        

        // Normal credit card payment when both are compatable
        // PaymentProcessor paymentProcessor = new CreditCardProcessor();
        // AdapterDesignPattern pattern = new AdapterDesignPattern(paymentProcessor);

        // pattern.checkOut(99999.9999);


        // When both are not compatable they talk via adapter

        PaypalProcessor paypalProcessor = new PaypalProcessor();
        PaypalAdapter paypalAdapter = new PaypalAdapter(paypalProcessor);
        AdapterDesignPattern pattern = new AdapterDesignPattern(paypalAdapter);

        pattern.checkOut(9999999.999);

    }
}
