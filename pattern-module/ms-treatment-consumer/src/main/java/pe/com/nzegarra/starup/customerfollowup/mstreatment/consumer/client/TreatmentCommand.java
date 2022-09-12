package pe.com.nzegarra.starup.customerfollowup.mstreatment.consumer.client;

import pe.com.nzegarra.starup.customerfollowup.mstreatment.document.Treatment;

public interface TreatmentCommand {

	void enviar(Treatment orden);

}
