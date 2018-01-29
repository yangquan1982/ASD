package ASDFramework.src.CRUD_command;

import java.sql.Connection;

/**
 * Created by hongleyou on 2017/8/8.
 */
public interface ICommand {
    public int execute(String cmd, Connection con, Operation operation);
}
