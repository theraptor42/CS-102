import java.util.NoSuchElementException;

/**
 * Created by Caspian on 11/17/2015.
 */
public class TreeNode
{
    private String myString;//The data stored in the node
    //word or synonym
    private TreeNode leftBranch;//node on the let side of the tree
    private TreeNode rightBranch;//node on the right side of the tree
    private TreeNode synonymTree;//Node of the root synonym for this entry
    //not used in the synonym tree

    public TreeNode()
    {
        myString = null;
        leftBranch = null;
        rightBranch = null;
        synonymTree = null;
    }

    public String getMyString()
    {
        return myString;
    }

    public void setMyString(String myString)
    {
        this.myString = myString;
    }

    public TreeNode getLeftBranch()
    {
        return leftBranch;
    }

    public void setLeftBranch(TreeNode leftBranch)
    {
        this.leftBranch = leftBranch;
    }

    public TreeNode getRightBranch()
    {
        return rightBranch;
    }

    public void setRightBranch(TreeNode rightBranch)
    {
        this.rightBranch = rightBranch;
    }

    public TreeNode getSynonymTree()
    {
        return synonymTree;
    }

    public void setSynonymTree(TreeNode synonymTree)
    {
        this.synonymTree = synonymTree;
    }

    public boolean containsSynonym(String findMe)
    {
        return (containsString(findMe, synonymTree));
    }

    private boolean containsString(String findMe, TreeNode currentNode)
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
        if (currentNode.getMyString().compareToIgnoreCase(findMe) > 0)
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

    public TreeNode getSynonymNode(String synonym)
    {
        if(!this.containsSynonym(synonym))
        {
            throw new NoSuchElementException();
            //get synonym node should follow a contains search
            // If I didn't do that then let me know
        }
        return (getNodeByString(synonym, synonymTree));
    }

    private TreeNode getNodeByString(String findMe, TreeNode currentNode)
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
        if (currentNode.getMyString().compareToIgnoreCase(findMe) > 0)
        {
            //if current goes before findMe, go down right
            return(getNodeByString(findMe, currentNode.getRightBranch()));
        }
        else
        {
            //if current goes after findMe, go doewn left
            return(getNodeByString(findMe, currentNode.getLeftBranch()));
        }
    }
}
