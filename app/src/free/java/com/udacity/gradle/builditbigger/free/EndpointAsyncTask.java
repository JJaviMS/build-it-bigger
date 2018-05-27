package com.udacity.gradle.builditbigger.free;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.android.gms.ads.InterstitialAd;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by JjaviMS on 23/05/2018.
 *
 * @author JJaviMS
 */
public class EndpointAsyncTask extends AsyncTask<Context,Void,String> {
    private static MyApi sMyApi = null;
    private Context mContext;

    @SafeVarargs
    @Override
    protected final String doInBackground(Context... pairs) {
        if (sMyApi==null){
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),new AndroidJsonFactory(),null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            sMyApi = builder.build();

        }
        mContext = pairs[0];

        try {
            return sMyApi.putJoke().execute().getJokes();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(mContext,s,Toast.LENGTH_LONG).show();

    }

}
