from Lista import Lista
from Nodo import Nodo

def leerNumero(mensaje):
    numero = 0
    numeroValido = False
    while not numeroValido:
        try :
            numero = float(input(mensaje))
            numeroValido = True
        except:
            print("El dato no es numérico!")
    return numero

contactos = Lista()
contactos.desdeArchivo("Contactos.txt")

opcionMenu = 0
nodoBuscado = None
while opcionMenu != 7:
    print("********** Menú de Contactos **********")
    print("1. Agregar contacto")
    print("2. Listar")
    print("3. Buscar contacto")
    print("4. Modificar contacto")
    print("5. Quitar contacto")
    print("6. Ordenar")
    print("7. Salir")

    opcionMenu = leerNumero("Opcion escogida?")

    if opcionMenu == 1:
        print("Datos del Contactos a agregar:")
        nombre = input("Nombre?")
        movil = input("Móvil?")
        correo = input("Correo?")
        n = Nodo(nombre, movil, correo)
        contactos.agregar(n)
    elif opcionMenu == 2:
        prefijo=input("Mostrar que comiencen por:")
        contactos.mostrar(prefijo)
    elif opcionMenu == 3:
        nodoBuscado = None
        textoBusqueda=input("Nombre a buscar:")
        nodos = contactos.buscar(textoBusqueda)
        if nodos:
            if len(nodos)==1:
                nodoBuscado = nodos[0]
            else:
                print("Se encontraron estos registros:")
                fila = 1
                for n in nodos:
                    print("Registro ", fila, ":")
                    n.mostrar()
                    fila += 1
                indiceElegido = 0
                while indiceElegido not in range(1, len(nodos)+1):
                    indiceElegido = int(leerNumero("Cual elige?"))
                nodoBuscado = nodos[indiceElegido-1]
            print("Se eligió este registro:")
            nodoBuscado.mostrar() 
        else:
            print("No se encontraron registros")
    elif opcionMenu == 4:
        if nodoBuscado:
            print("Nombre actual ", nodoBuscado.nombre)
            texto = input("Nuevo nombre?")
            if len(texto)>0:
                nodoBuscado.nombre = texto
            print("Correo actual ", nodoBuscado.correo)
            texto = input("Nuevo correo?")
            if len(texto)>0:
                nodoBuscado.correo = texto
            print("Móvil actual ", nodoBuscado.movil)
            texto = input("Nuevo Móvil?")
            if len(texto)>0:
                nodoBuscado.movil = texto
            print("El registro quedó así:")
            nodoBuscado.mostrar() 
        else:
            print("No hay contacto seleccionado")
    elif opcionMenu == 5:
        if nodoBuscado:
            contactos.eliminar(nodoBuscado)
            print("El nodo fue eliminado")
        else:
            print("No hay contacto seleccionado")
    elif opcionMenu == 6:
        contactos.ordenar()
        print("La lista fue ordenada alfabeticamente por el nombre")
    elif opcionMenu != 7:
        print("Opcion no válida")

    



