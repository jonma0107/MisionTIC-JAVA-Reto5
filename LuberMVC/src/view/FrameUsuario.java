package view;

import controllers.UsuarioController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import model.UsuarioModel;
import utils.SpringUtilities;

public class FrameUsuario extends JFrame {
    JTextField textFieldUsu_cc; 
    JTextField textFieldUsu_nombre; 
    JTextField textFieldUsu_apellido; 
    JTextField textFieldUsu_email;
    UsuarioController controller;
    PanelUsuario listadoPanel;
    boolean editar = false;
    
    FrameUsuario(){
        controller = new UsuarioController();
        initComponents();
    }
    
    private void initComponents(){
        // Al cerrar la ventana se finaliza la ejecución del programa
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        // Establece el titulo de la ventana
        setTitle("Inscripción de Usuarios");
        
        // Establece el aspecto de la distribución utilizada
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        JPanel panel = new JPanel(new SpringLayout());

        //Create and populate the panel.
        JLabel l = new JLabel("Cédula Usuario", JLabel.TRAILING);
        panel.add(l);
        textFieldUsu_cc = new JTextField(20);
        l.setLabelFor(textFieldUsu_cc);
        panel.add(textFieldUsu_cc);
        
        l = new JLabel("Nombre Usuario", JLabel.TRAILING);
        panel.add(l);
        textFieldUsu_nombre = new JTextField(20);
        l.setLabelFor(textFieldUsu_nombre);
        panel.add(textFieldUsu_nombre);

        l = new JLabel("Apelido Usuario", JLabel.TRAILING);
        panel.add(l);
        textFieldUsu_apellido = new JTextField(20);
        l.setLabelFor(textFieldUsu_apellido);
        panel.add(textFieldUsu_apellido);

        l = new JLabel("Email Usuario", JLabel.TRAILING);
        panel.add(l);
        textFieldUsu_email = new JTextField(20);
        l.setLabelFor(textFieldUsu_email);
        panel.add(textFieldUsu_email);
        
        JButton btnSubmit = new JButton("Guardar Nuevo Usuario");
        panel.add(btnSubmit);
        JPanel panelBtn = new JPanel(new GridLayout());
        JButton btnClear = new JButton("Limpiar Campos");
        panelBtn.add(btnClear);
        JButton btnListar = new JButton("Refresh");
        panelBtn.add(btnListar);
        
        panel.add(panelBtn);
        
        btnSubmit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                btnSubmitClick();
            }
        });

        btnClear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                btnClearClick();
            }
        });

        btnListar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                btnListarClick();
            }
        }); 
        
        //Lay out the panel.
        SpringUtilities.makeCompactGrid(panel,
                                        5, 2, //rows, cols
                                        15, 15,        //initX, initY
                                        15, 15);       //xPad, yPad        
        // Sirve de panel principal de la ventana
        JPanel panelPrincipal = new JPanel();
        setContentPane(panelPrincipal);
        panelPrincipal.add(panel);
        
        listadoPanel = new PanelUsuario(controller);
        
        JPanel panelBtn2 = new JPanel();
        JButton btnEditar = new JButton("Editar");
        panelBtn2.add(btnEditar);
        JButton btnEliminar = new JButton("Eliminar");
        panelBtn2.add(btnEliminar);
        listadoPanel.add(panelBtn2, BorderLayout.PAGE_END);
        
        btnEditar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                btnEditarClick();
            }
        });

        btnEliminar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                btnEliminarClick();
            }
        });
        
        panelPrincipal.add(listadoPanel);
        pack();
        //setSize(800, 600);
        
        // Permite ubicar la ventana en el centro de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation((screenSize.width - frameSize.width) / 2, 
                (screenSize.height - frameSize.height) / 2);
        
        // Hace que la ventana de la aplicación sea visible
        setVisible(true);
    
    }
    
    // MÉTODOS DE LOS BOTONES  
    public void btnSubmitClick(){
        try {
            int usu_cc = Integer.parseInt(textFieldUsu_cc.getText());
            String usu_nombre = textFieldUsu_nombre.getText();
            String usu_apellido = textFieldUsu_apellido.getText();
            String usu_email = textFieldUsu_email.getText();
        
            UsuarioModel usuario = new UsuarioModel(usu_cc, usu_nombre, usu_apellido, usu_email);
            if(editar){
                controller.actualizarUsuario(usuario);
                editar = false;
            }else
                controller.agregarUsuario(usuario);
            btnClearClick();
            listadoPanel.cargarUsuarios();
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Ingresa los valores correctos");
        }
    }
    
    public void btnClearClick(){
        textFieldUsu_cc.setText(null);
        textFieldUsu_nombre.setText(null);
        textFieldUsu_apellido.setText(null);
        textFieldUsu_email.setText(null);
    }
    
    public void btnListarClick(){
        listadoPanel.cargarUsuarios();
    }
    
    public void btnEditarClick(){
        int selected = this.listadoPanel.getTable().getSelectedRow();
        if (selected != -1){
            JTable table = listadoPanel.getTable();
            textFieldUsu_cc.setText((String)table.getValueAt(selected, 0));
            textFieldUsu_nombre.setText((String)table.getValueAt(selected, 1));
            textFieldUsu_apellido.setText((String)table.getValueAt(selected, 2));
            textFieldUsu_email.setText((String)table.getValueAt(selected, 3));
            editar = true;
        }
    }
    
    public void btnEliminarClick(){
        int selected = this.listadoPanel.getTable().getSelectedRow();
        if (selected != -1){
            String id = ((String) this.listadoPanel.getTable().getValueAt(selected, 0));
            controller.eliminarUsuario(Integer.parseInt(id));
            this.listadoPanel.cargarUsuarios();
        }
    }
    
    public static void main(String[] args) {
        new FrameUsuario();
    }
}
