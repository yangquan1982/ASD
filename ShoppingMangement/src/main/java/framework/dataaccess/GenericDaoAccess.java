package framework.dataaccess;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Predicate;

import framework.common.Functor;

public class GenericDaoAccess<ID extends Serializable, T extends MappingObject<ID>> implements DaoAccess<T, ID> {
    
    private SQLConstructor<T, ID> constructor;
    private FacadeJDBCExecutor executor;
    
    public GenericDaoAccess(String tableName, String keyName) {//tablename and primary key name
        this.constructor = new SQLConstructor<T, ID>(tableName, keyName);
        this.executor = new FacadeJDBCExecutor();
    }

    @Override
    public void insert(T entity) throws SQLException {
        String insertSQL = constructor.constructInsert(entity);
        executor.executeSQL(insertSQL);
    }

    @Override
    public void update(T entity) throws SQLException {
        String updateSQL = constructor.constructUpdate(entity, entity.getPrimaryKeyValue(), entity.getMappedValues());
        executor.executeSQL(updateSQL);
    }

    @Override
    public T getById(ID id) throws SQLException {
        String selectSQL = constructor.constructSelect(id);
        return null;
    }

    @Override
    public List<T> getAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <R> void executeAll(Functor<T, R> func, Predicate<T> p) throws SQLException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public <S extends T> S save(S entity) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends T> Iterable<S> save(Iterable<S> entities) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public T findOne(ID id) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<T> findAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterable<T> findAll(Iterable<ID> ids) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public boolean exists(ID id) throws SQLException {
        String selectCountSQL = constructor.constructSelect(id);
        return executor.executeSelectExist(selectCountSQL);
    }

    @Override
    public long count() throws SQLException {
        String selectCountSQL = constructor.constructSelectCount();
        return executor.executeSelectCount(selectCountSQL);
    }

    @Override
    public void delete(ID id) throws SQLException {
        String deleteSQL = constructor.constructDelete(id);
        executor.executeSQL(deleteSQL);
    }

    @Override
    public void delete(T entity) throws SQLException {
        ID id = entity.getPrimaryKeyValue();
        String deleteSQL = constructor.constructDelete(id);
        executor.executeSQL(deleteSQL);
    }

    @Override
    public void delete(Iterable<? extends T> entities) throws SQLException {
        for(T t: entities) {
            ID id = t.getPrimaryKeyValue();
            String deleteSQL = constructor.constructDelete(id);
            executor.executeSQL(deleteSQL);
        }
    }

    @Override
    public void deleteAll() throws SQLException {
        String deleteAllSQL = constructor.constructDeleteAll();
        boolean ret = executor.executeSQL(deleteAllSQL);
        if(!ret) throw new SQLException("Delte ALL Failed");
    }
}
