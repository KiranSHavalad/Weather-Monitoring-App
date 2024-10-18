document.addEventListener('DOMContentLoaded', function() {
    fetch('/check-alerts?city=Mumbai')
        .then(response => response.json())
        .then(data => {
            document.getElementById('weather-data').innerHTML = `
                <p>City: ${data.city}</p>
                <p>Temperature: ${data.temperature} °C</p>
            `;
        })
        .catch(error => {
            console.error('Error fetching weather data:', error);
        });
});
