archivo = open(r "C:\Users\PROFESIONAL\Documents\Python\remeras.xlsx", "r")
contenido = archivo.read()
nombre = archivo.name
modo = archivo.mode
enconding = archivo.encoding
archivo.close()
if archivo.closed:
    print ("El archivo se ha cerrado correctamente")
else:
    print ("El archivo permanece abierto")


#linea_1 tiene la ruta correcta, pero presenta error.
