//Psudos Sobre los validadores
//Verifica las sintaxisi para cada metodo a ver si esta perron asi como lo hicimos

//Cada parametro de un metodo sirve para 
//identificar el tipo de dato del parametro o de la variable en cuestion 

1.(Privado) boolean esNum(cadena:String) 
	Intentar
		cadena.convertirANumero()
		regresar Verdadero
	Exepcion
		regresar Falso

2.(Privado) boolean esNom(cadena:String)
	//Esta es una forma para determinar los metodos tipo el lenguaje
	//Uno es como Python y otro tipo Java o C++
	Si No (esNum(cadena)) Y cadena.longitud() > 0
		regresar Verdadero
	De lo contrario
		regresar Falso
	
3.(Privado) boolean esFecha(cadena:String)
	Intentar
		cadena.TieneFormato(cadena,'dd/mm/yyyy')
		Regresar Verdadero
	Exepcion
		Regresar Falso

4.(Publico) (int,double) capNumero(mensaje:String)
	//La variable texto tiene como funcion mandar un 
	//mensaje a pantalla de lo que se solicita
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

4.2(Publico-Sobrecargado) (int,double)capNumero(mensaje: String, limI:int, limS:int)
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

5.(Publico) (String)capCade(mensaje:String)
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
	De lo contrario
	    regresar Falso

7.(Publico) String invertirCadena(cadena:String) 
    String aux = ""
	Para i = (cadena.longitud() - 1); hasta i == 0; con paso -1 Empezar
	    aux += cadena[i]
	Terminar Para
	regresar aux	 

8.(Privado) Archivo getDirs(directorio:String)
    Archivo ruta = nuevo Archivo(directorio)     //Referencia al tipo de dato Archivo 
	Si (ruta.existe() Y ruta.esDirectorio()) //Funciones de biblioteca C++ y Java
	    Archivo[] archivos = nuevo Archivo()
		regresar archivos
	De lo contrario
	    imprimir "Directorio no existente."
	
/* 
 * Como tema aparte, la manera de manejar archivos y mostrar directorios es 
 * muy diferente entre los distintos lenguajes de programacion, lo que da la
 * necesidad de generar multiples algoritmos para distintos lenguajes,
 * hara falta discutir como se va a proceder con estas funciones particulares,
 * sin embargo, esta estructura se repite en C++ y en Java, asi que he creado
 * este algoritmo por el momento.
 */

    Si (getDirs(directorio) es instancia de Archivo)  // Esta linea hace referencia al
        Para cada Archivo arch en archivos Empezar  //tipo de dato Archivo ya existente
		    imprimir arch
		Terminar Para

8.(Publico) String invertirCadena(cadena:String) 
	Para i = (cadena.longitud() - 1); hasta i == 0; con paso -1 Empezar
	Terminar Para
	regresar aux	 
