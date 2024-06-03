Sign Up for API Key:

Visit the OpenWeatherMap website and sign up for a free API key.
Create a new Java project:

Set up a new Java project using your preferred IDE (Eclipse, IntelliJ, etc.) or build tool (Maven, Gradle).
Add Dependencies:

If you're using a build tool like Maven, add the necessary dependencies to your pom.xml file. For OpenWeatherMap, you can use a library like Unirest for making HTTP requests.
xml
Copy code
<dependencies>
    <dependency>
        <groupId>com.mashape.unirest</groupId>
        <artifactId>unirest-java</artifactId>
        <version>1.4.9</version>
    </dependency>
</dependencies>
Write Java Code:

Create a Java class for your weather API.
java
Copy code
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class WeatherApi {
    private static final String API_KEY = "your_openweathermap_api_key";
    private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather";

    public static void main(String[] args) {
        String cityName = "London";
        getWeather(cityName);
    }

    public static void getWeather(String cityName) {
        try {
            HttpResponse<JsonNode> response = Unirest.get(API_URL)
                    .queryString("q", cityName)
                    .queryString("appid", API_KEY)
                    .header("Accept", "application/json")
                    .asJson();

            System.out.println("Response Code: " + response.getStatus());
            System.out.println("Weather Data:\n" + response.getBody().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}