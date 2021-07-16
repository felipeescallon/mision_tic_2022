from Nodo import Nodo

class Lista():

    def __init__(varClase):
        varClase.cabeza = None

    #metodo para agregar un nodo a la lista
    def agregar(varClase, n):
        #Verificar que haya un nodo para agregar
        if n != None:
            if varClase.cabeza == None:
                #La lista esta vacia
                #El nodo agregado es la cabeza
                varClase.cabeza = n
            else:
                #recorrer la lista hasta el ultimo nodo
                apuntador = varClase.cabeza
                while apuntador.siguiente != None:
                    apuntador = apuntador.siguiente
                apuntador.siguiente = n
                n.siguiente = None

    def desdeArchivo(varClase, nombreArchivo):
        varClase.cabeza = None
        lineas = open(nombreArchivo, "r")
        for linea in lineas:
            datos = linea.split(";")
            if len(datos)>=4:
                n = Nodo(datos[1], datos[3], datos[2])
                varClase.agregar(n)

    def mostrar(varClase, prefijo):
        #recorrer la lista hasta el ultimo nodo
        apuntador = varClase.cabeza
        while apuntador != None:
            if prefijo=="" or apuntador.nombre.lower().startswith(prefijo.lower()):
                print(apuntador.nombre, apuntador.correo, apuntador.movil)
            apuntador = apuntador.siguiente

    def obtenerPredecesor(varClase, n):
        predecesor = None
        if n != None and varClase.cabeza != None and varClase.cabeza!=n:
            predecesor = varClase.cabeza
            while predecesor != None and predecesor.siguiente!=n:
                predecesor = predecesor.siguiente
        return predecesor
    
    def eliminar(varClase, n):
        if n!= None:
            if n == varClase.cabeza:
                varClase.cabeza.siguiente = n.siguiente
            else:
                predecesor = varClase.obtenerPredecesor(n)
                predecesor.siguiente = n.siguiente

    def intercambiar(varClase, n1, n2) :
        if n1 != None and n2 != None and n1 != n2:
            cambiarSiguientes = False
            predecesor1 = varClase.obtenerPredecesor(n1)
            predecesor2 = varClase.obtenerPredecesor(n2)
            if predecesor1 != None:
                if predecesor1 != n2:
                    predecesor1.siguiente = n2
                    cambiarSiguientes = True
                else:
                    n2.siguiente = n1.siguiente
                    n1.siguiente = n2
                    if predecesor2 != None:
                        predecesor2.siguiente = n1
            else:
                #El Cabeza va a ser el segundo nodo
                varClase.cabeza = n2
                cambiarSiguientes = True

            if predecesor2 != None:
                if predecesor2!=n1:
                    predecesor2.siguiente = n1
                    cambiarSiguientes = True
                else:
                    cambiarSiguientes = False
                    n1.siguiente = n2.siguiente
                    n2.siguiente = n1
                    if predecesor1 != None:
                        predecesor1.siguiente = n2
            else:
                #El Cabeza va a ser el primer nodo
                varClase.cabeza = n1
                cambiarSiguientes = True
                
            if cambiarSiguientes:
                siguiente1 = n1.siguiente
                n1.siguiente = n2.siguiente
                n2.siguiente = siguiente1

    #Ordenar ascendentemente la lista por el nombre
    def ordenar(varClase):
        if varClase.cabeza != None:
            apuntador1 = varClase.cabeza
            while apuntador1.siguiente != None:
                apuntador2 = apuntador1.siguiente
                while apuntador2 != None:
                    #Intercambiar siempre y cuando el nombre siguiente sea menor
                    if apuntador1.nombre > apuntador2.nombre:
                        n1 = apuntador1
                        n2 = apuntador2
                        varClase.intercambiar(n1, n2)
                        apuntador1 = n2
                        apuntador2 = n1
                    apuntador2 = apuntador2.siguiente
                apuntador1 = apuntador1.siguiente
        
    def buscar(varClase, texto):
        nodosEncontrados = []
        if varClase.cabeza != None:
            apuntador = varClase.cabeza
            while apuntador != None:
                if texto.lower() in apuntador.nombre.lower():
                    nodosEncontrados.append(apuntador)
                apuntador = apuntador.siguiente
        return nodosEncontrados
