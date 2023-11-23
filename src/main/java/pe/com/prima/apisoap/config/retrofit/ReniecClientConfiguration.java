package pe.com.prima.apisoap.config.retrofit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pe.com.prima.apisoap.config.retrofit.base.ClientConfiguration;
import pe.com.prima.apisoap.proxy.OpReniecClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class ReniecClientConfiguration extends ClientConfiguration {


    private String msBaseUrl;

    public ReniecClientConfiguration(
            @Value("${prima.restapi.proxy.opReniec.baseUrl}") String msBaseUrl){
        this.msBaseUrl = msBaseUrl;
    }

    @Bean
    OpReniecClient msReniecClientBaseUrl() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(getOkHttpClient())
                .baseUrl(this.msBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(OpReniecClient.class);
    }
   
}
