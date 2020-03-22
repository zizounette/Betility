package com.example.betprobability;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.OkHttpResponseListener;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Response;

import static com.example.betprobability.AppConstants.BASE_URL;

public class RegisterActivity extends BaseActivity {

    private static final String TAG = "RegisterActivity";
    private EditText mEditTextUsername;
    private EditText mEditTextPassword;

    private Button mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mEditTextUsername = findViewById(R.id.editTextReg);
        mEditTextPassword = findViewById(R.id.editText2Reg);
        mRegister = findViewById(R.id.button2Reg);
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });
    }

    private void register() {
        JSONObject request = new JSONObject();
        String username = mEditTextUsername.getText().toString();
        String password = mEditTextPassword.getText().toString();
        try {
            request.put("username",username);
            request.put("password",password);
            request.put("statut","U");

        } catch (JSONException e) {
            Log.e(TAG , "Echec population de l'objet de login " + request, e);
        }
        AndroidNetworking.post(BASE_URL + "/user/register")
                .setPriority(Priority.MEDIUM)
                .setContentType("application/json")
                .addHeaders("Accept","application/json")
                .addJSONObjectBody(request)
                .build()
                .getAsOkHttpResponse(new OkHttpResponseListener() {
                    @Override
                    public void onResponse(Response response) {

                        View view = findViewById(R.id.register_layout);
                        Snackbar.make(view,"Inscription effectuée",Snackbar.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e(TAG, "Echec inscription :" + anError.getErrorDetail() +anError.getErrorBody(), anError.getCause());
                    }
                });

    }
}
