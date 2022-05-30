package it.pietrantuono.skyitaly.network;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class WeatherCaller {

    private static final String BASE_URL = "http://api.weatherunlocked.com/api/current/";
    private double lat, lon;
    private Context context;

    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private static final String appId = "04da659a";
    private static final String appKey = "1012ea349f09bef3f08042a08be061a1";
    private Response.Listener<String> responseListener;
    private Response.ErrorListener errorListener;
    private String url;

    public WeatherCaller(double lat, double lon, Context context, Response.Listener<String> responseListener, Response.ErrorListener errorListener){
        this.lat = lat;
        this.lon = lon;
        this.responseListener = responseListener;
        this.errorListener = errorListener;
        buildUrl();

    }

    private void buildUrl(){
        url = BASE_URL+lat+","+lon+"?app_id="+appId+"&app_key="+appKey;
    }

    public void call(){
        mRequestQueue = Volley.newRequestQueue(context);
        mStringRequest = new StringRequest(Request.Method.GET, url, responseListener, errorListener);
        mRequestQueue.add(mStringRequest);
    }

}
