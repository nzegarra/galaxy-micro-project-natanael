package pe.com.nzegarra.starup.customerfollowup.mstreatment.configuration;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import pe.com.nzegarra.starup.customerfollowup.mstreatment.document.Treatment;

@Configuration
public class KafkaConsumerConfiguration {

	@Value("${custom.kafka.bootstrap-servers}")
	private String bootstrapServers;

	@Value("${custom.kafka.group-id}")
	private String groupId;

	public ConsumerFactory<String, Treatment> ordenConsumerFactory() {
	
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);

		JsonDeserializer<Treatment> jsonDeserializer = new JsonDeserializer<>(Treatment.class);
		jsonDeserializer.addTrustedPackages("*");
		return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),jsonDeserializer);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Treatment> ordenKafkaListenerContainerFactory() {
		
		ConcurrentKafkaListenerContainerFactory<String, Treatment> factory = new ConcurrentKafkaListenerContainerFactory<>();
		
		factory.setConsumerFactory(ordenConsumerFactory());
		
		return factory;
	}	
}
