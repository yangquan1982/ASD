package ASDFramework.src.CRUD_command;

import java.sql.Connection;

/**
 * Created by hongleyou on 2017/8/8.
 */
public class ConcreteCommand implements ICommand {
    private IReceiver receiver = null;

    public ConcreteCommand(IReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public int execute(String cmd, Connection con, Operation operation) {
        return receiver.CRUD_action(cmd, con, operation);
    }
}
