package it.pietrantuono.skyitaly.network;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;


import it.pietrantuono.skyitaly.network.model.BaseResponse;
import it.pietrantuono.skyitaly.network.model.PlantsList;
import it.pietrantuono.skyitaly.network.model.SkiResortList;
import it.pietrantuono.skyitaly.ui.callbacks.IListPlantCallback;
import it.pietrantuono.skyitaly.ui.callbacks.ISkiResortCallback;

public class SkiResortCaller {

    private Context context;
    private ISkiResortCallback callback;
    private IListPlantCallback plantCallback;
    private static final String BASE_URL = "http://192.168.1.158:8080/SimpleWSApp/rest/skiresort";


    public SkiResortCaller(Context context, ISkiResortCallback callback) {
        this.context = context;
        this.callback = callback;
    }

    public SkiResortCaller(Context context, IListPlantCallback callback) {
        this.context = context;
        this.plantCallback = callback;
    }

    public void getSkiResorts(int userId, int type){
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = BASE_URL+"/skiResortList?userId="+userId+"&"+"favorite="+type;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        SkiResortList skiResponse = new Gson().fromJson(response, SkiResortList.class);
                        if (skiResponse.getCode() == 200) {
                            callback.getSkiResorts(skiResponse.getListSkiMap());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("SkiResortList", error.getMessage());
            }
        });
        queue.add(stringRequest);

    }


    public void getListPlants(int skiMapId){
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = BASE_URL+"/plantList?skiMapId="+skiMapId;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        PlantsList plantsList = new Gson().fromJson(response, PlantsList.class);
                        if (plantsList.getCode() == 200) {
                            plantCallback.onListPlant(plantsList.getPlants());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("SkiResortList", error.getMessage());
            }
        });
        queue.add(stringRequest);

    }


    public void addRemoveFavorite(int userId, int skiMapId){
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = BASE_URL+"/addRemoveFavourite?userId="+userId+"&"+"skiMapId="+skiMapId;

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        BaseResponse base = new Gson().fromJson(response, BaseResponse.class);
                        if (base.getCode() == 200) {
                           // callback.onListPlant(plantsList.getListPlant());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("SkiResortList", error.getMessage());
            }
        });
        queue.add(stringRequest);

    }
}
