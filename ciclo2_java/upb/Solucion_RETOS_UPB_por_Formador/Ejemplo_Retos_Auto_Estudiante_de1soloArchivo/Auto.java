
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

    public static void main(String[] args){
        Auto auto1 = new Auto("EMX-493", 20, true);
        Auto auto2 = new Auto("QET-882", 25, true);
        //Auto auto3 = new Auto("CFZ-886", 30, false);
        Auto auto3 = new Auto();
        auto3.setPlaca("CFZ-886");
        auto3.setDiasDesdeUltimoMantenimiento(30);
        auto3.setTieneSeguro(false);
        System.out.println(auto1.NecesitaMantenimiento());
        System.out.println(auto1.SePuedeRentar());
        System.out.println(auto2.NecesitaMantenimiento());
        System.out.println(auto2.SePuedeRentar());
        System.out.println(auto3.NecesitaMantenimiento());
        System.out.println(auto3.SePuedeRentar());

    }

}
