package ASDFramework.src.CRUD_command;

import java.sql.Connection;

/**
 * Created by hongleyou on 2017/8/8.
 */
public class Invoker {
    private ICommand command = null;

    public Invoker(ICommand command) {
        this.command = command;
    }

    public int action(String cmd, Connection con, Operation operation) {
        return command.execute(cmd, con, operation);
    }
}
