/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.clases;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public class claseGasolinera2 {
    double[] deposito={10000,10000,10000};
    String[] depositonomb={"Diesel","Regular","Especial"};
    List listaCliente;
    List listaCombustible;
    List listaCantidad;
    
    public claseGasolinera2() {
        this.listaCliente = new ArrayList<>();
        this.listaCombustible = new ArrayList<>();
        this.listaCantidad = new ArrayList<>();
    }
    
    public String compra(String Cliente,int Combustible, double Cantidad){
        String mensaje="Error";
        System.out.print(Cliente +Combustible+Cantidad);
        try {
            if (Cantidad <= deposito[Combustible]) {
                listaCliente.add(Cliente);
                listaCombustible.add(Combustible);
                listaCantidad.add(Cantidad);
                deposito[Combustible]-=Cantidad;
                mensaje="Compra realizada exactamente";
            } else {
                mensaje ="Compra fallida, no se tiene la cantidad solicitada en el deposito";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mensaje;
    }
    
    public List lista1(){
        return listaCliente;
    }
    public List lista2(){
        return listaCombustible;
    }
    public List lista3(){
        return listaCantidad;
    }
    
    public void cargartabla(JTable tabla,int filtro){
       DefaultTableModel modelo = new DefaultTableModel(new String[]{"Tipo","Galones vendidos","Client"},0);
        
        for (int i = 0; i < listaCliente.size(); i++) {
            if (listaCombustible.get(i).equals(filtro) || filtro==-1) {
                modelo.addRow(new Object[]{
                    //Casting
                    depositonomb[(Integer)listaCombustible.get(i)],
                    listaCantidad.get(i),
                    listaCliente.get(i)
                });
            } 
        }
        tabla.setModel(modelo);
    }
}
