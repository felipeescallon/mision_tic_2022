fruta="banana"                      #Cada caracter de la variable puede hubicarse con [].
letra=fruta[0]                      #Como funciona como una array, los valores comienzan desde 0. Asi, la primera letra es la 0 y la ultima 5.
print(fruta)
print(letra)
print(len(fruta))                   #len muestra la cantidad de caracteres de una cadena.
print()

indice=0
while indice <len (fruta):          #De estas dos manera se recorre una cadena con un bucle.
    letra=fruta[indice]
    print(letra)
    indice+=1
print()
for caracter in fruta:
    print(caracter)
print()

s="Monty Python"
print(s[0:5])                       #Con los dos puntos se rebana la cadena. Asi, se mostrará desde el valor a la izquierda hasta el valor a la derecha de los dos puntos.
print(s[6:])                        #Dejando en blanco el espacio de la derecha, el programa supone que se quiere leer hasta el final de la cadena.
print(s[4:3])                       #Si el primer indice es mayor o igual que el segundo, el resultado es vacio.

saludo="Hola Mundo"
#saludo[0]="h"                       No es posible cambiar un caracter de esta manera. Las cadenas son inmutables.
saludo0="h"+saludo[1:]              #Si necesitas, puedes hacerlo de esta forma.
print(saludo0)
print()

palabra="banana"        
contador=0                  
for letra in palabra:               #De esta manera se cuenta las veces que en la cadena "palabra" aparece la letra "a"
    if letra=="a":
        contador=contador+1
print(contador)
print("a" in palabra)               #in sirve para buscar dentro de la variable a la derecha si existe en ella el valor a la izquierda de in.
