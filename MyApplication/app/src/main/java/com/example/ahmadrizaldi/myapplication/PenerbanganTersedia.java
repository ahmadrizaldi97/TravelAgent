package com.example.ahmadrizaldi.myapplication;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PenerbanganTersedia extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private List<Airline> movies;
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayout;
    private RecyclerView.LayoutManager layoutManager;
    private ArlineAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penerbangan_tersedia);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        movies = new ArrayList<>();
        getMoviesFromDB(0);


        gridLayout = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayout);

        adapter = new ArlineAdapter(PenerbanganTersedia.this, movies);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                if (gridLayout.findLastCompletelyVisibleItemPosition() == movies.size() - 1) {
                    getMoviesFromDB(movies.get(movies.size() - 1).getId_f());
                }

            }
        });
    }

    private void getMoviesFromDB(int id) {

        AsyncTask<Integer, Void, Void> asyncTask = new AsyncTask<Integer, Void, Void>() {
            @Override
            protected Void doInBackground(Integer... movieIds) {

                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("http://192.168.43.181/detail_flights.php")
                        .build();
                try {
                    Response response = client.newCall(request).execute();

                    JSONArray array = new JSONArray(response.body().string());

                    for (int i = 0; i < array.length(); i++) {

                        JSONObject object = array.getJSONObject(i);

                        Airline movie = new Airline(object.getInt("id_f"), object.getString("flight_id"),
                                object.getString("dates"), object.getString("from_"), object.getString("to_"),
                                object.getInt("hargae"), object.getInt("hargab"), object.getInt("hargaf"), object.getInt("kuotae"),
                                object.getInt("kuotab"), object.getInt("kuotaf"), object.getString("jamberangkat"), object.getString("jamtiba"), object.getString("destinasike"));

                        PenerbanganTersedia.this.movies.add(movie);
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                adapter.notifyDataSetChanged();
            }
        };

        asyncTask.execute(id);
    }

}
