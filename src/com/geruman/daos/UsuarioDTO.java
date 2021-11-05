package com.geruman.daos;

public class UsuarioDTO {
	private String nombre;
	private int dni;
	private Ojos colorDeOjos;

	public UsuarioDTO() {
		
	}
	public UsuarioDTO(String nombre, int dni, Ojos colorDeOjos) {
		this.nombre = nombre;
		this.dni = dni;
		this.colorDeOjos = colorDeOjos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public Ojos getColorDeOjos() {
		return colorDeOjos;
	}
	public void setColorDeOjos(Ojos colorDeOjos) {
		this.colorDeOjos = colorDeOjos;
	}
	@Override
	public String toString() {
		return "Nombre: "+nombre+" dni: "+dni+" Color de ojos: "+colorDeOjos;
	}
}
