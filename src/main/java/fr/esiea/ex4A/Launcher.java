package fr.esiea.ex4A;

import fr.esiea.ex4A.model.AgifyClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import retrofit2.Retrofit;
//import com.google.gson

@SpringBootApplication
public class Launcher {

    public static void main(String[] args) {
        SpringApplication.run(Launcher.class, args);
    }
    @Bean
    AgifyClient agifyClient() {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.agify.io/")
            //.addConverterFactory(GsonConverterFactory.create())
            .build();

        return retrofit.create(AgifyClient.class);
    }
}
