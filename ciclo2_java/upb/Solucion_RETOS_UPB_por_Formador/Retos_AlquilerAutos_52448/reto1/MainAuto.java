/*

RETO #1 DEL CICLO 2 (Programación en Java-SQL-MVC)
PROGRAMA MISION TIC 2022
Autor Ing. Andrés Felipe Escallón Portilla (30 de Julio de 2021)

HE SOLUCIONADO EL RETO DENTRO DE MI ROL COMO FORMADOR DE DICHO PROGRAMA LABORANDO CON EL MINISTERIO TIC  (MinTIC) DE COLOMBIA 
Y CON LA UNIVERSIDAD PONTIFICIA BOLIVARIANA DE MEDELLIN

El requerimiento del Reto#1 se puede encontrar aquí:
https://drive.google.com/drive/folders/1OyQn_GYc-6l1dKt1-5tmNMc6abJO5DNq?usp=sharing

*/
public class MainAuto{
    
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

        System.out.println("AHORA SI SE VAN A VALIDAR LA 4 PRUEBAS DEL RETO 1:");
        Auto autoA = new Auto("ADK-847", 25, true);
        System.out.println(autoA.NecesitaMantenimiento());

        Auto autoB = new Auto("GYZ-175", 2, false);
        System.out.println(autoB.SePuedeRentar());
        

        Auto autoC = new Auto("FAT-324", 20, true);
        System.out.println(autoC.SePuedeRentar());

        System.out.println(autoA.SePuedeRentar());

        System.out.println("AHORA SI SE VAN A VALIDAR LA 4 PRUEBAS DEL RETO 1:");

        System.out.println("\n QUEDA PENDIENTE REALIZAR LAS PRUEBAS UNITARIAS PARA LA FUNCIÓN LIQUIDAR NÓMINA CON JUNIT...");
        




    }

}
