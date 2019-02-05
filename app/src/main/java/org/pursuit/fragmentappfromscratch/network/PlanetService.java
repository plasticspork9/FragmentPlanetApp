package org.pursuit.fragmentappfromscratch.network;

import org.pursuit.fragmentappfromscratch.model.PlanetResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PlanetService {
    @GET("/JDVila/storybook/master/planets.json")
    Call<PlanetResponse> getPlanetsList();
}
