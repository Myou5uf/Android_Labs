package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.JsonIOException;
import com.squareup.picasso.Picasso;
import com.udacity.sandwichclub.model.Sandwich;
import com.udacity.sandwichclub.utils.JsonUtils;
import org.json.JSONException;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_POSITION = "extra_position";
    private static final int DEFAULT_POSITION = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView ingredientsIv = findViewById(R.id.image_iv);

        Intent intent = getIntent();
        if (intent == null) {
            closeOnError();
        }

        int position = intent.getIntExtra(EXTRA_POSITION, DEFAULT_POSITION);
        if (position == DEFAULT_POSITION) {
            // EXTRA_POSITION not found in intent
            closeOnError();
            return;
        }

        String[] sandwiches = getResources().getStringArray(R.array.sandwich_details);
        String json = sandwiches[position];
        Sandwich sandwich = new Sandwich();
        try {
            sandwich = JsonUtils.parseSandwichJson(json);
            return;
        }
        catch (JsonIOException | JSONException e){
            e.printStackTrace();
            if (sandwich == null){
                closeOnError();
                return;
            }
        }

        populateUI(sandwich);
        Picasso.with(this)
                .load(sandwich.getImage())
                .into(ingredientsIv);

        setTitle(sandwich.getMainName());
    }

    private void closeOnError() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }

    private void populateUI(Sandwich sandwich) {
        TextView decription = findViewById(R.id.description_tv);
        TextView placeoforigin = findViewById(R.id.origin_iv);



        decription.setText(sandwich.getDescription());
        placeoforigin.setText(sandwich.getPlaceOfOrigin());

        RecyclerView rv2 = findViewById(R.id.ingredients_tv2);
        rv2.setLayoutManager(new LinearLayoutManager(this));
        rv2.setAdapter(new RviewAdapter2(this, sandwich.getIngredients()));
    }
}
