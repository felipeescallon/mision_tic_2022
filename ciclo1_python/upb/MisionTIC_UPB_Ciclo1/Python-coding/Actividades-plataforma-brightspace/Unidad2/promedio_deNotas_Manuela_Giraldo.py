# datos de estudiante para promedio final
estudiante = input("Ingrese nombre completo: ")
codigo = int(input("Ingrese numero ID de estudiante: "))

#mensaje de bienvenida
print("Bienvenido " + estudiante + " con codigo ID: " + str(codigo) + " a continuacion vamos a calcular su promedio final de Fundamentos de programacion.")

#captura de notas
A= float(input("Ingrese su primera nota de Fundamentos de programacion: "))
B= float(input("Ingrese su segunda nota de Fundamentos de programacion: "))
C= float(input("Ingrese su tercera nota de Fundamentos de programacion: "))
D= float(input("Ingrese su cuarta nota de Fundamentos de programacion: "))
E= float(input("Ingrese su quinta nota de Fundamentos de programacion: "))

#promedio
promedio = ((A + B + C + D + E) / 5 )

#mensaje final
print("Su promedio final de Fundamentos de programacion es: ", promedio)
