from Pila import Pila

class VerificadorXML():
    
    textoXML=""
    errorVerificando=""
    lineaError=0
    inicioLineaError=0

    #Método que indica si un caracter es letra o Numero
    def esAlfanumerico(dato):
        if dato.isalpha() or dato.isdigit() \
                or dato=="ñ" or dato=="Ñ":
            return True
        else:
            return False

    #Método que indica si un caracter es simbolo
    def esSimbolo(dato):
        if dato=="?" or dato=="\"" or dato==":" or dato=="'":
            return True
        else:
            return False

    def asignarError(mensaje):
        VerificadorXML.errorVerificando = mensaje
        return True

    def verificar():
        error = False
        VerificadorXML.errorVerificando = ""
        VerificadorXML.lineaError = 0
        textoEtiqueta = ""
        #Obtener primer línea
        i = 0
        linea = 1
        inicioLinea = 0
        while VerificadorXML.textoXML[i] != ">":
            textoEtiqueta += VerificadorXML.textoXML[i]
            i += 1
        textoEtiqueta += ">"
        
        b1=textoEtiqueta.startswith("<?xml")
        b2=textoEtiqueta.endswith("?>")
        if textoEtiqueta.startswith("<?xml") and textoEtiqueta.endswith("?>"):
            linea += 1
            inicioLinea = i
            i += 1
            textoEtiqueta = ""
            p = Pila()
            abrioEtiqueta = 0
            abrioNodo = False
            while i < len(VerificadorXML.textoXML) and not error:
                caracter = VerificadorXML.textoXML[i]
                if caracter == "<":
                    if (abrioEtiqueta == 0):
                        abrioEtiqueta = 1
                    else:
                        error = VerificadorXML.asignarError("Etiqueta no cerrada")
                elif caracter == ">":
                    if len(textoEtiqueta) > 0:
                        if abrioEtiqueta == 1:
                            #Etiqueta de inicio de nodo
                            p.apilar(textoEtiqueta)
                            abrioEtiqueta = 0
                            textoEtiqueta = ""
                            abrioNodo = True
                        elif abrioEtiqueta == 2:
                            #Etiqueta de fin de nodo
                            if not p.vacia():
                                etiquetaApilada = p.desapilar()
                                if textoEtiqueta != "/" + etiquetaApilada:
                                    error = VerificadorXML.asignarError("Etiqueta de cierre \"" \
                                            + textoEtiqueta \
                                            + "\" no coincide con la de apertura \"" + etiquetaApilada \
                                            + "\"")
                            else:
                                error = VerificadorXML.asignarError("Faltó etiqueta de apertura")
                            abrioEtiqueta = 0
                            textoEtiqueta = ""
                            abrioNodo = False
                        else:
                            error = VerificadorXML.asignarError("Etiqueta no abierta")
                    else:
                        error = VerificadorXML.asignarError("No se especificó Etiqueta")
                elif caracter == " ":
                    if abrioEtiqueta == 1 \
                        and len(textoEtiqueta) > 0 \
                        and VerificadorXML.textoXML[i + 1:i + 3]=="/>":
                        textoEtiqueta = ""
                        abrioEtiqueta = 0
                        i += 2
                    else:
                        if abrioEtiqueta > 0:
                            error = VerificadorXML.asignarError("Caracter \" \" no válido en la etiqueta")
                elif caracter == "/":
                    if abrioEtiqueta == 1 and len(textoEtiqueta) == 0:
                        abrioEtiqueta = 2
                        textoEtiqueta = "/"
                    else:
                        error = VerificadorXML.asignarError("Caracter \"/\" no válido en la etiqueta")
                elif caracter == "\t":
                    #No hacer nada
                    pass
                elif caracter=="\n":
                    linea += 1
                    inicioLinea = i + 1
                else:
                    if abrioEtiqueta > 0:
                        if VerificadorXML.esAlfanumerico(caracter):
                            textoEtiqueta += caracter
                        else:
                            error = VerificadorXML.asignarError("Caracter \"" + caracter + "\" no válido en la etiqueta")
                    elif not abrioNodo:
                        error = VerificadorXML.asignarError("Caracter \"" + caracter + "\" no válido fuera de nodo")
                i += 1
            if not error and not p.vacia():
                error = VerificadorXML.asignarError("Faltó una etiqueta de cierre")
        else:
            error = vasignarError("No es un documento XML")

        if error:
            VerificadorXML.lineaError = linea
            VerificadorXML.inicioLineaError = inicioLinea
        return not error
