package prog.cipfpbatoi;

import java.util.StringTokenizer;

public class Data {
	
	private int dia;
	
	private int mes;
	
	private int any;

	private static final String[] DIES_TEXT = new String[] { "diumenge", "dilluns", "dimarts", "dimecres", "dijous", "divendres",
			"dissabte"};

	private static final String[] MESOS_TEXT = new String[] { "gener", "febrer", "març", "abril", "maig", "juny",
			"juliol", "agost", "setembre", "octubre", "novembre", "desembre" };

	/**
	 *  Constructor por defecto
	 *  Inicializa una fecha a dia 1-1-1970
	 */
	public Data() {
            dia=1;
            mes=1;
            any=1970;
	}

	/**
	 *  Inicializa la fecha
	 *  @param dia de la semana
	 *  @param mes del año
	 *  @param anyo
	 */
	public Data(int dia, int mes, int any) {
            this.dia=dia;
            this.mes=mes;
            this.any=any;
	}

	/**
	 * Inicializa la fecha a partir de otra pasada en formato String dd/mm/yyyy
	 *
	 * Deberemos trocearlas de forma que asignemos el día més y año a cada uno de los atributoe
         * Tienes que utilizar las funciones de *String o consultar la documentación oficial y hacerlo OBLIGATORIAMENTE 
         * con la clase StringTokenizer. 
         * Si el formato recibido no es el correcto, creará la fecha por defecto.
	 * @param fecha
	 */
	public Data(String data) {
            StringTokenizer st = new StringTokenizer(data,"/");
            int contador=1;
            
            do{
                String aux=st.nextToken();
                
                switch(contador){
                    case 1:
                        if(Integer.parseInt(aux)<=31){
                            this.dia=Integer.parseInt(aux);
                        }else{
                            contador=4;
                        }
                        contador++;
                        break;
                    case 2:
                        if(Integer.parseInt(aux)<=12){
                            this.mes=Integer.parseInt(aux);
                        }else{
                            contador=4;
                        }
                        contador++;
                        break;
                    case 3:
                        if(Integer.parseInt(aux)<=9999 && Integer.parseInt(aux)>=0){
                            this.any=Integer.parseInt(aux);
                        }else{
                            contador=4;
                        }
                        break;
                    default:
                        dia=1;
                        mes=1;
                        any=1970;
                        break;
                }
            }while(st.hasMoreTokens());

            if(contador==4){
                dia=1;
                mes=1;
                any=1970;
            }
        }

	/**
	 * Modifica la fecha actual a partir de los datos pasados como argumento
	 */
	public void set(int dia, int mes, int anyo) {
            this.dia=dia;
            this.mes=mes;
            this.any=anyo;
	}

	/**
	 * Obtiene una fecha con los mismos atributos que la fecha actual
	 * @return
	 */
	public Data clone() {
            Data clon=new Data(this.dia,this.mes,this.any);
            return clon;
	}

	/**
	 * Devuelve el día de la semana que representa por la Fecha actual
	 * @return @dia
	 */
	public int getDia() {
            return dia;
	}

	/**
	 * Devuelve el mes que representa la Fecha actual
	 * @return @mes
	 */
	public int getMes(){
            return mes;
	}

	/**
	 * Devuelve el año que representa la Fecha actual
	 * @return @mes
	 */
	public int getAny(){
            return any;
	}

	/**
	 * Muestra por pantalla la fecha en formato español dd-mm-yyyy
	 */
	public void mostrarEnFormatES()  {
            System.out.printf("%s-%s-%s",dia,mes,any);
            System.out.println("");
	}

	/**
	 * Muestra por pantalla la fecha en formato inglés yyyy-mm-dd
	 */
	public void mostrarEnFormatGB() {
            System.out.printf("%s-%s-%s",any,mes,dia);
            System.out.println("");
	}

	/**
	 * Muestra por pantalla la fecha en formato texto dd-mmmm-yyyy
	 * Ej. 1 enero de 1970
	 */
	public void mostrarEnFormatText() {
            System.out.printf("%s-%s-%s",dia,getMesEnFormatText(),any);
            System.out.println("");
        }
	/**
	 * Retorna un booleano indicando si la fecha del objeto es igual a la fecha pasada como
	 * argumento
	 *
	 * @return boolean
	 */
	public boolean isIgual(Data otraFecha) {
            if(otraFecha.getDia()==dia && otraFecha.getMes()==mes && otraFecha.getAny()==any){
                return true;
            }  
            return false;
	}

	/**
	 * Retorna un String que representa el dia de la setmana en format text (dilluns, dimarts, dimecres, dijous, divendres, dissabte, diumenge).
         * L'algorisme de resolució d'aquest mètode es troba al enunciat.
	 * @return String
	 */
	public String getDiaSetmana() {
            return DIES_TEXT[getDiesTranscorregutsOrigen()%7];
	}

	/**
	 * Retorna un booleà indicant si la data representada per l'objecte actual és festiva. Es considerarà festiu si el dia de la setmana és dissabte o diumenge
	 * @return boolean
	 */
	public boolean isFestiu() {
            if(getDiaSetmana().equals("dissabte") || getDiaSetmana().equals("diumenge")){
                return true;
            }
            return false;
	}

