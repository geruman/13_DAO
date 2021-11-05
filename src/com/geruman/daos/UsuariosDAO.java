package com.geruman.daos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsuariosDAO implements UsuariosDAOInterface {
	private Map<Integer, UsuarioDTO> usuarios;
	public UsuariosDAO() {
		usuarios = new HashMap<Integer, UsuarioDTO>();
	}
	@Override
	public void insertar(UsuarioDTO usuarioDTO) throws UsuarioExisteException{
		if(usuarios.get(usuarioDTO.getDni()) != null) {
			throw new UsuarioExisteException(usuarioDTO.getDni());
		}
		usuarios.put(usuarioDTO.getDni(), usuarioDTO);

	}

	@Override
	public List<UsuarioDTO> todosLosUsuarios() {
		return new ArrayList<UsuarioDTO>(usuarios.values());
	}

	@Override
	public UsuarioDTO getByDni(int dni) {
		return usuarios.get(dni);
	}

	@Override
	public void eliminarDni(int dni) {
		usuarios.remove(dni);

	}

	@Override
	public void actualizar(int dni, UsuarioDTO usuarioDTO) throws UsuarioExisteException {
		if(usuarios.containsKey(dni)) {
			usuarios.remove(dni);
			if(usuarios.containsKey(usuarioDTO.getDni())) {
				throw new UsuarioExisteException(usuarioDTO.getDni());
			}
			usuarios.put(usuarioDTO.getDni(), usuarioDTO);
		}

	}

}
