package com.example.betprobability;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.example.betprobability.com.betprobability.model.User;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONException;
import org.json.JSONObject;

import static android.view.inputmethod.EditorInfo.IME_ACTION_DONE;
import static com.example.betprobability.AppConstants.BASE_URL;

public class LoginActivity extends BaseActivity {

    private static final String TAG = "LoginActivity";
    private EditText mEditTextUsername;
    private EditText mEditTextPassword;
    private Button mButtonSignIn;
    private  Button mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEditTextUsername = findViewById(R.id.editText);
        mEditTextPassword = findViewById(R.id.editText2);
        mEditTextPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == IME_ACTION_DONE) {
                    authenticate();
                    return true;
                }
                return false;
            }
        });
        mButtonSignIn = findViewById(R.id.button);
        mButtonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authenticate();
            }
        });

        mRegister = findViewById(R.id.button2);
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void authenticate() {
        final String username = mEditTextUsername.getText().toString();
        String password = mEditTextPassword.getText().toString();

        //Validation
        mEditTextUsername.setError(null);
        boolean cancel = false;
        View focusView = null;
        if (TextUtils.isEmpty(username)){
            mEditTextUsername.setError("Ce champ est obligatoire");
            cancel = true;
            focusView = mEditTextUsername;
        } else if (!isValidEmail(username)) {
            mEditTextUsername.setError("Veuillez saisir votre email");
            cancel = true;
            focusView = mEditTextUsername;

        }

        if (TextUtils.isEmpty(password)){
            mEditTextPassword.setError("Veuillez saisir votre mot de passe");
            if(!cancel) {
                cancel = true;
                focusView = mEditTextPassword;
            }
        }

        if (cancel) {
            focusView.requestFocus();
            return;
        }

        // Invoquer le service metier
        JSONObject request = new JSONObject();
        try {
            request.put("username",username);
            request.put("password",password);
        } catch (JSONException e) {
            Log.e(TAG , "Echec population de l'objet de login", e);
        }


        AndroidNetworking.post(BASE_URL + "/user/authenticate")
                .setPriority(Priority.MEDIUM)
                .setContentType("application/json")
                .addHeaders("Accept","application/json")
                .addJSONObjectBody(request)
                .build()
                .getAsObject(User.class, new ParsedRequestListener<User>() {
                    @Override
                    public void onResponse(User cust) {
                        if(BuildConfig.DEBUG) {
                            Log.d(TAG,"Authentification OK : " + cust);
                        }
                        //Toast.makeText(LoginActivity.this,"Vous etes connecté",Toast.LENGTH_SHORT).show();
                        View view = findViewById(R.id.login_layout);
                        Snackbar.make(view,"Vous etes connecté",Snackbar.LENGTH_SHORT).show();

                        ((BetApplication)getApplication()).setCustomer(cust);
                        closeKeyboard();

                        LoginActivity.super.mWelcome.setTitle("Bienvenue");

                        onLoginEnded();

                    }

                    @Override
                    public void onError(ANError anError) {
                        //Toast.makeText(LoginActivity.this,"Echec de l'authentification",Toast.LENGTH_SHORT).show();
                        View view = findViewById(R.id.login_layout);
                        Snackbar.make(view,"Echec de l'authentification",Snackbar.LENGTH_SHORT).show();
                    }
                });
    }


    private boolean isValidEmail(String text) {
        return  text.contains("@");
    }

    private void closeKeyboard (){

        View view = getCurrentFocus();
        if(view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),InputMethodManager.RESULT_UNCHANGED_HIDDEN);
        }

    }

    private void onLoginEnded() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}
