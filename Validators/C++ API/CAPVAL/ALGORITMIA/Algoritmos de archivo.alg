1.0 (Publico) (void) printNames(rutaStr:String)
    Si (validador.isDir(rutaStr))     
        Path ruta = rutaStr
        Para Archivo arch en iterador_de_directorios(ruta)
            Escribir(archivo.ruta.nombre() + "\n")

1.1 (Publico) (void) printNames(rutaStr:String, filtrar: boolean)
    Si (validador.isDir(rutaStr))     
        Path ruta = rutaStr
        Para Archivo arch en iterador_de_directorios(ruta)
            Si arch.es_regular()
                Escribir(archivo.ruta.nombre() + "\n")

2.0 (Publico) (Vector<Path>) getDirs(ruta:String)
    Si(validador.isDir(rutaStr))
        Vector<Path> rutas;
        Path ruta = rutaStr
        Para Archivo arch en iterador_de_directorios(ruta)
            Si arch.es_regular()
                rutas.agregar(arch.ruta())
        Regresar rutas

2.1 (Publico) (Vector<Path>) getDirs(ruta:String, extension:String)
    Si(validador.isDir(rutaStr))
        Vector<Path> rutas;
        Path ruta = rutaStr
        String patron = "^(([a-zA-Z0-9 _-]+\\)?)+"
        patron += extension + $
        Patron patronRegex = patron



        Para Archivo arch en iterador_de_directorios(ruta)
            Si arch.es_regular() Y buscarPatron(arch.ruta(), patronRegex)
                rutas.agregar(arch.ruta())
        Regresar rutas


3.0 (Publico) (Path) capDir()
    Escribir("Ingrese la ruta al directorio deseado:\n")
    leer rutaTest
    Mientras(!validator.isDir(rutaTest))
        Escribir("Ingrese una ruta valida")
        leer rutaTest
    regresar cast(Path) rutaTest

4.0 (Publico) (File) capFile()
    Path ruta = capDir()
    Vector<Path> rutas = getDirs(ruta)

    printNames(ruta)
    opcion = capInt("Ingrese el numero del archivo deseado: ", 0, rutas.longitud()-1)
    Regresar Archivo archivo(Vector<opcion-1>)


//Requisitos

/*
 * iostream
 * string
 * vector 
 * regex
 * filesystem
 * fstream
 */


