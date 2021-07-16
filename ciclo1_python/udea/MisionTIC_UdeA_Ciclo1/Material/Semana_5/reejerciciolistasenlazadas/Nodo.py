class Nodo():

    def __init__(varClase, nombre, movil, correo):
        varClase.nombre = nombre
        varClase.movil = movil
        varClase.correo = correo
        varClase.siguiente = None

    def actualizar(varClase, nombre, movil, correo):
        varClase.nombre = nombre
        varClase.movil = movil
        varClase.correo = correo

    def mostrar(varClase):
        print("Nombre:", varClase.nombre)
        print("Móvil:", varClase.movil)
        print("Correo:", varClase.correo)
