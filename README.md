 #   This Weather Monitoring and Alert System is a real-time data processing application that retrieves weather data from the OpenWeatherMap API and provides summarized insights, trends,      and alerts for major metropolitan areas in India. The system fetches weather data at regular intervals (every 5 or 10 minutes) and stores it in a database. If any weather conditions      breach predefined thresholds (like temperature, humidity, etc.), the system triggers an alert via email or SMS. The project is written in Java, with a custom-built frontend and      database for data storage.

# Technologies Used
    -Programming Language: Java (without Spring)
    -Frontend Technologies: HTML, CSS, JavaScript
    -Database: MySQL (for storing weather data)
    -External API: OpenWeatherMap API
    -Alerting System: Email/SMS alerts based on weather thresholds

# Prerequisites
  To run this project, you will need:

    -Java Development Kit (JDK): Version 11 or later
     -MySQL: Installed and running on your local machine
     -API Key: From OpenWeatherMap (sign up at OpenWeatherMap to get your API key)
     -Mailing or SMS Service: A valid account (e.g., SendGrid, Twilio, or any other service for sending alerts)


# dependencies for this project is :
    

  <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
  </dependency>
    
  <dependency>
    <groupId>org.json</groupId>
    <artifactId>json</artifactId>
    <version>20210307</version>
  </dependency>

  <dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.10.1</version>
  </dependency>

<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.30</version>
</dependency>
    
  
<dependency>
    <groupId>javax.mail</groupId>
    <artifactId>mail</artifactId>
    <version>1.4.7</version>
</dependency>
