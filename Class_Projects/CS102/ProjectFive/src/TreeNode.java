/*
    Caspian Peavyhouse - peav2414@kettering.edu
    CS-102, Fall 2015
    Programming Assignment 4
    TreeNode Class: Class that defines my custom binary search tree
*/

import sun.reflect.generics.tree.Tree;

import java.util.*;
public class TreeNode
{
    private String myString;//The data stored in the node
    //word or synonym
    private TreeNode leftBranch;//node on the let side of the tree
    private TreeNode rightBranch;//node on the right side of the tree
    private TreeNode synonymTree;//Node of the root synonym for this entry
    private boolean isEntry;// lets my toString know if I'm dealing with an entry
    //not used in the synonym tree

    final boolean ENTRY = true;
    final boolean SYNONYM = false;


    /*
    Method: TreeNode
    Purpose: setter
    Parameters:
        Boolean isEntry - is this an entry
    Returns:
        TreeNode
    */
    public TreeNode(boolean isEntry)
    {
        myString = null;
        leftBranch = null;
        rightBranch = null;
        synonymTree = null;
        this.isEntry = isEntry;
        //set as input to make all TreeNodes must have isEntryDefined
    }


    /*
    Method: getMyString
    Purpose: getter
    Returns:
        myString
    */
    public String getMyString()
    {
        return myString;
    }

    /*
    Method: setMyString
    Purpose: setter
    Parameters:
        MyString
    */
    public void setMyString(String myString)
    {
        this.myString = myString;
    }

    /*
    Method: getLeftBranch
    Purpose: getter
    Returns:
        LeftBranch
    */
    public TreeNode getLeftBranch()
    {
        return leftBranch;
    }

    /*
    Method: setLeftBranch
    Purpose: setter
    Parameters:
        leftBranch
    */
    public void setLeftBranch(TreeNode leftBranch)
    {
        this.leftBranch = leftBranch;
    }

    /*
    Method: getrightBranch
    Purpose: getter
    Returns:
        RightBranch
    */
    public TreeNode getRightBranch()
    {
        return rightBranch;
    }

    /*
    Method: setRight Branch
    Purpose: setter
    Parameters:
        leftBranch
    */
    public void setRightBranch(TreeNode rightBranch)
    {
        this.rightBranch = rightBranch;
    }

    /*
    Method: getSynonymTree
    Purpose: getter
    Returns:
        SynonymTree
    */
    public TreeNode getSynonymTree()
    {
        return synonymTree;
    }

    /*
    Method: isEntry
    Purpose: is this an entry?
    Parameters:
    isEntry - boolean
    Returns:
        boolean - is it?
    */
    public boolean isEntry()
    {
        return isEntry;
    }

    /*
    Method: containsSynoym
    Purpose: searches for a synonym in SynTree
    Parameters:
    String findMe Synonym to be found
    Returns:
        boolean - did I do it?
    */
    public boolean containsSynonym(String findMe)
    {
        return (TreeNode.containsString(findMe, synonymTree));
    }

    /*
    Method: containsString
    Purpose: basic search function
    Parameters:
    String findMe - String to be found
    TreeNode currentNoe - current node in the tree
    Returns:
        boolean - did I do it?
    */
    public static boolean containsString(String findMe, TreeNode currentNode)
    {
        if (findMe == null || findMe.equals("") || currentNode == null)
        {
            //did not find it
            //end of list, empty list, or invalid string
            return false;
        }
        if (currentNode.getMyString().equalsIgnoreCase(findMe))
        {
            //found it
            return true;
        }
        if (currentNode.getMyString().compareToIgnoreCase(findMe) < 0)
        {
            //if current goes before findMe, go down right
            return(containsString(findMe, currentNode.getRightBranch()));
        }
        else
        {
            //if current goes after findMe, go doewn left
            return(containsString(findMe, currentNode.getLeftBranch()));
        }
    }

