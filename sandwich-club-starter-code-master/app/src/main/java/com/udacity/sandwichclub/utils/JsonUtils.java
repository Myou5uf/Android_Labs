package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;
import java.util.ArrayList;
import  java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException{
        String mName, mPlase, mDescription, mImage;
        List<String> alsoList = new ArrayList<>(), ingredientsList = new ArrayList<>();
        JSONObject mJson = new JSONObject(json);
        JSONObject name = mJson.getJSONObject("name");
        mName = name.getString("mainName");
        JSONArray alsoKnownAsArray = name.getJSONArray("alsoKnownAs");
        if (alsoKnownAsArray != null) {
            for (int i = 0; i < alsoKnownAsArray.length(); i++) {
                alsoList.add(alsoKnownAsArray.getString(i));
            }
        }
        JSONArray ingredients = mJson.getJSONArray("ingredients");
        if (ingredients != null) { for (int i = 0; i < ingredients.length(); i++)
            ingredientsList.add(ingredients.getString(i));
        }
        mPlase = mJson.getString("placeOfOrigin");
        mDescription = mJson.getString("description");
        mImage = mJson.getString("image");
        return new Sandwich(mName, alsoList, mPlase, mDescription, mImage, ingredientsList);
    }
}
