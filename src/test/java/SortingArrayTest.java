import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SortingArrayTest {

    @Test
    public void bubbleSort(){
        int size = 10;
        ArrayList<Integer> arrayList = new ArrayList<>(size);
        for (int i = 0; i < size; i++)
            arrayList.add(size - i);
        ArrayList<Integer> sorted = SortingArray.bubbleSort(arrayList);
        for (int i = 0; i < size-1; i++)
            assertFalse(sorted.get(i).compareTo(sorted.get(i+1)) > 0);
        System.out.printf("%n");
    }
}
