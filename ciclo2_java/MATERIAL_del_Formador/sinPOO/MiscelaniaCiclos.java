public class MiscelaniaCiclos {
  public static void main(String[] args) {
    
    //EJEMPLO 1 con los digitos del 0-9: while vs do-while vs for
    System.out.println("EJEMPLO 1 con los digitos del 0-9: while vs do-while vs for:");
    System.out.println("while...");        
    int i = 0;
    while (i <= 9) {
      System.out.println("Digit: "+i);
      i++;
    }  

    System.out.println("do-while...");        
    int j = 0;
    do {
      System.out.println("Digit: "+j);
      j++;
    }while (j <= 9);  

    System.out.println("for...");    
    for (int c = 0; c <= 9; c++) {
        System.out.println(c);
      }  

/////////////////////////////////////////////////////
    //EJEMPLO 2 con los digitos del 0-9: while vs do-while vs for        
    System.out.println("EJEMPLO 2 (no entra en while/for, solo entra una vez al do-while e incrementa la variable usada en 1) con los digitos del 0-9: while vs do-while vs for:");
    System.out.println("while...");        
    int k = 9;
    System.out.println("k antes="+k);
    while (k < 9) {
      System.out.println("Digit: "+k);
      k++;
    }
    System.out.println("k después="+k);
    
    System.out.println("do-while...");    
    int  x= 9;
    System.out.println("x antes="+x);
    do {
      System.out.println("Digit: "+x);
      x++;
    }while (x < 9);
    System.out.println("x después="+x);

    
    System.out.println("for...");    
    //int i = 9;
    //System.out.println("i="+i);
    System.out.println("Testing the for loop: before");
    for (int cont = 0; cont < 9; cont++) {
      System.out.println("Digit: "+cont);
      //i++;
    }
    System.out.println("Testing the for loop: after");


    }

}
