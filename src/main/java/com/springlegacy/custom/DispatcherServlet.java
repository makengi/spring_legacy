package com.springlegacy.custom;

import javax.naming.ldap.Control;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 7787985341339751572L;
    private HandlerMapping handlerMapping;
    private ViewResolver viewResolver;


    @Override
    public void init() throws ServletException {
        handlerMapping = new HandlerMapping();
        viewResolver = new ViewResolver();
        viewResolver.setPrefix("/web/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("EUC-KR");
        service(req,resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // parse path from client request
        String uri = req.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"));

        // 2. HandlerMapping을 통해 path에 해당하는 Controller를 검색
        Controller controller = handlerMapping.getController(path);

        // 3. 검색된 Controller 를 실행
        String viewName = controller.handleRequest(req, resp);

        String view = null;
        if(!viewName.contains(".do")){
            view = viewResolver.getView(viewName);
        }else{
            view = viewName;
        }
        resp.sendRedirect(view);



    }
}
