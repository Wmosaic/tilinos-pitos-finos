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

1.1.A (Publico-Sobrecargado) (int,double) capNumero(mensaje: String, lim:int)
	aux = ""
    num = ?
	Empezar a hacer
	    Mientras No(esNum(aux))
		    imprimir mensaje
		    leer aux
		num = aux.convertidoANumero()
	Mientras (num >= lim)

	regresar variable.convertidoANumero()

1.1.B (Publico-Sobrecargado) (int, double) capNumero(mensaje:String, lim:int)
    aux = ?
	Empezar a hacer
		aux = capNumero(mensaje)
	Mientras (aux >= lim)
	Regresar aux;

1.2.A (Publico-Sobrecargado) (int,double) capNumero(mensaje: String, limI:int, limS:int)
	aux = ""
    num = ?
	Empezar a hacer
	    Mientras No(esNum(aux))
		    imprimir mensaje
		    leer aux
		num = aux.convertidoANumero()
	Mientras (limS <= num <= limI)
	
	regresar variable.convertidoANumero()

1.2.B (Publico-Sobrecargado) (int,double) capNumero(mensaje: String, limI:int, limS:int)
    aux = ?
	Empezar a hacer
		aux = capNumero(mensaje)
	Mientras (limS <=aux >= limI)
	Regresar aux;

2.0 (Publico) (String) capNom(mensaje:String)
	imprimir mensaje
	leer variable

	Mientras No (esNom(variable)) Empezar
		imprimir mensaje
		leer variable
	Terminar Mientras

	regresar variable

2.1 (Publico-Sobrecargado) (String) capNom(mensaje:String, limC: int)
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
