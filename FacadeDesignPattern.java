
/*

Definition :- 

Provide a unified interface to a set of interfaces in a subsystem.
Facade defines a higher-level interface that makes the subsystem easier to use.


*/



class Television {
    public void on(){
         System.out.println("TV turned ON."); 
    }

    public void setInputChannel(String channel){
         System.out.println("TV channel set to: " + channel); 
    }

    public void off(){
         System.out.println("TV turned OFF.");
    }
}

class SoundSystem {
    public void on(){
         System.out.println("Sound system ON.");
    }
    
    public void setVolume(int level){
         System.out.println("Volume set to: " + level);
    }
    
    public void off(){
         System.out.println("Sound system OFF.");
    }
}

class StreamingPlayer {
    public void on(){
         System.out.println("Streaming player ON."); 
    }
    
    public void playMovie(String movie){
         System.out.println("Streaming: '" + movie + "'"); 
    }
    
    public void stop(){ 
        System.out.println("Streaming stopped."); 
    }
    
    public void off(){
         System.out.println("Streaming player OFF."); 
    }
}

class RoomLights {
    public void dim(int percentage){
         System.out.println("Lights dimmed to " + percentage + "%."); 
    }
    
    public void on(){
         System.out.println("Lights turned to 100%."); 
    }
}

class HomeTheaterFacade {
    private final Television tv;
    private final SoundSystem soundSystem;
    private final StreamingPlayer player;
    private final RoomLights lights;

    public HomeTheaterFacade(Television tv, SoundSystem soundSystem, StreamingPlayer player, RoomLights lights) {
        this.tv = tv;
        this.soundSystem = soundSystem;
        this.player = player;
        this.lights = lights;
    }

    public void watchMovie(String movie) {
        System.out.println("Preparing theater for movie");
        lights.dim(20);
        tv.on();
        tv.setInputChannel("HDMI 1");
        soundSystem.on();
        soundSystem.setVolume(25);
        player.on();
        player.playMovie(movie);
    }

    public void endMovie() {
        System.out.println("Shutting down home theater");
        player.stop();
        player.off();
        soundSystem.off();
        tv.off();
        lights.on();
    }
}


public class FacadeDesignPattern {

    public static void main(String[] args){
        Television tv = new Television();
        SoundSystem soundSystem = new SoundSystem();
        StreamingPlayer player = new StreamingPlayer();
        RoomLights lights = new RoomLights();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(tv, soundSystem, player, lights);

        // One simple call replaces 6-7 low-level invocations
        homeTheater.watchMovie("InterStellar");

        homeTheater.endMovie();
    }
}
