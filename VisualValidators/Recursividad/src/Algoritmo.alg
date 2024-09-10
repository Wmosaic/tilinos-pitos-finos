Llamar: VocalOut ("Hola Mundo")


VocalOut(String cadena)
    Llamar: outVocal(cadena, 0)

outVocal(String s, int index)   //Empieza en 0
    CadenaVocalOut = ""

    //ejem: 0 >= 10
    //Esta condicional termina el ciclo
    Si (index -Mayor o igual- a Longitud "s") Entonces:
        regresar ""     //cadena vacía
    Terminar Si

    //Comprobar si el carácter es una vocal
    //Empezando con Carácter[0] de "s"
    noIsVocal: Llamar: isVocal(Carácter[index] de "s", 0)

    Si (noIsVocal) Entonces:
        CadenaVocalOut += Carácter[index] de "s" //Agregar carácter
    Terminar Si

    //Volver a mandar llamar el mismo método (con mayor index)
    CadenaVocalOut += Llamar: outVocal(s, index + 1)

    Regresar CadenaVocalOut



isVocal(char c, int index)
    vocales = "aAáÁeEéÉiIíÍoOóÓuUúÚ"

    //ejem: 0 >= 20
    //Esta condicional termina el ciclo
    Si (index -Mayor o igual- a Longitud "vocales") Entonces:
        regresar True
    Terminar Si

    Si (c == Carácter[index] de "vocales") Entonces:
        regresar False
    Terminar Si

    //Volver a mandar llamar el mismo método (con mayor index)
    //No terminara hasta terminar toda la cadena de búsqueda
    regresar Llamar isVocal(c, index + 1)



CICLO FOR;
for (inicial iterador = 0; Condicional Iterador < 10; Incremento i = i + 1);


CICLO RECURSIVO;
Modificador return_Tipo nombre_Método (inicial Iterador = 0);
    if (Condicional Iterador < 10){
        Regresar nombre_Método(Incremento i = i + 1);
    }
    Regresar "";


CICLO RECURSIVO con +CONDICIONALES;
Modificador return_Tipo nombre_Método (inicial Iterador = 0);
    if (Condicional Iterador >= 10){
        Regresar "";
    }
    if (Condicional nueva){
        Regresar nombre_Método(Incremento i = i + 1);
    }
    Regresar nombre_Método(Incremento i = i + 1);





