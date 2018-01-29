package ASDFramework.src.Vistor;

/**
 * Created by hongleyou on 2017/8/7.
 */
public interface Vistor<T> {
    public T visit(Person person, String cmd, String msg);

}
