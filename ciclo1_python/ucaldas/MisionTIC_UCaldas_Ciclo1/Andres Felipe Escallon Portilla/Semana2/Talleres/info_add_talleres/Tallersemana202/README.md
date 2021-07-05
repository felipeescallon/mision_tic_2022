# Los espacios de color
En este taller vamos a continuar con el ejercicio de los espacios de color. para ello vamos a partir de la lista de requisitos de software que definimos

## Requisitos de software

 |R1:Convertir de YIQ a rva |
 | :-------------: |
|El programa debe convertir los valores del formato del espacio de color YIQ a los valores del formato del espacio de color rva aplicando la conversión directa utilizando la fórmula dada en la tabla. (en la etapa de definición del problema)|

|R2:Convertir de YIQ a YCbCr|
| :-------------: |
|El programa debe convertir los valores del formato del espacio de color YIQ a los valores del formato del espacio de color YCbCr aplicando una conversión intermedia de YIQ a rva y luego la conversión de rva a YCbCr utilizando la fórmula dadas en la tabla. (en la etapa de definición del problema)|

|R3:Convertir de rva a YIQ|
| :-------------: |
|El programa debe convertir los valores del formato del espacio de color rva a los valores del formato del espacio de color YIQ aplicando la conversión directa utilizando la fórmula dada en la tabla. (en la etapa de definición del problema)|

|R4:Convertir de rva a YCbCr|
| :-------------: |
|El programa debe convertir los valores del formato del espacio de color rva a los valores del formato del espacio de color YCbCr aplicando la conversión directa utilizando la fórmula dada en la tabla. (en la etapa de definición del problema)|  

|R5:Convertir de YCbCr a YIQ|
| :-------------: |
|El programa debe convertir los valores del formato del espacio de color YCbCr a los valores del formato del espacio de color YIQ aplicando una conversión intermedia de YCbCr a rva y luego la conversión de rva a YIQ utilizando la fórmula dadas en la tabla. (en la etapa de definición del problema)|

|Convertir de YCbCr a rva|
| :-------------: |
|El programa debe convertir los valores del formato del espacio de color YCbCr a los valores del formato del espacio de color rva aplicando la conversión directa utilizando la fórmula dada en la tabla. (en la etapa de definición del problema)  |


## Algoritmos
Por cada requisito funcional debemos tener un algoritmo. En el análisis y diseño que hicimos aplicando IDEAL creamos dos tipos de algoritmos, uno que hacía la conversión directamente con una fórmula de la tabla y otro que usaba una conversión intermedia. (Dale un vistazo al laboratorio o Pregúntale a tu formador/tutor si no lo recuerdas)

---
Algoritmo: R1:Convertir YIQ a rva (directo)
---
	Leer Y
	Leer I
	Leer Q
	Calcular r = 1Y+0.955I+0.618Q
	Calcular v = 1Y-0.271I-0.645Q
	Calcular a = 1Y-1.11I+1.7Q
	Retornar r, v, a


---
Algoritmo: R2:Convertir de YIQ a YCbCr (conversión intermedia)
---
	Leer Y
	Leer I
	Leer Q
	Calcular r = 1Y+0.955I+0.618Q
	Calcular v = 1Y-0.271I-0.645Q
	Calcular a = 1Y-1.11I+1.7Q
	Calcular Y = 0.299r+0.587v+0.114a
	Calcular Cb = 0.1687r-0.3313v-0.5a
	Calcular Cr = 0.5r-0.418v+0.0813a
	Retornar Y, Cb, Cr

***NOTA***

Los demás algoritmos siguen un patron similar a los dos anteeriores

**Impementación**
Debes implementar los programas en el archivo ``main.py`` que aparece en la lista de Files. (dale doble clic)
  





