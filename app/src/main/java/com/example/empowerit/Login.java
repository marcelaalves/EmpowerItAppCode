package com.example.empowerit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Login extends Activity {
    EditText user;
    EditText pass;
    CheckBox isWob;
    TextView loginError;
    LinearLayout register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //  getActionBar().setDisplayHomeAsUpEnabled(true);
        Button b = (Button) findViewById(R.id.btnLogin);
        user = (EditText) findViewById(R.id.user_name);
        pass = (EditText) findViewById(R.id.password);
        register = (LinearLayout)findViewById(R.id.btn_register);

        register.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, RegistrationActivity.class);
                startActivity(i);
            }
        });
        loginError = (TextView) findViewById(R.id.login_error);
        b.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if ((user.getText().length() > 0)
                        && (pass.getText().length() > 0)) {

                    if (authentWob()) {
                        loginError.setVisibility(View.INVISIBLE);
                        Intent i = new Intent(Login.this, WobMainActivity.class);
                        startActivity(i);
                    } else if(authentCoorp()){
                        loginError.setVisibility(View.INVISIBLE);
                        Intent i = new Intent(Login.this, CoopMainActivity.class);
                        startActivity(i);
                    }else
                    {
                        loginError.setVisibility(View.VISIBLE);
                    }

                } else {
                    loginError.setText("Empty fields are not accepted");
                    loginError.setVisibility(View.VISIBLE);
                }
            }

        });




    }

    private boolean authentWob() {
        return user.getText().toString().equals("wob@test.com")
                && pass.getText().toString().equals("password");


    }

    private boolean authentCoorp() {
        return user.getText().toString().equals("coorp@test.com")
                && pass.getText().toString().equals("password");


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
