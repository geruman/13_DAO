package com.geruman.tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.function.ThrowingRunnable;
import org.junit.jupiter.api.Test;

import com.geruman.daos.Ojos;
import com.geruman.daos.UsuarioDTO;
import com.geruman.daos.UsuarioExisteException;
import com.geruman.daos.UsuariosDAO;
import com.geruman.daos.UsuariosDAOInterface;

class UserDAOTests {

	@Test
	void testUsuarioDTO() {
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setNombre("joaquin");
		usuario.setDni(23457897);
		usuario.setColorDeOjos(Ojos.VERDE);
		assertEquals("joaquin",usuario.getNombre());
		assertEquals(23457897,usuario.getDni());
		assertEquals(Ojos.VERDE,usuario.getColorDeOjos());
	}
	@Test
	void testUsuarioDAO() throws UsuarioExisteException{
			UsuariosDAOInterface usuarioDAO = new UsuariosDAO();
			usuarioDAO.insertar(new UsuarioDTO("Javier",24345678,Ojos.AZUL));
			assert usuarioDAO.todosLosUsuarios().size()==1;
			assert null != usuarioDAO.getByDni(24345678);
			assert "Javier".equals(usuarioDAO.getByDni(24345678).getNombre());
			usuarioDAO.eliminarDni(24345678);
			assert null == usuarioDAO.getByDni(24345678);
			usuarioDAO.insertar(new UsuarioDTO("Javier",24345678,Ojos.AZUL));
			usuarioDAO.insertar(new UsuarioDTO("Jorge",18346543,Ojos.MARRON));
			assert 2 == usuarioDAO.todosLosUsuarios().size();
			usuarioDAO.actualizar(18346543,new UsuarioDTO("Jimena",18346543,Ojos.VERDE));
			assertEquals("Jimena",usuarioDAO.getByDni(18346543).getNombre());
			assertThrows(UsuarioExisteException.class,new ThrowingRunnable() {
				public void run() throws Throwable {
					usuarioDAO.insertar(new UsuarioDTO("Jimena",18346543,Ojos.VERDE));
					
				}
			});
			

	}

}
