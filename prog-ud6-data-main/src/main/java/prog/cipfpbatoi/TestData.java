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
        
        System.out.println("=== START - Prova de de Constructors - START === ");
        
        System.out.println("--- Cree un nou objecte utilitzant el constructor parametritzat int int int (16,1,2021) ---");
        Data data1=new Data(16,1,2021);
        data1.mostrarEnFormatES();
        data1.mostrarEnFormatGB();
        data1.mostrarEnFormatText();
        System.out.println("La data es correcta: "+data1.isCorrecta());
        System.out.println("La fecha es festiva: "+data1.isFestiu());
        System.out.println("El dia de la semana es: "+data1.getDiaSetmana());
        System.out.println("---------------------------");
        
        System.out.println(" ");
        System.out.println(" ");
        
        System.out.println("--- Cree un nou objecte utilitzant el constructor String (16/1/2021) ---");
        Data data2=new Data("16/1/2021");
        data2.mostrarEnFormatES();
        data2.mostrarEnFormatGB();
        data2.mostrarEnFormatText();
        System.out.println("La data es correcta: "+data2.isCorrecta());
        System.out.println("La fecha es festiva: "+data2.isFestiu());
        System.out.println("El dia de la semana es: "+data2.getDiaSetmana());
        System.out.println("---------------------------");
        
        System.out.println(" ");
        System.out.println(" ");
        
        System.out.println("--- Comprove mitjançant el mètode isIgual que les dates representades per tots dos objectes són iguals  ---");
        
        System.out.println(" ");
        
        System.out.println("La data creada amb els constructors anteriors són iguals: "+ data1.isIgual(data2));
        System.out.println("---------------------------");
        
        System.out.println(" ");
        System.out.println(" ");
        
        System.out.println("--- Cree un nou objecte utilitzant el constructor per defecte (1,1,1970) ---");
        Data data3=new Data();
        data3.mostrarEnFormatES();
        data3.mostrarEnFormatGB();
        data3.mostrarEnFormatText();
        System.out.println("La data es correcta: "+data3.isCorrecta());
        System.out.println("La fecha es festiva: "+data3.isFestiu());
        System.out.println("El dia de la semana es: "+data3.getDiaSetmana());
        System.out.println("---------------------------");
        
        System.out.println("=== FI - Prova de Constructors - FI === ");
        
        System.out.println(" ");
        System.out.println(" ");
        
        System.out.println("=== START - Prova de Mètodes afegir/restar dies - START ==== ");
        
        System.out.println(" ");
        
        System.out.println("--- Endemà de la data inicial (16-1-2021) - (+1 dia) ---");
        Data data4=new Data(16,1,2021);
        data4=data4.afegir(1);
        data4.mostrarEnFormatES();
        data4.mostrarEnFormatGB();
        data4.mostrarEnFormatText();
        System.out.println("La data es correcta: "+data4.isCorrecta());
        System.out.println("La fecha es festiva: "+data4.isFestiu());
        System.out.println("El dia de la semana es: "+data4.getDiaSetmana());
        System.out.println("---------------------------");
        
        System.out.println(" ");
        System.out.println(" ");
        
        System.out.println("--- Dia anterior de la data inicial (16-1-2021) - (-1 dia) ---");
        Data data5=new Data(16,1,2021);
        data5=data5.restar(1);
        data5.mostrarEnFormatES();
        data5.mostrarEnFormatGB();
        data5.mostrarEnFormatText();
        System.out.println("La data es correcta: "+data5.isCorrecta());
        System.out.println("La fecha es festiva: "+data5.isFestiu());
        System.out.println("El dia de la semana es: "+data5.getDiaSetmana());
        System.out.println("---------------------------");
        
        System.out.println(" ");
        System.out.println(" ");
        
        System.out.println("--- Data corresponent a restar 30 dies a la data inicial (16-1-2021) - (-30 dies) ---");
        Data data6=new Data(16,1,2021);
        data6=data6.restar(30);
        data6.mostrarEnFormatES();
        data6.mostrarEnFormatGB();
        data6.mostrarEnFormatText();
        System.out.println("La data es correcta: "+data6.isCorrecta());
        System.out.println("La fecha es festiva: "+data6.isFestiu());
        System.out.println("El dia de la semana es: "+data6.getDiaSetmana());
        System.out.println("---------------------------");
        
        System.out.println(" ");
        System.out.println(" ");
        
        System.out.println("=== FI - Prova de Mètodes afegir/restar - FI === ");
        System.out.println(" ");
        System.out.println("=== START - Prova del mètode modificador - START === ");
        System.out.println(" ");
        
        System.out.println("--- Modifique la data del primer objecte creat (16-1-2020) per la data 22-1-2021 ---");
        Data data7=new Data(16,1,2020);
        data7.set(22, 1, 2021);
        data7.mostrarEnFormatES();
        data7.mostrarEnFormatGB();
        data7.mostrarEnFormatText();
        System.out.println("La data es correcta: "+data7.isCorrecta());
        System.out.println("La fecha es festiva: "+data7.isFestiu());
        System.out.println("El dia de la semana es: "+data7.getDiaSetmana());
        System.out.println("---------------------------");
        
        System.out.println(" ");
        
        System.out.println("=== FI - Prova del mètode modificador - FI === ");
        
        
        
        
        
        
        
        
        
        System.out.println("--- Dia anterior de la data inicial (16-1-2021) - (-1 dia) ---");
        Data data=new Data(2,3,2022);
        data=data.restar(30);
        data.mostrarEnFormatES();
        
        
        System.out.println(" ");
        System.out.println(" ");
    }
}
