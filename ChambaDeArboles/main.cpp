#include "trees.hpp"
#include <iostream>


void printNodeContent(trees::BBTNode nodo) 
{
	std::cout << nodo.getData();
}

int main() 
{
	using namespace trees;

	std::function<void(BBTNode)> print = printNodeContent;


	BBTNode nodo = BBTNode(1);
	BinaryTree tree = BinaryTree(nodo);

	//Ridicula instanciacion, pero funciona con valor 65 xd
	BBTNode nodoA = BBTNode('A');

	nodo.setLeft(nodoA);


	tree.allLeft(print);

}