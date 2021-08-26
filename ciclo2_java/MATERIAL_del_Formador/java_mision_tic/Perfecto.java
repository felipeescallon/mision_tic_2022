class Perfecto 
{
     
    public boolean perfecto(int n)
      {
        int suma = 0;
 
        for (int i = 1; i < n; i++)
        {
          if (n % i == 0) 
          {
            suma = suma + i;
          }
        }
 
        if (suma == n) 
        {
            return true;
        } 
        else 
        {
            return false;
        }
      }
}

