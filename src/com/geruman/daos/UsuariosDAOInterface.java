package com.geruman.daos;

import java.util.List;

public interface UsuariosDAOInterface {

	void insertar(UsuarioDTO usuarioDTO) throws UsuarioExisteException;

	List<UsuarioDTO> todosLosUsuarios();

	UsuarioDTO getByDni(int dni);

	void eliminarDni(int dni);

	void actualizar(int dni, UsuarioDTO usuarioDTO) throws UsuarioExisteException;

}
