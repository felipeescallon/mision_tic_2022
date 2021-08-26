/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package clases;

import Empleado;

import java.util.ArrayList;//necesario para manejar ArrayList

/**
 *
 * @author Administrador
 */
public class CallCenter {
    
    //atributos
    private ArrayList<Empleado> empleados = new ArrayList<>();//puede usarse para que le asignen una lista de empleados desde el main usando el metodo SET pero esta NO es necesariamente la que está recibiendo el método estático aunque en el main las puedo hacer coincidir

    public CallCenter() {//uso este para crear un tesorero (aunque para liquidar nominas y prestaciones se debe usar la clase para acceder a los métodos estáticos porque no se genera copia de dichos métodos en los objetos que si se pueden crear pero para acceder a atributos y métodos NO ESTÁTICOS, aunque también funciona con los objetos pues hacen parte de la clase)
    }
    
    //por la relación de agregación entre las clases del modelo UML, este parámetro NO debe ir en el constructor, quedando el equivalenmte all constructoir vacío!!!
    //public CallCenter(ArrayList<Empleado> empleados){ //como solo hay un atributo, el set haría lo mismo que este constructor sobrecargado
    //     this.empleados = empleados;
    //}

    //Refactoing...(get,set):
    /**
     * @return the empleados
     */
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     * @param empleados the empleados to set
     */
    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }
    
    //otros métodos:
    
    //OJO: Este método adicional está tal cual como lo solicita el reto:
    //DEBO IMPLEMENTARLO: recibe una lista de objetos tipo Empleado y retorna una lista (número decimal) con la liquidación de cada empleado 

    public static ArrayList<Double> liquidarNominaEmp(ArrayList<Empleado> empleados){
        //this.setEmpleados(empleados);
        //this.empleados = empleados;        
        //COMO ESTAMOS EN UN CONTEXTO ESTÁTICO, ENTONCES EN EL MAIN PARA USAR EL SET PERO EL PARAMETRO DE ESTE METODO ESTATICO NO ES EL ATRIBUTO DE CALL CENTER, ES DECIR, AQUI NO SE USA SINO PARA OTRAS COSAS PUEDE USARSE
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
            return nominas;//retorna una lista (número decimal) con las liquidaciiones de nomina de cada empleado 
        }
      }

    //OJO: Este método adicional está tal cual como lo solicita el reto:
    //DEBO IMPLEMENTARLO: recibe una lista de objetos tipo Empleado y retorna una lista (número decimal) con la liquidación de cada empleado 

    public static ArrayList<Double> liquidarPrestacionesEmp(ArrayList<Empleado> empleados){
        //this.setEmpleados(empleados);
        //this.empleados = empleados;        
        //COMO ESTAMOS EN UN CONTEXTO ESTÁTICO, ENTONCES EN EL MAIN PARA USAR EL SET PERO EL PARAMETRO DE ESTE METODO ESTATICO NO ES EL ATRIBUTO DE CALL CENTER, ES DECIR, AQUI NO SE USA SINO PARA OTRAS COSAS PUEDE USARSE
        ArrayList<Double> prestaciones = new ArrayList<>();//defino una lista de prestaciones vacía (null)
        
        //INFORMACIÓN SOBRE LA LIQUIDACIÓN CON BASE EN LOS CRITERIOS DEL RETO Y LOS DATOS ACTUALES (AÑO 2021) EN COLOMBIA:
        //REFERENCIA: https://colombia.as.com/colombia/2021/01/05/actualidad/1609876969_200603.html#:~:text=El%20salario%20m%C3%ADnimo%20subi%C3%B3%20%2430.723,1%20de%20enero%20de%202021.
        //Un trabajador que gane un salario mínimo en el país tendrá que recibir $908.526 pesos más auxilio de transporte adicional equivalente a 106.454 pesos.
        //salario minimo = $908.526 pesos 
        //auxilio de transporte adicional equivalente a $106.454 pesos.

        //Defino lo anterior y los porcentajes de prestaciones como constantes
        //REF: https://www.gerencie.com/porcentajes-prestaciones-sociales.html
        final int SALARIO_MINIMO = 908526;    
        final double PORCENTAJES_PRESTACIONES = (8.33*2.12)/100;//8.33%(prima de servicios)+8.33%(cesantias)+12%(interéses sobre las cesantías) aplicados al total devengado (salario mensual con horas extras y con auxilio de transporte (en caso de que aplique))
        final double PORCENTAJE_VACACIONES = (4.16/100);//aplicado sobre el salario mensual básico
        int AUXILIO_TRANSPORTE;

        //LIQUIDACION PRESTACIONES
        //Carmen: liquidación = 353157.19 = (total:salario + horas extras + SI_aux tte)*PORCENTAJES_PRESTACIONES  + salario*PORCENTAJE_VACACIONES  = 290757.19 + 62400 = 353157.19       
        //Laura: liquidación = 445221.80 (total:salario + horas extras + NO_aux tte)*PORCENTAJES_PRESTACIONES  + salario*PORCENTAJE_VACACIONES  = 362021.80 + 83200 = 445221.80       

        double salario;
        double horas_extras;
        double total;     
        double prestacion;
        boolean condicion;  
        
        if (empleados.isEmpty()){//empleados.size()==0 (ES LO MISMO)
            return null;//Sí la lista de empleados se encuentra vacía, el método debe de retornar un vector vacío.
        }else{            
                for (Empleado empleado : empleados) {           
                    salario = empleado.getSalario();
                    condicion = (salario<=2*SALARIO_MINIMO);
                    AUXILIO_TRANSPORTE = (condicion)?106454:0;                                        
                    horas_extras = empleado.getHorasExtra();                    
                    total = salario + horas_extras + AUXILIO_TRANSPORTE;
                    prestacion = total*PORCENTAJES_PRESTACIONES + salario*PORCENTAJE_VACACIONES;
                    prestaciones.add(prestacion);
                }                                       
              return prestaciones;//retorna una lista (número decimal) con las liquidaciones de prestaciones de cada empleado 
            }                
        
    }
}
