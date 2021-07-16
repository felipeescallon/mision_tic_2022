# -*- coding: utf-8 -*-
"""
@author: Ing. Víctor Fabián Castro Pérez
"""
import os
import os.path

RutaAbsArchivo = os.path.abspath(__file__)
print("La ruta absoluta de este script es \n ", RutaAbsArchivo)

path, filename = os.path.split(RutaAbsArchivo)
#print("La ruta del script es {}\n \nEl nombre del archivo es \n {}".format(RutaAbsArchivo,filename))
print()
RutaAbsArchivo2=os.path.realpath(path)
print("La ruta del script con realpath() {}\n",(RutaAbsArchivo2,filename))
print()
Ultimacarpeta=os.path.basename(path)
print("El subdirectorio actual es", Ultimacarpeta)

tamano=os.path.getsize(path)
print ("El tamaño actual de la carpeta es de es", tamano, "bytes")

