package framework.recommendation;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import framework.mapreduce.AbstractMapper;
import framework.mapreduce.CoOccurrenceMapper;
import framework.mapreduce.ComputeFrameWork;
import framework.mapreduce.GroupByPair;
import framework.mapreduce.Pair;
import framework.mapreduce.Reducer;
import framework.mapreduce.Utility;
import framework.mapreduce.test.WordCountTest;

public class CoOccurrenceRecommendation implements IRecomendation {
    
    private final static int recommendationNumbers = 1; 
   
    private String inputContents;

    @Override
    public boolean setUp() {
        // TODO Auto-generated method stub        
        URI filePath;
        String fileContents = null;
        try {
            filePath = WordCountTest.class.getResource("testDataForW1D2.txt").toURI();
            fileContents = Utility.loadFileIntoMemory(filePath);
            inputContents = fileContents;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Integer[] predict(int productNO) {
        try {
            AbstractMapper<String, Integer> mapper = new CoOccurrenceMapper(inputContents);
            List<Pair<String, Integer>> mapResults = mapper.map();
            List<GroupByPair<String, Integer>> reduceInput = ComputeFrameWork.convertInputFormat(mapResults);
            Reducer<String, Integer> reducer = new Reducer<String, Integer>(reduceInput);
            Map<String, Integer> output = reducer.reduce();
            return getMostRelatedProduct(output, productNO);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }
    
    private Integer[] getMostRelatedProduct(Map<String, Integer> output, int productNO) throws Exception {
        Map<Integer, String> combineProducts = new TreeMap<Integer, String>();
        for(Map.Entry<String, Integer> entry : output.entrySet()) {
            String key = entry.getKey();
            String[] keyparts = key.split(":");
            if(keyparts.length != 2)
                throw new Exception("illegal parameters size");
            if(keyparts[0].equals(String.valueOf(productNO)))
                combineProducts.put(entry.getValue(), keyparts[1]);
        }
        Integer[] finalResult = new Integer[recommendationNumbers];
        int i = 0;
        for(Map.Entry<Integer,String> combineProduct : combineProducts.entrySet()) {
            finalResult[i] = Integer.valueOf(combineProduct.getValue());
            i++;
        }
        return finalResult;
    }
    
    public String getInputContents() {
        return inputContents;
    }

    public void setInputContents(String inputContents) {
        this.inputContents = inputContents;
    }

}
