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
        Data data=new Data(16,03,2024);
        Data data1=new Data(28,03,2055);
        Data data2=new Data("01/12/2005");
        Data data3=new Data();
        
         
        System.out.println(data.getNumeroSetmana());
        System.out.println("");
    }
}
