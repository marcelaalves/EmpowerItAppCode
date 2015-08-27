package com.example.empowerit;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.smartcanvas.Smartcanvas;
import com.smartcanvas.model.Card;

import org.jose4j.lang.JoseException;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Marcela on 26/08/15.
 */
public class RegistrationActivity extends Activity implements View.OnClickListener {
    EditText company_name;
    EditText user_name;
    EditText password;
    EditText password2;

    private static final String CLIENT_ID = "kMRaR35PmKwZRqtEfznNkQUaiitKr0Ij";
    private static final String CLIENT_SECRET = "rX8DZ5CfrFrMFhtmwaUWxMptC3UiqWvd";
    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    private static final JsonFactory JSON_FACTORY = new JacksonFactory();

    Smartcanvas smartcanvas;


    LinearLayout newRegister;

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        finds();

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {
            smartcanvas = new Smartcanvas(HTTP_TRANSPORT, JSON_FACTORY, CLIENT_ID, CLIENT_SECRET);
        } catch (JoseException e) {
            e.printStackTrace();
        }

        newRegister.setOnClickListener(this);

    }

    private void finds() {
        newRegister = (LinearLayout) findViewById(R.id.btn_register);
        company_name = (EditText) findViewById(R.id.company_name);
        user_name = (EditText) findViewById(R.id.user_name);
        password = (EditText) findViewById(R.id.password);
        password2 = (EditText) findViewById(R.id.password2);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_register) {

            extractFieldsAndIntent();


        }
    }

    private void extractFieldsAndIntent() {
        Date date = new Date();
        DateTime dateTime = new DateTime(date);

        Card.Author author = new Card.Author();
        author.setDisplayName(company_name.getText().toString());
        author.setImageURL("http://www.pubzi.com/f/731147-sm-731131-Cartoon-Flower.png");

        Card buildCard = Card.newBuilder()
                .withTitle(company_name.getText().toString())
                .withAuthor(new Card.Author())
                .withContentProvider(new Card.ContentProvider("123", "123", "123"))
                .withContent(user_name.getText().toString())
                .build();
        buildCard.setCreateDate(dateTime);

        try {
            smartcanvas.cards().insert(buildCard);
            Toast.makeText(this, R.string.success_card_insert, Toast.LENGTH_SHORT).show();
            Intent i = new Intent(RegistrationActivity.this, Login.class);
            startActivity(i);
            finish();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, R.string.erro_card_insert, Toast.LENGTH_SHORT).show();
        }
    }
}
