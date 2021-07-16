#Importar la libreria para GUI
from tkinter import *

#Importar generador de numeros aleatorios
import random

#Importar los Enumerados
from Enumerados import *

class Carta:
    #Metodo constructor
    def __init__(varClase):
        #Generar aleatoriamente el indice de la carta
        varClase.indice=random.randrange(1, 53)

        # Atributo privado para almacenar el numero de la carta
        # 1= As de Trebol, 14= As de Pica, 27= As de Corazon, 40= As de Diamante,
        # 2= 2 de Trebol, 15= 2 de Pica, 28= 2 de Corazon, 41= 2 de Diamante,
        # 3= 3 de Trebol, 16= 3 de Pica, 29= 3 de Corazon, 42= 3 de Diamante,
        # ...
        # 10= 10 de Trebol, 23= 10 de Pica, 36= 10 de Corazon, 49= 10 de Diamante,
        # 11= J de Trebol, 24= J de Pica, 37= J de Corazon, 50= J de Diamante,
        # 12= Q de Trebol, 25= Q de Pica, 38= Q de Corazon, 51= Q de Diamante,
        # 13= K de Trebol, 26= K de Pica, 39= K de Corazon, 52= K de Diamante

    def obtenerPinta(varClase):
        if varClase.indice <= 13:
            return PintaCarta.TREBOL
        elif indice <= 26:
            return PintaCarta.PICA;
        elif indice <= 39:
            return PintaCarta.CORAZON;
        else:
            return PintaCarta.DIAMANTE;

    def obtenerIndiceNumero(varClase):
        n = varClase.indice % 13
        if n==0:
            n=13;
        return n
    
    def obtenerNumero(varClase):
        n = varClase.indice % 13
        if n==0:
            n=13;
        return NumeroCarta(n)

    def mostrar(varClase, frm, x, y):
        lblCarta=Label(frm)
        #cargar la imagen
        imgCarta=PhotoImage(file = "./Carta"+str(varClase.indice)+".gif")
        #Mostrar la imagen
        lblCarta.config(image=imgCarta)
        lblCarta.image=imgCarta
        lblCarta.place(x=x, y=y)

    def obtenerIndice(varClase):
        return varClase.indice
