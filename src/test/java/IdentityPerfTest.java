import Problem2.Identity;
import org.junit.Test;

import java.util.*;

import static java.util.Collections.sort;
import static org.junit.Assert.assertEquals;

public abstract class IdentityPerfTest {
    final static public int targetStringLength = 10;
    ArrayList<Identity> idsArray;
    List<Identity> idsLinkedList;
    Map<String, Identity> idsTree;
    Map<String, Identity> idsDict;

    public void fillEmUp(int numOfElements) {
        idsArray = new ArrayList<>(numOfElements);
        idsLinkedList = new LinkedList<>();
        idsTree = new TreeMap<>();
        idsDict = new HashMap<>();

        for (int i = 0; i < numOfElements; i++) {
            idsArray.add(new Identity(PerfUtils.randStr(targetStringLength), PerfUtils.randStr(targetStringLength)));
        }
        sort(idsArray);

        for (Identity id : idsArray) {
            idsLinkedList.add(id);
            idsTree.put(id.username, id);
            idsDict.put(id.username, id);
        }

        assertEquals(numOfElements, idsArray.size());
        assertEquals(numOfElements, idsLinkedList.size());
        assertEquals(numOfElements, idsTree.size());
        assertEquals(numOfElements, idsDict.size());
    }

    @Test
    public void runTest() {
        // timing method based on https://howtodoinjava.com/java/date-time/execution-elapsed-time/
        for (int i = 5000; i < 500000; i += 5000) {
            // homework
            runTestOfSize(i);
        }
    }

    abstract void runTestOfSize(int i);
}
