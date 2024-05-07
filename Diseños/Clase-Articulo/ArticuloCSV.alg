//Pseudocodigo Correspondiente al Ejercicio 21

1.Meta()
	Imprimir "Capturar, calcular y desplegar las descripciones y precios de una lista de n articulos"
	Imprimir "Implementando la captura de datos centinela y la lectura de archivos CSV"

2.1 CapturaManual()
	Cuenta = 0
	Articulo listaArticulo[100] = nuevo Articulo()
	
	Para Cuenta donde Cuenta es menor a 100 y Cuenta incrementa 1 en 1 Empezar:
		Imprimir "Captura la descripcion del articulo / fin: "
		leer desArticulo
		Si desArticulo.Minuscula() == "fin": Romper Ciclo
		Imprimir "Capture la unidad del articulo (kg,mts,lts): "
		leer uniArticulo
		Imprimir "Capture cuantas veces se compro el articulo: "
		leer canArticulo
		Imprimir "Capture el precio unitario del articulo: "
		leer preArticulo
		listaArticulo[Cuenta] = Articulo(desArticulo,uniArticulo,canArticulo,preArticulo)
		Cuenta++
	Finalizar Para~~
	
	Regresar Cuenta

2.2 CapturaCSV()
	Cuenta = 0
	Articulo listaArticulo[100] = nuevo Articulo()
	String lineaCSV[3]

	Imprimir "Deme la ruta de acceso de sus archivos CSV que contegan la lista del mandado: "
	leer rutaAcceso
	
	misArchivos = BuscarRutaDeAcceso(rutaAcceso)
	
	Para i que es igual a 0 Donde i es menor a misArchivos.longitud() y i incrementa 1 en 1:
		Imprimir (i+1)+"."+misArchivos[i]
	
	Imprimir "Seleccione su archivo usando su numero: "
	leer numeroArchivo
	
	Archivo = Abrir(rutaAcceso+misArchivos[numeroArchivo-1])
	Archivo.leerLinea() //Se lee el encabezado
	
	Mientras Archivo este abierto Entoces:
		lineaCSV = Archivo.leerLinea()
		descripcion = lineaCSV[0]
		unidad = lineaCSV[1]
		cantidad = lineaCSV[2]
		precio = lineaCSV[3]
		listaArticulo = Articulo(descripcion,unidad,cantidad,precio)
		Cuenta++
	Terminar Mientras~~
	
	Regresar Cuenta

3. Calculos()
	subtotal = 0
	monto[50]
	Para i = 0; i <cuenta; i++ empezar
		monto[i] = listaArticulo[i].MetodoObtenerCantidad * listaArticulo[i].MetodoObtenerPrecio()
		subtotal += monto[i]
	Finalizar
	total = subtotal + (subtotal * 0.16)

4. Salida()
	Imprimir "Cuenta de las compras"
	para i = 0; i < cuenta; i++ empezar
		Imprimir listaArticulo[i].MetodoObtenerCadena()
		Imprimir "Monto de la compra: "+monto[i]
	terminar
	Imprimir "El subtotal es: "+subtotal
	Imprimir "El total (iva %16) "+total

5. Navegabilidad()
	AFF = 'S'
	Mientras AFF == 'S' O AFF == 's' Empezar:
		meta()
		Imprimir "Seleccione una opcion (Tradicional/Fichero) :"
		leer opcion
		Segun opcion.minuscula()
			caso tradicional
				limite = Captura_Tradicional()
			caso fichero
				limite = Captura_Ficheros()
			Predeterminado
				Imprimir 'Seleccione una opcion valida'
				detener
				continuar
		calculos()
		salida()
		Imprimir "Capturar otros datos AFF: "
		leer AFF
	Terminar ~~


	
		
	
	