/------Manejo de Archivos en Python----------/

/*
* El metodo forDireccion es exclusivo en Python por una estupida razon ocurre un problema
* con el UNICODE al capturar el caracter '\', por ende antes de trabajar con una
* ruta de acceso en Python se debe dar un correcto formato a la misma, de este modo: 
*/

//Le das: "mi\ruta\de\acceso" (En widonws al copiar la ruta de un archivo tiene comillas)
//El formato funcina con comillas y sin las mismas solo para facilitar la captura al usuario
//Obtienes: mi/ruta/de/acceso <--El correcto formarto para trabajar con Piton

//En resumen forDireccion es exclusivo de Python
1. (Publico) (String) forDireccion(direccion: string)
    newD = ""
    
    Para c en direccion Empezar
        Si c == '\\':
            c = '/'
        Si c == '"':
            c = ''
        newD += c
    Terminar Para

    return newD

/* 
*  En python la biblioteca OS tiene un metodo llamado listdir()
*  como argumento tiene una cadena donde busca y lee los archivos
*  dentro de la ruta acceso dada como argumento y regresa una lista
*  con todos los nombres de los archivo leeídos
*/

2. (Privado) (boolean) isDirec(direccion: string)
    Intentar
        listdir(direccion)
        regresar Verdadero
    Excepcion 
        regresar Falso

3. (Publico) (string) capDireccion(mensaje: string)
    Error = "Hubo un problema con la ruta de acceso, verifique por favor"
    Imprimir mensaje
    leer verdDireccion

    Mientras No(isDirec(forDireccion(verdDireccion))) Empezar
        Imprimir Error
        leer verdDireccion
    Terminar Mientras
    
    Regresar forDireccion(verdDireccion)+'/'

//Mejora de printsDir() la razon por la cual mandar un arreglo/lista de los nombres de los archivos

4. (Publico) (lista:String) getFiles(direccion: string) 
    myFiles = listdir(direccion)

    Para f en rango(0,len(myFiles),1) Empezar
        Imprimir f+1 + "." +myFiles[f]
    Terminar Para

    regresar myFiles