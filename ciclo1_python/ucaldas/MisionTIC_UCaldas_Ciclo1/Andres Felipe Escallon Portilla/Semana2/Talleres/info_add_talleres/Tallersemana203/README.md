# Distancia más corta
En este taller vamos a continuar con el ejercicio de la distancia mas corta. para ello vamos a partir de la lista de requisitos de software que definimos

## Requisitos de software

 |R1:Calcular distancia entre Celular 1 y Antena 1 |
 | :-------------: |
|Dadas las coordenadas cartesianas de la ubicación del celular 1 y de la antena 1 se calcula la distancia aplicando la fórmula de la distancia entre dos puntos |

|R2:Calcular la distancia entre Antena 1 y Central Holi |
 | :-------------: |
|Dadas las coordenadas cartesianas de la ubicación de la antena 1 y la Centra Holi se calcula la distancia aplicando la fórmula de la distancia entre dos puntos |

|R3:Calcular la distancia entre Central Holi y Antena 2 |
 | :-------------: |
|Dadas las coordenadas cartesianas de la ubicación de la Centra Holi y de la antena 2 se calcula la distancia aplicando la fórmula de la distancia entre dos puntos |

|R4:Calcular la distancia entre Antena 2 y Celular 2 |
 | :-------------: |
|Dadas las coordenadas cartesianas de la ubicación de la antena 2 y el celular 2 se calcula la distancia aplicando la fórmula de la distancia entre dos puntos |

|R5:Realizar la suma de los resultados de las 4 distancias anteriores |
 | :-------------: |
|Obtiene la distancia total que recorre la señal sumando las distancias parciales calculadas  |

## Algoritmos
Por cada requisito funcional debemos tener un algoritmo. En el análisis y diseño que hicimos aplicando IDEAL se escribieron dos, animate a escribir en este editor los algoritmos faltantes; puedes usar como base los que te presentamos

---
Algoritmo: R1:Calcular distancia entre Celular 1 y Antena 1
---
1.	Leer coordenada (Cx,Cy) del celular 1
2.	Leer coordenada (Ax,Ay) de la antena 1
3.  Calcular distancia = √(Cx-Ax)^2+(Cy-Ay)^2 
4.  Retornar distancia


---
Algoritmo: R5: Obtener la distancia total
---
1.	Llamar calcular distancia celular 1 antena 1
2.	Llamar Calcular la distancia entre Antena 1 y Central Holi
3.	Llamar Calcular la distancia entre Central Holi y Antena 2
4.	Llamar Calcular la distancia entre Antena 2 y Celular 2
5.	Calcular distancia  suma de las distancias retornadas
6.	Retornar distancia