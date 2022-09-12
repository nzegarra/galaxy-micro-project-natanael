package pe.com.nzegarra.starup.customerfollowup.mstreatment.consumer.client;

import java.util.List;
import java.util.Objects;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import pe.com.nzegarra.starup.customerfollowup.mstreatment.document.Treatment;

@Slf4j
@Component
public class TreatmentCommandImpl implements TreatmentCommand{

	private DiscoveryClient discoveryClient;

	// Client
	private WebClient rest;

	//MS-VENTAS-GESTION-PEDIDOS-COMMAND
	private String uri = "ms-treatment-command-v2";
	private String service_treatmentcommand__gateway="http://app-service-admin-gateway.galaxy-dev.svc.cluster.local:80/api/treatment-command";

	public TreatmentCommandImpl(WebClient.Builder builder, DiscoveryClient discoveryClient) {
		this.discoveryClient = discoveryClient;
		this.rest = builder.baseUrl(service_treatmentcommand__gateway + "/v1/treatment-command").build();
//		this.rest = builder.baseUrl(this.getURI() + "/v1/treatment-command").build();
	}

	@Override
	public void enviar(Treatment orden) {
		try {
			
			log.info("Pre post enviar command [{}]",orden);
			this.getURI();
			log.info("rest  [{}]",rest);
			rest.post()
	        .uri("")
	        .body(BodyInserters.fromValue(orden))
	        .retrieve()
	        .bodyToMono(Treatment.class)
	        .subscribe(System.out::println);
			
			log.info("Post enviar -> command");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private String getURI() {
		List<ServiceInstance> instances = discoveryClient.getInstances(uri);
		System.out.println("getServices");
		discoveryClient.getServices().forEach(System.out::println);
		
		if (Objects.isNull(instances) || instances.isEmpty()) {
			log.info("instances is null");
			return null;
		}
		String uri = instances.get(0).getUri().toString();
		log.info("uri ->" + uri);
		return uri;
	}

}
