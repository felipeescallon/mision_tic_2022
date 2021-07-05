
contadores = {'Manuela': 1 , 'Luciana' : 34 , 'David' : 56}
for clave in contadores:
    print(clave, contadores [clave])

#contador
contador = 0
for valor in [3, 41, 12 , 9 , 74 , 15]:
    contador = contador + 1 
print('Numeros de elementos: ', contador)

#el acomulado
total = 0 
for valor in [3, 41, 12 , 9 , 74 , 15]:
    total = total + valor
print('Total: ' , total)

#numero mayor
mayor = None
print('Antes: ' , mayor)
for valor in [3, 41, 12 , 9 , 74 , 15]:
    if mayor is None or valor > mayor:
        mayor = valor 
    print('Bucle: ', valor , mayor )
print('Mayor: ' , mayor )

#Numero Menor
menor = None
print('Antes:' , menor)
for valor in [3, 41 , 12 , 9 , 74 , 15]:
    if menor is None or valor < menor:
        menor = valor 
    print('Bucle: ', valor , menor )
print('Menor: ' , menor )

 