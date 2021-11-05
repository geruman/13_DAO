package com.geruman;

import com.geruman.daos.Ojos;
import com.geruman.daos.UsuarioDTO;
import com.geruman.daos.UsuarioExisteException;
import com.geruman.daos.UsuariosDAO;
import com.geruman.daos.UsuariosDAOInterface;

public class DAODemoMain {

	public static void main(String[] args) {
		UsuariosDAOInterface usuariosDAO = new UsuariosDAO();
		try {
			usuariosDAO.insertar(new UsuarioDTO("Clara",23345678,Ojos.AZUL));
			usuariosDAO.insertar(new UsuarioDTO("Alfonsin",12294578,Ojos.MARRON));
			usuariosDAO.insertar(new UsuarioDTO("Nelson",35678643,Ojos.VERDE));
			usuariosDAO.insertar(new UsuarioDTO("Nicolas",23456787,Ojos.AZUL));
			imprimirUsuarios(usuariosDAO);
			System.out.println("El usuario"+usuariosDAO.getByDni(23456787)+" se actualizo a ");
			usuariosDAO.actualizar(23456787, new UsuarioDTO("Mariano",24569876,Ojos.MARRON));
			System.out.println(usuariosDAO.getByDni(24569876));
			System.out.println();
			System.out.println("Ahora la lista de usuarios es: ");
			imprimirUsuarios(usuariosDAO);
			System.out.println("Ahora borro al dni 24569876");
			usuariosDAO.eliminarDni(24569876);
			System.out.println("Y la lista queda...");
			imprimirUsuarios(usuariosDAO);
			System.out.println("Voy a buscar un dni en el dao");
			System.out.println(usuariosDAO.getByDni(35678643));
			
		} catch (UsuarioExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void imprimirUsuarios(UsuariosDAOInterface usuariosDAO) {
		for(UsuarioDTO usuario: usuariosDAO.todosLosUsuarios()) {
			System.out.println(usuario);
		}
	}
}
