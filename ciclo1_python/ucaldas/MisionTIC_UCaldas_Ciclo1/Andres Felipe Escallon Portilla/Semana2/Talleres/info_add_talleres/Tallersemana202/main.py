""" Taller 2.2 Espacios de Color #
    Tu nombre aquí
    Mayo xx-XX """

# Definición de Funciones (Dividir)

#======================================================================
#          E S P A C I O    P R E _ _ C O N F I G U R A D O
# =====================================================================
def convertir_yiq_a_rva(y,i,q):
  """ 
  Parameters
  ----------
  y,i,q:float
     valores del espacio de color YIQ
  Returns
  -------
  r,v,a:float
     valores del espacio de color RVA    
  """ 
  r = y+0.955*i+0.618*q
  v = y-0.271*i-0.645*q
  a = y-1.11*i+1.7*q

  return r,v,a
#-------------------------------------------
def convertir_yiq_a_ycbcr(y,i,q): 
  """ 
  Parameters
  ----------
  y,i,q:float
     valores del espacio de color YIQ
  Returns
  -------
  y,cb,cr:float
     valores del espacio de color YCbCr
  """ 
  #Se hace aqui la conversión intermedia
  r = y+0.955*i+0.618*q
  v = y-0.271*i-0.645*q
  a = y-1.11*i+1.7*q 
  
  #Se hace aqui la conversión que se pide
  y = 0.299*r+0.587*v+0.114*a
  cb = 0.1687*r-0.3313*v-0.5*a
  cr = 0.5*r-0.418*v+0.0813*a

  return y,cb,cr
#======================================================================
#          E S P A C I O    D E    T R A B A J O     A L U M N O
# =====================================================================
def convertir_rva_a_yiq(r,v,a):
  #TODO: comentarios
  #TODO: instrucciones
  y=0
  i=0
  q=0
  return y,i,q
#-------------------------------------------
def convertir_rva_a_ycbcr(r,v,a):
  #TODO: comentarios
  #TODO: instrucciones
  y=0
  cb=0
  cr=0
  return y,cb,cr
#-------------------------------------------
def convertir_ycbcr_a_yiq(y,cb,cr):
  #TODO: comentarios
  #TODO: instrucciones
  y=0
  i=0
  q=0
  return y,i,q 

def convertir_ycbcr_a_rva(y,cb,cr):
  #TODO: comentarios
  #TODO: instrucciones
  r=0
  v=0
  a=0
  return r,v,a 


#======================================================================
#   Algoritmo principal Punto de entrada a la aplicación (Conquistar)
# =====================================================================

#lectura espacio de color RVA 
r = float(input("Digite el valor de r:"))
v = float(input("Digite el valor de v:"))
a = float(input("Digite el valor de a:"))


#lectura espacio de color YIQ 
y = float(input("Digite el valor de Y:"))
i = float(input("Digite el valor de I:"))
q = float(input("Digite el valor de Q:"))

#lectura espacio de color YCbCr 
y = float(input("Digite el valor de Y:"))
cb = float(input("Digite el valor de Cb:"))
cr = float(input("Digite el valor de Cr:"))


#Llamado/invocación de funciones

#Se utilizan otras variables para gurdar lo que retorna la funciòn
#para no cambiar el valor de las entradas por teclado

rt,vt,at= convertir_yiq_a_rva(y,i,q)
print("la conversión de yiq a rva es","r=",rt,"v=",vt,"a=",at)
yt,cbt,crt=convertir_yiq_a_ycbcr(y,i,q)
print("la conversión de yiq a ycbcr es","y=",yt,"cb=",cbt,"cr=",crt)

#======================================================================
#          E S P A C I O    D E    T R A B A J O     A L U M N O
# =====================================================================

#TODO: realizar los llamados a las funciones faltantes 
