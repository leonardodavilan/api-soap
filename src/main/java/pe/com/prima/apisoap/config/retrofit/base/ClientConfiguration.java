package pe.com.prima.apisoap.config.retrofit.base;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class ClientConfiguration {

    protected OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient
                .Builder();
        this.addErrorHandlerInterceptor(okHttpClientBuilder);
        return okHttpClientBuilder.build();
    }

    protected void addErrorHandlerInterceptor(OkHttpClient.Builder builder) {
        Interceptor interceptor = (chain) -> {
            Request request = chain.request();
            return chain.proceed(request);
        };
        builder.addInterceptor(interceptor);
    }

}
