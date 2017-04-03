package com.hibs.GPSRoute;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hibs.GPSRoute.Activities.Login;

public class Regist extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6,e7;
    Button btn1;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        e1=(EditText)findViewById(R.id.rege1);
        e2=(EditText)findViewById(R.id.rege2);
        e3=(EditText)findViewById(R.id.rege3);
        e4=(EditText)findViewById(R.id.rege4);
        e5=(EditText)findViewById(R.id.rege5);
        e6=(EditText)findViewById(R.id.rege6);
        e7=(EditText)findViewById(R.id.rege7);

        btn1=(Button)findViewById(R.id.regb1);

        db=openOrCreateDatabase("Driver", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS drive1(id VARCHAR,name VARCHAR,username VARCHAR,password VARCHAR);");

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (e2.getText().toString().length()==0&&e3.getText().toString().length()==0&&e4.getText().toString().length()==0&&e5.getText().toString().length()==0&&e6.getText().toString().length()==0&&e7.getText().toString().length()==0)
                {
                    showMessage("ERROR","please enter all the values");
                    return;
                }
//                if (e1.getText().toString().length()==0)
//                {
//                    showMessage("ERROR","please enter UserID");
//                    return;
//                }

                if (e2.getText().toString().length()==0)
                {
                    showMessage("ERROR","please enter Name");
                    return;
                }

                if (e3.getText().toString().length()==0)
                {
                    showMessage("ERROR","please enter Age");
                    return;
                }

                if (e4.getText().toString().length()==0)
                {
                    showMessage("ERROR","please enter Mobile No");
                    return;
                }

                if (e5.getText().toString().length()==0)
                {
                    showMessage("ERROR","please enter Address");
                    return;
                }

                if (e6.getText().toString().length()==0)
                {
                    showMessage("ERROR","please enter UserName");
                    return;
                }

                if (e7.getText().toString().length()==0)
                {
                    showMessage("ERROR","please enter Password");
                    return;
                }

                db.execSQL("INSERT INTO drive1 VALUES('"+e1.getText()+"','"+e2.getText()+"','"+e6.getText()+"','"+e7.getText()+"')");
                showMessage("SUCCESS","Record Inserted");
                clearText();
                Intent in=new Intent(Regist.this,Sample.class);
                startActivity(in);
                finish();
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
        e7.setText("");

        e1.requestFocus();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            onBackPressed();
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }
}
