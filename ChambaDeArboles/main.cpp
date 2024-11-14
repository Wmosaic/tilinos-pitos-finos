#include "trees.hpp"
#include <iostream>

void LOG(const char* msg) 
{
	std::cout << msg;
}

int main() 
{
	using namespace trees;

	BinaryTree tree = BinaryTree();

	tree.add(5);
	tree.add(3);
	tree.add(4);
	tree.add(7);
	tree.add(6);
	tree.add(1);

	std::cout << "Inorden " << std::endl;
	tree.inOrder();
	std::cout << '\n';
	std::cout << "Postorden " << std::endl;
	tree.postOrder();
	std::cout << '\n';
	std::cout << "Preorden " << std::endl;
	tree.preOrder();
	std::cout << '\n';



}