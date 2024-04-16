1.0.A (Privado) boolean isNum(cadena:String) 
	Intentar
		cadena.convertirANumero()
		regresar Verdadero
	en Exepcion
	    Escribir
		regresar Falso

1.0.B (Privado) boolean isNum(cadena:String)
    String patron = "^\\d+(\\.\\d+)?$" 		
	// Patron regex para discriminar numeros
	
	regresar buscarPatron(cadena, patron)

2.0.A (Privado) boolean isNom(cadena:String)
	//Esta es una forma para determinar los metodos tipo el lenguaje
	//Uno es como Python y otro tipo Java o C++
	Si No (esNum(cadena)) Y cadena.longitud() > 0
		regresar Verdadero
	De lo contrario regresar Falso

2.0.B (Privado) boolean isNom(cadena:String)
	String patron = "^[^\\d]+$"
	// Patron regex para discriminar cadenas, si topa un numero hay false
	
	regresar buscarPatron(cadena, patron)
	
3.0.A (Privado) boolean isDate(cadena:String)
	Intentar
		cadena.TieneFormato(cadena,'dd/mm/yyyy')
		Regresar Verdadero
	en Exepcion regresar Falso

3.0.B (Privado) boolean isDate(cadena:String)
	String patron = "^(0?[1-9]|[12][0-9]|3[01])(/|-|\\.|_)(0?[1-9]|1[0-2])(/|-|\\.|_)(\\d{4})$"
	// Patron regex para aceptar formato de fecha separado por
	// los caracteres '/','.','-','_'

	regresar buscarPatron(cadena, patron)

4.0 (Privado) boolean isStr(cadena:String)
    //La expresion es igual a un instanceof o isinstance
    //Aunque se iguale un objeto de tipo String a null, el objeto deja de ser instancia de string.
    //Por lo que podemos hacer un retorno de funcion temprano y reducir los niveles de 
    //Indentacion, simplificando la logica del programa

    Si cadena No (es instancia de String) Entoces
	regresar falso;
    regresar cadena.longitud() != 0;

//Los algoritmos de archivos, como isDir() o getFiles(), se deben de 
//Realizar individualmente para cada lenguaje, los algoritmos no 
//Incluidos se deben de realizar en un archivo.alg aparte
