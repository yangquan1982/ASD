package framework.recommendation.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import framework.designpattern.observer.Observer;
import framework.recommendation.CFRecommendation;
import framework.recommendation.IRecomendation;
import framework.recommendation.RateInformation;
import framework.recommendation.RecommendtaionFactory;
import shopping.model.Purchase.InterestedPurchaseRecord;

public class ProducerConsumer implements Observer<InterestedPurchaseRecord>{
    // Create a list shared by producer and consumer
    // Size of list is 5.
    LinkedList<InterestedPurchaseRecord> list = new LinkedList<>();

    int capacity = 5;
    private static ProducerConsumer INSTANCE = null;
    
    private RecommendtaionFactory rf = new RecommendtaionFactory();
    private IRecomendation recommendation = rf.createFactory("CF");
    
    private Map<String, Integer[]> recommendationResults = new
            HashMap<String, Integer[]>();
    
    public static ProducerConsumer getInstance() {
        if (INSTANCE == null) {
            synchronized (ProducerConsumer.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ProducerConsumer();
                }
            }
        }
        return INSTANCE;
    }

    // Function called by producer thread
    public void produce(InterestedPurchaseRecord pRecord) throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                // producer thread waits while list
                // is full
                while (list.size() == capacity)
                    wait();
                System.out.println("Producer produced-" + value);
                // to insert the jobs in the list
                list.add(pRecord);
                // notifies the consumer thread that
                // now it can start consuming
                notify();
                // makes the working of program easier
                // to understand
                Thread.sleep(1000);
            }
        }
    }

    // Function called by consumer thread
    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                // consumer thread waits while list
                // is empty
                while (list.size() == 0)
                    wait();
                // to retrive the ifrst job in the list
                InterestedPurchaseRecord pRecord = list.removeFirst();
                predict(pRecord);
                // Wake up producer thread
                notify();
                // and sleep
                Thread.sleep(1000);
            }
        }
    }
    
    public LinkedList<InterestedPurchaseRecord> getList() {
        return list;
    }

    public void setList(LinkedList<InterestedPurchaseRecord> list) {
        this.list = list;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void updateInformation(InterestedPurchaseRecord pRecord) {
        try {
            this.produce(pRecord);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void predict(InterestedPurchaseRecord pRecord) {
        //find real product id
        String productId  = pRecord.getCart().getLineItemList().get(0).getProduct().getId();
        String customerId = pRecord.getCustomer().getCustomerProfile().getId();
        int customerNO = RateInformation.getRateInformation().getCustRowPos().get(customerId);
        int productNO = RateInformation.getRateInformation().getProcRowPos().get(productId);
        String transId = pRecord.getCustomer().getCustomerProfile().getId() + ":" +
                pRecord.getCart().getLineItemList().get(0).getProduct().getId();
        recommendation.setUp();
        ((CFRecommendation)recommendation).setCustomer(customerNO);
        Integer[] productsIds = recommendation.predict(productNO);
        recommendationResults.put(transId, productsIds);
    }
}
