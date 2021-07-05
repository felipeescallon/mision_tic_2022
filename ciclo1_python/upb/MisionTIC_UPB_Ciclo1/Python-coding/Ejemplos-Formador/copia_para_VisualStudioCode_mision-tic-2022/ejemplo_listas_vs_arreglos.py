#listas(arreglo sin numpy) vs arreglos(con numpy)

arreglo_sin_numpy = [2, 3, 5, 7, 11, 13, 7, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101]# ES UNA LISTA    
print('arreglo_sin_numpy:',arreglo_sin_numpy)
print('len=',len(arreglo_sin_numpy))
print('sum=',sum(arreglo_sin_numpy))
print('max=',max(arreglo_sin_numpy))
print('min=',min(arreglo_sin_numpy))
print('promedio (sin mean)=',sum(arreglo_sin_numpy)/len(arreglo_sin_numpy))
#####################################################################
print()
#####################################################################

import numpy as np # previamente en la terminal de VSC (pip install numpy) o directamente en Google Collab 

arreglo_con_numpy=np.array(arreglo_sin_numpy)
print('arreglo_con_numpy:',arreglo_con_numpy)
#print(arreglo_con_numpy.len()) #NO ESTÁ DEDIFINA DENTRO DE NUMPY, ENTONCES FUNCIONA PARA AMBOS CASOS (LISTAS Y ARREGLOS)
print('len=',len(arreglo_con_numpy))
print('sum=',arreglo_con_numpy.sum())
print('max=',arreglo_con_numpy.max())
print('min=',arreglo_con_numpy.min())
print('promedio (con mean)=',arreglo_con_numpy.mean())
