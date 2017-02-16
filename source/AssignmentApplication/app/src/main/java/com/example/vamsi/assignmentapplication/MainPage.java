package com.example.vamsi.assignmentapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainPage extends AppCompatActivity {
    EditText Textsearch = (EditText) findViewById(R.id.editText2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void web1 (View V)
    {
        String SearchQuery =Textsearch.getText().toString();
        String Url = "https://kgsearch.googleapis.com/v1/entities:search?query=" + Textsearch.getText().toString() +
                "&key=AIzaSyB82KHibkqFCPiYbTs-G_Z60Y-YjM2dEU8&limit=1&indent=True";
        OkHttpClient Client = new OkHttpClient ();
        Request request = new Request.Builder()
                .url(Url)
                .build();
        Client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final JSONObject jsonResult;
                final String result =response.body().string();
                final ImageView image = (ImageView) findViewById (R.id.imageView);

                try {
                    jsonResult = new JSONObject(result);
                    JSONArray convertedTextArray = jsonResult.getJSONArray("itemListElement");
                    final String cText;
                    cText=convertedTextArray.getJSONObject(0).getJSONObject ("result").getJSONObject ("image").get ("contentUrl").toString ();
                    runOnUiThread (new Runnable ( ) {
                        @Override
                        public void run() {
                            Picasso.with (getApplicationContext ())
                                    .load(cText)
                                    .into(image);
                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace ( );
                }
            }
        });

    }

}
