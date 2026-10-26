import java.util.*;

interface ObservableChannel {

    void subscribe(ObserverSubscriber subscriber);
    void unSubscribe(ObserverSubscriber subscriber);
    void notifySubscribers(String videoTitle);
    void uploadVideo(String videoTitle);

}

class ConcreteChannel implements ObservableChannel{

    private List<ObserverSubscriber> subscribers;
    private List<String> videoTitles;
    private String channelName;

    public ConcreteChannel(String channelName){
        subscribers = new ArrayList<>();
        videoTitles = new ArrayList<>();
        this.channelName = channelName;
    }

    @Override
    public void subscribe(ObserverSubscriber subscriber){

        if(subscriber == null || subscribers.contains(subscriber)) return;
        subscribers.add(subscriber);
    }

    @Override
    public void unSubscribe(ObserverSubscriber subscriber) {
        
        if(subscriber == null || !subscribers.contains(subscriber)) return;
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(String videoTitle){

        for(ObserverSubscriber subscriber : subscribers) {
            subscriber.update(channelName,videoTitle);
        }
    }

    public void uploadVideo(String videoTitle) {

        if(videoTitle == null || videoTitles.contains(videoTitle)) return;
        videoTitles.add(videoTitle);

        notifySubscribers(videoTitle);
    }

}

interface ObserverSubscriber {

    void update(String channelName, String videoTitle);

}

class ConcreteSubscriber implements ObserverSubscriber {

    private String subscriberName;

    public ConcreteSubscriber(String name){

        this.subscriberName = name;

    }

    public void update(String channelName, String videoTitle) {

        System.out.println("Hello "+subscriberName+" a new video uploaded "+videoTitle+" by "+channelName);
    }


}

public class ObserverDesignPattern {

    public static void main(String[] args) {

        ObserverSubscriber prashanth = new ConcreteSubscriber("Prashanth");
        ObserverSubscriber sarfraz = new ConcreteSubscriber("Sarfraz");
        ObserverSubscriber pavan = new ConcreteSubscriber("Pavan");

        ObservableChannel channel = new ConcreteChannel("Code in java");
        channel.subscribe(prashanth);
        channel.subscribe(sarfraz);
        channel.subscribe(pavan);

        channel.uploadVideo("LLD series");

        
    }
    
}
