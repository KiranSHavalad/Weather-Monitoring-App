import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        WeatherFetcher weatherFetcher = new WeatherFetcher();
        DatabaseManager dbManager = new DatabaseManager();
        AlertManager alertManager = new AlertManager();
        EmailSender emailSender = new EmailSender();

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable task = () -> {
            try {
                WeatherData weatherData = weatherFetcher.fetchWeather("Mumbai");
                dbManager.saveWeatherData(weatherData);
                
                if (alertManager.checkTemperatureAlert(weatherData)) {
                    emailSender.sendAlert("kshavalad@gmail.com", "Weather Alert", "Temperature exceeds threshold.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        scheduler.scheduleAtFixedRate(task, 0, 5, TimeUnit.MINUTES);
    }
}
