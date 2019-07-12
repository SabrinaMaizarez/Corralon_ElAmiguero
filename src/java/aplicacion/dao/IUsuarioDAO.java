/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dao;

import aplicacion.modelo.dominio.Usuario;
import java.util.List;


/**
 *
 * @author fliaMaizarez
 */
public interface IUsuarioDAO {
    void agregarUsuario(Usuario unUsuario);
    void eliminarUsuario(Usuario unUsuario);
    Usuario validarUsuario(String nombreUsuario, String password);
    Usuario obtenerUsuario(String nombreUsuario);
    List <Usuario> obtenerListaUsuariosActivos();
    void modificar(Usuario unUsuario);
}
