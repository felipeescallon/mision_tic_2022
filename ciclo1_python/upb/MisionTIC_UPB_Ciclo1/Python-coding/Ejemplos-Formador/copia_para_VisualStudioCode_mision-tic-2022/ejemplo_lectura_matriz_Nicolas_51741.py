matriz=[]
print("Ingrese su respuesta y presione la tecla Enter")
n=int(input("Ingrese el numero de filas: "))
m=int(input("Ingrese el numero de columnas: "))
for i in range(n):
    matriz.append([])
    for x in range(m):
        print("A continuacion ingrese el numero en la posicion [",i+1,",",x+1,"]")
        temp=input("Numero: ")
        matriz[i].append(temp)
print("Tu matriz es la siguiente: ")
for f in range(n):
    print(matriz[f])