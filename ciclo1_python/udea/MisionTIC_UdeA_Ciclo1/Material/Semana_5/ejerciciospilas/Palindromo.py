from Pila import Pila

texto = input("Frase a validar?")

texto=texto.lower();
        
p=Pila()
#Quitar lo espacios en blanco
texto=texto.replace(" ", "")

mitad = int(len(texto)/2)

for i in range(0,mitad):
    p.apilar(texto[i]);

esPalindromo=True
i = mitad
if len(texto)% 2!=0:
    i += 1
while not p.vacia() and esPalindromo:
    caracter=p.desapilar()
    if texto[i] != caracter:
        esPalindromo=False;
    i += 1
if esPalindromo:
    print("La frase es palindromo")
else:
    print("La frase no es palindromo")
