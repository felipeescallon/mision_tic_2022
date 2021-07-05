#print ("Hola mundo")


# INTENTO DE ARCHIVO
#color = int(input("Por favor ingrese su edad: "))
#edad = color
#print (f'El usuario tiene' + edad)
#triada = [5,6,7,8]
#valor = [(1,3),2,3,4]
#dato = dict(zip(valor,triada))
#lista = {1:0,5:1,6:2,4:3,8:5,10:6}

#print (dato)
#print(type(valor))
#dato.update(lista)


#SEPARACIÓN

#Vamos a probar hacer algo de Swicht

def swicht_demo(argument):
    swichter = {
        1: "Enero",
        2: "Febrero",
        3: "Marzo",
        4: "Abril",
        5: "Mayo",
        6: "Junio",
        7: "Julio",
        8: "Agosto",
        9: "Septiembre",
        10: "Octubre",
        11: "Noviembre",
        12: "Diciembre"
        }
    print (swichter.get(argument, "Mes invalido"))

def menu():
    print("----------MENU----------")
    print("1. opción 1")
    print("2. opción 2")
    print("3. opción 3")
    print("4. opción 4")
    print("------------------------")

def default():
    return "Opción no valida"

