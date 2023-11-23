package pe.com.prima.apisoap.config.retrofit.base;

import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

@Slf4j
public class ProxyConsumer {

    public static <T> T consume(Call<T> proxyCaller) throws Exception {
        log.info("[ProxyConsumer] - consume {} ", proxyCaller.request());
        try {
            Response<T> proxyResponse = proxyCaller.execute();
            return proxyResponse.body();
        } catch (IOException ex) {
            log.error(ex.getMessage(), ex);
            throw new Exception();
        } catch(Exception e) {
            log.error(e.getMessage());
            throw new Exception();
        }
    }

}