	/**
	 * Retorna el número de la setmana dins de l'any actual. 
         * Es considera una setmana l'interval de dates entre una data que siga dilluns i la següent data en ordre cronològic que siga diumenge. 
         * També es comptabilitza com a setmana tant la primera setmana de l'any com l'última (inclusivament en aquells anys en què la primera i/o 
         * última setmana no conté set dies en total).
	 *
	 * @return int dia semana
	 */
	public int getNumeroSetmana() {
            int nSemana=0;
            int diaAño=getDiesTranscorregutsOrigen()-getDiesTranscorregutsEnAny()+1;
                        
            while(!DIES_TEXT[diaAño%7].equals("dilluns")){
                diaAño++;
                if(DIES_TEXT[diaAño%7].equals("dilluns") || getDiesTranscorregutsEnAny()<7 ){
                    nSemana++;
                }
            }
            
            while(diaAño<=getDiesTranscorregutsOrigen()){
                diaAño+=7;
                nSemana++;
            }
            
            return nSemana;
	}

	/**
	 * Retorna un nou objecte de tipus data que representa la data resultant d'afegir el nombre de dies passats com a argument a la data que representa l'objecte actual. 
         * Haurem de tindre en compte els dies que té el mes actual i si l'any és de traspàs (bisiesto) 
         * amb la finalitat de construir el nou objecte amb la data correcta. 
         * El màxim nombre de dies que podrem afegir serà 30 i no podrem afegir un nombre negatiu de dies. 
	 *
	 * @return boolean
	 */
	public Data afegir(int numDias){
            int numeroDia=dia;
            int mes=this.mes;
            int año=any;
            
            if(numDias>0 && numDias<=30){
                if(numDias+numeroDia>=getDiesMes(mes, año)){
                    numeroDia=numeroDia+numDias-getDiesMes(mes, año);
                    mes++;
                    if(mes==13){
                        año++;
                        mes=1;
                    }    
                }else{
                    numeroDia+=numDias;
                }
                    
                Data resultado= new Data(numeroDia,mes, año);
                return resultado;
          
            }else{
                System.out.println("Solo se puede aumentar un máximo de 30 días y un mínimo de 1");
            }
            return null;
	}

	/**
	 * Retorna un nou objecte de tipus data que representa la data resultant de restar el nombre de dies passats com a argument a la data que representa l'objecte actual. 
         * Haurem de tindre en compte els dies que té el mes actual i si l'any és de traspàs (bisiesto) amb la finalitat de construir el nou objecte amb la data correcta.  
         * El màxim nombre de dies que podrem restar serà 30 i no podrem restar un nombre negatiu de dies. 
	 *
	 * @return boolean
	 */
	public Data restar(int numDias){
            int numeroDia=dia;
            int mes=this.mes;
            int año=any;
            
            if(numDias>0 && numDias<=30){
                if(numeroDia-numDias<=0){
                    mes--;
                    numeroDia=getDiesMes(mes, año)-numDias+numeroDia;
                    
                    if(mes==0){
                        año--;
                        numeroDia++;
                        mes=12;
                    }    
                }else{
                    numeroDia-=numDias;
                }
                    
                Data resultado= new Data(numeroDia,mes, año);
                return resultado;
          
            }else{
                System.out.println("Solo se puede disminuir un máximo de 30 días y un mínimo de 1");
            }
            return null;
	}

        /**
         * Retorna un booleà indicant si la data representada per l'objecte actual és correcta. 
         * No oblides comprovar que el dia es trobe dins del rang dels dies que té el mes tenint en compte si l'any és de traspàs(bisiesto) o no.
         * @return 
         */
	public boolean isCorrecta(){
            if(dia<=getDiesMes(mes, any)){
                if(mes<=12 && mes >0){
                    if(any>0 && any <9999){
                        return true;
                    }
                }
            }
		return false;
	}

	/**
	 * Retorna el mes del año en formato text (enero, febrero, marzo,...)
	 * @return char
	 */
	private String getMesEnFormatText() {
            return MESOS_TEXT[mes-1];
	}

	/**
	 * Devuelve el número de dias transcurridos desde el 1-1-1
	 *
	 * @return int
	 */
	private int getDiesTranscorregutsOrigen() {
            int nDias=0;
            
            for(int año=1;año<this.any;año++){
                nDias=nDias+getDiesAny(año);
            }
            
            for(int mes=1;mes<this.mes;mes++){
                nDias=nDias+getDiesMes(mes,any);
            }
            
            nDias=nDias+dia;
            
            return nDias;
	}

	/**
	 * Devuelve el número de dias transcurridos en el anyo que representa el objeto
	 *
	 * @return int
	 */
	private int getDiesTranscorregutsEnAny() {
            int nDias=0;
            
            for(int mes=1;mes<=this.mes-1;mes++){
                nDias=nDias+getDiesMes(mes,any);
            }
            
            nDias += dia;
		return nDias;
	}

	/**
	 * Indica si el año pasado como argumento es bisiesto. Un año es bisiesto si es divisible por 4
	 * pero no es divisible entre 100 o es divisible entre 4 entre 100 y entre 400
	 *
	 * @return boolean
	 */
	public static boolean isBisiesto(int anyo){
            if(anyo%4==0 && anyo%100!=0){
                return true;
            }else if(anyo%4==0 && anyo%100==0 && anyo%400==0){
                return true;

            }
            return false;
            
	}

	/**
	 *  Calcula el número de días que tiene el @mes en el @año pasado como argumento
	 *  Deberás hacer uso del métodos isBisiesto
	 *
	 *  @return int total dias mes en curso
	 */
	public static int getDiesMes (int mes, int anyo) {
            switch(mes){
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    return 31;
                case 2:
                    if(isBisiesto(anyo)){
                        return 29;
                    }else{
                        return 28;
                    }                       
                default:
                    return 30;
            }
        }

	/**
	 * Calcula el número total de dias que tiene el año pasado como argumento
	 *
	 * @return int total dias anyo en curso
	 */
	public static int getDiesAny (int anyo){
            if(isBisiesto(anyo)){
                return 366;
            }
            return 365;
	}
}
