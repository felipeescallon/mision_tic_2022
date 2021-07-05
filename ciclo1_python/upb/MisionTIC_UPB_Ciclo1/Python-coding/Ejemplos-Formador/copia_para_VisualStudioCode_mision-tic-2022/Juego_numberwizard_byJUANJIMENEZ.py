#Juan Sebastian Jimenez Gonzalez
#Ingeniero forestal

#Number Wizard
import random

print("####NUMBER WIZARD####")
print("\nHola Mago. Adivina adivinador.\n ¿Cuál es el número en el que estoy pensando yo?\n")

rnd = random.randint(0, 1000)
print (rnd)

#print (rnd)
numero = int(input("Ingresa un número entre 0 y 1000:"))
i=0
while rnd != numero:
	if numero < rnd:
		print("El número es mayor.\n")
	else:
		print("El número es menor.\n")
	i = i+1
	numero = int(input("Ingresa un número entre 0 y 1000:"))

print(f"\n¡Eureka! El número era {rnd}, eres un excelente adivino y lo hiciste en {i} intentos.\n")	