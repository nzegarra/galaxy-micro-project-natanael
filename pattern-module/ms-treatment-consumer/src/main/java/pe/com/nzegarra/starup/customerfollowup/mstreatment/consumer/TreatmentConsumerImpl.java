package pe.com.nzegarra.starup.customerfollowup.mstreatment.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import pe.com.nzegarra.starup.customerfollowup.mstreatment.consumer.client.TreatmentCommand;
import pe.com.nzegarra.starup.customerfollowup.mstreatment.document.Treatment;

@Slf4j
@Service
public class TreatmentConsumerImpl implements TreatmentConsumer {

	
	  private TreatmentCommand orderCommand;
	  
	  public TreatmentConsumerImpl(TreatmentCommand orderCommand) {
	  this.orderCommand=orderCommand; }
	 
	
	@KafkaListener(
			topics = "${custom.kafka.topic-name}",
			groupId = "${custom.kafka.group-id}",
			containerFactory = "ordenKafkaListenerContainerFactory")
	@Override
	public void consumeMessage(Treatment orden) {
		log.info("Consumer message [{}]", orden);
		
		orderCommand.enviar(orden);
	}

}
