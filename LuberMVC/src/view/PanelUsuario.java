package view;

import controllers.UsuarioController;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelUsuario extends JPanel {
   private JTable table;
   private UsuarioController controller;
    
    public PanelUsuario(UsuarioController controller){
        this.controller = controller;
        initComponents();
        cargarUsuarios();
}

//    public PanelUsuario() {
//        
//    }

    private void initComponents() {
        table = new JTable();
        setLayout(new BorderLayout());
        JScrollPane jsp  = new JScrollPane(table);
        add(jsp);
        //cargarUsuarios();
    }

    public void cargarUsuarios() {
        table.setModel(controller.consultarUsuarios());
    }
    
    public void buscarUsuario(String dato, int validacion) {
        table.setModel(controller.buscarUsuario(dato, validacion));
    }
    
    public JTable getTable() {
        return table;
    }
}    
