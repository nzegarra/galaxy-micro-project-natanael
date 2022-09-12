package pe.com.nzegarra.starup.customerfollowup.mstreatment.configuration;

import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.apache.kafka.clients.consumer.ConsumerConfig;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import org.apache.kafka.common.serialization.StringSerializer;

import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.ProducerListener;
import org.springframework.kafka.support.serializer.JsonSerializer;

import lombok.extern.slf4j.Slf4j;
import pe.com.nzegarra.starup.customerfollowup.mstreatment.document.Treatment;

@Slf4j
@Configuration
public class KafkaTreatmentProducerConfiguration {

	
	@Value("${custom.kafka.bootstrap-servers}")
	private String bootstrapServers;

	@Bean
	public ProducerFactory<String, Treatment> ordenProducerFactory() {
		
		Map<String, Object> configProps = new HashMap<>();
		
		configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		
		return new DefaultKafkaProducerFactory<>(configProps);
	}
	
	@Bean 
	public KafkaTemplate<String, Treatment> ordenKafkaTemplate() {
	
		KafkaTemplate<String, Treatment> kafkaTemplate = new KafkaTemplate<>(ordenProducerFactory());

		kafkaTemplate.setProducerListener(new ProducerListener<String, Treatment>() {

			@Override
			public void onSuccess(ProducerRecord<String, Treatment> producerRecord, RecordMetadata recordMetadata) {

				log.info("Mensaje publicado con exito: {}  offset:  {}", producerRecord.value(), recordMetadata.offset());
				
			}

			@Override
			public void onError(ProducerRecord<String, Treatment> producerRecord, RecordMetadata recordMetadata,
					Exception exception) {
				log.warn("Error al publicar el mensaje [{}] exception: {}", producerRecord.value(), exception.getMessage());
			}
		});
		return kafkaTemplate;
	}
	
}
