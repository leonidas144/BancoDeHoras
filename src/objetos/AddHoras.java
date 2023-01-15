/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetos;

/**
 *
 * @author leo_a
 */
public class AddHoras {
    private String re;
    private String data;
    private float horas;
    private String obs;

    public AddHoras() {
    }

    public AddHoras(String re, String data, float horas, String obs) {
        this.re = re;
        this.data = data;
        this.horas = horas;
        this.obs = obs;
    }

    public String getRe() {
        return re;
    }

    public void setRe(String re) {
        this.re = re;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public float getHoras() {
        return horas;
    }

    public void setHoras(float horas) {
        this.horas = horas;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    public String toString(){
        return data
            + " - "
            + "Adicionado: " 
            + horas
            + " Observações: "
            + obs;
        
    }

    public Iterable<AddHoras> read() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

