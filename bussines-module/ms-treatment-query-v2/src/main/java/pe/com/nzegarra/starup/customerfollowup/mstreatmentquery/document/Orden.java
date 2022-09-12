package pe.com.nzegarra.starup.customerfollowup.mstreatmentquery.document;


import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "Pedido")
public class Orden implements Serializable {

	@Id
    private String id= UUID.randomUUID().toString();

	@Field("idPedido")
	private Long idPedido;

	@Field("clienteId")
	private Long clienteId;
	
	private String clienteRazonSocial;

	@Field("glosa")
	private String glosa;

	@Field("fechaRegistro")
	private String fechaRegistro;

	@Field("total")
	private Double total;

}
