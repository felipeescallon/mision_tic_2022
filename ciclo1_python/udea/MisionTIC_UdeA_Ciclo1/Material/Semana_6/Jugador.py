#importar la clase CARTA
from Carta import Carta

#Importar los Enumerados
from Enumerados import *

class Jugador :

    #Metodo constructor
    def __init__(varClase):
        varClase.cartas=[]
        varClase.totalCartas = 10
        varClase.Grupos=[]
        varClase.numeroGrupos=[]

    #Metodo para generar las cartas
    def repartir(varClase):
        varClase.cartas = []
        for i in range(0, varClase.totalCartas+1):
            varClase.cartas.append(Carta())

    #Metodo para mostrar todas las cartas del jugador
    def mostrarCartas(varClase, frm) :
        #limpiar el panel
        for w in frm.winfo_children():
            w.destroy()
        x = 5
        for i in range(0, len(varClase.cartas)):
            varClase.cartas[i].mostrar(frm, x, 5)
            x += 45

    #Metodo para encontrar las Grupos que hay en las cartas
    def obtenerGrupos(varClase) :
        varClase.Grupos = []
        varClase.numeroGrupos = []

        contadores = []
        for i in range(0, 13):
            contadores.append(0)

        for i in range(0, len(varClase.cartas)):
            pc=varClase.cartas[i].obtenerIndiceNumero() - 1
            contadores[pc] += 1;

        #Contar cuantas Grupos hay
        cf = 0
        for i in range(0, 13):
            if contadores[i] > 1:
                cf+=1

        #Hubo Grupos?
        if (cf > 0) :
            #Instanciar las Grupos
            cf = 0;
            for i in range(0, 13):
                if (contadores[i] > 1) :
                    pf=contadores[i]

                    varClase.Grupos.append(GrupoCarta(pf))
                    varClase.numeroGrupos.append(NumeroCarta(i + 1))

    def obtenerMensajeGrupos(varClase):
        mensaje="No hay Grupos"
        varClase.obtenerGrupos();
        if len(varClase.Grupos)>0:
            mensaje="Las Grupos del jugador son:\n"
            for i in range(0, len(varClase.Grupos)):
                mensaje+=varClase.Grupos[i].name +" de "+varClase.numeroGrupos[i].name +"\n"
        return mensaje;

    def obtenerPuntaje():
        puntaje=0


        return puntaje

