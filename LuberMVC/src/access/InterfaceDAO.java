package access;

import java.util.List;
//import model.ConductorModel;
import model.UsuarioModel;

public interface InterfaceDAO {
    public List<UsuarioModel> obtenerUsuarios();
    public UsuarioModel obtenerUsuario(int usu_cc);
    public void agregarUsuario(UsuarioModel usuario);
    public void actualizarUsuario(UsuarioModel usuario);
    public void eliminarUsuario(int usu_cc);
    
//    public List<ConductorModel> obtenerConductores();
//    public ConductorModel obtenerConductor(int usu_cc_fk);
//    public void agregarConductor(ConductorModel conductor);
//    public void actualizarConductor(ConductorModel conductor);
//    public void eliminarConductor(int usu_cc_fk);

       
    
}
