import math
def suma(x,y):
    print("")
    z=x+y
    return(z)
def resta(x,y):
    z=x-y
    return(z)
def mult(x,y):
    z=x*y
    return(z)
def binario(x):
    bin=""
    while(True):
        if(x<=3):
            bin=bin+str(x%2)
            bin=bin+str(int(x/2))
            break
        bin=bin+str(x%2)
        x=int(x/2)
        print(bin)
    return(bin[::-1])
def decimal(x):
    dec=0
    long=len(x)
    x=x[::-1]
    for a in range(len(x)):
        dec=dec+(int(math.pow(2,a))*int(x[a]))
    return(dec)
def logaritmo(x,y):
    z=math.log(x,y)
    return(z)
def seno(x):
    z=math.sin(x)
    return(z)
def coseno(x):
    z=math.cos(x)
    return(z)
def raiz(x):
    x=math.fabs(x)
    z=math.isqrt(x)
    return(z)
def menu():
    print("Menu\n1. Suma\n2. Resta\n3. Multiplicacion\n4. Logaritmo\n5. Coseno\n6. Seno\n7. Raíz Cuadrada\n8. Convertir Decimal a Binario\n9. Convertir Binario a Decimal.")
    opcion=input("Ingrese la operacion que quiere realizar: ")
    if(opcion.isnumeric()):
        if(int(opcion)>=1 and int(opcion)<5):
            num1=0
            num2=0
            resul=0
            if(int(opcion)==1):
                num1=input("Ingrese el primer sumando: ")
                if(num1.isnumeric()):
                    num1=int(num1)
                    num2=input("Ingrese el segundo sumando: ")
                    if(num2.isnumeric()):
                        num2=int(num2)
                        resul=suma(num1,num2)
                        print("Su resultado es: ", resul)
            if(int(opcion)==2):
                num1=input("Ingrese el minuendo: ")
                if(num1.isnumeric()):
                    num1=int(num1)
                    num2=input("Ingrese el sustraendo: ")
                    if(num2.isnumeric()):
                        num2=int(num2)
                        resul=resta(num1,num2)
                        print("Su resultado es: ", resul)
            if(int(opcion)==3):
                num1=input("Ingrese el primer factor: ")
                if(num1.isnumeric()):
                    num1=int(num1)
                    num2=input("Ingrese el segundo factor: ")
                    if(num2.isnumeric()):
                        num2=int(num2)
                        resul=mult(num1,num2)
                        print("Su resultado es: ", resul)
            if(int(opcion)==4):
                num1=input("Ingrese la base: ")
                if(num1.isnumeric()):
                    num1=int(num1)
                    num2=input("Ingrese el argumento del logaritmo: ")
                    if(num2.isnumeric()):
                        num2=int(num2)
                        resul=logaritmo(num1,num2)
                        print("Su resultado es: ", resul)
        elif(int(opcion)>=5 and int(opcion)<=9):
            num1=0
            resul=0
            if(int(opcion)==5):
                num1=input("Ingrese el angulo en radianes: ")
                if(num1.isnumeric()):
                    num1=float(num1)
                    resul=coseno(num1)
                    print("Su resultado es: ", resul)
            if(int(opcion)==6):
                num1=input("Ingrese el angulo en radianes: ")
                if(num1.isnumeric()):
                    num1=float(num1)
                    resul=seno(num1)
                    print("Su resultado es: ", resul)
            if(int(opcion)==7):
                print("Tenga en cuenta que si ingresa un numero negativo se calculara la raiz del valor absoluto")
                num1=input("Ingrese el numero a calcular la raiz: ")
                if(num1.isnumeric()):
                    num1=float(num1)
                    resul=raiz(num1)
                    print("Su resultado es: ", resul)
            if(int(opcion)==8):
                num1=input("Ingrese el numero en decimal: ")
                if(num1.isnumeric()):
                    num1=int(num1)
                    resul=binario(num1)
                    print("Su resultado es: ", resul)
            if(int(opcion)==9):
                num1=input("Ingrese el numero en binario: ")
                if(num1.isnumeric()):
                    resul=decimal(num1)
                    print("Su resultado es: ", resul)
        else:
            print("Error, opcion no valida")
# Programa Principal
for p in range(5):
    menu()
