
/*

RETO #1 DEL CICLO 2 (Programación en Java-SQL-MVC)
PROGRAMA MISION TIC 2022
Autor Ing. Andrés Felipe Escallón Portilla (30 de Julio de 2021)

HE SOLUCIONADO EL RETO DENTRO DE MI ROL COMO FORMADOR DE DICHO PROGRAMA LABORANDO CON EL MINISTERIO TIC  (MinTIC) DE COLOMBIA 
Y CON LA UNIVERSIDAD PONTIFICIA BOLIVARIANA DE MEDELLIN

El requerimiento del Reto#1 se puede encontrar aquí:
https://drive.google.com/drive/folders/1OyQn_GYc-6l1dKt1-5tmNMc6abJO5DNq?usp=sharing

*/
public class Auto{
    
    private String Placa;
    private int DiasDesdeUltimoMantenimiento;
    private boolean TieneSeguro;

    public Auto(){

    }    
    
    public Auto(String Placa, int DiasDesdeUltimoMantenimiento, boolean TieneSeguro){
        this.Placa = Placa;
        this.DiasDesdeUltimoMantenimiento = DiasDesdeUltimoMantenimiento;
        this.TieneSeguro = TieneSeguro;

    }   
    
    public String getPlaca(){
        return Placa;
    }

    public int getDiasDesdeUltimoMantenimiento(){
        return DiasDesdeUltimoMantenimiento;
    }
    public boolean isTieneSeguro(){
        return TieneSeguro;
    }

    public void setPlaca(String Placa){
        this.Placa = Placa;
    }
    
    public void setDiasDesdeUltimoMantenimiento(int DiasDesdeUltimoMantenimiento){
        this.DiasDesdeUltimoMantenimiento = DiasDesdeUltimoMantenimiento;

    }
        
    public void setTieneSeguro(boolean TieneSeguro){
        this.TieneSeguro = TieneSeguro;
    }


    public boolean NecesitaMantenimiento() {
        
        boolean respuesta;
        //respuesta = (this.DiasDesdeUltimoMantenimiento > 20)? true : false;
        respuesta = (getDiasDesdeUltimoMantenimiento() > 20)? true : false;
        return respuesta;
    }

    public boolean SePuedeRentar()
     {
        if (!NecesitaMantenimiento()){
            //if (this.TieneSeguro){
            if (isTieneSeguro()){
                return true;
            }
            else{
                return false;
            }
        }
        else {
            return false;
        }
    }
}   