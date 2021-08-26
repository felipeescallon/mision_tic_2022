import java.util.Scanner;

public class MyTryCatch {
  public static void main(String[] args) {
    
    try{
    
    Scanner in=new Scanner(System.in);
    System.out.print("Enter a number:");
    
    float num=in.nextFloat();
    
    System.out.println("You entered the number:"+num);
    
    }catch (Exception e){
            
            System.out.println("Error!!!");
    }

  }

}