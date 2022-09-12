package pe.com.nzegarra.starup.customerfollowup.mstreatment.producer;

import pe.com.nzegarra.starup.customerfollowup.mstreatment.document.Treatment;

public interface TreatmentProducer {

	public void sendMessage(Treatment orden);

}
