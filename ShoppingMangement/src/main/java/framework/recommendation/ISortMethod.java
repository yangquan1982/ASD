package framework.recommendation;

import java.util.Map;

public interface ISortMethod<T extends Comparable<? super T>> {
    public Map<Integer,T> sort(T[] sortarray);
}
