filas = int(input("Ingrese el número de filas de la matriz: "))
columnas = int(input("Ingrese el número de columnas de la matriz: "))
matriz = []
for m in range(filas):
    matriz.append([])
    for n in range(columnas):
          
        matriz[m].append(int(input(f"Ingrese el valor de la columna {n} de la fila {m}: ")))
print(matriz)