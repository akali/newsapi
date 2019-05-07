package kz.mathncode;

import android.util.Log;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;

import kz.mathncode.model.Category;
import kz.mathncode.model.Country;
import kz.mathncode.model.NewsResponse;
import kz.mathncode.model.RequestParams;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void newsTest() throws InterruptedException {
        NewsAPI api = new NewsAPI("*********");

        api.getTopHeadlines(
                RequestParams
                        .newBuilder()
                        .setCountry(Country.RU)
                        .setCategory(Category.TECHNOLOGY)
                        .build(), new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                System.err.println(t.getMessage());
            }
        });

        Thread.sleep(9000);

    }
}