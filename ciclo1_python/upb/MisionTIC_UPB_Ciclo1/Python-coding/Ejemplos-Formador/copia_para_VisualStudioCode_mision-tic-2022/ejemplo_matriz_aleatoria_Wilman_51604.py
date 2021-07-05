from random import randint
matriz = []             # se inicializa la lista matriz vacia
numf = input("Ingresa numero de filas\n-> ")
numc = input("Ingresa numero de columnas\n-> ")
numf = int(numf)
numc = int(numc)
for fila in range(numf):   # se agregan 4 filas (elementos de la lista)
    fila = []           # cada iteracion agraga una fila vacia
    for columna in range(numc):    # se agregan 5 columnas por fila (posicion por fila)
        fila.append(randint(1,100))     # se agregan numeros aleatorios a cada posicion
    matriz.append(fila)         # se agregan todos los datos generados a la lista vacia "matriz"
print(f"Lista 'matriz' {matriz}\n")   # Imprime la lista de matriz
print("Matriz multidimensional")
for i in matriz:
    print(i)             # imprime la lista como matriz multidimensional
print()