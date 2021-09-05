package controllers;

import access.InterfaceDAO;
import access.UsuarioDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.UsuarioModel;
//import view.FrameUsuario;
//import view.PanelUsuario;

public class UsuarioController {
    private InterfaceDAO usuarioDAO;

    public UsuarioController() {
        this.usuarioDAO = new UsuarioDAO();
    }

//    public UsuarioController(FrameUsuario vista, PanelUsuario panel, InterfaceDAO control) {
////        System.out.println("Conectado a la base de datos!");
//    }
    
    public DefaultTableModel consultarUsuarios(){
        String[] nombres  =  {"Cédula Usuario", "Nombre Usuario", "Apellido Usuario", "Email Usuario"};
        DefaultTableModel modelo = new DefaultTableModel(null, nombres);
        List <UsuarioModel>  usuarios  = usuarioDAO.obtenerUsuarios();
        for(UsuarioModel usuario: usuarios){
            String[] registro = new String[4];
            registro[0] = usuario.getUsu_cc()+"";
            registro[1] = usuario.getUsu_nombre();
            registro[2] = usuario.getUsu_apellido();
            registro[3] = usuario.getUsu_email();
            modelo.addRow(registro);
    }
        return modelo;
    
    }    
    
    public void agregarUsuario(UsuarioModel usuario){
        usuarioDAO.agregarUsuario(usuario);
    }

    public void actualizarUsuario(UsuarioModel usuario){
        usuarioDAO.actualizarUsuario(usuario);
    } 
    
    public void eliminarUsuario(int usu_cc){
        usuarioDAO.eliminarUsuario(usu_cc);
    } 
}
