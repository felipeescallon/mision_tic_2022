class PerfectoCliente 
{    
  public static void main(String[] args)    
  {   
    pruebas_unitarias();       
  }
    public static void pruebas_unitarias()
    {
        Perfecto obj = new Perfecto();
        System.out.println(obj.perfecto(28));
        System.out.println(obj.perfecto(7));
        System.out.println(obj.perfecto(8));
        System.out.println(obj.perfecto(8128));
    }
}
