import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherFetcher {
    private static final String API_KEY = "bd5e378503939ddaee76f12ad7a97608"; // Replace with your actual API key
    private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s";

    public WeatherData fetchWeather(String city) throws Exception {
        String urlString = String.format(API_URL, city, API_KEY);
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode(); // Check the response code

        // Handle errors (e.g., 404 Not Found, 401 Unauthorized)
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new Exception("Failed to fetch weather data: HTTP code " + responseCode);
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JsonObject jsonResponse = JsonParser.parseString(response.toString()).getAsJsonObject();

        double tempKelvin = jsonResponse.getAsJsonObject("main").get("temp").getAsDouble();
        double feelsLikeKelvin = jsonResponse.getAsJsonObject("main").get("feels_like").getAsDouble();
        String mainCondition = jsonResponse.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").getAsString();
        String timestamp = jsonResponse.get("dt").getAsString(); // Unix timestamp

        double tempCelsius = tempKelvin - 273.15;
        double feelsLikeCelsius = feelsLikeKelvin - 273.15;

        return new WeatherData(city, tempCelsius, feelsLikeCelsius, mainCondition, timestamp);
    }
}
