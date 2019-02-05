package org.pursuit.fragmentappfromscratch.controller;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.fragmentappfromscratch.DetailActivity;
import org.pursuit.fragmentappfromscratch.R;
import org.pursuit.fragmentappfromscratch.model.Planet;

public class PlanetHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView planetName;
    private TextView planetNumber;
    private ImageView planetImage;
    PlanetAdapter planetAdapter;
    Context context;

    public PlanetHolder(@NonNull View itemView) {
        super(itemView);

        itemView.setOnClickListener(this);
        context = itemView.getContext();

        planetName = itemView.findViewById(R.id.name);
        planetNumber = itemView.findViewById(R.id.number);
        planetImage = itemView.findViewById(R.id.image);

    }

    public void onBind(Planet planet) {
        planetName.setText(planet.getName());
        planetNumber.setText(String.valueOf(planet.getNumber()));

        Picasso.with(itemView.getContext())
                .load(planet.getImage())
                .into(planetImage);
    }

    @Override
    public void onClick(View v) {
        int position = getAdapterPosition();
        Planet planetItem = planetAdapter.planetList.get(position);

        Intent detailIntent = new Intent(context, DetailActivity.class);
        detailIntent.putExtra("name", planetItem.getName());
        detailIntent.putExtra("number", String.valueOf(planetItem.getNumber()));
        detailIntent.putExtra("image", planetItem.getImage());
        context.startActivity(detailIntent);
    }
}
