man_a = open (' mbox-short.txt')
contador = 0
for linea in man_a:
    linea = linea.rstrip()
    if linea.find('@uct.ac.za') == -1: continue
    print(linea)
