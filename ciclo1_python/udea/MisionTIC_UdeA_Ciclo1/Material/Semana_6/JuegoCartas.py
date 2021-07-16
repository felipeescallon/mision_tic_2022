#Importar la libreria para GUI
from tkinter import *
#Importar la libreria para LISTAS DESPLEGABLES
from tkinter.ttk import Notebook
#Importar la libreria para MENSAJES
from tkinter import messagebox

#Importar la funcionalidad del JUGADOR
from Jugador import Jugador

ventana = Tk()
ventana.title('Juego de Cartas')
ventana.minsize(width=300,height=200)

#Crear el menu principal
mnuP = Menu(ventana)
#Agregarlo a la ventana
ventana.config(menu=mnuP)

#Variables globales
j1=Jugador()
j2=Jugador()

def repartir():
    j1.repartir()
    j1.mostrarCartas(f1)
    j2.repartir()
    j2.mostrarCartas(f2)


def verificar():
    if nbJ.index(nbJ.select())==0:
        f=j1.obtenerMensajeGrupos()
    else:
        f=j2.obtenerMensajeGrupos()
    messagebox.showinfo("Verificacion", f)

def salir():
    ventana.destroy()
    quit()

#Opciones del menu
mnuJ = Menu(mnuP)
mnuJ.add_command(label="Repartir", command=repartir)
mnuJ.add_command(label="Verificar", command=verificar)
mnuP.add_cascade(label="Juego", menu=mnuJ)

mnuP.add_command(label="Salir", command=salir)

nbJ = Notebook(ventana)
nbJ.pack(fill='both', expand='yes')

f1 = Frame(ventana, bg="green")
f2 = Frame(ventana, bg="lightblue")

nbJ.add(f1, text='Jugador 1')
nbJ.add(f2, text='Jugador 2')


