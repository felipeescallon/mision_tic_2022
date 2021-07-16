# -*- coding: utf-8 -*-
"""
@author: Ing. Víctor Fabián Castro Pérez
"""
import os
#os.path.abspath(__file__) devuelve la ruta absoluta de la ruta relativa dada.
RutaRelativa=os.path.abspath(__file__) 
#La función os.path.split() divide el nombre del fichero con la ruta de la ruta puabsoluta 
# y el nombre del archivo.
path, filename = os.path.split(RutaRelativa)
print("La ruta relativa del archivo Script es \n {} \nEl nombre del script es {}".format(path, filename))