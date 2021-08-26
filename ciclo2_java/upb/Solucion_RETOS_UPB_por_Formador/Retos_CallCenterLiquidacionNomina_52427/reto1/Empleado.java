/*

RETO #1 DEL CICLO 2 (Programación en Java-SQL-MVC)
PROGRAMA MISION TIC 2022
Autor Ing. Andrés Felipe Escallón Portilla (30 de Julio de 2021)

HE SOLUCIONADO EL RETO DENTRO DE MI ROL COMO FORMADOR DE DICHO PROGRAMA LABORANDO CON EL MINISTERIO TIC  (MinTIC) DE COLOMBIA 
Y CON LA UNIVERSIDAD PONTIFICIA BOLIVARIANA DE MEDELLIN

El requerimiento del Reto#1 se puede encontrar aquí:
https://drive.google.com/drive/folders/1OyQn_GYc-6l1dKt1-5tmNMc6abJO5DNq?usp=sharing

*/

import java.util.ArrayList;//necesario para manejar ArrayList

public class Empleado{
//atributos: por encapsulamiento en POO deben ser de acceso privado
private int id;
private String nombre;
private int horasExtra;//se refiere al valor (en pesos $) por concepto de horasExtra
private boolean auxilioTransporte;
private int salario;

//métodos:

//constructores:
public Empleado(){
/*ES INNECESARIO ESTO PERO ES ASI COMO EL CONSTRUCTOR VACIO INICIALIZA LOS ATRIBUTODS DE LA CLASE CON LOS VALORES POR DEFECTO 
    (de tipo numerico en 0, de tipo cadena o de tipo objeto en null, y de tipo boolean en false)
    id = 0;
    nombre = null;
    horasExtrav = 0;
    auxilioTransporte = false;
    salario = 0;
*/
    //APROVECHARÉ PARA MOSTRAR EN PANTALLA LOS VALORES POR DEFECTO CUANDO SE CREE UN OBJETO DE LA CLASE EMPLEADO USANDO EL CONSTRUCTOR VACIO
    //invoco a una función que creé para tal fin:
    System.out.println("Se ha creado un objeto de la clase Empleado usando el constructor vacio (inicializa con los valores por defecto)");
    this.mostrarValoresAtributos();
    System.out.println("La misma información usando directamente el método String toString() invocado desde el constructor:");
    System.out.println(this.toString());
}

public Empleado(int id, String nombre, int horasExtra, boolean auxilioTransporte, int salario){
    //ES NECESARIO PORQUE ES ASI COMO EL CONSTRUCTOR LLENO INICIALIZA LOS ATRIBUTODS DE LA CLASE, PRECISAMENTE CON LOS VALORES PASADOS COMO PARAMETROS O ARGUMENTOS 
     //El uso de this es para referirse a que se guarden en los atributos de ESTA clase los valores pasados como parametros 
     //se soluciona la ambiguedad sin importar que los argumentos se llamen igual que los atributos porque dichos argumentos son variables locales para la función constructora
     //si se ponen otros nombres en los paramentros, entionces this no es necesario, pero se deja así porque IDEs como NEtbeans lo trabajan de esa forma automáticamente
     this.id = id;
     this.nombre = nombre;
     this.horasExtra = horasExtra;
     this.auxilioTransporte = auxilioTransporte;
     this.salario = salario;
     //APROVECHARÉ PARA MOSTRAR EN PANTALLA LOS VALORES POR DEFECTO CUANDO SE CREE UN OBJETO DE LA CLASE EMPLEADO USANDO EL CONSTRUCTOR LLENO
    //invoco a una función que creé para tal fin:
    System.out.println("Se ha creado un objeto de la clase Empleado usando el constructor lleno (inicializado con los valores pasados por parámetros)");
    this.mostrarValoresAtributos();
    System.out.println("La misma información usando directamente el método String toString() invocado desde el constructor:");
    System.out.println(this.toString());    
    }

