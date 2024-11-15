#pragma once
#include <iostream>

namespace trees 
{

	//Blanced Binary Tree Node

	class BBTNode
	{
	private:
		int m_data;
		int m_equilibrium;
		BBTNode* m_leftNode;
		BBTNode* m_rightNode;

	public:

		BBTNode(int data) : m_data(data)
		{
			m_leftNode = m_rightNode = nullptr;
			m_equilibrium = 0;
		}

		~BBTNode() {}

		void setData(int p_data)    { m_data = p_data; }

		void setLeft(BBTNode* node)  { m_leftNode = node; }

		void setRight(BBTNode* node) { m_rightNode = node; }

		void setEquilibrium(int equilibrium) { m_equilibrium = equilibrium; }

		BBTNode* getLeft()	{ return m_leftNode;  }
		BBTNode* getRight()	{ return m_rightNode; }

		int getData() const	{ return m_data;       }
		int getEquilibrium() const { return m_equilibrium; }

		void updateEquilibriumFactor() {
			int leftHeight = calculateHeight(m_leftNode);
			int rightHeight = calculateHeight(m_rightNode);
			m_equilibrium = leftHeight - rightHeight;
		}

		int calculateHeight(BBTNode* node) {
			if (node == nullptr) return -1;
			int leftHeight = calculateHeight(node->getLeft());
			int rightHeight = calculateHeight(node->getRight());
			return 1 + std::max(leftHeight, rightHeight);
		}

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

		BBTNode* rightRotate(BBTNode* node) {
			BBTNode* left = node->getLeft();
			BBTNode* right = left->getRight();

			left->setRight(node);
			node->setLeft(right);

			node->updateEquilibriumFactor();
			left->updateEquilibriumFactor();

			return left; 
		}

		BBTNode* leftRotate(BBTNode* node) {
			BBTNode* right = node->getRight();
			BBTNode* left = right->getLeft();

			right->setLeft(node);
			node->setRight(left);

			node->updateEquilibriumFactor();
			right->updateEquilibriumFactor();

			return right; 
		}

		BBTNode* leftRightRotate(BBTNode* node) {
			node->setLeft(leftRotate(node->getLeft())); 
			return rightRotate(node); 
		}

		BBTNode* rightLeftRotate(BBTNode* node) {
			node->setRight(rightRotate(node->getRight())); 
			return leftRotate(node); 
		}

		BBTNode* balance(BBTNode* node) {
			node->updateEquilibriumFactor();

			if (node->getEquilibrium() > 1) {
				if (node->getLeft()->getEquilibrium() < 0)
					return leftRightRotate(node);
				return rightRotate(node);
			}
			else if (node->getEquilibrium() < -1) {
				if (node->getRight()->getEquilibrium() > 0)
					return rightLeftRotate(node);
				return leftRotate(node);
			}

			return node; 
		}

		BBTNode* insertNode(BBTNode* currentNode, BBTNode* newNode)
		{
			if (!currentNode)
			{
				return newNode;
			}

			int nodeValue = currentNode->getData();
			int newValue = newNode->getData();

			if (nodeValue == newValue)
				return nullptr;

			if (newValue < nodeValue)
			{
				currentNode->setLeft(insertNode(currentNode->getLeft(), newNode));
			}
			else
			{
				currentNode->setRight(insertNode(currentNode->getRight(), newNode));
			}

			currentNode->updateEquilibriumFactor();

			return balance(currentNode); 
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

		bool add(int data)
		{
			BBTNode* newNode = new BBTNode(data);

			if (!m_treeRoot)
			{
				m_treeRoot = newNode;
				return true; 
			}

			m_treeRoot = insertNode(m_treeRoot, newNode);

			return m_treeRoot != nullptr; 
		}

		bool add(BBTNode* node) { return insertNode(m_treeRoot, node); }

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