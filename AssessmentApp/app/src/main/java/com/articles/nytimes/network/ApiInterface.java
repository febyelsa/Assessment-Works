package com.articles.nytimes.network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("svc/mostpopular/v2/viewed/1.json?api-key=0EBHYo0y3Icj0vK3lo3AYPpbl7cSTu02")
    Call<ServiceResponse> getArticlesList();
}