    //OJO: Este constructor está tal cual como lo solicita el reto (no se requiere id):
    public Empleado(String nombre, int horasExtra, boolean auxilioTransporte, int salario){
         //this.id = id;//NO LO REQUIERE
         this.nombre = nombre;
         this.horasExtra = horasExtra;
         this.auxilioTransporte = auxilioTransporte;
         this.salario = salario;
         //APROVECHARÉ PARA MOSTRAR EN PANTALLA LOS VALORES POR DEFECTO CUANDO SE CREE UN OBJETO DE LA CLASE EMPLEADO USANDO EL CONSTRUCTOR DEFINIDO POR EL RETO (Lleno sin el Id)
        //invoco a la otra  función que creé para tal fin:
        System.out.println("Se ha creado un objeto de la clase Empleado usando el constructor 'semi-lleno' (inicializado con los valores pasados por parámetros)");
        String retorno = this.retornarValoresAtributoSinId();
        System.out.println(retorno);
        System.out.println("La misma información usando directamente el método String toString() invocado desde el constructor:");
        System.out.println(this.toString());    
        }
//getters and setters:

//get
public int getId(){
    return id;
}
public String getNombre(){
    return nombre;
}
public int getHorasExtra(){
    return horasExtra;
}
public boolean isAuxilioTransporte(){//si es booleano el retorno, entonces el nombre no inicvia con get sino con is
    return auxilioTransporte;
}
public int getSalario(){
    return salario;
}


//set
public void setId(int id){
    this.id = id;
}
//int id, String nombre, int horasExtra, boolean auxilioTransporte, int salario
public void setNombre(String nombre){    
     this.nombre = nombre;    
}

public void setHorasExtra(int horasExtra){    
        this.horasExtra = horasExtra;        
}

public void setAuxilioTransporte(boolean auxilioTransporte){        
    this.auxilioTransporte = auxilioTransporte;    
}

public void setSalario(int salario){
    this.salario = salario;
}

//otros métodos

//APROVECHARÉ PARA MOSTRAR EN PANTALLA LOS VALORES POR DEFECTO CUANDO SE CREE UN OBJETO DE LA CLASE EMPLEADO USANDO EL CONSTRUCTOR VACIO
public void mostrarValoresAtributos(){
    System.out.println("Id del empleado= "+this.id);//se puede directamente
    System.out.println("Nombre del empleado= "+this.getNombre());//se puede indirectamente
    System.out.println("Valor horas extra del empleado= "+this.getHorasExtra());//se puede indirectamente
    System.out.println("¿El empleado tiene Auxilio de Transporte?: "+this.auxilioTransporte);//?"Si":"No");//se puede indirectamente haxciendo uso del operador ternario para dar más claridad y que no aparezca solo true/false sino Si/No
    System.out.println("Salario del empleado= "+this.salario+"\n ");//se puede directamente       
}

public void mostrarValoresAtributoSinId(){    
    System.out.println("Nombre del empleado= "+this.getNombre());//se puede indirectamente
    System.out.println("Valor horas extra del empleado= "+this.getHorasExtra());//se puede indirectamente
    System.out.println("¿El empleado tiene Auxilio de Transporte?: "+this.auxilioTransporte);//?"Si":"No");//se puede indirectamente hacciendo uso del operador ternario para dar más claridad y que no aparezca solo true/false sino Si/No
    System.out.println("Salario del empleado= "+this.salario+"\n ");//se puede directamente       
}
//Para mostrar el retorno en el Main más fácilmente:
public String retornarValoresAtributoSinId(){    
    return "\n Nombre del empleado= "+this.getNombre()+"\n Valor horas extra del empleado= "+this.getHorasExtra()+"\n ¿El empleado tiene Auxilio de Transporte?: "+this.isAuxilioTransporte()+"\n Salario del empleado= "+this.getSalario()+"\n ";
}

//LA ANTERIOR FUNCIÓN SE PUEDE REEMPLAZAR POR EL MÉTODO POR DEFECTO QUE TIENE JAVA: String toString() usado para mostrar la información de los atributos de los objetos 
//no es necesario pasarsela al constructor aunque si es posible, pero también se puede mostrar desde el Main como System.out.println(objeto):
//Ver mas detalles en: https://www.discoduroderoer.es/funcion-tostring-para-clases-en-java/

@Override //sobrescrito de la clase object
//Ver más detalles en: https://www.arquitecturajava.com/java-tostring-overriding-y-eclipse/

public String toString(){    
    return "\n Nombre del empleado= "+this.getNombre()+"\n Valor horas extra del empleado= "+this.getHorasExtra()+"\n ¿El empleado tiene Auxilio de Transporte?: "+this.isAuxilioTransporte()+"\n Salario del empleado= "+this.getSalario()+"\n ";
}

//OJO: Este método adicional está tal cual como lo solicita el reto:
//DEBO IMPLEMENTARLO: recibe una lista de objetos tipo Empleado y retorna una lista (número decimal) con la liquidación de cada empleado 

public static ArrayList<Double> liquidarNominaEmp(ArrayList<Empleado> empleados){
    
    ArrayList<Double> nominas = new ArrayList<>();//defino una lista de nominas vacía (null)
    
    //INFORMACIÓN SOBRE LA LIQUIDACIÓN CON BASE EN LOS CRITERIOS DEL RETO Y LOS DATOS ACTUALES (AÑO 2021) EN COLOIMBIA:
    //REFERENCIA: https://colombia.as.com/colombia/2021/01/05/actualidad/1609876969_200603.html#:~:text=El%20salario%20m%C3%ADnimo%20subi%C3%B3%20%2430.723,1%20de%20enero%20de%202021.
    //Un trabajador que gane un salario mínimo en el país tendrá que recibir $908.526 pesos más auxilio de transporte adicional equivalente a 106.454 pesos.
    //salario minimo = $908.526 pesos 
    //auxilio de transporte adicional equivalente a $106.454 pesos.

    //Defino lo anterior y el 8% de aportes a salud(4%) y pension(4%) como constantes
    final int SALARIO_MINIMO = 908526;    
    final double PORCENTAJE_DEDUCCIONES = 0.08;
    int AUXILIO_TRANSPORTE;
    

    //Carmen: total = 1646454 (salario + horas extras + aux tte), deducciones 8% (excluyendo aux tte) = 1540000*8/100 = 123200. Liquidacion neta = 1523254
    //Pablo: total = 1331454 (salario + horas extras + aux tte), deducciones 8% (excluyendo aux tte) = 1225000*8/100 = 98000. Liquidacion neta = 1233454
    //Laura: total = 2050000 (salario + horas extras + aux tte), deducciones 8% (no tiene derecho a aux tte) = 2050000*8/100 = 164000. Liquidacion neta = 1886000

    double total;
    double nomina;
    boolean condicion;  

    /*
    if (condicion) {
        total = empleados.get(empleado).getSalario() + empleados.get(empleado).getHorasExtra() + AUXILIO_TRANSPORTE;
        liquidacion = total - (total - AUXILIO_TRANSPORTE)*PORCENTAJE_DEDUCCIONES;
    }
    else {
        total = empleados.get(empleado).getSalario() + empleados.get(empleado).getHorasExtra() + AUXILIO_TRANSPORTE;
        liquidacion=total-(total-AUXILIO_TRANSPORTE)*PORCENTAJE_DEDUCCIONES
    }
    */
    if (empleados.size()==0){
        return null;//Sí la lista de empleados se encuentra vacía, el método debe de retornar un vector vacío.
    }else{
        //for (double nomina : nominas) {
            //for (Empleado empleado : empleados) {            
            for (int k=0; k<empleados.size(); k++) {
                condicion = ((empleados.get(k).getSalario()) <= (2*SALARIO_MINIMO));
                //condicion = (empleado.getSalario()<=2*SALARIO_MINIMO);
                AUXILIO_TRANSPORTE = (condicion)?106454:0;
                //total = empleado.getSalario() + empleado.getHorasExtra() + AUXILIO_TRANSPORTE;
                total = (empleados.get(k).getSalario()) + (empleados.get(k).getHorasExtra()) + AUXILIO_TRANSPORTE;
                nomina = total - ((total-AUXILIO_TRANSPORTE)*PORCENTAJE_DEDUCCIONES);
                nominas.add(nomina);
            }       
            
        //}        
        return nominas;//retorna una lista (número decimal) con la liquidación de cada empleado 
    }
  }

}


