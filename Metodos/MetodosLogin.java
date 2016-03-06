/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;
import Formularios.Login;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class MetodosLogin {

Pool metodospool = new Pool();

public int validar_ingreso(){

    String usuario = Login.txUsuario.getText();
    String clave = String.valueOf(Login.jpassClave.getPassword());

    int resultado=0;
    
    String SSQL="SELECT * FROM usuarios WHERE login='"+usuario+"' AND clave='"+clave+"'";
    System.out.println("SSQL:"+SSQL);
    System.out.println("usuario:"+usuario);
    System.out.println("clave:"+clave);
    Connection conect = null;

    try {

        conect = metodospool.dataSource.getConnection();
        Statement st = conect.createStatement();
        ResultSet rs = st.executeQuery(SSQL);

        if(rs.next()){
            System.out.println(rs.getInt(3));
            resultado=rs.getInt(3);

        }

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null, ex, "Error de conexión", JOptionPane.ERROR_MESSAGE);

    }finally{


        try {

            conect.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión", JOptionPane.ERROR_MESSAGE);

        }

    }

return resultado;

}

}

