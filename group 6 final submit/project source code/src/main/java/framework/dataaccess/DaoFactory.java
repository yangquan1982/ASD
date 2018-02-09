package framework.dataaccess;

public interface DaoFactory {
    public DaoAccess<?, ?> createDao(String table);
}
