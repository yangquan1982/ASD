package framework.recommendation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//implement most big heap sorting
//Facade patterns
public class SortUtil<T extends Comparable<? super T>> {
    //perfect one is heap sort but here just interate the array to pick the largest one
    public static <T extends Comparable<? super T>> Map<Integer,T> getMostOne(T[] rArrays, int numbers, SortType sortType)
            throws Exception{
        List<T> list = new ArrayList<T>();
        for(T t: rArrays) {
            list.add(t);
        }
        if(numbers<=2) {
            return OnePassCompareSort.sort(list, sortType);
        } else {
            return HeapSort.sort(rArrays, sortType);
        }
    }
}
