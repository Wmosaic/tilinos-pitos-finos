
1.(Privado) boolean esNum(cadena:String) 
	Intentar
		cadena.convertirANumero()
		regresar Verdadero
	en Exepcion regresar Falso

2.(Privado) boolean esNom(cadena:String)
	//Esta es una forma para determinar los metodos tipo el lenguaje
	//Uno es como Python y otro tipo Java o C++
	Si No (esNum(cadena)) Y cadena.longitud() > 0
		regresar Verdadero
	De lo contrario regresar Falso
	
3.(Privado) boolean esFecha(cadena:String)
	Intentar
		cadena.TieneFormato(cadena,'dd/mm/yyyy')
		Regresar Verdadero
	en Exepcion regresar Falso

4.(Publico) (int,double) capNumero(mensaje:String)
	imprimir mensaje
	leer variable
	
	Mientras No (esNum(variable)) Empezar
		imprimir mensaje
		leer variable
	Terminar Mientras

	regresar variable.convertidoANumero()

4.1(Publico-Sobrecargado) (int,double) capNumero(mensaje: String, lim:int)
	imprimir mensaje
	leer variable

	Mientras No (esNum(variable)) Empezar
		imprimir mensaje
		leer variable
	Terminar Mientras

//En automatico al salir del primer mientras se sabe que es un numero
//Y puede ser comparado con los operadores racionales

	Mientras convertirANumero(variable) <= lim Empezar 
		imprimir "El valor debe ser mayor a " + lim
		leer variable
	Terminar Mientras

	regresar variable.convertidoANumero()

4.2(Publico-Sobrecargado) (int,double) capNumero(mensaje: String, limI:int, limS:int)
	imprimir mensaje
	leer variable

	Mientras No (esNum(variable)) Empezar
		imprimir mensaje
		leer variable
	Terminar Mientras

	//En automatico al salir del primer mientras se sabe que es un numero
	//Y puede ser comparado con los operadores racionales

	Mientras No (limI <= convertirANumero(variable) <= limS) Empezar 
		imprimir "Deber estar entre " + limI + " y " + limS
		leer variable
	Terminar Mientras

	regresar variable.convertidoANumero()

5.(Publico) (String) capNom(mensaje:String)
	imprimir mensaje
	leer variable

	Mientras No (esNom(variable)) Empezar
		imprimir mensaje
		leer variable
	Terminar Mientras

	regresar variable

5.1(Publico-Sobrecargado) (String) capCade(mensaje:String, limC: int)
	imprimir mensaje
	leer variable

	Mientras No (esNom(variable)) O NO(variable.longitud() <= limC) Empezar
		imprimir mensaje
		leer variable
	Terminar Mientras

	regresar variable

6.(Publico) boolean cadVal(cadena:String)
    Si (cadena.longitud() != 0 Y cadena != null)
	    regresar Verdadero
	De lo contrario regresar Falso

7.(Publico) String invertirCadena(cadena:String) 
    String aux = ""
	Para i = (cadena.longitud() - 1); hasta i == 0; con paso -1 Empezar
	    aux += cadena[i]
	regresar aux	 

/*
 * Extrema discrepancia entre los tipos de manejo de archivo entre cada
 * lenguaje distinto, entre c++ python y java son 3 maneras distintas
 * de manejar archivos, ninguno se asemeja a los demas, para facilidad
 * del desarrollo del primer validador en c++, aqui se incluyen los 
 * pseudocodigos para hacerlo en c++, sin embargo se deben de desarrollar
 * otros 2 mas para los demas lenguajes.
 */


8.0 (Publico) boolean esDir(directorioDePrueba:String)				
	Si directorioDePrueba.esDirectorio() Y directorioDePrueba.existe()
	    regresar Verdadero
	De lo contrario regresar Falso

9.0 (Publico) void printDirs(directorio:String)
    Si esDir(directorio)
        para auto arch en directorio.iteradorDeDirectorios() Empezar
		    imprimir arch.getNombre + \n
	De lo contrario imprimir "Directorio no existente."

10.(Publico) (String) capFech(mensaje:string)
	imprimir mensaje
	leer variable

	Mientras No(esFecha(variable)) Empezar
		imprimir mensaje
		leer variable
	
	Regresar variable
/*
 * El capCSV tiene como funcion verificar que todos los datos de una fila
 * tengan el formato adecuado, es decir, que no haya un "mat3o", un numero
 * mal capturado o una fecha con el formato incorrecto, iterando un contador
 * que al final de la del ciclo verifica si la longitud del arreglo/lista
 * son iguales, en ese caso todo esta bien de lo contrario hubo un elemento
 * que no paso el formato entoces hay un dato invalido.
 */

11.(Publico) (boolean) capCSV(eleFila: arreglo/lista)
	items[50]
	cuenta = 0

	Para i=0; i < eleFila.longitud; i++
		Si esNom(eleFila[i])
			cuenta++
		Si esNum(eleFila[i])
			cuenta++
		Si esFecha(eleFila[i])
			cuenta++
	
	Si cuenta == eleFila.longitud() 
		regresar Verdadero
	De lo contrario regresar Falso

// Me agrada la idea del cap CSV , pero quiza sea mejor idea hacerlo como:
// Trabajo en proceso, son las 00:45, me piro

11.1(Publico) (boolean) capCSV(csv:Archivo)
    para String fila en csv Empezar
	    Si fila.buscarPatron(((.+),)+) == Falso // Asegura la estructura de un 
		    imprimir "CSV Invalido."			// CSV usando regexpr's
			regresar Falso
		De lo contrario
		    	