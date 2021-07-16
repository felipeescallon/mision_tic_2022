# -*- coding: utf-8 -*-
"""
@author: Ing. Víctor Fabián Castro Pérez
"""
import os

dta=os.getcwd()
# Imprime el directorio de trabajo actual dta
print("Directorio de Trabajo Actual:\n {0}".format(dta))
print("----")

# Obtiene la ruta en donde está el script
RutaScript = __file__
print("Este script está en la ruta : \n", RutaScript)

print("----")

# os.path.abspath(__file__) Devuelve la ruta absoluta de la ruta relativa dada.

RutaAbsArchivo = os.path.abspath(__file__)
print("La ruta absoluta de este script es \n", RutaAbsArchivo)

#La función os.path.split() divide el nombre script con la ruta completa. 
#Queda entonces la ruta absoluta y el nombre del fichero por separado
path, filename = os.path.split(RutaAbsArchivo)
print("----")
print("La ruta del script es {}\n \nEl nombre del archivo es {}".format(path, filename))
