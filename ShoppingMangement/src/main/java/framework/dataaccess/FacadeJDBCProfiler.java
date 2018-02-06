package framework.dataaccess;

import java.util.List;
import java.util.Map;

public class FacadeJDBCProfiler<T> {
    
    private FacadeJDBCExecutor<T> executor;
    
    public FacadeJDBCProfiler() {
        executor = new FacadeJDBCExecutor<T>();
    }
    
    public boolean executeSQL(String sql) {
        long startTime = System.currentTimeMillis();
        boolean ret = executor.executeSQL(sql);
        long endTime = System.currentTimeMillis();
        System.out.println("Time: \t"+ (double)(endTime - startTime)/1000);
        return ret;
    }
    
    //int executeUpdate(String sql) throws SQLException;
    public int executeUpdate(String sql) {
        long startTime = System.currentTimeMillis();
        int affectedRecords = executor.executeUpdate(sql);
        long endTime = System.currentTimeMillis();
        System.out.println("Time: \t"+ (double)(endTime - startTime)/1000);
        return affectedRecords;
    }
    
    public int[] executeBatch(List<String> sqlList) {
        int sqlSize = sqlList.size();
        int[] returnValues = new int[sqlSize];
        long startTime = System.currentTimeMillis();
        returnValues = executor.executeBatch(sqlList);
        long endTime = System.currentTimeMillis();
        System.out.println("Time: \t"+ (double)(endTime - startTime)/1000);
        return returnValues;
    }
    
    public int executePrepareSQL(String sql, Map<Integer, Object> parameters) {
        int returnValue = -1;
        long startTime = System.currentTimeMillis();
        returnValue = executor.executePrepareSQL(sql, parameters);
        long endTime = System.currentTimeMillis();
        System.out.println("Time: \t"+ (double)(endTime - startTime)/1000);
        return returnValue;
    }
    
    public int executePrepareSQL(String sql, List<Map<Integer, Object>> parameters) {
        int returnValue = -1;
        long startTime = System.currentTimeMillis();
        returnValue = executor.executePrepareSQL(sql, parameters);
        long endTime = System.currentTimeMillis();
        System.out.println("Time: \t"+ (double)(endTime - startTime)/1000);
        return returnValue;
    }
}
