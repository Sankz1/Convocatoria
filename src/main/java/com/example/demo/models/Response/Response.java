package com.example.demo.models.Response;
public class Response<T>{
	private String mensaje;
	private T Entity;
	public Response(String mensaje, T entity) {
		super();
		this.mensaje = mensaje;
		Entity = entity;
	}
	
	public Response(String mensaje) {
		super();
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public T getEntity() {
		return Entity;
	}
	public void setEntity(T entity) {
		Entity = entity;
	}
	
	
	
}