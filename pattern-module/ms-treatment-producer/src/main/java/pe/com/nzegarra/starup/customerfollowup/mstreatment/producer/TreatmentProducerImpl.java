package pe.com.nzegarra.starup.customerfollowup.mstreatment.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.kafka.core.KafkaTemplate;

import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import pe.com.nzegarra.starup.customerfollowup.mstreatment.document.Treatment;

@Slf4j
@Service
public class TreatmentProducerImpl implements TreatmentProducer {

	@Value("${custom.kafka.topic-name}")
	private String topicName;

	@Autowired
	private KafkaTemplate<String, Treatment> ordenKafkaTemplate;

	@Override
	public void sendMessage(Treatment orden) {
		log.info("send taller", orden);
		log.info("topicName", topicName);
		ordenKafkaTemplate.send(topicName, orden);
	}

}
