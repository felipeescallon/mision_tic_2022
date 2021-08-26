import Alquiler;
import Persona;
import MotoAcuatica;
public class MainRentaMotosAcuaticas3 {
    public static void main(String[] args) {
        
        Persona cliente1 = new Persona("1000428", 20, "Juan");        
        Persona cliente2 = new Persona("10004830", 20, "Héctor");
        Persona cliente3 = new Persona("10008612", 14, "Carlos");
        Persona cliente4 = new Persona("522356", 53, "Israel");
        
        MotoAcuatica moto1 = new MotoAcuatica("001", "VXCruiser", "Yamaha");
        MotoAcuatica moto2 = new MotoAcuatica("3", "VXCruiser", "Yamaha");//**compartida por dos clientes        
        MotoAcuatica moto3 = new MotoAcuatica("2", "RXT", "Sea-Doo");
        
        Alquiler alquiler1= new Alquiler(5, cliente1, moto1);
        System.out.println(alquiler1.toString());//invoca al método toString()
        //System.out.println("Alquiler 1: "+alquiler1);//invoca automáticamente al método toString()
        
        Alquiler alquiler2= new Alquiler(123, cliente2, moto2);//**compartida por dos clientes
        System.out.println(alquiler2.TerminarAlquiler(5));
        
        Alquiler alquiler3= new Alquiler(125, cliente3, moto2);//**compartida por dos clientes
        System.out.println(alquiler3.TerminarAlquiler(5));
        
        Alquiler alquiler4= new Alquiler(92, cliente4, moto3);
        System.out.println(alquiler4.TerminarAlquiler(2));
        
        ///////////////////////////////////////////////////
        //PRUEBAS PARA EL HISTORIAL DE ALQUILERES DEL RETO 3:
        
        Persona cliente_uno = new Persona("2155", 17, "Carlito");        
        Persona cliente_dos = new Persona("73521", 19, "Juan");
        Persona cliente_tres = new Persona("63743", 25, "Valeria");
        Persona cliente_cuatro = new Persona("6785", 33, "Jose");
        Persona cliente_cinco = new Persona("6786", 21, "Miguel");        
        Persona cliente_seis = new Persona("514231", 48, "Maria");
        
        
        Alquiler alquiler_uno= new Alquiler(1, cliente_uno, moto1);
        Alquiler alquiler_dos= new Alquiler(2, cliente_dos, moto1);
        Alquiler alquiler_tres= new Alquiler(3, cliente_tres, moto1);
        Alquiler alquiler_cuatro= new Alquiler(4, cliente_cuatro, moto1);
        Alquiler alquiler_cinco= new Alquiler(5, cliente_cinco, moto1);
        Alquiler alquiler_seis= new Alquiler(6, cliente_seis, moto1);
        
        Alquiler[] historial = new Alquiler[6];//lista vacía de 6 (0-5) objetos tipo Alquiler
        
        historial[0]=alquiler_uno;
        historial[1]=alquiler_dos;
        historial[2]=alquiler_tres;
        historial[3]=alquiler_cuatro;
        historial[4]=alquiler_cinco;
        historial[5]=alquiler_seis;
        
        System.out.println(Alquiler.AnalizarAlquileres(historial));
        System.out.println("¡El anterior FUNCIONÓ porque dió lo mismo que estaba en el pdf del reto 3!");
        
        
    }
    
}
