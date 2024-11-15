#include "Archivador.h"
#include "Capturador.h"
#include "Validador.h"
#include <iostream>
#include <string>

void debugPrint(std::string message, Validador* val){
    std::cout << message << std::endl;
    std::cout << "isnum\t"  << val->isNumI(message) << val->isNumD(message) << std::endl;
    std::cout << "isnom\t"  << val->isNom(message)  << std::endl;             
    std::cout << "isdate\t" << val->isDate(message) << std::endl;
    std::cout << "isStr\t"  << val->isStr(message)  << std::endl;
}


int main(){
    typedef std::string String;
    Validador*  val {new Validador()};
    Capturador* cap {new Capturador(val)};
    File*      fil {new File(cap)};

    debugPrint("Unpuente xdddd",val);
    debugPrint("32",val);
    debugPrint("3.2",val);
    debugPrint("22.10.13",val);
    debugPrint("22/10/13",val);
    debugPrint("32/10/13",val);
    debugPrint("29/02/2001",val);
    debugPrint("23/13/2022",val);
    debugPrint("23/9/-15",val);
    debugPrint("11/01/2024",val);
    debugPrint("",val);
    debugPrint(" ",val);

    int x;
    double y;
    String casa;

    x = cap->capInt("Salta linea?");                        //capint
    x = cap->capInt("Salta linea?", 1);                     //capint limite
    x = cap->capInt("Salta linea?", 0, 10);                 //capint rango


    y = cap->capReal("Real Salta linea?");                  //capreal
    y = cap->capReal("Real Salta linea?", 1);               //capreal limite
    y = cap->capReal("Real Salta linea?", 0, 10);           //capreal rango  


    casa = cap->capNom("Nom, espacios?");                   //capnom 
    casa = cap->capNom("Nom, espacios?, caracteres?",10);   //capnom limite

    casa = cap-> capDate("fecha");



    return 0;
}
