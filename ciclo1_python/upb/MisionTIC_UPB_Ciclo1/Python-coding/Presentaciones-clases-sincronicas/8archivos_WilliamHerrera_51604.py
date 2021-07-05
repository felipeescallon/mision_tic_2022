
#Cerrando archivos de forma automática
with open("remeras.txt", "r") as archivo:
    contenido = archivo.read()

print (archivo.closed)
#true


# Lectura de archivos
man_a = open('mbox-short.txt')
contador = 0
for linea in man_a:
    linea = linea.rstrip()
    if linea.startswith('From: '):
        print(linea)


# Búsqueda a través de un archivo
man_a = open('mbox-short.txt')
contador = 0
for linea in man_a:
    linea = linea.rstrip()
    if linea.startswith('From: '):
        print(linea)


