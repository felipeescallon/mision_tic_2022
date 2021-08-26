import java.util.HashMap;
import Persona;
import MotoAcuatica;

public class Alquiler {
    private int Id;
    private Persona Cliente;
    private MotoAcuatica Moto; 

    public Alquiler(int id, Persona cliente, MotoAcuatica moto) {
        Id = id;
        Cliente = cliente;
        Moto = moto;
    }       
    
    
    public double TerminarAlquiler(int cantidadHoras){
        int costo_por_hora=0;
        int total=0;
        
        if(this.Moto.getMarca().equals("Yamaha"))costo_por_hora = 50000;
        if(this.Moto.getMarca().equals("Kawasaki"))costo_por_hora = 60000;
        if(this.Moto.getMarca().equals("Sea-Doo"))costo_por_hora = 60000;
        
        total = cantidadHoras * costo_por_hora;
        
        int resultado = (this.Cliente.getEdad()<18)? 2*total:total;
        return resultado;                   
    }
    
    public static HashMap<String, Integer> AnalizarAlquileres(Alquiler[] historial){
        HashMap<String, Integer> diccionario = new HashMap<>();//inicializando un diccionario vacío
                
        int num_pers_acc_18_o_menos = 0;
        int num_pers_acc_19_a_30 = 0;
        int num_pers_acc_31_a_40 = 0;
        int num_pers_acc_41_a_50 = 0;
        int num_pers_acc_51_o_mas = 0;
        
        
        for (Alquiler alquiler : historial){
            if (alquiler.Cliente.getEdad()<=18){//18 o menos
                num_pers_acc_18_o_menos++;                
            }
            else if (alquiler.Cliente.getEdad()<=30){//19-30
                num_pers_acc_19_a_30++;
            }
            else if (alquiler.Cliente.getEdad()<=40){//31-40
                num_pers_acc_31_a_40++;
            }                
            else if (alquiler.Cliente.getEdad()<=50){//41-50
                    num_pers_acc_41_a_50++;
                    }                
            else{ //(alquiler.Cliente.getEdad()>50){//51 o más
                    num_pers_acc_51_o_mas++;
                    }          
        diccionario.put("18 o menos",  num_pers_acc_18_o_menos); //.put(K key, V value)            
        diccionario.put("19 - 30",  num_pers_acc_19_a_30);
        diccionario.put("31 - 40",  num_pers_acc_31_a_40);
        diccionario.put("41 - 50",  num_pers_acc_41_a_50);
        diccionario.put("51 o más",  num_pers_acc_51_o_mas);
        }        
        return diccionario;//HashMap is like a dictionary in Python 
    }

    @Override
    public String toString() {
        //return super.toString(); //To change body of generated methods, choose Tools | Templates.
        return this.Cliente.getNombre()+" con cédula "+this.Cliente.getCedula()+" renta la moto "+this.Moto.getId()+" modelo "+this.Moto.getModelo()+".";
    }
    
    
    
    
}
