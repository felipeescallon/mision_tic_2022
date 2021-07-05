num_entero=-10

if num_entero<0:    # ¿es negativo?: Si(True: Verdadero)
  print("el numero entero es negativo")


expresion = (3<8) #True 
print(expresion)
x = 3 if expresion else 8
print(x)

expresion = False # (3>8)
print(expresion)
x = 3 if expresion else 8
print(x)

# expresion==True (es redundante)
if expresion:
  
  x=3
  print(x)
else: #if expresion==False (if not expresion)
  x=8
  print(x)


x = 3 if -1<0 else 8
print(x) # x=3

x = 3 if (-1<0 and 5!=5) else 8 #...esto se puede extender a ciclos, listas y funciones(lambda).............
print(x) # x=8