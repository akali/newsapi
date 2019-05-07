package kz.mathncode.newsapi;

import kz.mathncode.newsapi.model.NewsResponse;
import kz.mathncode.newsapi.model.RequestParams;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

import java.util.Map;

public class NewsAPI {
    private static final String BASE_URL = "https://newsapi.org/";
    private String accessToken;
    private Retrofit retrofit;
    private APIInterface api;

    public NewsAPI(String accessToken) {
        this.accessToken = accessToken;

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        api = retrofit.create(APIInterface.class);
    }

    public void getEverything(
            RequestParams params,
            Callback<NewsResponse> callback
    ) {
        params.setApiKey(this.accessToken);

        api.getEverything(params.map()).enqueue(callback);
    }

    public void getTopHeadlines(
            RequestParams params,
            Callback<NewsResponse> callback
    ) {
        params.setApiKey(this.accessToken);

        api.getTopHeadlines(params.map()).enqueue(callback);
    }

    public interface APIInterface {
        @GET("/v2/everything")
        Call<NewsResponse> getEverything(@QueryMap Map<String, String> params);

        @GET("/v2/top-headlines")
        Call<NewsResponse> getTopHeadlines(@QueryMap Map<String, String> params);
    }
}
