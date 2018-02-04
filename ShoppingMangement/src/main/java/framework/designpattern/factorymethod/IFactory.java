package framework.designpattern.factorymethod;

public interface IFactory<T> {
    public T createFactory(String type);
}