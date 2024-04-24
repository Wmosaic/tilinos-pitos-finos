0.0 CONSTRUCTOR  Capturador()
    Validador val
    this.validator = val

0.1 CONSTRUCTOR Capturador(Validador val)
    this.validator = val

//capNumero es el algoritmo generico para capInt y capReal
//solo cambiamos los tipos de datos de retorno


1.0 (Publico) (int,double) capNumero(mensaje:String)
	imprimir mensaje
	leer variable
	
	Mientras No (esNum(variable)) Empezar
		imprimir mensaje
		leer variable
	Terminar Mientras

	regresar variable.convertidoANumero()

1.1 (Publico-Sobrecargado) (int,double) capNumero(mensaje: String, lim:int)
	imprimir mensaje
	leer variable

	Mientras No (esNum(variable)) Empezar
		imprimir mensaje
		leer variable
	Terminar Mientras

	Mientras convertirANumero(variable) <= lim Empezar 
		imprimir "El valor debe ser mayor a " + lim
		leer variable
	Terminar Mientras

	regresar variable.convertidoANumero()

1.2 (Publico-Sobrecargado) (int,double) capNumero(mensaje: String, limI:int, limS:int)
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

2.0 (Publico) (String) capNom(mensaje:String)
	imprimir mensaje
	leer variable

	Mientras No (esNom(variable)) Empezar
		imprimir mensaje
		leer variable
	Terminar Mientras

	regresar variable

2.1 (Publico-Sobrecargado) (String) capNom(mensaje:String, limC: int)
	/* 
	* Esto es una porqueria pero en caso de que un programador chistoso ponga un entero negativo
    * Abra un ciclo infinito por naturaleza del isNom(), entoces si detecta un negativo lo hace Positivo
    * Esto se podria lanzar con RisesError quiza para solucionar problemas.
	* Se proponen una solucion super rapida pero creo que hay una mejor solucion
    */    
	Si limChar < 0: limC = limC*-1 
    Si limChar == 0: limC = limC+1
	imprimir mensaje
	leer variable

	Mientras No (esNom(variable)) O NO(variable.longitud() <= limC) Empezar
		imprimir mensaje
		leer variable
	Terminar Mientras

	regresar variable


3.0 (Publico) (String) capFech(mensaje:string)
	imprimir mensaje
	leer variable

	Mientras No(esFecha(variable)) Empezar
		imprimir mensaje
		leer variable
	
	Regresar variable

//Los algoritmos de archivos, como isDir() o getFiles(), se deben de 
//Realizar individualmente para cada lenguaje, los algoritmos no 
//Incluidos se deben de realizar en un archivo.alg aparte
