import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseManager {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/weather_db";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";

    public void saveWeatherData(WeatherData data) throws Exception {
    	Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

        String query = "INSERT INTO weatherdata (city, temperature, feels_like, main_condition, timestamp) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, data.getCity());
        stmt.setDouble(2, data.getTemperature());
        stmt.setDouble(3, data.getFeelsLike());
        stmt.setString(4, data.getMainCondition());
        stmt.setString(5, data.getTimestamp());

        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }
}
