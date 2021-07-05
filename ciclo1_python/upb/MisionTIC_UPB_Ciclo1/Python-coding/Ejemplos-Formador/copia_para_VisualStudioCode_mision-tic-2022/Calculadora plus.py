import math

def numeros():
    while True:
      try:
         num1 = int(input("ingresa numero 1: "))
         num2 = int(input("ingresa numero 2: "))
         
         
         return num1,num2
         
      except ValueError:
          print("error")
    
def logaritmo():
    while True:
      try:
         num_log = int(input("a que numero quieres sacar el logaritmo: "))
         print(math.log(num_log))
         break
      except ValueError:
          print("error")
    
def seno():
    while True:
      try:
          num_sin = int(input("a que numero quieres sacar el seno: "))
          print(math.sin(num_sin))
          break
      except ValueError:
          print("error")
    
def coseno():
    while True:
      try:
        num_cos = int(input("a que numero quieres sacar el coseno: "))
        print(math.cos(num_cos))
        break
      except ValueError:
          print("error")
    

def raiz():
  while True:
      try:
        num_raiz = int(input("a que numero quieres sacar el raiz cuadrada: "))
        print(math.sqrt(num_raiz))
        break
        
        
      except ValueError:
          print("error")

def decimal_binario():
    while True:
        try:
            dem1 = float(input("ingresa el numero que quieres pasar a binario: "))
            dem2 = int(dem1)
            print(bin(dem2))
            break         
        except ValueError:
            print("error")

def binario_decimal():
    while True:
        try:
            bin1 = input("ingresa los caracteres binarios que quieres convertir en numero: ")
            bin2 = int(str(bin1), 2)
            bin3 = float(bin2)
            print(bin3)
            break       
        except ValueError:
            print("error")   
       

def elecciondeopcion():
    
    opcion = int(input("que operacion deseas realizar: "))
 
    
    if opcion == 1:
        num1,num2 = numeros()
        print( num1 + num2)
    elif opcion == 2:
        num1,num2 = numeros()
        print( num1 - num2)
    elif opcion == 3:
        num1,num2 = numeros()
        print( num1 * num2)
    elif opcion == 4:
        num1,num2 = numeros()
        if num2 == 0:
             print("no se puede dividir entre 0")
             exit()
        print( num1 / num2)

    elif opcion == 5:
        logaritmo()
    elif opcion == 6:
        seno()
    elif opcion == 7:
        coseno()
    elif opcion == 8:
        raiz()
    elif opcion == 9:
        decimal_binario()
    elif opcion == 10:
        binario_decimal()
    
    
    
def menu():
    print("que operacion deseas realizar: \n 1. suma  \n 2. resta  \n 3. multiplicacion  \n 4. division  \n 5. logaritmo  \n 6. seno  \n 7. coseno  \n 8. raiz  \n 9. decimal a binario  \n 10. binario a decimal \n")    
    
    elecciondeopcion()


menu()