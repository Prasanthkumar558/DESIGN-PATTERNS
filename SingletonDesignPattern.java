
/*

Definition: -

Ensure a class only has one instance, and provide a global point of access to it.


*/



/**
 *  When ever we need only one object for class and that one object is only visible to every where in application so we
 *  use singleton design pattern
 * 
 * Best examples is Logger in applications and database connnections in this situations we can use singleton design pattern
 * SingletonDesignPattern
 */


/**
 * Eager initialization
 * While in multithreaded environment this will create multiple instances
 * SingletonDesignPattern
 */
 
class Logger {
    
    public static volatile Logger instance = new Logger();

    private Logger(){}

    public static Logger getInstance(){
        return instance;
    }
}

/**
 * Lazy with synchronized function
 * Still in multithreaded environment it will cause to much delay because multithreading
 * SingletonDesignPattern
 */

class DatabaseConnection {

    private static volatile DatabaseConnection instance;

    private DatabaseConnection(){}

    public static synchronized DatabaseConnection getInstance(){

        if(instance == null){
            instance = new DatabaseConnection();
        }

        return instance;
    }
}


/**
 * Double check locking 
 * It is optimzed way
 * SingletonDesignPattern
 */

class Singleton {

    private static volatile Singleton instance;

    private Singleton(){}

    public static Singleton getInstance(){

        if(instance == null) {

            synchronized(Singleton.class) {

                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}


public class SingletonDesignPattern {

    public static void main(String[] args) {
        
    }
    
}
