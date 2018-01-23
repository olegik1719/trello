
import java.util.ArrayList;

public class SortingArray{
    /**
     *
     * @param comparables -- ArrayList to sorting
     * @param order -- ascending (default) or re descending order
     * @return sorted copy of source arrayList.
     */
    public static <T extends Comparable> ArrayList<T> bubbleSort(ArrayList<T> comparables, boolean order){
        int size = comparables.size();
        ArrayList<T> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++)
            result.add(comparables.get(i));
        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < size - i -1; j++) {
                if ((result.get(j).compareTo(result.get(j + 1)) > 0)==order)
                    result.set(j,result.set(j+1,result.get(j)));
            }
        }
        return result;
    }

    public static <T extends Comparable> ArrayList<T> bubbleSort(ArrayList<T> comparables){
        return bubbleSort(comparables, true);
    }
}
