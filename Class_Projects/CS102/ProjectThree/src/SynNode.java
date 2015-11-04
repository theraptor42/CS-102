/*
    Caspian Peavyhouse - peav2414@kettering.edu
    CS-102, Fall 2015
    Programming Assignment 2
    SynNode Class  - stores a synonym and a reference to the
                   -next SynNode in the linkedList
*/
public class SynNode
{
    String synonym;// the synNode's synonym
    SynNode nextSynonymNode;//refence to the next synNode

    /*
    Method: Entry - constructor
    Purpose: linked list node of synonym nodes
    Parameters:
        String synonym     the synNode's synonym
        SynNode nextSynonymNode    refence to the next synNode
    Returns:
        SynNode - object created
    */
    public SynNode(String synonym, SynNode nextSynonymNode)
    {
        this.synonym = synonym;
        this.nextSynonymNode = nextSynonymNode;
    }

    /*
    Method: getNextSynNode - getter
    Purpose: gets the next synonym node
    Parameters:
        none
    Returns:
        SynNode - the next synonym node
    */
    public SynNode getNextSynonymNode()
    {
        return nextSynonymNode;
    }

    /*
    Method: setNextSynNode - setter
    Purpose: gets the next synonym node
    Parameters:
        SynNode nextSynonymNode  the new nextSynNode
    Returns:
        none
    */
    public void setNextSynonymNode(SynNode nextSynonymNode)
    {
        this.nextSynonymNode = nextSynonymNode;
    }

    /*
    Method: getSynonym - getter
    Purpose: gets SynNode's synonym
    Parameters:
        none
    Returns:
        String - the synonym
    */
    public String getSynonym()
    {
        return synonym;
    }

}
