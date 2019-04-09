package com.example.ame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.database.sqlite.SQLiteDatabase;


public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText password;
    private TextView login;
    private int counter=3;
    private TextView olvido;
    private TextView registate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name= (EditText)findViewById(R.id.txtusuario);
        password=(EditText)findViewById(R.id.txtcontraseña);
        login=(TextView) findViewById(R.id.textViewingre);
        olvido =(TextView) findViewById(R.id.textViewolvido);
        registate =(TextView) findViewById(R.id.textViewregistrate);


        registate.setText("Registrate: 5");


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(name.getText().toString(),password.getText().toString());
            }
        });

    }
    private void validate(String username, String userpassword){
        if ((username.equals("america")) &&(userpassword.equals("1234") )){
            Intent intent = new Intent(MainActivity.this, MenuActivity.class);
            startActivity(intent);
        }else {
            counter--;
            registate.setText("tiene que registrarse: "+ String.valueOf(counter));
            if(counter==0){
                login.setEnabled(false);
            }

        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
