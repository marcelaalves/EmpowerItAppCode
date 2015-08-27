package com.example.empowerit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.testing.json.MockJsonFactory;
import com.google.api.client.util.DateTime;
import com.smartcanvas.Smartcanvas;
import com.smartcanvas.model.Card;

import org.jose4j.lang.JoseException;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Marcela on 26/08/15.
 */
public class RegistrationActivity extends Activity {

    LinearLayout newRegister;
    Smartcanvas smartcanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        try {


            Smartcanvas smartcanvas = new Smartcanvas(new NetHttpTransport(), new MockJsonFactory(), Credential.cliente_id, Credential.access_token);
            Card card = new Card(givenProvider());
            String s = card.getSummary();
            Card.Author author = new Card.Author();
            author.setDisplayName("Marcela Alves");
            author.setImageURL("http://www.pubzi.com/f/731147-sm-731131-Cartoon-Flower.png");
           card.setAuthor(author);
            Date date = new Date(); // java.util.Date; - This date has both the date and time in it already.
            DateTime dateTime = new DateTime(date);
            card.setCreateDate(dateTime);
            card.setId(Long.valueOf(1234));
            card.setContent("App Company");
            card.setTitle("EmpowerIT");
            smartcanvas.cards().insert(card);
            Card newCard = smartcanvas.cards().get(Long.valueOf(1234));


        } catch (JoseException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        newRegister = (LinearLayout) findViewById(R.id.btn_register);
        newRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegistrationActivity.this, Login.class);
                startActivity(i);
                finish();

            }
        });

    }

    private Card.ContentProvider givenProvider() {
        return new Card.ContentProvider("ID provider", "GooglePlus", "Content ID");
    }


}
