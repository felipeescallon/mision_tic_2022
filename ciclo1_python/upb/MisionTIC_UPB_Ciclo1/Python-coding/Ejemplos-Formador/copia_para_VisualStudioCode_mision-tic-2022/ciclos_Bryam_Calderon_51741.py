centinela=7
while (centinela>=0 and centinela<=7) and centinela!=0:
    print("////////////////////////////////////////")
    print ("\\\\\\\\Bienvenido al programa múltiple:\\\\\\\\\\")
    print("///////// Seleccione la opcion //////////")
    print("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\")
    print("1. Saludar.\n2. Es par.\n3. Promedio\n4. Módulo\n5. Porcentaje\n6. Potencia. \n7. Refrescar \n0. Salir\n")
    centinela=float(input("Digite el numero y presione \"enter\":"))
    
    if centinela==1: #Saludar
        hora=float(input("¿Que hora (militar) es?: "))
        if hora>=6 and hora<=11:
            print ("\n")
            print("////////////////////////////////////////")
            print("¡Buenos Dias!")
        elif hora >=12 and hora<=18:
            print ("\n")
            print("////////////////////////////////////////")
            print("¡Buenas Tardes!")
        else:
            print ("\n")
            print("////////////////////////////////////////")
            print("¡Buenas Noches!")
        print("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\")
        print ("\n")
    
    if centinela==2: #Es Par
        IPar=float(input("Por favor, ingrese su número: "))
        if IPar%2==0:
            print ("\n")
            print("////////////////////////////////////////")
            print("Su número es par.")
        else:
            print ("\n")
            print("////////////////////////////////////////")
            print("Su número es impar.")
        print("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\")
        print ("\n")

    if centinela==3: #Promedio
        valor1=input("Por favor, ingrese el primer valor a promediar: ")
        valor2=input("Por favor, ingrese el segundo valor a promediar: ")
        valor3=input("Por favor, ingrese el tercer valor a promediar: ")
        valor4=input("Por favor, ingrese el cuarto valor a promediar: ")
        valor5=input("Por favor, ingrese el quinto valor a promediar: ")
        valor1=float(valor1)
        valor2=float(valor2)
        valor3=float(valor3)
        valor4=float(valor4)
        valor5=float(valor5)
        total=(valor1+valor2+valor3+valor4+valor5)/5
        mensaje="El promedio de los cinco valores es "
        print ("\n")
        print("////////////////////////////////////////")
        print(mensaje, total)
        print("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\")
        print ("\n")

    if centinela==4: #Módulo
        modEndo=float(input("Por favor, ingrese su dividendo: "))
        modSor=float(input("Por faovr, ingrese el divisor: "))
        if modSor==0:
            print ("\n")
            print("////////////////////////////////////////")
            print ("¡No se puede dividir por cero!")
        else:
            print ("\n")
            print("////////////////////////////////////////")
            print ("El residuo de la división es: ",int(modEndo%modSor))#round(modEndo%modSor,0)
        print("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\")
        print ("\n")

    if centinela==5: #Porcentaje
        perTotal=float(input("Por favor, ingrese el valor total: "))
        perCento=float(input("Por favor, ingrese el porcentaje que desea sacarle al valor anterior: "))
        print("\n")
        print("////////////////////////////////////////")
        print("El valor del porcentaje es: ", perTotal*perCento/100)
        print("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\")
        print ("\n")

    if centinela==6: #Potenciacion
        potBase=float(input("Por favor, ingrese el valor a elevar: "))
        potExpo=float(input("Por favor, ingrese el exponente: "))
        print("\n")
        print("////////////////////////////////////////")
        print("El valor elevado es: ",potBase**potExpo)
        print("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\")
        print ("\n")
