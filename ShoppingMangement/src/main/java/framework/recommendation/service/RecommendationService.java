package framework.recommendation.service;


//Customer should be something relates to the purchase
//rest service should be much better
public class RecommendationService implements Runnable {
    
    @Override
    public void run() {
        try {
            while(true) {
                ProducerCosumer.getInstance().consume();
                Thread.sleep(100);
            }
        } catch (Exception ex) {
            
        }
    }
}
