#Ejemplos de listas
quesos = ["Cheddar", "Edam", "Gouda"]
numeros = [1, 5]
vacia = []
print(quesos, numeros, vacia)

#Listas son MUTABLES
numeros[0] = 10
print(numeros)

#Evaluar si un elemento hace parte de una lista

print(5 in numeros)

#Recorrer elementos de una lista con FOR
for elemento in quesos:
    print(elemento)
