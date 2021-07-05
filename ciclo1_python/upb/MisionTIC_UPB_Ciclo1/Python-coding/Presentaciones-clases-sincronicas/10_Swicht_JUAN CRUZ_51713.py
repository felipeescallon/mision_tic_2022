print("----CONVERTIDOR----")
opc = int(input(" 1. Distancia cm a in\n 2. Peso lb a kg\n Digite la opcion: "))
num = float(input(" Digite el valor a convertir: "))

def switch (opc,num):
    switcher = {
        1: opcion1(num),
        2: opcion2(num)

    }
    return switcher.get(opc,"Error")

def opcion1(num):
    #num = float(input("Ingrese la distancia en centimetros: "))
    pulg = num/2.54
    #print("Las pulgadas son ",pulg)
    return pulg
def opcion2(num):
    #num = float(input("Ingrese el peso en libras: "))
    kilo = num/2.21
    #print("Los kilogramos son ",kilo)
    return kilo

a = switch(opc,num)
print(a)