package framework.recommendation;

import framework.designpattern.factorymethod.IFactory;

public class RecommendtaionFactory implements IFactory<IRecomendation> {

    @Override
    public IRecomendation createFactory(String type) {
        if(type.equals("CF"))
            return new CFRecommendation();
        else
            return new CoOccurrenceRecommendation();
    }

}
