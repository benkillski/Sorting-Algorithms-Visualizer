package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

//TODO: FIX
public class TreeSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        //Tree tree = new Tree();
        //tree.treeins(array);
        //tree.inorderRec(tree.root);

        treeSort(array, array.getArraySize());
    }

    private void treeSort(ArrayManager array, int n)
    {
        Tree tree = new Tree();

        tree.treeins(array);

        int i = 0;
        tree.storeSorted(tree.root, array, i);
    }

    @Override
    public String getAlgorithmName()
    {
        return "Tree";
    }

    private class Tree
    {
        Node root;

        public Tree()
        {
            root = null;
        }

        public void insert(int key)
        {
            root = insertRec(root, key);
        }

        private Node insertRec(Node root, int key)
        {
            if(root == null)
            {
                root = new Node(key);
                return root;
            }

            if (key < root.key)
                root.left = insertRec(root.left, key);
            else if (key > root.key)
                root.right = insertRec(root.right, key);

            return root;
        }

        void storeSorted(Node node, ArrayManager array, int i)
        {
            if(node != null)
            {
                storeSorted(node.left, array, i);
                array.setArrayValue(i++, node.key);
                storeSorted(node.right, array, i);
            }
        }

        void treeins(ArrayManager array)
        {
            for(int i = 0; i < array.getArraySize(); i++)
            {
                insert(array.getArrayValue(i));
            }
        }


    }

    private class Node
    {
        int key;
        Node left, right;

        public Node(int item)
        {
            key = item;
            left = right = null;
        }
    }
}
