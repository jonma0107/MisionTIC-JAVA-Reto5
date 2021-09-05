package model;

public class UsuarioModel {
    private int usu_cc;
    private String usu_nombre;
    private String usu_apellido;
    private String usu_email;
    
    private int usu_cc_via;
    private int usu_cc_fk;
 
    //Constructor para manejo interno de la tabla 
    public UsuarioModel(int usu_cc, String usu_nombre, String usu_apellido, String usu_email) {
        this.usu_cc = usu_cc;
        this.usu_nombre = usu_nombre;
        this.usu_apellido = usu_apellido;
        this.usu_email = usu_email;
    }
    
    //Constructor para mostrar la información de la proyección de la BD
    public UsuarioModel(int usu_cc, String usu_nombre, String usu_apellido, String usu_email, int usu_cc_via, int usu_cc_fk) {
        this.usu_cc = usu_cc;
        this.usu_nombre = usu_nombre;
        this.usu_apellido = usu_apellido;
        this.usu_email = usu_email;
        this.usu_cc_via = usu_cc_via;
        this.usu_cc_fk = usu_cc_fk;
    }

    /**
     * @return the usu_cc
     */
    public int getUsu_cc() {
        return usu_cc;
    }

    /**
     * @param usu_cc the usu_cc to set
     */
    public void setUsu_cc(int usu_cc) {
        this.usu_cc = usu_cc;
    }

    /**
     * @return the usu_nombre
     */
    public String getUsu_nombre() {
        return usu_nombre;
    }

    /**
     * @param usu_nombre the usu_nombre to set
     */
    public void setUsu_nombre(String usu_nombre) {
        this.usu_nombre = usu_nombre;
    }

    /**
     * @return the usu_apellido
     */
    public String getUsu_apellido() {
        return usu_apellido;
    }

    /**
     * @param usu_apellido the usu_apellido to set
     */
    public void setUsu_apellido(String usu_apellido) {
        this.usu_apellido = usu_apellido;
    }

    /**
     * @return the usu_email
     */
    public String getUsu_email() {
        return usu_email;
    }

    /**
     * @param usu_email the usu_email to set
     */
    public void setUsu_email(String usu_email) {
        this.usu_email = usu_email;
    }

    /**
     * @return the usu_cc_via
     */
    public int getUsu_cc_via() {
        return usu_cc_via;
    }

    /**
     * @param usu_cc_via the usu_cc_via to set
     */
    public void setUsu_cc_via(int usu_cc_via) {
        this.usu_cc_via = usu_cc_via;
    }

    /**
     * @return the usu_cc_fk
     */
    public int getUsu_cc_fk() {
        return usu_cc_fk;
    }

    /**
     * @param usu_cc_fk the usu_cc_fk to set
     */
    public void setUsu_cc_fk(int usu_cc_fk) {
        this.usu_cc_fk = usu_cc_fk;
    }

    
    
    
    
    
    
    
    
}



