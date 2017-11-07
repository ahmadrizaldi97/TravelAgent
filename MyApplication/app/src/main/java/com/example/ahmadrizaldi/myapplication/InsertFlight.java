package com.example.ahmadrizaldi.myapplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class InsertFlight extends AppCompatActivity {

    EditText editTextName, editTextEmail, editTextWebsite;
    Spinner maskapai;

    String GetName, GetEmail, GetWebsite;
    String FlightID_, Maskapai;

    Button buttonSubmit ;

    String DataParseUrl = "http://arizaldi168.000webhostapp.com/flights/insertbro.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_flight);

        editTextName = (EditText)findViewById(R.id.flightidmaster);
        maskapai = (Spinner) findViewById(R.id.maskapaimaster);

        buttonSubmit = (Button)findViewById(R.id.button2);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                GetDataFromEditText();

                SendDataToServer(FlightID_, Maskapai, GetWebsite);

            }
        });
    }


    public void GetDataFromEditText(){

        GetName = "dsadads";
        GetEmail = "dadadas";
        GetWebsite = "dasdasdasdasdas";
        FlightID_ = editTextName.getText().toString();
        Maskapai = maskapai.getSelectedItem().toString();

    }


    public void SendDataToServer(final String name, final String email, final String website){

        final ProgressDialog progressDialog = new ProgressDialog(InsertFlight.this);
        progressDialog.setMessage("Loading...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();


        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {

                String QuickName = name ;
                String QuickEmail = email ;
                String QuickWebsite = website;

                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                nameValuePairs.add(new BasicNameValuePair("flight_id", QuickName));
                nameValuePairs.add(new BasicNameValuePair("maskapai", QuickEmail));

                try {
                    HttpClient httpClient = new DefaultHttpClient();

                    HttpPost httpPost = new HttpPost(DataParseUrl);

                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = httpClient.execute(httpPost);

                    HttpEntity entity = response.getEntity();


                } catch (ClientProtocolException e) {

                } catch (IOException e) {

                }
                progressDialog.dismiss();
                return "Data Submit Successfully";
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

                Toast.makeText(InsertFlight.this, "Data Submit Successfully", Toast.LENGTH_LONG).show();

            }
        }
        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
        sendPostReqAsyncTask.execute(name, email, website);
    }

}