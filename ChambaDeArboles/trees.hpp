#pragma once
#include <iostream>

namespace trees 
{
	//Blanced Binary Tree Node

	class BBTNode
	{
	private:
		int m_data;
		BBTNode* m_leftNode;
		BBTNode* m_rightNode;
		BBTNode* m_rootNode;

	public:

		//Params: Initialize the value of the node with the constructor parameter.
		//every node is set to null
		BBTNode(int data) : m_data(data) 
		{
			m_leftNode = m_rightNode = m_rootNode = nullptr;
			m_data = data;
		}

		BBTNode(int data, BBTNode rootNode) : m_data(data), m_rootNode(&rootNode)
		{
			m_leftNode = m_rightNode = nullptr;
		}

		//Default destructor
		~BBTNode() { }

		//Sets the given data as that node's data
		void setData(int p_data)    { m_data = p_data; }

		//Sets the given node as the left node
		void setLeft(BBTNode node)  { m_leftNode = &node; }

		//Sets the given node as the right node
		void setRight(BBTNode node) { m_rightNode = &node; }

		//Sets the given node as the root node
		void setRoot(BBTNode node)  { m_rootNode = &node; }
		
		BBTNode getLeft()	{ return *m_leftNode;  }
		BBTNode getRight()	{ return *m_rightNode; }
		BBTNode getRoot()	{ return *m_rootNode;  }
		int getData()		{ return m_data;       }

		void disconnect() 
		{
			m_leftNode = m_rightNode = m_rootNode = nullptr;
		}

	};

	class BinaryTree
	{
	private:
		int m_nodeCount;
		BBTNode* m_treeRoot;

	private:

		bool insertNode(BBTNode currentNode, int data) 
		{
			if (data == currentNode.getData())
				return false;

			if (data < currentNode.getData())
			{
				if (&currentNode.getLeft()) 
					return insertNode(currentNode.getLeft(), data);
				else
					currentNode.setLeft(BBTNode(data, currentNode));
			}
			else
			{
				if (&currentNode.getRight())
					return insertNode(currentNode.getRight(), data);
				else
					currentNode.setRight(BBTNode(data, currentNode));
			}
			return true;
		}

	public:
		bool add(int data) { return insertNode(*m_treeRoot, data); }
		bool add(BBTNode node) { return insertNode(*m_treeRoot, node.getData()); }

		bool postOrder();
		bool preOrder();
		bool inOrder();

	};

};