//Pseudocodigo Correspondiente al Ejercicio 23

1.Meta()
	Imprimir "Capturar y desplegar una lista de monedas"
  	Imprimir "Presentes dentro de un monedero totalizando"
   	Imprimir "las monedas presentes dentro de cada divisas"
	Imprimir "Por captura de datos Centinelas o CSV E INCLUYE LECTURA"

2.1 CapturaManual()
	Cuenta = 0
	Moneda listaMoneda[100] = nuevo Moneda()
	(int) RepeticionMoneda[100] = {}
	
	Para Cuenta donde Cuenta es menor a 100 y Cuenta incrementa 1 en 1 Empezar:
		Imprimir "Captura el nombre de la divisa / fin: "
		leer nomDivisa
		Si nomDivisa.Minuscula() == "fin": Romper Ciclo
		Imprimir "Capture el valor de la moneda: "
		leer valMoneda
		Imprimir "Capture el nombre del escudo: "
		leer nomEscudo
		Imprimir "Capture el año de la Moneda: "
		leer añoMoneda
		Imprimir "Capture el pais de la moneda: "
		leer nomPais
		Imprimir "Cuantas monedas del mismo valor: "
		leer repeticionMoneda
		listaMoneda[Cuenta] = Moneda(nomDivisa,valMoneda,
								nomEscudo,añoMoneda,nomPais)
		RepeticionMoneda[Cuenta] = repeticionMoneda
		Cuenta++
	Finalizar Para~~
	
	Regresar Cuenta

2.2 CapturaCSV()
	Cuenta = 0
	Moneda listaMoneda[100] = nuevo Moneda()
	(int) RepeticionMoneda[100] = {}
	String lineaCSV[5]

	Imprimir "Deme la ruta de acceso de sus archivos CSV que contegan la lista de las monedas: "
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
		nomDivisa = lineaCSV[0]
		valMoneda = lineaCSV[1]
		nomEscudo = lineaCSV[2]
		añoMoneda = lineaCSV[3]
		nomPais = lineaCSV[4]
		repetecionMoneda[Cuenta] = lineaCSV[5]
		listaMoneda[Cuenta] = Moneda(nomDivisa,valMoneda,
								nomEscudo,añoMoneda,nomPais)
		Cuenta++
	Terminar Mientras~~
	
	Regresar Cuenta

3.1 setDivisas()
	String DivisasFiltradas[50]
	cuentaDivisaFiltrada = 0
	
	Para i = 0; i < Cuenta; i++Empezar
	    esRepetido = Falso
		Para j=0 j < cuentaDivisaFiltrada; j++ Empezar
			Si listaMoneda[i].ObtenerDivisa() == DivisasFiltradas[j] Entoces
				esRepetido = Verdadero
				Salir del Ciclo
			Terminar Si
		Si(NOT(esRepetido)) Entoces
		    DivisasFiltradas[ceuntaDivisaFiltrada] = listMoneda[i].getDivisa()
			cuentaDivisaFiltrada++
        Terminar Si
		Terminar Para 
	Terminar Para 
				 
3.2 Calculos()
   String newDivisas[] = setDivisas()
   (float) cuenta_val[50]
   (float) subtotal[50]

   Para j = 0; j < cuentaDivisaFiltrada; j++ empezar
      dineros = 0
      Para i = 0; i < cuenta; i ++
         Si newDivisas[j] == listaMoneda[i].MetodoObtenerDivisa()
            dinero += repetecionMoneda[i] * listaMoneda[i].MetodoObtenerValor()
      cuenta_val[j] = dinero //El monto totoal de cada Divisa
   Terminar
   
   Para k = 0;k < cuenta; k++ empezar
	subtotal[k] = repetecionMoneda[i] * listaMoneda[i].MetodoObtenerValor() 

4.1 generarCarpeta() //Opcional
	Imprimir "Deme el nombre del archivo: "
	leer nombreArchivo
	Imprimir "Ya tiene Carpeta para su Archivo [S/N]: "
	leer opc

	Si opc == "S" entonces
		Imprimir "Capture el directorio de la carpeta "
		leer rutaCarpeta
	De lo contrario
		Imprimir "Deme el nombre de la carpeta para generar una: "
		leer rutaCarpeta
		objPath = Path(rutaCarpeta)
		objPath.crearCarpeta()

	Regresar Path(rutaCarpeta+nombreArchivo)

4.2 escrituraArchivo()
	miRuta = generarCarpeta()
	archivo = Abrir(miRuta,Modo: Escritura)
	
	Para i = 0; i < Cuenta; i++ empezar
		archivo.escribir(listaMoneda[i].ObtenerCadena()+" ")
		archivo.escribir(subtotal[i]+"\n")
	Terminar

	Para j = 0; j<CuentaDivisaFiltrada;j++ Empezar
		archivo.escribir("La divisa: "+newDivisa[j]+" tiene: "+cuenta_val[j])
	Terminar 

	archivo.Cerrar()

4.3 escrituraData()
		Imprimir "Ponle el nombre a tu archivo: "
		leer nombreArchivo

		fileOut = Abrir(nombreArchivo,modo: "Escritura")
		fileOut.Escribir("Nombre,Valor,Escudo,Año,Pais,Repeticion")
		lim = listaMoneda.longitud
		
		Para i = 0; i < lim; i++ empezar
			NomDivisa = listaMoneda[i].getDivisa()
			valMoneda = listaMoneda[i].getValor()
			nomEscudo = listaMoneda[i].getEscudo()
			añoMoneda = listaMoneda[i].getAño()
			nomPais   = listaMoneda[i].getPais()
			repetecion = repetecionMoneda[i]
			linea = nomDivisa+','+ValMoneda','+nomEscudo+','+añoMoneda+','+nomPais+','+repetecion

			fileOut.Escribir(linea)
		Terminar
		fileOut.cerrar()

4.4 Salida()
	String newDivisas[] = setDivisas()
	Imprimir "Su monedero: "
	Para i = 0; i < Cuenta; i++ Empezar
		Imprimir listaMoneda[i].MetodoObtenerCadena()
		Imprimir "El subtotal: "+subtotal[i]
		Imprimir "-------------------"
	Terminar ~~
	
	Para j = 0; j < cuentaDivisaFiltrada; j++ Empezar
		Imprimir "La divisa: "+newDivisa[j]+" tiene: "+cuenta_val[j]
	Terminar ~~

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
		
		Imprimir "Desea guardar los datos en Pantalla: "
		leer opcArchivo

		Si (opcArchivo == 'S') escrituraArchivo() 
		
		Imprimir "Desea guardar los datos capturados: "
			leer opcArchivo
		
		si (opcArchivo == 'S') escrituraData()
		
		Imprimir "Capturar otros datos AFF: "
		leer AFF
	Terminar ~~
