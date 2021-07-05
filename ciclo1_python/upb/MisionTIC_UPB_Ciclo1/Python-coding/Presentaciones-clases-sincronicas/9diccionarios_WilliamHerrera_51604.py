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