    /*
    Method: getNodeByString
    Purpose: gets a node by its string value
    Parameters:
    String findMe- the string to be foud
    TreeNode currentNode - current node in the tree
    Returns:
        TreeNode - whatI found
    */
    public static TreeNode getNodeByString(String findMe, TreeNode currentNode)
    {
        if (findMe == null || findMe.equals("") || currentNode == null)
        {
            //did not find it
            //end of list, empty list, or invalid string
            throw new NoSuchElementException();
        }
        if (currentNode.getMyString().equalsIgnoreCase(findMe))
        {
            return currentNode;
        }
        if (currentNode.getMyString().compareToIgnoreCase(findMe) < 0)
        {
            //if current goes before findMe, go down right
            return(getNodeByString(findMe, currentNode.getRightBranch()));
        }
        else
        {
            //if current goes after findMe, go down left
            return(getNodeByString(findMe, currentNode.getLeftBranch()));
        }
    }

    /*
    Method: addSynonymInOrder
    Purpose: adds a synonym to the syn tree
    Parameters:
    String newSynonm
    Returns:
        boolean - did I do it?
    */
    public boolean addSynonymInOrder(String newSynonym)
    {
        //in scope, this. is an entry node adding a new syn to synTree
        if (newSynonym == null || newSynonym.equals(""))
        {
            return false;
        }
        if (this.containsSynonym(newSynonym))
        {
            return false;
        }
        TreeNode newSynNode =  new TreeNode(SYNONYM);//it is not an entry
        newSynNode.setMyString(newSynonym);
        synonymTree = addTreeNodeInOrder(newSynNode, synonymTree);
        return (true);
    }


    /*
    Method: addTreeNodeInOrder
    Purpose: adds a node to a tree in alphabet order
    Parameters:
    TreeNode newLeaf - node being added
    TreeNode currentTree - tree being added to

    Returns:
        boolean - did I do it?
    */
    public static TreeNode addTreeNodeInOrder(TreeNode newLeaf, TreeNode currentTree)
    {
        if (currentTree == null)
        {
            return (newLeaf);
        }
        String newString = newLeaf.getMyString();
        if (currentTree.getMyString().compareToIgnoreCase(newString) > 0)
        {
            currentTree.setLeftBranch(addTreeNodeInOrder(newLeaf, currentTree.getLeftBranch()));
        }
        else
        {
            currentTree.setRightBranch(addTreeNodeInOrder(newLeaf, currentTree.getRightBranch()));
        }
        return currentTree;
    }

    /*
    Method: removeSynonym
    Purpose: non static method to remove a synonym node
    Parameters:
    String synToRemove - the string of what I want to remove
    Returns:
        boolean - did I do it?
    */
    public boolean removeSynonym(String synToRemove)
    {
        if (!this.isEntry())
        {
            //if its not an entry, there is no synonym tree
            throw new NoSuchElementException();
        }
        if (synToRemove == null || synToRemove.equals(""))
        {
            return false;
        }
        if (this.containsSynonym(synToRemove))
        {
            TreeNode nodeToRemove = TreeNode.getNodeByString(synToRemove, this.getSynonymTree());
            return TreeNode.removeTreeNode(nodeToRemove, this.getSynonymTree(), null);
        }
        else
        {
            return false;
        }
    }

