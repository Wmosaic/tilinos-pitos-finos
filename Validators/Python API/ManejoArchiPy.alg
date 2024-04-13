/*------Manejo de Archivos en Python----------*/

/*
* El metodo forDireccion es exclusivo en Python por una estupida razon ocurre un problema
* con el UNICODE al capturar el caracter '\', por ende antes de trabajar con una
* ruta de acceso en Python se debe dar un correcto formato a la misma, de este modo: 
* Le das: "mi\ruta\de\acceso" (En widonws al copiar la ruta de un archivo tiene comillas)
* El formato funcina con comillas y sin las mismas solo para facilitar la captura al usuario
* Obtienes: mi/ruta/de/acceso <--El correcto formarto para trabajar con Piton
*/

//En Python el metodo replace es aplicado a objetos de tipo String
//El primer argumento es el caracter a remplazar y el segundo
//El caracter con el que se remplazara el primer argumento

1. (Publico) (String) formatearCadena(direccion: string)
    
    Si '"' esta en direccion Entoces
        direccionNoComilla = (direccion.replace('"','')).replace('\\','/')
    De lo Contrario
        direccionFormateada = direccion.replace('\\','/')

    return direccionFormateada

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

/*
* El funcionamiento de este metodo hace que lea cada elemento de una linea
* de un archivo CSV y si ese elemento pasa por el validador isNum, IsDate o isNom
* usaremos un contador que se ira incremetando por cada elemento que pase por
* el isDate, IsNum o isNom Entoces si la longitud de la lista es diferente al contador 
* hay un error y en automatico el programa se interrupe para obligar al usario que 
* modifique su archivo
*/

//El metodo rstrip y split hace dividir la línea por comas y eliminar espacios en blanco al final

5. (Publico) (Vacio) valCSV(direccion: String)
    rowError = 1
    cuenta = 0
    Archivo =  ArchivoAbrir(direccion)
    Archivo.leerLinea() // Se lee la primera linea por que es el encabeado

    -Para cada línea en csvFile Empezar para:
        rowError++
        myLis = lines.rstrip().split(',')
        -Para cada elemento lin en myLis Empezar para:
            si self.isNom(lin) es verdadero: cuenta++
            si self.isNum(lin) es verdadero: cuenta++
            si self.isDate(lin) es verdadero: cuenta++
        -Terminar Segundo Para
        Si la longitud de myLis no es igual a cuenta:
            imprimir "Hay un error en la línea: "+rowError
            abort() Interrumpe y sale del programa
        cuenta=0
    -Terminar Primer Para

    imprimir "No hay errores en su archivo :D"
    Archivo.Cerrar()
