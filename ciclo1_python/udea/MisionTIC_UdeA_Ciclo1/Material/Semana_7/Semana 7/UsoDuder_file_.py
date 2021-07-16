# -*- coding: utf-8 -*-
"""
@author: Ing. Víctor Fabián Castro Pérez
"""
# Esto maneja el mensaje de advertencia de UMR
import warnings
warnings.filterwarnings("ignore", message="Reloaded modules: <Mifuncion>")

import Mifuncion

Mifuncion.imprimealgo()
rutadefuncion=__file__
print("La ruta donde está el script de la funcion Mifuncion es: \n",rutadefuncion)
