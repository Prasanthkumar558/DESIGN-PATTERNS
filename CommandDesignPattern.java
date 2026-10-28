
class Light {

    public void on(){
        System.out.println("Light is turned on...");
    }

    public void off(){
        System.out.println("Light is turned off...");
    }
}

class Fan {
    
    public void on(){
        System.out.println("Fan is turned on...");
    }

    public void off(){
        System.out.println("Fan is turned off...");
    }
}

interface Command {

    void execute();
    void undo();

}

class LightCommand implements Command{

    Light light;
    public LightCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute(){
        light.on();
    }

    @Override
    public void undo(){
        light.off();
    }

}

class FanCommand implements Command {

    Fan fan;

    public FanCommand(Fan fan){
        this.fan = fan;
    }

    @Override
    public void execute(){
        fan.on();
    }

    @Override
    public void undo(){
        fan.off();
    }
}

class Remote {

    private int buttons;
    private Command[] commands;
    private boolean[] turnOrOff;

    public Remote(int buttons){
        this.buttons = buttons;

        commands = new Command[buttons];
        turnOrOff = new boolean[buttons];
    }

    public void setCommand(int index, Command command){

        if(index < 0 || index >= buttons){
            System.out.println("Please press button properly");
        }

        if(command == null){
            System.out.println("Command should not be null");
        }

        commands[index] = command;
    }

    public void resetCommand(int index){

        if(index < 0 || index >= commands.length){
            System.out.println("Please press button properly");
        }

        commands[index] = null;
    }

    public void pressButton(int index) {
        if(index < 0 || index >= commands.length  || commands[index] == null){
            System.out.println("Please press button properly || command of button should have assigned");
        }

        if(turnOrOff[index] == false){
            commands[index].execute();
            turnOrOff[index] = true;
        }
        else{
            commands[index].undo();
        }
    }

}

public class CommandDesignPattern {

    public void main(String[] args) {

        Remote remote = new Remote(2);
        Light light = new Light();
        Fan fan = new Fan();
        LightCommand lightCommand = new LightCommand(light);
        FanCommand fanCommand = new FanCommand(fan);

        remote.setCommand(0,lightCommand);
        remote.setCommand(1,fanCommand);
    
        remote.setCommand(0,fanCommand);

        remote.pressButton(0);
        remote.pressButton(0);
    }
}
