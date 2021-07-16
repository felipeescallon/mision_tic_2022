
from Laberinto import Laberinto

laberinto = [[1,1,1,1,1,1,1,1,1,1], \
            [1,0,0,1,0,0,0,1,0,1], \
            [1,0,0,1,0,0,0,1,0,1], \
            [1,0,0,0,0,1,1,0,0,1], \
            [1,0,1,1,1,0,0,0,0,1], \
            [1,0,0,0,1,0,0,0,0,1], \
            [1,0,1,0,0,0,1,0,0,1], \
            [1,0,1,1,1,0,1,1,0,1], \
            [1,1,0,0,0,0,0,0,0,1], \
            [1,1,1,1,1,1,1,1,1,1]]
           

l = Laberinto(laberinto, 1, 0, len(laberinto)-1, len(laberinto[0])-2)

print("El laberinto original es:")
l.mostrar()


print("f=", l.filas, ", c=",l.columnas)

#l.encontrarSalida()
if l.resolver():
    print("la solución es:")

    l.mostrar()
else:
    print("no tiene solucion")

