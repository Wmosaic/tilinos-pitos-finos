#include "trees.hpp"
#include <iostream>


int main() 
{
	using namespace trees;


	BBTNode nodo = BBTNode(1);
	
	//Ridicula instanciacion, pero funciona con valor 65 xd
	BBTNode nodoA = BBTNode('A');

	nodo.setLeft(nodoA);


	std::cout << nodo.getData() << std::endl;

	std::cout << nodo.getLeft().getData();
}