import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ejercicio_3 {
    private static boolean add;   

    public static void main(String[] args) throws Exception {
               
        
        List<Integer> par = new ArrayList<>();
        List<Integer> impar = new ArrayList<>();

        int[] V1 = {15,7,2,1,5,9,8,7,24,50};
        for(int i = 0; i < V1.length; i++){
            if (V1[i]%2==0) {
                par.add(V1[i]);
            } else {
                impar.add(V1[i]);
           }
        }
        Collections.sort(par);
        Collections.sort(impar);

        List<Integer> resultado = new ArrayList<Integer>();
        resultado.addAll(par);
        resultado.addAll(impar);
        System.out.println(resultado);

    }
 

}
