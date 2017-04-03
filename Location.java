package com.hibs.GPSRoute;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Location extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5,e6;
    Button b1;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        e1=(EditText)findViewById(R.id.le1);
        e2=(EditText)findViewById(R.id.le2);
        e3=(EditText)findViewById(R.id.le3);
        e4=(EditText)findViewById(R.id.le4);
        e5=(EditText)findViewById(R.id.le5);
        e6=(EditText)findViewById(R.id.le6);
        b1=(Button) findViewById(R.id.lb1);


        db=openOrCreateDatabase("SAMPLEGPS", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS locate(persons VARCHAR,source VARCHAR,destination VARCHAR,date VARCHAR,time VARCHAR,mobile VARCHAR)");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(e1.getText().toString().equals("")&&e2.getText().toString().equals("")&&e3.getText().toString().equals("")&&e4.getText().toString().equals("")&&e5.getText().toString().equals("")&&e6.getText().toString().equals(""))
                {
                    showMessage("WARNING","please enter the all values");
                    return;
                }
                db.execSQL("INSERT INTO locate VALUES('"+e1.getText()+"','"+e2.getText()+"','"+e3.getText()+"','"+e4.getText()+"','"+e5.getText()+"','"+e6.getText()+"')");
                showMessage("SUCCESS","LOCATION  get Successfully");
                clearText();

            }
        });

    }
    public  void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }

    public void clearText()
    {
        e1.setText("");
        e2.setText("");
        e3.setText("");
        e4.setText("");
        e5.setText("");
        e6.setText("");
        e1.requestFocus();
    }
}
