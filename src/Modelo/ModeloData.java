/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Datos.Data;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ARCANGEL
 */
public class ModeloData {

    private final Connection cn = (Connection) Conexion.conectar();

    private String sql = "";

    public DefaultTableModel mostrar() throws SQLException {
        DefaultTableModel modelo;

        String[] title = {"Registro", "Covid", "Dolencia"};

        String[] registro = new String[3];

        modelo = new DefaultTableModel(null, title);

        sql = "select * from tbl_data order by idData";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registro[0] = rs.getString("idData");
                
                String a =  rs.getString("isCovid");
                if(Integer.parseInt(a)== 0){
                     registro[1] = "NO";
                }else{
                    registro[1] = "SI";
                }
               
                String b =  rs.getString("dolencia");
                if(Integer.parseInt(b)== 1){
                     registro[2] = "Fiebre";
                }
                if(Integer.parseInt(b)== 2){
                     registro[2] = "Goteo de Nariz";
                }
                if(Integer.parseInt(b)== 3){
                     registro[2] = "No Huele";
                }

                modelo.addRow(registro);
            }

            return modelo;
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }finally{
            cn.close();
        }

    }

    public boolean Insertar(Data dt) throws SQLException {

        sql = "insert into tbl_data (isCovid,dolencia) values (?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, dt.getCovid());
            pst.setInt(2, dt.getEnfermedad());
            

            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }finally{
            cn.close();
        }
    }

    public boolean Eliminar(Data dt) throws SQLException {
        sql = "delete from tbl_data where idData=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, dt.getIdRegistro());
            
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return false;
        }finally{
            cn.close();
                    
        }
    }

}
