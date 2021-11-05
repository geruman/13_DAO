package com.geruman.daos;

public class UsuarioExisteException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioExisteException(Integer dni) {
		super("El usuario con ese dni ya existe, no se puede insertar.DNI:"+dni);
	}
}
