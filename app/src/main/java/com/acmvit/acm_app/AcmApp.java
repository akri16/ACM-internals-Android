package com.acmvit.acm_app;

import android.app.Application;
import android.content.IntentFilter;
import android.net.ConnectivityManager;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.acmvit.acm_app.pref.SessionManager;
import com.acmvit.acm_app.service.NetworkChangeReceiver;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class AcmApp extends Application {
    private GoogleSignInClient mGoogleSignInClient;
    private static SessionManager sessionManager;
    private static final MutableLiveData<Boolean> isConnected = new MutableLiveData<>(false);

    @Override
    public void onCreate() {
        super.onCreate();

        //Setup SessionManager
        sessionManager = new SessionManager(this);

        //Google SignIn Setup
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.google_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        //Init Connection status
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        setIsConnected(connectivityManager.getActiveNetworkInfo().isConnected());
        registerReceiver(new NetworkChangeReceiver(),
                new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    public GoogleSignInClient getmGoogleSignInClient() {
        return mGoogleSignInClient;
    }

    public static SessionManager getSessionManager() {
        return sessionManager;
    }

    public static void setIsConnected(boolean isConnected) {
        AcmApp.isConnected.setValue(isConnected);
    }

    public static LiveData<Boolean> getIsConnected() {
        return isConnected;
    }

    public static boolean getIsConnectedOneTime(){
        return isConnected.getValue();
    }

}
