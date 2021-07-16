#Importar libreria para cuadro de diálogo
from tkinter import filedialog

from VerificadorXML import VerificadorXML

nombreArchivo=filedialog.askopenfilename()

if len(nombreArchivo)>0:
    #Abrir archivo
    archivoXML = open(nombreArchivo, "r")

    VerificadorXML.textoXML = ""
    for linea in archivoXML:
        VerificadorXML.textoXML += linea

    print(VerificadorXML.textoXML)

    if VerificadorXML.verificar():
        print("El documento XML es correcto")
    else:
        print(VerificadorXML.errorVerificando, \
                    ". Línea ", VerificadorXML.lineaError)

