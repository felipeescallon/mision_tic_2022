import numpy as np
matriz = [[2, 0, 5, 8], [1, 3, 7, 4], [6, 9, 0, 2]]
print(matriz)
print(matriz*(-2))# no arroja el resultado esperado
#Sugerencias:
#1. Hacerlo manualmente (opcional: estariamos REINVENTANDO LA RUEDA porque numpy YA LO HACE) 
#2. Usar numpy (deseado)
matriz_np = np.array(matriz)
print(matriz_np)
matriz_np_mult=matriz_np*(-2)
print(matriz_np_mult)