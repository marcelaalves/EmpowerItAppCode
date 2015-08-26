package com.example.empowerit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Marcela on 26/08/15.
 */
public class RegistrationActivity extends Activity {

   LinearLayout newRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        newRegister = (LinearLayout)findViewById(R.id.btn_register);
        newRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegistrationActivity.this, Login.class);
                startActivity(i);
                finish();

            }
        });

    }

}
