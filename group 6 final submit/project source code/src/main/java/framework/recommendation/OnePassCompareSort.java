package framework.recommendation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
    
public class OnePassCompareSort {
    
    public static <T extends Comparable<? super T>> Map<Integer, T> sort(List<T> list, SortType sortType)
            throws Exception {
        switch (sortType) {
        case BIG_TO_SMALL:
            return OnePassCompareSort.twoBig(list);
        case SMALL_TO_BIG:
            return OnePassCompareSort.twoSmall(list);
        default:
            return OnePassCompareSort.twoSmall(list);
        }
    }
    
    public static <T extends Comparable<? super T>> Map<Integer, T> twoSmall(List<T> list) throws Exception {
        Map<Integer, T> map = new HashMap<Integer, T>();
        T min, secondSmall;
        Integer minLocation, secondSmallLocation;
        if(list.size() == 0 || list.size() == 1)
            throw new Exception("The list size is smaller than 1");
        if(list.get(0).compareTo(list.get(1)) <= 0) {
            min = list.get(0);
            secondSmall = list.get(1);
            minLocation = 0;
            secondSmallLocation = 1;
        } else {
            min = list.get(1);
            secondSmall = list.get(0);
            minLocation = 1;
            secondSmallLocation = 0;
        }

        for(int j = 2; j<list.size(); j++) {
            T i = list.get(j);
            if(i.compareTo(min) < 0) {
                secondSmall = min;
                secondSmallLocation = minLocation;
                min = i;
                minLocation = j;
            }
            else if (i.compareTo(secondSmall) < 0) {
                secondSmall = i;
                secondSmallLocation = j;
            }
        }
        map.put(minLocation, min);
        map.put(secondSmallLocation, secondSmall);
        return map;
    }
    
    public static <T extends Comparable<? super T>> Map<Integer, T> twoBig(List<T> list) throws Exception {
        Map<Integer, T> map = new HashMap<Integer, T>();
        T max, secondBig;
        Integer maxLocation, secondBigLocation;
        if(list.size() == 0 || list.size() == 1)
            throw new Exception("The list size is smaller than 1");
        if(list.get(0).compareTo(list.get(1)) <= 0) {
            secondBig = list.get(0);
            max = list.get(1);
            maxLocation = 1;
            secondBigLocation = 0;
        } else {
            max = list.get(0);
            secondBig = list.get(1);
            maxLocation = 0;
            secondBigLocation = 1;
        }

        for(int j = 2; j<list.size(); j++) {
            T i = list.get(j);
            if(i.compareTo(max) > 0) {
                secondBig = max;
                secondBigLocation = maxLocation;
                max = i;
                maxLocation = j;
            }
            else if (i.compareTo(secondBig) > 0) {
                secondBig = i;
                secondBigLocation = j;
            }
        }
        map.put(maxLocation, max);
        map.put(secondBigLocation, secondBig);
        return map;
    }
}
