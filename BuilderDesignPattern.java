import java.util.*;

class HttpRequest {

    private String url;
    private String method;
    private Map<String,String> headers;
    private String body;
    private int timeout;
    
    public HttpRequest(Builder builder){
            this.url = builder.url;
            this.method = builder.method;
            this.headers = builder.headers;
            this.body = builder.body;
            this.timeout = builder.timeout;
        }
    
    public static Builder builder(){
        return new Builder();
    }
    
    public String getUrl(){
        return this.url;
    }

    public String getMethod(){
        return this.method;
    }

    public Map<String, String> getHeaders(){
        return this.headers;
    }

    public String getBody(){
        return this.body;
    }

    public int getTimeout(){
        return this.timeout;
    }

    @Override
    public String toString(){
        return "URL: "+this.url+" ,"+"\n"+
               "Method: "+this.method+" ,"+"\n"+
               "Headers: "+this.headers+" ,"+"\n"+
               "Body: "+this.body+" ,"+"\n"+
               "Timeout: "+this.timeout+"\n";
    }

    public static class Builder {
        private String url;
        private String method;
        private Map<String,String> headers = new HashMap<>();
        private String body;
        private int timeout = 5000;

        public Builder(){}

        public Builder withUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder withMethod(String method) {
            this.method = method;
            return this;
        }

        public Builder withHeaders(String key, String value) {
            this.headers.put(key,value);
            return this;
        }

        public Builder withBody(String body) {
            this.body = body;
            return this;
        }

        public Builder withTimeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public HttpRequest build() {
            if(this.url == null || this.method == null) {
                System.out.println("URL or Method should not be null");
            }

            return new HttpRequest(this);
        }
    }
}

public class BuilderDesignPattern { 
    
    public static void main(String[] args) {
        
        HttpRequest request = HttpRequest.builder()
                                         .withUrl("https://localhost:8080/api/students")
                                         .withMethod("POST")
                                         .withHeaders("Content-Type", "application/json")
                                         .withHeaders("Authorization", "Bearer token_xyz123")
                                         .withBody("{\"id\": \"12406821\", \"major\": \"CSE\", \"year\": 3, \"degree\": \"B.Tech\"}")
                                         .withTimeout(5000)
                                         .build();

        System.out.println(request);
    }
}
