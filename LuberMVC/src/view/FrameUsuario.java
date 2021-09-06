package view;

import controllers.UsuarioController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.JTextArea;
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
    JTextArea areaDeTexto1;
    JTextArea areaDeTexto2;
    JTextArea areaDeTexto3;
    JTextArea areaDeTexto4;
    
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
        
        panel.setBackground(new Color(207,217,255));

        //Create and populate the panel.
        JLabel l = new JLabel("Cédula Usuario", JLabel.TRAILING);
        panel.add(l);
        textFieldUsu_cc = new JTextField(20);
        TextPrompt placeholder1 = new TextPrompt("Ingrese sólo números", textFieldUsu_cc);
        placeholder1.changeAlpha(150);
        l.setLabelFor(textFieldUsu_cc);
        panel.add(textFieldUsu_cc);
        
        l = new JLabel("Nombre Usuario", JLabel.TRAILING);
        panel.add(l);
        textFieldUsu_nombre = new JTextField(20);
        TextPrompt placeholder2 = new TextPrompt("Ingrese sólo letras", textFieldUsu_nombre);
        placeholder2.changeAlpha(150);
        l.setLabelFor(textFieldUsu_nombre);
        panel.add(textFieldUsu_nombre);

        l = new JLabel("Apelido Usuario", JLabel.TRAILING);
        panel.add(l);
        textFieldUsu_apellido = new JTextField(20);
        TextPrompt placeholder3 = new TextPrompt("Ingrese sólo letras", textFieldUsu_apellido);
        placeholder3.changeAlpha(150);
        l.setLabelFor(textFieldUsu_apellido);
        panel.add(textFieldUsu_apellido);

        l = new JLabel("Email Usuario", JLabel.TRAILING);
        panel.add(l);
        textFieldUsu_email = new JTextField(20);
        TextPrompt placeholder4 = new TextPrompt("Ingrese sólo letras", textFieldUsu_email);
        placeholder4.changeAlpha(150);
        l.setLabelFor(textFieldUsu_email);
        panel.add(textFieldUsu_email);
        
        JPanel panelBtn = new JPanel(new FlowLayout());
        JButton btnSubmit = new JButton("Guardar Usuario");
        panel.add(btnSubmit);        
        //JPanel panelBtn = new JPanel(new GridLayout());
        JButton btnClear = new JButton("Limpiar Campos");
        panelBtn.add(btnClear);
        JButton btnListar = new JButton("Refrescar");
        panelBtn.add(btnListar);
        JButton btnBuscar = new JButton("Buscar");
        panelBtn.add(btnBuscar);
        panelBtn.setBackground(new Color(207,217,255));
                
        panel.add(panelBtn);
        //btnSubmit.setBackground(Color.yellow);//setsetBackground(new Color(207,217,255));
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
        
        btnBuscar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0){
                btnBuscarClick();
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
        
        panelPrincipal.setBackground(new Color(207,217,255));
        //setBackground(new Color(int R,int G,int B));
        
        areaDeTexto1 = new JTextArea();
        areaDeTexto1.setText("");
        areaDeTexto1.setEditable(false);
        Font font = new Font("Arial", Font.ITALIC, 12);
        //Font font2 = new Font("Arial", Font.BOLD, 12);
        areaDeTexto1.setFont(font);
        areaDeTexto1.setForeground(new Color(46,55,89));
        areaDeTexto1.setBackground(new Color(207,217,255));
        panelPrincipal.add(areaDeTexto1);
        
        
        areaDeTexto2 = new JTextArea();
        areaDeTexto2.setText("");
        areaDeTexto2.setEditable(false);
        Font font1 = new Font("Arial", Font.PLAIN, 12);
        areaDeTexto2.setFont(font1);
        areaDeTexto2.setForeground(new Color(65,79,128));
        areaDeTexto2.setBackground(new Color(207,217,255));
        panelPrincipal.add(areaDeTexto2);
        
        areaDeTexto3 = new JTextArea();
        areaDeTexto3.setText("");
        areaDeTexto3.setEditable(false);
        Font font2 = new Font("Arial", Font.PLAIN, 12);
        areaDeTexto3.setFont(font2);
        areaDeTexto3.setForeground(new Color(65,79,128));
        areaDeTexto3.setBackground(new Color(207,217,255));
        panelPrincipal.add(areaDeTexto3);
        
        
        JPanel panelBtn2 = new JPanel();
        areaDeTexto4 = new JTextArea();
        areaDeTexto4.setText("Seleccione dando un click encima del registro que desea editar o eliminar");
        areaDeTexto4.setEditable(false);
        Font font3 = new Font("Arial", Font.PLAIN, 12);
        areaDeTexto4.setFont(font3);
        //areaDeTexto4.setForeground(new Color(65,79,128));
        areaDeTexto4.setBackground(new Color(207,217,255));
        panelBtn2.add(areaDeTexto4);
        JButton btnEditar = new JButton("Editar");
        panelBtn2.add(btnEditar);
        JButton btnEliminar = new JButton("Eliminar");
        panelBtn2.add(btnEliminar);
        panelBtn2.setBackground(new Color(207,217,255));
                        
        listadoPanel.add(panelBtn2, BorderLayout.PAGE_END);
        listadoPanel.add(areaDeTexto1, BorderLayout.LINE_END);
        listadoPanel.add(areaDeTexto2, BorderLayout.PAGE_START);
        listadoPanel.add(areaDeTexto3, BorderLayout.WEST);
        //listadoPanel.add(areaDeTexto4, BorderLayout.PAGE_END);
              
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
    
    public void btnBuscarClick(){
        try{
        String usu_cc = textFieldUsu_cc.getText();
        String usu_nombre = textFieldUsu_nombre.getText();
        String usu_apellido = textFieldUsu_apellido.getText();
        String usu_email = textFieldUsu_email.getText();
        int validacion;
        if(usu_cc.length() != 0){
            validacion = 1; 
            listadoPanel.buscarUsuario(usu_cc, validacion);
        }
        if(usu_nombre.length() != 0){
            validacion = 2; 
            listadoPanel.buscarUsuario(usu_nombre, validacion);
        }    
        if(usu_apellido.length() != 0){
            validacion = 3; 
            listadoPanel.buscarUsuario(usu_apellido, validacion);     
        }
        if(usu_email.length() != 0){
            validacion = 4; 
            listadoPanel.buscarUsuario(usu_email, validacion);     
        } 
//        } if(usu_nombre.length() != 0){
//            validacion = 2; 
//            listadoPanel.buscarUsuario(usu_nombre, validacion);
//        
//        } if(usu_apellido.length() != 0){
//            validacion = 3; 
//            listadoPanel.buscarUsuario(usu_apellido, validacion);
//        
//        } else {//(usu_email.length() != 0){
//            validacion = 4; 
//            listadoPanel.buscarUsuario(usu_email, validacion);
        btnClearClick();
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Ingresa los valores correctos");
        }
 
        
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
