def capCSV(self,direc) -> None:
        rowError,cuenta = 1,0
        with open(direc,encoding='UTF-8') as csvFile: 
            csvFile.readline()
            for lines in csvFile:
                rowError += 1 
                myLis = lines.rstrip().split(',')
                for lin in myLis:   
                    if self.__isNomb(lin): cuenta += 1
                    if self.__isNume(lin): cuenta += 1
                    if self.__isDate(lin): cuenta += 1 
                if len(myLis) != cuenta:
                    print("Hay un error en la linea: "+str(rowError))
                    abort()
                cuenta = 0
        print("No hay errores en su archivo: :D")
