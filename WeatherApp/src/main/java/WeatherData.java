import java.time.LocalDateTime;

public class WeatherData {
    private String city;
    private String mainCondition;
    private double temperature;
    private double feelsLike;
    private  String timestamp;
    public WeatherData(String city, double temperature, double feelsLike, String mainCondition, String timestamp) {
        this.city = city;
        this.temperature = temperature;
        this.feelsLike = feelsLike;
        this.mainCondition = mainCondition;
        this.timestamp = timestamp;
    }
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getMainCondition() {
		return mainCondition;
	}
	public void setMainCondition(String mainCondition) {
		this.mainCondition = mainCondition;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public double getFeelsLike() {
		return feelsLike;
	}
	public void setFeelsLike(double feelsLike) {
		this.feelsLike = feelsLike;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

   
}
