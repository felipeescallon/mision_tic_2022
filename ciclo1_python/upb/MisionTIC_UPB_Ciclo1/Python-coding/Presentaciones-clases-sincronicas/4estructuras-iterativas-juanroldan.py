#Inicializacion de variable y actualizacion
x = 0 #Inicializacion
x = x + 1 #Actualizacion

#Ciclo WHILE
#Ejemplo1 while
n = 5 #Variable iterativa
while n > 0: #Condicion
    print(n) #Cuerpo del while, se ejecuta si condicion es verdadera
    n = n - 1 #Cuerpo del while, se ejecuta si condicion es verdadera
print('Despegue') #Se ejecuta cuando condicion es falsa

#Ejemplo2 del ciclo while
i = 0
while i < 3:
    print(i)
    i += 1
    print('Hecho')

#Ejemplo3 while
anio = 2001
while anio <= 2012:
    print('Informes del año', str(anio))
    anio += 1

#BREAK
#Ejemplo break1
while True:
    nombre = input('Indique su nombre: ')
    if nombre:
        break

#Ejemplo break2
n = 10
while True:
    print(n, end = ' ')
    n = n - 1
    if n == 3: #Sin esta condicion el bucle seria infinito por ser verdadero siempre
        break
print('Terminado')

#Ejemplo break3
while True:
    linea = input('> ')
    if linea == 'fin':
        break
    print(linea)
print('Terminado')

#CONTINUE
#Ejemplo continue1
while True:
    linea = input('> ')
    if linea[0] == '#':
        continue
    if linea == 'fin':
        break
    print(linea)
print('Terminado')


#Ciclo FOR
#Ejemplo for1 con una lista
amigos = ['Jose', 'Juan', 'Ana', 'Pedro']
for amigo in amigos: #amigo es variable de iteracion
    print('Feliz año nuevo:', amigo)
print('Terminado')

#Ejemplo for2 con una tupla
colores = ('amarillo', 'azul', 'rojo', 'verde')
for color in colores: #color es variable de iteracion
    print(color)

#Ejemplo for3 usando un rango
for anio in range(2001, 2013): #anio es variable de iteracion
    print(f'Informes del año {anio}')

#Contar con ciclo for
contador = 0
for valor in [3, 41, 12, 9, 74, 15]:
    contador = contador + 1
print('Numero de elementos: ',contador)
print(f'Numero de elementos: {contador}')

#Acumular con ciclo for
total = 0
for valor in [3, 41, 12, 9, 74, 15]:
    total = total + valor
print('Total: ', total)

#Numero maximo con ciclo for
mayor = None
print('Antes:', mayor)
for valor in [3, 41, 12, 9, 74, 15]:
    if mayor is None or valor > mayor:
        mayor = valor
    print('Bucle:', valor, mayor)
print('Mayor:', mayor)
print()

#Numero minimo con ciclo for
menor = None
print('Antes:', menor)
for valor in [3, 41, 12, 9, 74, 15]:
    if menor is None or valor < menor:
        menor = valor
    print('Bucle:', valor, menor)
print('Menor:', menor)
print()