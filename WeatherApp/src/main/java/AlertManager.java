public class AlertManager {
    private static final double TEMP_THRESHOLD = 25.0; // Example threshold

    public boolean checkTemperatureAlert(WeatherData weatherData) {
        return weatherData.getTemperature() > TEMP_THRESHOLD;
    }
}
