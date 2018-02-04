package framework.recommendation;

public interface IRecomendation {
    //predicate relates products
    public boolean setUp();
    public Integer[] predict(int product); 
}