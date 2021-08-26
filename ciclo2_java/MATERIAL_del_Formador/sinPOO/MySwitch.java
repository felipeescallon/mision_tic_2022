import java.util.Scanner;

public class MySwitch {
  public static void main(String[] args) {
    
    Scanner in=new Scanner(System.in);
    System.out.print("Enter the number of a day from 1 to 7:");
    
    String day=in.nextLine();
    
    System.out.println("You entered the number:"+day);
    
    //int day = 7;
    
    
    switch (day) {
      case "1":
        System.out.println("Monday");
        break;
      case "2":
        System.out.println("Tuesday");
        break;
      case "3":
        System.out.println("Wednesday");
        break;
      case "4":
        System.out.println("Thursday");
        break;
      case "5":
        System.out.println("Friday");
        break;
      case "6":
        System.out.println("Saturday");
        break;
      case "7":
        System.out.println("Sunday");
        break;
	  default:
        System.out.println("Invalid option");
        break;
    }
    
  }
}