    /*
    Method: removeTreeNode
    Purpose: removes a node fro the tree
    Parameters:
    TreeNode nodeToRemove - node being removed
    TreeNode currentTree - tree being removed from
    TreeNode previous - previous nod in the tree
    Returns:
        boolean - did I do it?
    */
    public static boolean removeTreeNode(TreeNode nodeToRemove, TreeNode currentTree, TreeNode previous)
    {
        if (currentTree == null || nodeToRemove == null)
        {
            return false;
        }
        String removeMe = nodeToRemove.getMyString();
        if (currentTree.getMyString().equalsIgnoreCase(removeMe))
        {
            TreeNode copyOfCurrentTree = currentTree;
            if (previous == null)
            {}
            else
            {
                if (previous.getLeftBranch() == currentTree) {

                    previous.setLeftBranch(null);
                } else {
                    previous.setRightBranch(null);
                }
            }
            currentTree = null;
            TreeNode.addNodeWithChildren(copyOfCurrentTree.getRightBranch(), previous);
            TreeNode.addNodeWithChildren(copyOfCurrentTree.getLeftBranch(), previous);
            return true;
        }
        if (currentTree.getMyString().compareToIgnoreCase(removeMe) < 0 )
        {
            return removeTreeNode(nodeToRemove, currentTree.getRightBranch(), currentTree);
        }
        else
        {
            return removeTreeNode(nodeToRemove, currentTree.getLeftBranch(), currentTree);
        }

    }

    /*
    Method: addNodeWithChildren
    Purpose: adds a node with children to another tree
    Parameters:
    TreeNode adding - the current nodI'm adding
    TreeNode addedTo - the node Im adding to
    Returns:
    */
    public static void addNodeWithChildren(TreeNode adding, TreeNode addedTo)
    {

        if (adding == null)
        {}
        else
        {
            TreeNode newNode = new TreeNode(adding.isEntry());
            newNode.setMyString(adding.getMyString());
            TreeNode.addTreeNodeInOrder(newNode, addedTo);

            if (adding.getLeftBranch() == null) {
            } else {
                addNodeWithChildren(adding.getLeftBranch(), addedTo);
            }
            if (adding.getRightBranch() == null) {
            } else {
                addNodeWithChildren(adding.getRightBranch(), addedTo);
            }
        }
    }

    /*
    Method: toString
    Purpose: sends the database to a string
    Parameters:
    Returns:
    Sting - the entry's data
    */
    public String toString()
    {
        String returnString = "";
        if (this.isEntry())//this is an entry
        {
            returnString += "Word: " + this.getMyString();
            returnString += "\r\nSynonyms: ";
            if (synonymTree == null)
            {
                returnString += "There are no synonyms found for this entry";
            }
            else
            {
                returnString += synTreeToString(this.getSynonymTree());

                if (returnString.equalsIgnoreCase(""))
                {
                    returnString = "There are no synonyms found for this entry";
                }
                else
                {
                    returnString = returnString.substring(0, returnString.length() - 2);
                }
            }
        }
        //syn trees made this wierd

        return returnString;
    }


    /*
    Method: SynTreeToString
    Purpose: sends the database to a string
    Parameters:
    TreeNode current - current node bing printed
    Returns:
        String - htestring of synonyms
    */
    public static String synTreeToString(TreeNode current)//method
    {

        String returnString = "";
        if (current == null)
        {
            return "";
        }
        //get the stuff on the left side
        returnString += synTreeToString(current.getLeftBranch());

        //get the stuff in the middle
        returnString += current.getMyString() + ", ";
        //get the stuff on the right side

        returnString += synTreeToString(current.getRightBranch());

        return returnString;
    }


    /*
    Method: toFile
    Purpose: sends the database to a File
    Parameters:
    Returns:
        String - the entry to send to file
    */
    public String toFile()
    {
        String returnString = "";
        if (this.isEntry())//this is an entry
        {
            returnString += this.getMyString();
            returnString += synTreeToFile(this.getSynonymTree());
        }
        //syn trees made this wierd

        return returnString;
    }
    /*
    Method: synTreeToFile
    Purpose: sends the entry to a File
    Parameters:
    TreeNode current - current node bing printed
    Returns:
    String - The list of synonyms
    */
    public static String synTreeToFile(TreeNode current)//method
    {

        String returnString = "";
        if (current == null)
        {
            return "";
        }

        //get the stuff in the middle
        returnString += "/" + current.getMyString();
        //get the stuff on the left side
        returnString += synTreeToFile(current.getLeftBranch());
        //get the stuff on the right side
        returnString += synTreeToFile(current.getRightBranch());

        return returnString;
    }




}
