package ASDFramework.src.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hongleyou on 2017/8/12.
 */
public class TAggregate<T> implements IAggregate<T> {
    private List<T> list = new ArrayList<>();
    @Override
    public void add(T obj) {
        list.add(obj);
    }

    @Override
    public void remove(T obj) {
        list.remove(obj);
    }

    @Override
    public IIterator<T> iterator() {
        return new TIterator<T>(list);
    }
}
