from Cola import Cola
from Pila import Pila

class Punto():
    def __init__(varClase, x, y):
        varClase.x = x
        varClase.y = y

    def esIgual(varClase, punto):
        return varClase.x == punto.x and varClase.y == punto.y

    def mostrar(varClase):
        print("x=",varClase.x,", y=",varClase.y)

class Laberinto():

    def __init__(varClase, laberinto, \
                 filaInicio, columnaInicio, \
                 filaFin, columnaFin):
        varClase.filas = len(laberinto)
        varClase.columnas = len(laberinto[0])
        varClase.laberinto = laberinto
        
        varClase.inicio = Punto(filaInicio, columnaInicio)
        varClase.fin = Punto(filaFin, columnaFin)
        varClase.caminoCorto = Pila()

    def mostrar(varClase):
        for i in range(0, varClase.filas):
            linea = ""
            for j in range(0, varClase.columnas):
                if varClase.laberinto[i][j]==1:
                    linea += "|"
                elif varClase.laberinto[i][j]==0:
                    linea += " "
                elif varClase.laberinto[i][j]==-1:
                    linea += "*"
                else:
                    linea += str(varClase.laberinto[i][j])
                linea +=  " "
            print(linea)

    def estaLibre(varClase, punto):
        return varClase.laberinto[punto.x][punto.y]==0

    def asignar(varClase, punto, valor):
        varClase.laberinto[punto.x][punto.y] = valor

    def resolver(varClase):
        cola = Cola()
        varClase.asignar(varClase.fin, 0)
        punto = varClase.inicio
        cola.encolar(punto)
        
        varClase.asignar(punto, -1) # Asignarlo a -1 para evitar retroceder y repetir la búsqueda
        while not cola.vacia(): 
            punto = cola.desencolar()
            if punto.esIgual(varClase.fin): # Salida encontrada
                return True # Devuelve verdadero cuando se encuentra una ruta
            for di in range(0, 4): # escanea cíclicamente cada posición
                heAvanzado = False
                if di == 0 and punto.x>0:
                    heAvanzado = True
                    puntoInteres=Punto(punto.x-1, punto.y)
                elif di ==1 and punto.y<varClase.columnas-1:
                    heAvanzado = True
                    puntoInteres=Punto(punto.x, punto.y+1)
                elif di ==2 and punto.x<varClase.filas-1:
                    heAvanzado = True
                    puntoInteres=Punto(punto.x+1, punto.y)
                elif di ==3 and punto.y>0:
                    heAvanzado = True
                    puntoInteres=Punto(punto.x, punto.y-1)

                if heAvanzado:
                    if varClase.estaLibre(puntoInteres):
                        cola.encolar(puntoInteres)
                        varClase.asignar(puntoInteres, -1)


            #varClase.mostrar()
        return False

