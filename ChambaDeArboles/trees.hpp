#pragma once
#include <iostream>
#include <functional>
#include <iostream>



//Verdaderisimo sadpapu, toca hacerlo dinamicamente probablemente


namespace trees 
{

	//Blanced Binary Tree Node

	class BBTNode
	{
	private:
		int m_data;
		BBTNode* m_leftNode;
		BBTNode* m_rightNode;

	public:

		//Params: Initialize the value of the node with the constructor parameter.
		//every node connecting is set to null
		BBTNode(int data) : m_data(data)
		{
			m_leftNode = m_rightNode = nullptr;
		}

		//Default destructor
		~BBTNode() {}

		//Sets the given data as that node's data
		void setData(int p_data)    { m_data = p_data; }

		//Sets the given node as the left node
		void setLeft(BBTNode* node)  { m_leftNode = node; }

		//Sets the given node as the right node
		void setRight(BBTNode* node) { m_rightNode = node; }
		
		BBTNode* getLeft()	{ return m_leftNode;  }
		BBTNode* getRight()	{ return m_rightNode; }

		int getData() const	{ return m_data;       }

		void disconnect() 
		{
			m_leftNode = m_rightNode = nullptr;
		}

	};

	class BinaryTree
	{
	private:
		BBTNode* m_treeRoot;

	private:

		bool insertNode(BBTNode* currentNode, int data) 
		{
			return insertNode(currentNode, new BBTNode(data));
		}

		bool insertNode(BBTNode* currentNode, BBTNode* newNode) 
		{
			if (!currentNode) 
			{
				m_treeRoot = newNode;
				return true;
			}

			int nodeValue = currentNode->getData();
			int newValue = newNode->getData();


			if (nodeValue == newValue)
				return false;

			if (newValue < nodeValue)
			{
				if (!currentNode->getLeft()) 
				{
					currentNode->setLeft(newNode); 
					return true;
				}
				else
				{
					return insertNode(currentNode->getLeft(), newNode);
				}
			}
			else
			{
				if (!currentNode->getRight())
				{
					currentNode->setRight(newNode);
					return true;
				}
				else
				{
					return insertNode(currentNode->getRight(), newNode);
				}
			}
		}


	public:

		BinaryTree(BBTNode* root) 
		{
			m_treeRoot = root;
		}

		BinaryTree()
		{
			m_treeRoot = nullptr;
		}

		bool add(int data) { return insertNode(m_treeRoot, new BBTNode(data)); }
		bool add(BBTNode* node) { return insertNode(m_treeRoot, node); }

		//Triste, pero va a tocar dehacerse de las funciones complejas que queriamos
		//puesto que no disponemos de tiempo suficiente como para implementar bien
		void preOrder(BBTNode* currentNode)
		{
			if (currentNode) 
			{
				std::cout << currentNode->getData() << ' ';
				preOrder(currentNode->getLeft());
				preOrder(currentNode->getRight());
			}
		}

		void postOrder(BBTNode* currentNode) 
		{
			if (currentNode)
			{
				postOrder(currentNode->getLeft());
				postOrder(currentNode->getRight());
				std::cout << currentNode->getData() << ' ';
			}
		}

		void inOrder(BBTNode* currentNode) 
		{
			if (currentNode)
			{
				inOrder(currentNode->getLeft());
				std::cout << currentNode->getData() << ' ';
				inOrder(currentNode->getRight());
			}
		}

		void preOrder()  { preOrder (m_treeRoot); }
		void postOrder() { postOrder(m_treeRoot); }
		void inOrder()   { inOrder  (m_treeRoot); }

	};

};