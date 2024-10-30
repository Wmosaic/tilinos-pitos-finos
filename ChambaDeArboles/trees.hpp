#pragma once
#include <iostream>
#include <functional>

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
		int getData() const	{ return m_data;       }

		void disconnect() 
		{
			m_leftNode = m_rightNode = m_rootNode = nullptr;
		}

		BBTNode* ptr() { return this; }

	};

	class BinaryTree
	{
	private:
		int m_nodeCount;
		BBTNode* m_treeRoot;

	private:

		bool insertNode(BBTNode currentNode, const BBTNode& insertingNode)
		{
			if (insertingNode.getData() == currentNode.getData())
				return false;

			if (insertingNode.getData() < currentNode.getData())
			{
				if (currentNode.getLeft().ptr())
					return insertNode(currentNode.getLeft(), insertingNode);
				else
					currentNode.setLeft(insertingNode);
			}
			else
			{
				if (currentNode.getRight().ptr())
					return insertNode(currentNode.getRight(), insertingNode.getData());
				else
					currentNode.setRight(insertingNode);
			}
			return true;
		}


	public:

		BinaryTree(BBTNode root) : m_treeRoot(&root) 
		{
			m_nodeCount = 1;
		}

		bool add(int data) { return insertNode(*m_treeRoot, BBTNode(data)); }
		bool add(BBTNode node) { return insertNode(*m_treeRoot, node.getData()); }

		template<typename value_type>
		void allLeft(std::function<value_type> function) 
		{
			BBTNode* currentNode = this->m_treeRoot;

			do
			{
				function(currentNode->getData());
				currentNode = currentNode->getLeft().ptr();
			} while (currentNode->getLeft().ptr());

		}


		bool postOrder();
		bool preOrder();
		bool inOrder();

	};

};