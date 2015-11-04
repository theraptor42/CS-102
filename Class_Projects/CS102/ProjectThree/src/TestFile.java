import java.util.*;

/**
 * Created by Caspian on 11/4/2015.
 */
public class TestFile
{
    public static void main(String [] args)
    {
        String [] myarray = {"apple"};
        //LinkedList<String> newList = Arrays.asList(myarray);
        LinkedList<String> wordList = new LinkedList<String>();
        wordList.set(0, "apple");

        System.out.println(wordList.getFirst());
    }
}
