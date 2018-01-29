package ASDFramework.src.Iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hongleyou on 2017/8/12.
 */
public class TIterator<T> implements IIterator<T> {
    private List<T> list = new ArrayList<T>();
    private int cursor = 0;

    public TIterator(List<T> list) {
        this.list = list;
    }

    @Override
    public T next() {
        T obj = null;
        if(this.hasNext()){
            obj = this.list.get(cursor++);
        }
        return obj;
    }

    @Override
    public boolean hasNext() {
        if(cursor==list.size()){
            return false;
        }
        return true;
    }
}
