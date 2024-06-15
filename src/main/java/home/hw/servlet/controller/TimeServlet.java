package home.hw.servlet.controller;

import home.hw.tool.Time;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(value = "/time")
public class TimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String timezoneStr = req.getParameter("timezone");
        timezoneStr = Optional.ofNullable(timezoneStr).orElse("UTC");
        timezoneStr = Time.convertTimeZone(timezoneStr);

        req.setAttribute("time", Time.getCurrentTime(timezoneStr));
        req.getRequestDispatcher("response.jsp").forward(req, resp);

    }


}
