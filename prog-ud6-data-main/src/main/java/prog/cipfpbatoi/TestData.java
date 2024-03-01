/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prog.cipfpbatoi;

/**
 *
 * @author Cristian
 */
public class TestData {
    public static void main(String[] args){
        
        Data data1=new Data(5,12,2024);
        Data data2=new Data("17/1/2024");
        Data data3=new Data(5,3,2024);
        
        Data data4=new Data(1,12,2024);
        Data data5=new Data(32,12,2024);
        
        data1.restar(5).mostrarEnFormatES();
        System.out.println("");
        data2.afegir(17).mostrarEnFormatES();
        System.out.println("");
        data3.restar(5).mostrarEnFormatES();
        System.out.println("");
        
        data4.restar(1).mostrarEnFormatES();
        System.out.println("");
        data5.restar(2).mostrarEnFormatES();
        System.out.println("");
        
        System.out.println(data5.isCorrecta());
    }
}
