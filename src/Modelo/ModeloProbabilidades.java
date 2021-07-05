/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ARCANGEL
 */
public class ModeloProbabilidades {

    private final Connection cn = (Connection) Conexion.conectar();

    private String sql = "";

    private int Fiebre, Goteo, Huele,FiebreCovid, GoteoCovid, HueleCovid;

    private double totalRegistros;

        
    public DefaultTableModel mostrar() throws SQLException {

        DefaultTableModel modelo;

        String[] title = {"SINTOMAS", "Fiebre", "Goteo Nariz", "Huele"};

        String[] registro = new String[4];

        modelo = new DefaultTableModel(null, title);

        //Obtener Aquellos que tengan enfermedad = x
        for (int i = 1; i < 4; i++) {
            sql = "SELECT COUNT(*) as num FROM tbl_data WHERE dolencia = " + i;

            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);

                if (i == 1) {
                    while (rs.next()) {
                        Fiebre = rs.getInt("num");
                    }
                }
                if (i == 2) {
                    while (rs.next()) {
                        Goteo = rs.getInt("num");
                    }
                }
                if (i == 3) {
                    while (rs.next()) {
                        Huele = rs.getInt("num");
                    }
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }



        //Obtener el total de registros
        sql = "SELECT COUNT(*) as num FROM tbl_data";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                totalRegistros = rs.getInt("num");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

        //Realizar Operacion para calcular las probabilidades    
        double probabilidadFiebre = Fiebre / totalRegistros;
        double probabilidadGoteo = Goteo / totalRegistros;
        double probabilidadNoHuele = Huele / totalRegistros;

        registro[0] = "PROBABILIDADES";
        registro[1] = String.valueOf((Math.round(probabilidadFiebre * 100.0) / 100.0));
        registro[2] = String.valueOf((Math.round(probabilidadGoteo * 100.0) / 100.0));
        registro[3] = String.valueOf((Math.round(probabilidadNoHuele * 100.0) / 100.0));

        modelo.addRow(registro);

        //Hallar aquellos que tienen Covid y a la vez x enfermedad
        for (int i = 1; i < 4; i++) {
            sql = "SELECT COUNT(*) as num FROM tbl_data WHERE dolencia = " + i + " and isCovid = 1";

            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);

                if (i == 1) {
                    while (rs.next()) {
                        FiebreCovid = rs.getInt("num");
                    }
                }
                if (i == 2) {
                    while (rs.next()) {
                        GoteoCovid = rs.getInt("num");
                    }
                }
                if (i == 3) {
                    while (rs.next()) {
                        HueleCovid = rs.getInt("num");
                    }
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }


        //Realizar Operaciones para calcular las probabilidades
        double probabilidadFiebreCovid = (double)FiebreCovid / Fiebre;
        double probabilidadGoteoCovid = (double)GoteoCovid / Goteo;
        double probabilidadHueleCovid = (double)HueleCovid / Huele;

        registro[0] = "PROBABILIDADES CON COVID";
        registro[1] = String.valueOf((Math.round(probabilidadFiebreCovid * 100.0) / 100.0));
        registro[2] = String.valueOf((Math.round(probabilidadGoteoCovid * 100.0) / 100.0));
        registro[3] = String.valueOf((Math.round(probabilidadHueleCovid * 100.0) / 100.0));

        modelo.addRow(registro);
        
        cn.close();

        return modelo;

    }
     
   
}
