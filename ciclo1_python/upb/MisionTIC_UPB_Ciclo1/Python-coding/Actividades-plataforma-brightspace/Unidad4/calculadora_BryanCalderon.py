# Programa que calcule la suma, la resta, la multiplicación, la división y la potencia cuadrada.

print("Bienvenido a la calculadora")
suma1=float(input("Por favor, ingrese el primer numero a sumar: "))
suma2=float(input("Por favor, ingrese el segundo numero a sumar: "))
totalSuma=suma1+suma2
mensaje="El resultado es "
print(mensaje, totalSuma)
print("\n")

resta1=float(input("Por favor, ingrese el primer numero a restar: "))
resta2=float(input("Por favor, ingrese el segundo numero a restar: "))
totalResta=resta1-resta2
print(mensaje, totalResta)
print("\n")

multi1=float(input("Por favor, ingrese el primer numero a multiplicar: "))
multi2=float(input("Por favor, ingrese el segundo numero a multiplicar: "))
totalMulti=multi1*multi2
print(mensaje, totalMulti)
print("\n")

divi1=float(input("Por favor, ingrese el primer numero a dividir: "))
divi2=float(input("Por favor, ingrese el segundo numero a dividir: "))
totalDivi=divi1/divi2
print(mensaje, totalDivi)
print("\n")

potencia=float(input("Por favor, ingrese el numero a elevar al cuadrado: "))
totalPotencia=potencia**2
print(mensaje, totalPotencia)
