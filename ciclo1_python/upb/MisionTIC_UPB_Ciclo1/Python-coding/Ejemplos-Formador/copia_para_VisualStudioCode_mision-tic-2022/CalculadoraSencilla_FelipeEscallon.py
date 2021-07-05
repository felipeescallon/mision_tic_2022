print('Ejemplo Calculadora Sencilla (+,-,*,/) por Felipe Escallón:')
'''
ESTO ES UN COMEWNTARIO MULTILINEA
print('Ejemplo Calculadora Sencilla (+,-,*,/) por Felipe Escallón:\n')
PODEMOS DESCOMENTAR Y PROBAR EL print ANTERIOR
'''
print()
#MENU:
print("MENU:")
print("1: +")
print("2: -")
print("3: *")
print("4: /")
print()
#Ingreso de datos:
opcion=input("Ingrese la opción deseada del menú: ") # la opción se guarda como caden
numero_uno=float(input('Ingrese el primer número de la operación:'))# guarda como flotante (número real)
numero_dos=float(input('Ingrese el segundo número de la operación:'))# guarda como flotante (número real)
#Posibilidades para ejecutar la calculadora:
if opcion=='1':
  print("Vamos a sumar(+) los dos valores ingresados:")
  print('La suma es:',numero_uno+numero_dos)
if opcion=='2':
  print("Vamos a restar(-) los dos valores ingresados:\n")
  resta=numero_uno-numero_dos
  #print("Resultado="+str(resta)) # voy a concatenar dos cadenas(str1+str2: no suma sino que junta, str1str2)
  print("Resultado=",resta) # voy a concatenar dos cadenas(str1+str2: no suma sino que junta, str1str2)
if opcion=='3':
  print("Vamos a multiplicar(*) los dos valores ingresados:\n")
  #print(f'{numero_uno}*{numero_dos}={numero_uno*numero_dos}')
  mult=numero_uno*numero_dos
  print(f'{numero_uno}*{numero_dos}={mult}')
  #print('{}*{}'.format(numero_uno,numero_dos),"=",'{}'.format(mult))
if opcion=='4':
  print("Vamos a dividir(/) los dos valores ingresados:\n")
  #VALIDANDO EL DENOMINADOR (debe ser diferente de cero)
  if numero_dos!=0:
    print(numero_uno/numero_dos)
  else:
    print("¡No es posible dividir entre cero!")