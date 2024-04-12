1.0.A (Privado) boolean isNum(cadena:String) 
	Intentar
		cadena.convertirANumero()
		regresar Verdadero
	en Exepcion regresar Falso

1.0.B (Privado) boolean isNum(cadena:String)
    String patron = "^\d+(\.\d+)?$" 		
	// Patron regex para discriminar numeros
	
	regresar buscarPatron(cadena, patron)

2.0.A (Privado) boolean isNom(cadena:String)
	//Esta es una forma para determinar los metodos tipo el lenguaje
	//Uno es como Python y otro tipo Java o C++
	Si No (esNum(cadena)) Y cadena.longitud() > 0
		regresar Verdadero
	De lo contrario regresar Falso

2.0.B (Privado) boolean isNom(cadena:String)
	String patron = "^[^\d]+$"
	// Patron regex para discriminar cadenas, si topa un numero hay false
	
	regresar buscarPatron(cadena, patron)
	
3.0.A (Privado) boolean isDate(cadena:String)
	Intentar
		cadena.TieneFormato(cadena,'dd/mm/yyyy')
		Regresar Verdadero
	en Exepcion regresar Falso

3.0.B (Privado) boolean isDate(cadena:String)
	String patron = "^\d{2}(/|-|\.|_)\d{2}(/|-|\.|_)\d{4}$"
	// Patron regex para aceptar formato de fecha separado por
	// los caracteres '/','.','-','_'

	regresar buscarPatron(cadena, patron)


4.0 (Privado) boolean isStr(cadena:String)
    Si (cadena.longitud() != 0 || cadena != null)
	    regresar Verdadero
	De lo contrario regresar Falso

//Los algoritmos de archivos, como isDir() o getFiles(), se deben de 
//Realizar individualmente para cada lenguaje, los algoritmos no 
//Incluidos se deben de realizar en un archivo.alg aparte
