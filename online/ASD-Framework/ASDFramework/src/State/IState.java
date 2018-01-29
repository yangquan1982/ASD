package ASDFramework.src.State;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hongleyou on 2017/8/12.
 */
public interface IState {
    //This action method only for Http request and response.
    void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
