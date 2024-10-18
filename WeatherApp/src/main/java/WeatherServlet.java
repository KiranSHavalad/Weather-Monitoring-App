import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/fetchWeather")
public class WeatherServlet extends HttpServlet {
    private WeatherFetcher weatherFetcher = new WeatherFetcher();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String city = request.getParameter("city");
        if (city == null || city.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "City parameter is missing.");
            return;
        }

        try {
            WeatherData weatherData = weatherFetcher.fetchWeather(city);

            // Respond with HTML containing the weather data
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>Weather in " + city + "</h1>");
            out.println("<p>Temperature: " + weatherData.getTemperature() + " °C</p>");
            out.println("<p>Feels Like: " + weatherData.getFeelsLike() + " °C</p>");
            out.println("<p>Condition: " + weatherData.getMainCondition() + "</p>");
            out.println("</body></html>");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error fetching weather data.");
        }
    }
}
