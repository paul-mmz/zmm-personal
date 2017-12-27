package com.paul.servlet.headFirst;

import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class WelcomeServlet extends HttpServlet {

    public static AtomicInteger count = new AtomicInteger(0);

    public static Map<String, String> idNameMap = new HashMap<>();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String userName = null;
        if (session.isNew()) {
            userName = "Stranger, This is thr first time to visit our website.";
            Integer cookieValue = count.getAndIncrement();
            Cookie cookie = new Cookie("userName", "user" + cookieValue);
            resp.addCookie(cookie);
            idNameMap.put(session.getId(), "user" + cookieValue);
        } else {
            Cookie[] cookies = req.getCookies();
            if (cookies != null && cookies.length > 0) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName() != null && cookie.getName().equals("userName")) {
                        userName = cookie.getValue() + " back to our websit";
                        break;
                    }
                }
            }
            if(StringUtils.isBlank(userName)) {
                userName = idNameMap.get(session.getId());
            }
        }
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.print("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\t<title>\n" +
                "\t\tWelcome page\n" +
                "\t</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\twelcome" + userName +
                "<a href=\"" + resp.encodeURL("/zmm-personal/form.html") + "\">click me to form.html</a>" +
                "<p>" +
                "<a href=\"" + resp.encodeURL("/zmm-personal/newWelcome.html") + "\">back to welcome</a>" +
                "</body>\n" +
                "</html>");
    }

    public static Map<String, String> getIdNameMap() {
        return idNameMap;
    }

    public static void setIdNameMap(Map<String, String> idNameMap) {
        idNameMap = idNameMap;
    }
}
