package it.pietrantuono.skyitaly.network;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import it.pietrantuono.skyitaly.network.model.User;
import it.pietrantuono.skyitaly.ui.callbacks.ILoginCallback;

public class SkiResortCaller {

    private Context context;
    private ILoginCallback callback;

    private static final String BASE_URL = "http://192.168.1.158:8080/SimpleWSApp/rest/skiresort";

    public SkiResortCaller(Context context, ILoginCallback callback) {
        this.context = context;
        this.callback = callback;
    }
///changePassword
    public void login(String email, String password) {

        String URL = BASE_URL+"/login";
        JSONObject jsonBody = new JSONObject();


        JsonObjectRequest jsonOblect = new JsonObjectRequest(Request.Method.POST, URL, jsonBody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if (response.getInt("code") == 200) {
                        User u = new Gson().fromJson(response.toString(), User.class);
                        callback.loginSuccess(u);
                    }
                    else callback.loginFail();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.e("RESPONSE", "OK");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("RESPONSE", "KO");
            }
        }) {

            @Override
            protected String getParamsEncoding() {
                return "utf-8";
            }

            @Override
            public byte[] getBody() {

                Map<String, String> params = new HashMap<String, String>();
                params.put("email", email);
                params.put("password", password);
                if (params != null && params.size() > 0) {
                    return encodeParameters(params, getParamsEncoding());
                }
                return null;
            }

            @Override
            public String getBodyContentType() {
                // TODO Auto-generated method stub
                return "application/x-www-form-urlencoded";
            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                final Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/x-www-form-urlencoded");
                return headers;
            }

        };
        Volley.newRequestQueue(context.getApplicationContext()).add(jsonOblect);

        // Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_LONG).show();

    }

    public void changePassword(String email, String oldPassword, String newPassword) {

        String URL = BASE_URL+"/changePassword";
        JSONObject jsonBody = new JSONObject();


        JsonObjectRequest jsonOblect = new JsonObjectRequest(Request.Method.POST, URL, jsonBody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if (response.getInt("code") == 200) {
                        User u = new Gson().fromJson(response.toString(), User.class);
                        callback.loginSuccess(u);
                    }
                    else callback.loginFail();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.e("RESPONSE", "OK");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("RESPONSE", "KO");
            }
        }) {

            @Override
            protected String getParamsEncoding() {
                return "utf-8";
            }

            @Override
            public byte[] getBody() {

                Map<String, String> params = new HashMap<String, String>();
                params.put("email", email);
                params.put("password", oldPassword);
                params.put("newPassword", newPassword);
                if (params != null && params.size() > 0) {
                    return encodeParameters(params, getParamsEncoding());
                }
                return null;
            }

            @Override
            public String getBodyContentType() {
                // TODO Auto-generated method stub
                return "application/x-www-form-urlencoded";
            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                final Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/x-www-form-urlencoded");
                return headers;
            }

        };
        Volley.newRequestQueue(context.getApplicationContext()).add(jsonOblect);

        // Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_LONG).show();

    }

    public void recoveryPassword(String email) {

        String URL = BASE_URL+"/changePasswordDefault";
        JSONObject jsonBody = new JSONObject();


        JsonObjectRequest jsonOblect = new JsonObjectRequest(Request.Method.POST, URL, jsonBody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if (response.getInt("code") == 200) {
                        User u = new Gson().fromJson(response.toString(), User.class);
                        callback.loginSuccess(u);
                    }
                    else callback.loginFail();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Log.e("RESPONSE", "OK");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("RESPONSE", "KO");
            }
        }) {

            @Override
            protected String getParamsEncoding() {
                return "utf-8";
            }

            @Override
            public byte[] getBody() {

                Map<String, String> params = new HashMap<String, String>();
                params.put("email", email);
                if (params != null && params.size() > 0) {
                    return encodeParameters(params, getParamsEncoding());
                }
                return null;
            }

            @Override
            public String getBodyContentType() {
                // TODO Auto-generated method stub
                return "application/x-www-form-urlencoded";
            }
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                final Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/x-www-form-urlencoded");
                return headers;
            }

        };
        Volley.newRequestQueue(context.getApplicationContext()).add(jsonOblect);

        // Toast.makeText(getApplicationContext(), "done", Toast.LENGTH_LONG).show();

    }

    private byte[] encodeParameters(Map<String, String> params, String paramsEncoding) {
        StringBuilder encodedParams = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                encodedParams.append(URLEncoder.encode(entry.getKey(), paramsEncoding));
                encodedParams.append('=');
                encodedParams.append(URLEncoder.encode(entry.getValue(), paramsEncoding));
                encodedParams.append('&');
            }
            return encodedParams.toString().getBytes(paramsEncoding);
        } catch (UnsupportedEncodingException uee) {
            throw new RuntimeException("Encoding not supported: " + paramsEncoding, uee);
        }
    }

}
