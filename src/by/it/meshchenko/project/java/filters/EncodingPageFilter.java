package by.it.meshchenko.project.java.filters;

import javax.servlet.*;
import java.io.IOException;

public class EncodingPageFilter implements Filter {

    private String code;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        code=filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter EncodingPage started");
        req.getServletContext().log("filter EncodingPage started");
        String currentEncoding=req.getCharacterEncoding();
        if (code!=null && !code.equalsIgnoreCase(currentEncoding)){
            System.out.println("req EncodingPage started");
            req.getServletContext().log("req EncodingPage started");
            req.setCharacterEncoding(code);
        }
        currentEncoding=resp.getCharacterEncoding();
        if (code!=null && !code.equalsIgnoreCase(currentEncoding)){
            System.out.println("resp EncodingPage started");
            req.getServletContext().log("resp EncodingPage started");
            resp.setCharacterEncoding(code);
        }
        filterChain.doFilter(req,resp);
    }

    @Override
    public void destroy() {
        code=null;
    }
}
