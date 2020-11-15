package com.example.laba_4_sandwichclub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    TextView tv_from;
    TextView tv_color;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.id_tv);
        tv_from = findViewById(R.id.id_tv_from);
        tv_color = findViewById(R.id.id_tv_color);

        Cat murzik = new Cat();
        murzik.name = "Мурзик";
        murzik.age = 4;
        murzik.color = Color.RED;

        // Конвертация экземпляра класс Cat в JSON
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Log.i("GSON", gson.toJson(murzik));
        String text_gson = gson.toJson(murzik).toString();
        tv.setText(text_gson);

        // Конвертация JSON в объект
        String jsonText = "{'name':'Мурзик','color':-16777216,'age':8}";
        Cat barsik = gson.fromJson(jsonText, Cat.class);
        Log.i("GSON","Имя: " + barsik.name + "\nВозраст: " + barsik.age);
        tv_from.setText("Кот: " + barsik.name + ", " + barsik.age + " лет, " + " цвет: ");
        // Добавил компонент Textview и закрасил его цветом кота.
        tv_color.setBackgroundColor(barsik.color);

    }
}