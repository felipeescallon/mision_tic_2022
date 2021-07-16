# -*- coding: utf-8 -*-
"""

@author: Ing. Víctor Fabián Castro Pérez
"""
import os
# Obtiene el Directorio de trabajo actual dta Current Working Directory
dta=os.getcwd()

# Imprime el Directorio de trabajo actual dta
print("El Directorio de Trabajo Actual es :\n {0}".format(dta))
print()
# Imprime el tipo de dato obtenido en la función, en este caso es de tipo String
print("La función os.getcwd() retorna un dato de tipo: {0}".format(type(dta)))


