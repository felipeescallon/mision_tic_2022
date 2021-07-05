#colores
B  = '\033[34m' # blue
P  = '\033[35m' # purple
G  = '\033[32m' # green
O  = '\033[33m' # orange
W  = '\033[0m'  # white (normal)

#mensaje de bienvenida
mensajeBienvenida = B + "\n              Bienvenido(a) a la calculadora             " + B
mensaje2 = P + "Elige de 1 a 4 que operacion deseas realizar: " + W

#variables de menu
suma = "1. Suma"
resta = "2. Resta"
multiplicacion = "3. Multiplicacion"
division = "4. Division"

#mensajes a mostrar
print(mensajeBienvenida, end = "\n\n")
print(mensaje2, end= "\n\n")
print(suma , resta , multiplicacion , division, sep= "\n")


opcion = int(input("\nCual opcion eliges?: "))
if opcion < 1 or opcion > 4 :
    exit('Error operacion invalida.')

numero1 = int(input("\nIngrese primer numero: "))
numero2 = int(input("Ingrese segundo numero: "))
5
if opcion == 1:
    print(G + "\nEl resultado de la suma es: ", (numero1 + numero2))
elif opcion == 2:
    print(G + "\nEl resultado de la resta es: ", (numero1 - numero2))
elif opcion == 3:
    print(G + "\nEl resultado de la multiplicacion es: ", (numero1 * numero2))
elif opcion == 4:
    if numero2 == 0:
        exit('\nError, no se puede dividir por cero.')
    print(G + "\nEl resultado de la division es: ", (numero1 / numero2))
else:
    exit('\nIngresa una operacion valida.')

print("\n")
art = O + '''        .$$$$$:$$$:$$$$$$$     _..._        .$$$SSSSSS$$$$$$$$$.
       .$$$$$:$$$$:$$$$$$$    ~.sggg.        "  .~(g )$$$$$$$$$$.
       $$$$$:$$$$$:$$$$$$$ .sS$$$$$$$$s.     : '"--"' `$$$$$$$$$$.
       `$$$:$$$$$$:$$$$$$$.$$" .. g"-. `.    `.-.._    `$$$$$$$$$$
        $$$:$$$$$$:$$$$$$$`$' ' `._.'   :      `---      $$$$$$$$$.
        $$$:.$$$$$:$$$$$$$    `---'  _.'                 $$$$$$$$$$$.
        $$$$$:$$$$:$$$$$$s      ----"           .        $$$$$$$$$$$$.
        $$$$$`.$$$:$$$$$$$.                      `-._   .$$$$$$$$$$$$$$Sss.
        $$$$$$`;$$:$$$$$$$$.         _.:         .'   ;  $$$$$$$$$$$$$$$$$$$.
       .s$$$$$$'$$`.$$$$$$$$.      .'  `.       ' _ .`.  $$$$$$$$$$$$$$$$$$$$Ss.
     .s$$$$$$$$$$$$:$$$$$$$$$     :  _   ~~-...'.'.'  :  $$$$$$$$$$$$$$$$$$$$$$$
   .s$$$$$$$$$$$$$$`.$$$$$$$$s      : .~-,-.-.~:'.'   :  $$$$$$$$$$$$$$$$$$$$$$
 .s$$$$$$$$$$$$$$$$$`$$$$$$$$$$.    `  ~-.`"""'.'      `.$$$$$$$$$$$$$$$$$$$' ''' + O 

print(art)
print("\n")