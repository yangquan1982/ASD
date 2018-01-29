package ASDFramework.src.Iterator;

import java.util.Iterator;

/**
 * Created by hongleyou on 2017/8/12.
 */
public interface IAggregate<T> {
    public void add(T obj);
    public void remove(T obj);
    public IIterator<T> iterator();
}
