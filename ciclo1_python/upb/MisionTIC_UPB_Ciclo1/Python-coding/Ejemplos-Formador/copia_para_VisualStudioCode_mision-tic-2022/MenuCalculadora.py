import math
# SI VOY A EMPLEAR UNA VARIABLE COMO CONSTANTE, IDEALMENTE SE PONE EL NOMBRE EN MAYUSCULA
# PI=3.1416
# PI=math.pi # 3.14
numeros = 1 # es una variable inicializada
total = float()
promedio = float()
n = float()

opcion = int(input("ingresa 1(suma)2(resta)3(multiplicacion)4(division)5(potencia cuadrada)6(promedio): "))

if opcion == 6: # sugerencia: hacer validación preguntando cuantos valores desea promediar (debe ser un entero>0: 1,2,3,4,...)
                
    notas = int(input( "*****************************************************\
                       * ingresa el numero de notas que quieres promediar: *\
                      ********************************************************"))
                      
    4
    
    promedio = total/notas
    print("el promedio es: ")
    print("///",promedio,"///")
    


if opcion == 1:
    
    a = int(input("ingresar primer valor: "))
    b = int(input("ingresa el segundo valor: "))
    print("***",a + b,"***")
elif opcion == 2:
    
    a = int(input("ingresar primer valor: "))
    b = int(input("ingresa el segundo valor: "))
    print("***",a - b,"***")
elif opcion == 3:

    a = int(input("ingresar primer valor: "))
    b = int(input("ingresa el segundo valor: "))
    print("***",a*b,"***")
elif opcion == 4:
    
    a = int(input("ingresar primer valor: "))
    b = int(input("ingresa el segundo valor: ")) # falta la validación de que b debe ser distinto de cero
    print("***",a/b,"***")
elif opcion == 5:
   a = int(input("valor que quieres poner al cuadrado: "))
   elevado = math.pow(a,2) # elevado=a*a (a**2)
   print (elevado)


