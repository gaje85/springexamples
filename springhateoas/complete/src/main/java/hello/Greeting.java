package hello;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Greeting extends ResourceSupport {

    private  String content = "";
    
    public Greeting(){
    	
    }

    @JsonCreator
    public Greeting(@JsonProperty("contentOne") String contentOne) {
        this.content = contentOne;
    }

    public String getContent() {
        return content;
    }
}
