#Ejercicio práctico con listas.
"""
Manipulación de una lista
1.- Capturar una lista
2.- Mostrar una lista.
3.- Agregar un elemento a una lista.
4.- Eliminar un elemento de una lista
5.- Modificar un elemento de una lista
6.- Salir
""" 
#Definiendo la función capturar.
def capturar():#Captura n elementos en una lista.
    global lista#Definimos variable global. 
    lista=[]#Definimos lista vacia.
    print ("Cuantos elementos va a tener la lista?")
    n=input()
    n=int(n)
    for i in range(0, n):# Le indicamos que inicia desde cero hasta n.
        print("Ingrese el elemento del índice ", i)
        elemento = input()#Cualquier tipo. Recuerden.
        lista.insert(i, elemento)#Necesitamos el índice y el elemento.
#Definiendo la función mostrar
def mostrar():#Muestra la lista capturada.
    print(lista)
#Definiendo la función agregar.
def agregar():
    print("Ingresa el elemento que desea agregar: ")
    elemento=input()
    print("Ingrese el índice donde desea agregarlo. ")
    indice = input()
    indice = int(indice)
    #Validamos. Evitamos insertar antes del cero
    longitud=len(lista)#Devuelve la longitud de una cadena de texto.
    longitud=int(longitud)
    if(indice>longitud or indice < 0):#Quiere decir. < que cero y mayor que len.
        print("El índice debe estar entre 0 y ", longitud)
    else:
        lista.insert(indice,elemento)
        print("elemento Agregado.")
#Definfiendo la función eliminar.
def eliminar():
    print("Ingrese el índice del elemento que desea eliminar. ")
    indice = input()
    indice = int(indice)
    longitud=len(lista)
    longitud=int(longitud)
    if(indice>longitud or indice < 0):
        print("El índice debe estar entre 0 y ", longitud-1)
    else:
        del lista[indice]
        print("elemento Eliminado.")
#Definiendo la función modificar.
def modificar():
    print("Ingrese el índice del elemento que desea modificar. ")
    indice = input()
    indice = int(indice)
    print("Ingrese el nuevo valor del elemento.")
    elemento=input()
    longitud=len(lista)
    longitud=int(longitud)
    if(indice>longitud or indice < 0):
        print("El índice debe estar entre 0 y ", longitud-1)
    else:
        lista[indice]=elemento
        print("elemento Modificado.")
#Definiendo a la función principal.
def principal():
    opcion="1"
    while (opcion!=6):
        print("Manipulación de una lista")
        print("1.- Capturar una lista")
        print("2.- Mostrar una lista.")
        print("3.- Agregar un elemento a una lista.")
        print("4.- Eliminar un elemento de una lista")
        print("5.- Modificar un elemento de una lista.")
        print("6.- Salir.")
        print("Que deseas hacer?.")
        #Evaluando el valor de la opción.
        opcion=input()
        if (opcion=="1"):
            capturar()
        elif (opcion == "2"):
            mostrar()
        elif (opcion == "3"):
            agregar()
        elif (opcion == "4"):
            eliminar()
        elif (opcion == "5"):
            modificar()
        elif (opcion == "6"):
            print("!Programa Terminado!.")
        else:
            print("!Opción incorrecta!.")
print("Termino")
#Llamamos a la función principal.

principal()
