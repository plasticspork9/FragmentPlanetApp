package org.pursuit.fragmentappfromscratch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.pursuit.fragmentappfromscratch.controller.PlanetAdapter;
import org.pursuit.fragmentappfromscratch.model.Planet;
import org.pursuit.fragmentappfromscratch.model.PlanetResponse;
import org.pursuit.fragmentappfromscratch.network.ApiUtil;
import org.pursuit.fragmentappfromscratch.network.PlanetService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private PlanetService planetService;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        planetService = ApiUtil.getApiService();

        retrofitCall();

    }

    public void retrofitCall(){
        planetService.getPlanetsList().enqueue(new Callback<PlanetResponse>() {
            @Override
            public void onResponse(Call<PlanetResponse> call, Response<PlanetResponse> response) {
                List<Planet> planets = response.body().getPlanets();

                Log.d("SAMER", String.valueOf(planets.size()));

                setRecyclerView(planets);
            }

            @Override
            public void onFailure(Call<PlanetResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void setRecyclerView(List<Planet> planetList) {
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new PlanetAdapter(planetList));
    }
}
