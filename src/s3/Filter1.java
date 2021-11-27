package s3;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "Filter1")
public class Filter1 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        chain.doFilter(req, resp);
        resp.setContentType("text/html");
        PrintWriter out= resp.getWriter();
        String name =req.getParameter("user_name");
        String age =req.getParameter("age");

        if (name == null || "".equals(name) || age== null || "".equals(age))
        {
            out.println("<h1>plz enter the data<h1>");

            chain.doFilter(req,resp);

        }
        else
        {
            out.println("<h1> enter the data sucessfully<h1>");
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
