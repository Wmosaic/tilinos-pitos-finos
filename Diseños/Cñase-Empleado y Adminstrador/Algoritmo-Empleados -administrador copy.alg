Algoritmo Empleados y administradores

1.- Meta: Para Elaborar un programa que le permita capturar empleados, 
          especificando su nombre, salario y fecha de nacimiento; si el 
          empleado es un administrador capture el departamento y su bono. 
          Totalice la nomina de los empleados separando los subtotales de 
          bonos y salario  y reporte la lista de ellos con sus datos.

2.- Datos(): Arreglo a usar: Nomina[10] de Empleado
      Centinela = “fin”; 
      indice=0;
      Escribir(“Que tipo de Empleado es: N.-ormal, A.-dministrador o fin  ”), 
      tipo=?
      Mientras (tipo != Centinela and indice &lt; 10) 
          Empezará
              Escribir(“Déme el nombre:”) , nombre=?
              Escribir(“Déme el salario:”), salario=?
              Escribir(“fecha de nacimiento con formato (ddmmaa):”), nacimiento=?
              Si (tipo == "Administrador") 
                    Empezar
                           Escribir(“Déme departamento:”), depto=?
                           Escribir(“Déme el bono :”), bono=?
                            Nomina[indice] = nuevo Administrador(nombre, salario, 
                                                                      nacimiento, depto, bono);
                   Terminar
            Si (tipo=="normal")
                 Nomina[indice] = nuevo Empleado(nombre, salario, nacimiento);
            indice=indice+1
            Escribir(“Que tipo de empleado es: para salir de \”fin), tipo=?
      terminar
 
3.- Calculos: totalizar la nómina de los empleados.
    totaliza = 0;
    suma = 0;
    bono = 0;
    Lazo contado desde i = 0 hasta i = indice-1 para empezar
       suma = suma + nomina[i].salario
       si (nomina [i] es un administrador) 
         bono = bono + nomina[i].bono;
    terminar
    totaliza = totaliza + bono + suma;
       
4.- Reportar:
      Escribir:” listado de Empleados”;
      Escribir:" Nombre           Salario           depto.      bono"
      Escribir:"_____________________________________________________"
      Establecer un lazo contado desde i=0 hasta i=indice-1 Para empezar 
          escribir(nomina[i].nombre+" "+ nomina[i].salario + " ")
          Si (nomina[i] es un administrador)
             escribir (nomina[i].depto+ " "+ nomina[i].bono)               
	     escribir("\n")
      Terminar                               
      Escribir("________________________________________________);    
      Escribir("Total salarios:"+suma);      // considerar la suma de salarios
      Escribir("Total bonos: " + bono);
      Escribir("Total nomina:" + totaliza);

5.-  terminar  automáticamente (sin condición de paro)

