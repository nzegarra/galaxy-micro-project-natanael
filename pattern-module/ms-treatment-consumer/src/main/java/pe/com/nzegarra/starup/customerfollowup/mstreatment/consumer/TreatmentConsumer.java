package pe.com.nzegarra.starup.customerfollowup.mstreatment.consumer;

import pe.com.nzegarra.starup.customerfollowup.mstreatment.document.Treatment;

public interface TreatmentConsumer {

	public void consumeMessage(Treatment orden);

}
