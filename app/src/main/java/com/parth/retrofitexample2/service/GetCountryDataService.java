package com.parth.retrofitexample2.service;



import com.parth.retrofitexample2.model.Info;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface GetCountryDataService {

    @Headers({
            "x-rapidapi-host: restcountries-v1.p.rapidapi.com",
            "x-rapidapi-key: b7d78ad850msh82310f831b8231bp185fadjsn933f400ac321"
    })
    @GET("alpha/{init}")
    Call<Info> getCountryName(@Path("init")String initialOfCountry);

}
