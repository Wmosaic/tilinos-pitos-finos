/* Hace falta que los metodos sean privados??
 * aunque si, es una buena practica para el encapsulamiento
 * habra ocasiones donde no necesitemos un capInt o un capCSV
 * pero habra otras donde necesitaremos validar datos, sobre 
 * todo porque a mas gente manejando codigo, mayor es la prob
 * de que alguien no lea la documentacion del codigo, y quiera
 * pasar datos de un tipo donde no corresponde. Aunque si te
 * parece apropiado mantener esos metodos en private, lo respeto
 * y puedo reflejar esos cambios en los validadores de c++
 */


1.0.A (Privado) boolean esNum(cadena:String) 
	Intentar
		cadena.convertirANumero()
		regresar Verdadero
	en Exepcion regresar Falso

1.0.B (Publico) boolean esNum(cadena:String)
    String patron = "^\d+(\.\d+)?$" 		
	// Patron regex para discriminar numeros
	
	regresar buscarPatron(cadena, patron)

2.0.A (Privado) boolean esNom(cadena:String)
	//Esta es una forma para determinar los metodos tipo el lenguaje
	//Uno es como Python y otro tipo Java o C++
	Si No (esNum(cadena)) Y cadena.longitud() > 0
		regresar Verdadero
	De lo contrario regresar Falso

2.0.B (Publico) boolean esNom(cadena:String)
	String patron = "^[^\d]+$"
	// Patron regex para discriminar cadenas, si topa un numero hay false
	
	regresar buscarPatron(cadena, patron)
	
3.0.A (Privado) boolean esFecha(cadena:String)
	Intentar
		cadena.TieneFormato(cadena,'dd/mm/yyyy')
		Regresar Verdadero
	en Exepcion regresar Falso

3.0 (Publico) boolean esFecha(cadena:String)
	String patron = "^\d{2}(/|-|\.|_)\d{2}(/|-|\.|_)\d{4}$"
	// Patron regex para aceptar formato de fecha separado por
	// los caracteres '/','.','-','_'

	regresar buscarPatron(cadena, patron)


4.0 (Publico) boolean cadVal(cadena:String)
    Si (cadena.longitud() != 0 || cadena != null)
	    regresar Verdadero
	De lo contrario regresar Falso

5.0 (Publico) String invertirCadena(cadena:String) 
    String aux = ""
	Para i = (cadena.longitud() - 1); hasta i == 0; con paso -1 Empezar
	    aux += cadena[i]
	regresar aux	 


6.0 (Publico) boolean esDir(directorioDePrueba:String)				
	Si directorioDePrueba.esDirectorio() Y directorioDePrueba.existe()
	    regresar Verdadero
	De lo contrario regresar Falso

7.0 (Publico) void printDirs(directorio:String)
    Si esDir(directorio)
        para auto arch en directorio.iteradorDeDirectorios() Empezar
		    imprimir arch.getNombre + \n
	De lo contrario imprimir "Directorio no existente."

