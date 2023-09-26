package adv_producer.model.master;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import org.apache.kafka.common.serialization.Deserializer;

public class GreetingsDeSerializer implements Deserializer<Greeting> 
{
    
	 private ObjectMapper objectMapper = new ObjectMapper();

	    @Override
	    public void configure(Map<String, ?> configs, boolean isKey) {
	    }

	    @Override
	    public Greeting deserialize(String topic, byte[] data) {
	        try {
	            return objectMapper.readValue(new String(data, "UTF-8"), Greeting.class);
	        } catch (Exception e) {	           
	            return null;
	        }
	    }

	    @Override
	    public void close() {
	    }
}