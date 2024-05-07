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

/* 
*  En python la biblioteca OS tiene un metodo llamado listdir()
*  como argumento tiene una cadena donde busca y lee los archivos
*  dentro de la ruta acceso dada como argumento y regresa una lista
*  con todos los nombres de los archivo leeídos
*/

1. (Privado) (boolean) isDirec(direccion: string)
    Intentar
        direccion = direccion.replazar('\\' a '/')
        generarListaNombreArchivos(direccion)
        regresar Verdadero
    Excepcion 
        regresar Falso

2. (Publico) (string) capDireccion()
    Error = "Hubo un problema con la ruta de acceso, verifique por favor"
    Imprimir "Capture su ruta de Acceso w: "
    leer verdDireccion

    Mientras No(isDirec(verdDireccion)) Empezar
        Imprimir Error
        leer verdDireccion
    Terminar Mientras
    
    Regresar verdDireccion //La direccion obivaimente ya debe estar Formateada

/*
* Aqui Siento  y como sugerencia que lo mejor seria sobrecargar este método 
* Asi hacerlo mas versatil si el programadaro quiere 
* trabajar con una ruta de acceso "Fija" puede optar por 
* capFiles(direccion,ext) y asi acoplando mas los metodos
* y nos ahorramos el getDirs y el printNames
*/

3. (Publico) (Path) capFiles(direccion: string, ext: string) 
    newFiles = []
    myFiles = generarListaNombreArchivos(direccion)

    //Con esta logica se usa para filtrar los archivos con la extension 
    //En Python usare el metodo predifinido en el lenguaje *endswith(ext)*
    Para file en myFiles Empezar 
        Si f termina con la extencion "ext"
            newFiles.agregar(f)
    Terminar Para

    Para i in rango(0,len(newFiles),1)
        imprimir i+1+"."+newFiles[i]
    
    Imprimir "Seleccione su archivo por numero: Desde 1 hasta "+len(newFiles)
    leer index

    regresar Path(direccion+"/"+myFiles[index-1])

3.1 (Publico-Sobrecargado) (Path) capFiles(ext: string) 
    direccion = self.isDirec()
    myFiles =  generarListaNombreArchivos(direccion)

    //Con esta logica se usa para filtrar los archivos con la extension 
    //En Python usare el metodo predefinido en el lenguaje *endswith(ext)*
    Para file en myFiles Empezar 
        Si f termina con la extencion "ext"
            newFiles.agregar(f)
    Terminar Para

    Para f en rango(0,len(myFiles),1) Empezar
        Imprimir f+1 + "." +myFiles[f]
    Terminar Para

    Imprimir "Seleccione su archivo por numero: Desde 1 hasta "+len(myFiles)
    leer index

    regresar Path(myFiles[index-1]) 

/*
* El funcionamiento de este metodo hace que lea cada elemento de una linea
* de un archivo CSV y si ese elemento pasa por el validador isNum, IsDate o isNom
* usaremos un contador que se ira incremetando por cada elemento que pase por
* el isDate, IsNum o isNom Entoces si la longitud de la lista es diferente al contador 
* hay un error y en automatico el programa se interrupe para obligar al usario que 
* modifique su archivo
*/

//El metodo rstrip y split hace dividir la línea por comas y eliminar espacios en blanco al final

4. (Publico) (Vacio) valCSV(direccion: String)
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

//Direcciones ya validas obivaimente
5. (Publico) (LISTA) areFiles(direccion: string, ext: string)
    newArchivos = []
    misFiles = generarListaNombreArchivos(direccion)

    Para archivos en misFiles Entoces:
        Si archivo tiene la extencion "ext" Y se puede AbrirComoArchivo Entoces
            newArchivos.Agregar(archivo)
    
    Si len(newArchivos) == 0: InterrumpirPrograma
    De lo contrario Regresar newArchivos
