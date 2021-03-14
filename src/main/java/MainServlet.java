
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;


    public class MainServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


            Iterator<String> stringIterator = request.getParameterNames().asIterator();
            response.getWriter().println("<p><ol>");

            while (stringIterator.hasNext()) {
                String nextKey = stringIterator.next();
                String nextValue =  request.getParameter(nextKey);
                if (nextKey.equals(getServletConfig().getInitParameter("blockedQueryParam"))) {
                    response.setStatus(400);
                    return;
                }
                response.getWriter().println("<ul type=\"square\"><li>" + nextKey + ": " + nextValue + "</li></ul>");

            }

            response.getWriter().println("</p></ol>");

        }
    }

