package com.example.litho.picasso;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.litho.picasso.Litho.Components.ListSection;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.litho.sections.SectionContext;
import com.facebook.litho.sections.widget.RecyclerCollectionComponent;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.example.litho.picasso.Model.DataModel;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ComponentContext context = new ComponentContext(this);

        String data = getAssetJsonData(getApplicationContext());

        Type listType = new TypeToken<ArrayList<DataModel>>(){}.getType();

        List<DataModel> modelObjects = new Gson().fromJson(data, listType);

        final Component component =
                RecyclerCollectionComponent.create(context)
                        .disablePTR(true)
                        .section(ListSection.create(new SectionContext(context)).dataModels(modelObjects)).build();

        setContentView(LithoView.create(this,component));
    }

    public static String getAssetJsonData(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("Data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        Log.e("data", json);
        return json;

    }

}

