package ASDFramework.src.Adapter;

import javax.servlet.http.HttpServletResponse;


public class ResponseAdapter implements ResponseTarget {

    private final HttpServletResponse response;

    public ResponseAdapter(HttpServletResponse response) {
        this.response = response;
        response.setContentType("text/html;charset=utf-8");
    }

    public void write(Object o) throws Exception {
        this.response.getWriter().println(o.toString());
        this.response.getWriter().flush();
        this.response.getWriter().close();
    }
}
