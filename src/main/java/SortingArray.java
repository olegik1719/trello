
import java.util.ArrayList;

public class SortingArray{
    /**
     *
     * @param comparables -- ArrayList to sorting
     * @param order -- ascending (default) or re descending order
     * @return sorted copy of source arrayList.
     */
    public static <T extends Comparable> ArrayList<T> bubbleSort(ArrayList<T> dataArray, boolean order){
        int size = dataArray.size();
        ArrayList<T> result = new ArrayList<>(dataArray);
        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < size - i -1; j++) {
                if (result.get(j).compareTo(result.get(j + 1)) > 0)
                    result.set(j,result.set(j+1,result.get(j)));
            }
        }
        if (!order) return Collections.reverse(result);
        return result;
    }

    public static <T extends Comparable> ArrayList<T> bubbleSort(ArrayList<T> dataArray){
        return bubbleSort(dataArray, true);
    }
}
