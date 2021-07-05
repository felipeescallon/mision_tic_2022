#dict() --> me crea un diccionario sin elementos... ej:
diccionario = dict()
print(diccionario)
#me imprime esto: "{}"

#para agregar elementos a un dicionario se hace lo siguiente entre corchetes:
#Esta línea crea un elemento asociando a la clave 'one' el valor “uno”. Si imprimimos el diccionario de nuevo, vamos a ver un par clave-valor con dos puntos entre la clave y el valor: 
diccionario = ['one'] = 'uno'
print(diccionario)
#si lo imprimo me muestra esto:
#{'one': 'uno'}
#asi se agregan varios elementos..y me imprime aleatorio
dicionario = {'one' : 'uno', 'two' : 'dos', 'three' : 'tres'}
print(dicionario)
"""El orden de los pares clave-elemento no es el mismo. De hecho, si tu escribes este mismo ejemplo en tu computadora, 
podrías obtener un resultado diferente. En general, el orden de los elementos en un diccionario es impredecible. 
Pero ese no es un problema porque los elementos de un diccionario nunca son indexados con índices enteros. 
En vez de eso, utilizas las claves para encontrar los valores correspondientes: 
"""
#los elementos de un diccionario nunca son indexados con índices enteros. En vez de eso, utilizas las claves para encontrar los valores correspondientes: 
print(diccionario['two'])
#me imprime 'dos'
#si imprimo un clave que no este en el dicionario me arroja 'keyerror'
print(diccionario['four'])

contadores = {'chuck' : 1 , 'annie' : 42, 'jan' : 100}
for clave in contadores:
    print(clave, contadores[clave])

print("\n")



contadores = {'chuck' : 1 , 'annie' : 42, 'jan' : 100}
for clave in contadores:
    if contadores[clave] > 10:
        print(clave, contadores[clave])



print("\n")

contadores = {'chuck' : 1 , 'annie' : 42, 'jan' : 100}
lst = list(contadores.keys())
print(lst) 
lst.sort()
for clave in lst:
    print(clave, contadores[clave])







