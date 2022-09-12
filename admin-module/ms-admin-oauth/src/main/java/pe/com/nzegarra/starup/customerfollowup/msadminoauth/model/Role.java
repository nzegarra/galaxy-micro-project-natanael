package pe.com.nzegarra.starup.customerfollowup.msadminoauth.model;

import java.io.Serializable;
import java.util.List;


public class Role implements Serializable{
	
	private Long id;
	private String nombre;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private static final long serialVersionUID = 1L;
}
