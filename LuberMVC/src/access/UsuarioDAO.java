package access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.List;
import javax.swing.JOptionPane;
import model.UsuarioModel;
import utils.ConnectionDB;

//public class UsuarioDAO
public class UsuarioDAO implements InterfaceDAO {

    //private Connection conn = null;
    @Override
    public ArrayList<UsuarioModel> obtenerUsuarios() {
        Connection conn = null;
        ArrayList<UsuarioModel> usuarios = new ArrayList();
        try {
            //if(conn==null)
            conn = ConnectionDB.getConnection();
            String sql = "select * from usuario order by usu_cc asc";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                UsuarioModel usuario = new UsuarioModel(result.getInt(1), result.getString(2), result.getString(3), result.getString(4));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return usuarios;
    }

    @Override
    public ArrayList<UsuarioModel> buscarUsuario(String dato, int validacion) {
        Connection conn = null;
        ArrayList<UsuarioModel> usuarios = new ArrayList();
        try {
            //if(conn == null)
            conn = ConnectionDB.getConnection();
            switch (validacion) {
                case 1:
                    String sql = "SELECT * FROM usuario WHERE usu_cc like \""+Integer.parseInt(dato)+"%\"";
                    Statement statement = conn.createStatement();
                    //PreparedStatement statement = conn.prepareStatement(sql);
                    //statement.setInt(1, usu_cc);
                    ResultSet result = statement.executeQuery(sql);
                    while (result.next()) {
                        UsuarioModel usuario = new UsuarioModel(result.getInt(1), result.getString(2), result.getString(3), result.getString(4));
                        usuarios.add(usuario);
                    }
                    break;
                case 2:
                    String sql1 = "SELECT * FROM usuario where usu_nombre like \""+dato+"%\"";
                    Statement statement1 = conn.createStatement();
                    //PreparedStatement statement = conn.prepareStatement(sql);
                    //statement.setInt(1, usu_cc);
                    ResultSet result1 = statement1.executeQuery(sql1);
                    while (result1.next()) {
                        UsuarioModel usuario1 = new UsuarioModel(result1.getInt(1), result1.getString(2), result1.getString(3), result1.getString(4));
                        usuarios.add(usuario1);
                    }
                    break;
                case 3:
                    String sql2 = "SELECT * FROM usuario where usu_apellido like \""+dato+"%\"";
                    Statement statement2 = conn.createStatement();
                    //PreparedStatement statement = conn.prepareStatement(sql);
                    //statement.setInt(1, usu_cc);
                    ResultSet result2 = statement2.executeQuery(sql2);
                    while (result2.next()) {
                        UsuarioModel usuario2 = new UsuarioModel(result2.getInt(1), result2.getString(2), result2.getString(3), result2.getString(4));
                        usuarios.add(usuario2);
                    }
                    break;
                case 4:
                    String sql3 = "SELECT * FROM usuario where usu_email like \""+dato+"%\"";
                    Statement statement3 = conn.createStatement();
                    //PreparedStatement statement = conn.prepareStatement(sql);
                    //statement.setInt(1, usu_cc);
                    ResultSet result3 = statement3.executeQuery(sql3);
                    while (result3.next()) {
                        UsuarioModel usuario3 = new UsuarioModel(result3.getInt(1), result3.getString(2), result3.getString(3), result3.getString(4));
                        usuarios.add(usuario3);
                    }
                    break;      
                   

            }
//            String sql2 = "SELECT * FROM usuario WHERE usu_apellido = \" " + dato + ";\"";
//            Statement statement2 = conn.createStatement();
//            //PreparedStatement statement = conn.prepareStatement(sql);
//            //statement.setInt(1, usu_cc);
//            ResultSet result2 = statement2.executeQuery(sql2);
//            while (result2.next()) {
//                UsuarioModel usuario = new UsuarioModel(result2.getInt(1), result2.getString(2), result2.getString(3), result2.getString(4));
//                usuarios.add(usuario);
//            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
                    + "\nError :" + ex.getMessage());
        }
        return usuarios;

    }

    @Override
    public void agregarUsuario(UsuarioModel usuario) {
        Connection conn = null;
        //UsuarioModel usuario = null;
        try {
            //if(conn==null)
            conn = ConnectionDB.getConnection();
            String sql = "INSERT INTO usuario(usu_cc, usu_nombre, usu_apellido, usu_email)"
                    + "VALUES(?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, usuario.getUsu_cc());
            statement.setString(2, usuario.getUsu_nombre());
            statement.setString(3, usuario.getUsu_apellido());
            statement.setString(4, usuario.getUsu_email());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue "
                        + "insertado exitosamente !");
            } else {
                JOptionPane.showMessageDialog(null, "El registro No "
                        + " fue insertado !");
            }
            //conn.close();
        } catch (SQLException ex) {
        }
    }

    @Override
    public void actualizarUsuario(UsuarioModel usuario) {
        Connection conn = null;
        try {
            //if(conn==null)
            conn = ConnectionDB.getConnection();
            //conn = ConnectionDB.getConnection();
            String sql = "UPDATE usuario SET usu_nombre =?, usu_apellido =?, usu_email =? WHERE  usu_cc =?";
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, usuario.getUsu_nombre());
            statement.setString(2, usuario.getUsu_apellido());
            statement.setString(3, usuario.getUsu_email());
            statement.setInt(4, usuario.getUsu_cc());
            String sql2 = "UPDATE usuario SET usu_cc =? WHERE  usu_nombre =?";
            PreparedStatement statement2 = conn.prepareStatement(sql2);
            statement2.setInt(1, usuario.getUsu_cc());
            statement2.setString(2, usuario.getUsu_nombre());

            int rowsUpdated2 = statement2.executeUpdate();
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0 && rowsUpdated2 > 0);
            JOptionPane.showMessageDialog(null, "El registro fue "
                    + "actualizado exitosamente !");

            //conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }

    @Override
    public void eliminarUsuario(int usu_cc) {
        Connection conn = null;
        try {
            //if(conn==null)
            conn = ConnectionDB.getConnection();
            //Connection conn = null;
            //conn = ConnectionDB.getConnection();
            String sql = "DELETE FROM usuario WHERE usu_cc =?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, usu_cc);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue "
                        + " borrado exitosamente !");
            }
            //conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }

}
