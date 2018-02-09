
package framework.mapreduce;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMapper<K extends Comparable<K>, V> {
    private String contents = null;
    
    private List<Pair<K, V>> mapOutput = null;
    
    private boolean inCombine = true;

    public AbstractMapper() {
        mapOutput = new ArrayList<Pair<K, V>>();
    }

    public AbstractMapper(String contents) {
        this.contents = contents;
        mapOutput = new ArrayList<Pair<K, V>>();
    }
    
    public void assignTask(String contents) {
        this.contents = contents;
    }
    
    public List<Pair<K, V>> getMapOutput() {
        return mapOutput;
    }

    public void setMapOutput(List<Pair<K, V>> mapOutput) {
        this.mapOutput = mapOutput;
    }
    
    public boolean isInCombine() {
        return inCombine;
    }

    public void setInCombine(boolean inCombine) {
        this.inCombine = inCombine;
    }
    
    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    
    public abstract List<Pair<K,V>> map() throws Exception;
    
    protected void printInput() {
        if(ComputeFrameWork.DEBUG) {
            System.out.println("----------------------------------------------");
            System.out.println("---------------Mapper Input-------------------");
            System.out.println("----------------------------------------------");
            System.out.println(contents);
            System.out.println();
            System.out.println();
        }
    }
    
    protected void printOutput(List<Pair<String, Integer>> mapResults) {
        if(ComputeFrameWork.DEBUG) {
            System.out.println("----------------------------------------------");
            System.out.println("---------------Mapper Output-------------------");
            System.out.println("----------------------------------------------");
            Utility.mapOutput(mapResults);
            System.out.println();
            System.out.println();
        }
    }
}
