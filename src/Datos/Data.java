/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

/**
 *
 * @author ARCANGEL
 */
public class Data {
    
    private int idRegistro;
    private int covid;
    private int enfermedad;

    public Data() {
    }

    public Data(int idRegistro, int covid, int enfermedad) {
        this.idRegistro = idRegistro;
        this.covid = covid;
        this.enfermedad = enfermedad;
    }

    

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public int getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(int enfermedad) {
        this.enfermedad = enfermedad;
    }

    public int getCovid() {
        return covid;
    }

    public void setCovid(int covid) {
        this.covid = covid;
    }

    
    
   
    
    
    
    
}
