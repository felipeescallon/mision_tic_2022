class Cola:
    #Metodo constructor
    def __init__(varClase):
        varClase.datos=[]

    def encolar(varClase, dato):
        varClase.datos.append(dato)

    def desencolar(varClase):
        if not varClase.vacia():
            dato=varClase.datos[0]
            del varClase.datos[0]
            return dato
        else:
            return None
    
    def valorTope(varClase):
        if varClase.datos:
            return varClase.datos[-1] #retorna el ultimo elemento
        else:
            return None

    def vacia(varClase):
        return len(varClase.datos)==0

    def longitud(varClase):
        return len(varClase.datos)
        
