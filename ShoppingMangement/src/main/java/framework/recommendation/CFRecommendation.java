package framework.recommendation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CFRecommendation implements IRecomendation {

    public final static int rateRow = 10;
    public final static int rateCol = 11;
    public final static double[][] rateScore = {
            {3.4, 3.5, 3.6, 3.7, 3.8, 3.9, 4.0, 4.1, 4.2, 4.3, 4.23},
            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 3},
            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 3},
            {3.45, 3.5, 3.6, 3.7, 3.8, 3.99, 4.10, 4.19, 4.2, 4.3, 4.2},
            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 4},
            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 4},
            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 3},
            {3.46, 3.58, 3.69, 3.7, 3.80, 3.96, 4.07, 4.15, 4.28, 4.33, 4.3},
            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 3},
            {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 3}
    };
    
    private int customer;
    
    CFRecommendation(){}
    
    CFRecommendation(int customer){
        this.customer = customer;
    }
    
    @Override
    public boolean setUp() {
        RateInformation rateInformation = RateInformation.getRateInformation();
        rateInformation.assignRateInformation(rateRow, rateCol, rateScore);
        return true;
    }
    
    @Override
    public Integer[] predict(int product) {
        RateInformation rateInformation = RateInformation.getRateInformation();
        SimilarCustomers similarCustomers = new SimilarCustomers(rateInformation);
        try {
            similarCustomers.calculateRelativeSimilarScores();
            double[][] similarScores = similarCustomers.getRelativeScores();
            for(int i=0; i<rateRow; i++) {
                for(int j=0; j<rateRow; j++) {
                    System.out.print(similarScores[i][j] + "  ");
                }
                System.out.println("");
            }
            Map<Integer, Set<Integer>> mostSimilMaps = similarCustomers.getMostSimilCustomers();
            for(int i=0; i<rateRow; i++) {
                Set<Integer> sets = mostSimilMaps.get(Integer.valueOf(i));
                System.out.print(i + ": ");
                for(Integer simil : sets) {
                    System.out.print(simil + "   ");
                }
                System.out.println();
            }
            ProductPurchasePredicate predicate = new ProductPurchasePredicate(rateScore, similarScores);
            List<Integer> products = new ArrayList<Integer>();
            double purchaseScore = 0.0;
            for(int i=0; i<rateCol; i++) {
                purchaseScore = predicate.purchasePredict(customer, i, mostSimilMaps.get(Integer.valueOf(customer)));
                if(purchaseScore > 0.9)
                    products.add(i);
            }
            Integer[] temp = new Integer[0];
            return products.toArray(temp);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }
    
}
