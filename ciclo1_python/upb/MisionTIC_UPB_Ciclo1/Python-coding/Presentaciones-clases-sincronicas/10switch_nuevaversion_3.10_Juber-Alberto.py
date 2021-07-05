
#este codigo es para la version 3.10 de python

semana = 0

semana = int(input("introduzca numero segun el dia:"))

match semana:
  case 0:
    print("lunes")
  case 1:
    print("martes")
  case 2:
    print("Miercoles")
  case 3:
    print("Jueves")
  case 4:
    print("Viernes")
  case 5:
    print("Sabado")
  case 6:
    print("Domingo")
  case 7:
    print("Dia no existe")