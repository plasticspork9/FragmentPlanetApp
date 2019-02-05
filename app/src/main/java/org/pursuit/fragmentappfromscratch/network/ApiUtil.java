package org.pursuit.fragmentappfromscratch.network;

public class ApiUtil {
    public static final String BASE_URL = "https://raw.githubusercontent.com/";

    public static PlanetService getApiService(){

        return RetrofitSingleton.getRetrofit(BASE_URL).create(PlanetService.class);

    }
}
