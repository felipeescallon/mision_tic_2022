public static double[] cuadratica (double num1, double num2, double num3){
    double resul=0,var[];
    var= new double[2];
    resul= num2*num2-4*num1*num3;
    
    var[0]= -num2- Math.sqrt(resul) /2 * num1;
    var[1]= -num2+ Math.sqrt(resul) /2 * num1;
    return var;
