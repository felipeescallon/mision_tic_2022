public class HelloWorld{
    //función que retorna un mensaje
    public static String message()
    {
          //String str = new String("Hello World");//new es un "operador" usado para crear objetos(materialización de la plantilla) de una clase (plantilla)
	  String str = "Hello World";
          return str;
        }
        
    public static void main(String[] args)
    {
      String mensaje;
      mensaje=message();
      System.out.print(mensaje);
      //System.out.print(message());
    }
              
}