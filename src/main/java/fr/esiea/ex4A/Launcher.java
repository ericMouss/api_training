package fr.esiea.ex4A;

import ch.qos.logback.classic.spi.LoggingEventVO;
import fr.esiea.ex4A.model.AgifyClient;
import okhttp3.OkHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import retrofit2.Retrofit;

@SpringBootApplication
public class Launcher {

    public static void main(String[] args) {
        SpringApplication.run(Launcher.class, args);
    }

    @Bean
    AgifyClient agifyClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .client(httpClient.build())
            .build();

        return retrofit.create(AgifyClient.class);
    }
}
