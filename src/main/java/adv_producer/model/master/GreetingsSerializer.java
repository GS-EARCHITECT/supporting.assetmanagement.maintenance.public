package adv_producer.model.master;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import org.apache.kafka.common.serialization.Serializer;
import org.springframework.context.annotation.Configuration;

public class GreetingsSerializer implements Serializer<Greeting> {

	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
	}

	@Override
	public byte[] serialize(String topic, Greeting data) {
		try {
			return objectMapper.writeValueAsBytes(data);
		} catch (JsonProcessingException e) {

			return null;
		}
	}

	@Override
	public void close() {
	}

}
