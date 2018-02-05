package framework.dataaccess;

import java.util.List;
import java.util.Map;

public class FacadeJDBCProfiler extends FacadeJDBCExecutor {
    
    public FacadeJDBCProfiler() {
        super();
    }
    
    @Override
    public boolean executeSQL(String sql) {
        long startTime = System.currentTimeMillis();
        boolean ret = super.executeSQL(sql);
        long endTime = System.currentTimeMillis();
        System.out.println("Time: \t"+ (double)(endTime - startTime)/1000);
        return ret;
    }
    
    //int executeUpdate(String sql) throws SQLException;
    @Override
    public int executeUpdate(String sql) {
        long startTime = System.currentTimeMillis();
        int affectedRecords = super.executeUpdate(sql);
        long endTime = System.currentTimeMillis();
        System.out.println("Time: \t"+ (double)(endTime - startTime)/1000);
        return affectedRecords;
    }
    
    @Override
    public int[] executeBatch(List<String> sqlList) {
        int sqlSize = sqlList.size();
        int[] returnValues = new int[sqlSize];
        long startTime = System.currentTimeMillis();
        returnValues = super.executeBatch(sqlList);
        long endTime = System.currentTimeMillis();
        System.out.println("Time: \t"+ (double)(endTime - startTime)/1000);
        return returnValues;
    }
    
    @Override
    public int executePrepareSQL(String sql, Map<Integer, Object> parameters) {
        int returnValue = -1;
        long startTime = System.currentTimeMillis();
        returnValue = super.executePrepareSQL(sql, parameters);
        long endTime = System.currentTimeMillis();
        System.out.println("Time: \t"+ (double)(endTime - startTime)/1000);
        return returnValue;
    }
    
    @Override
    public int executePrepareSQL(String sql, List<Map<Integer, Object>> parameters) {
        int returnValue = -1;
        long startTime = System.currentTimeMillis();
        returnValue = super.executePrepareSQL(sql, parameters);
        long endTime = System.currentTimeMillis();
        System.out.println("Time: \t"+ (double)(endTime - startTime)/1000);
        return returnValue;
    }
}
