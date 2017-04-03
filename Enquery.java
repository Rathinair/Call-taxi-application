package com.hibs.GPSRoute;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Pattern;

public class Enquery extends AppCompatActivity {

    EditText e1,e2,e3;
    Button b1;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquery);

        e1=(EditText)findViewById(R.id.ee1);
        e2=(EditText)findViewById(R.id.ee2);
        e3=(EditText)findViewById(R.id.ee3);

        b1=(Button) findViewById(R.id.eb1);

        db=openOrCreateDatabase("SAMPLEGPS", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS query(name VARCHAR,mail VARCHAR,query VARCHAR)");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!Validation()) {
                    db.execSQL("INSERT INTO query VALUES('" + e1.getText() + "','" + e2.getText() + "','" + e3.getText() + "')");
                    showMessage("SUCCESS", "QUERY passed Successfully");
                    clearText();
                }

            }
        });

    }
    private boolean Validation() {
        if(e1.getText().toString().equals("")&&e2.getText().toString().equals("")&&e3.getText().toString().equals(""))
        {
            showMessage("WARNING","please enter the all values");
            return true;
        }

        if(e1.getText().toString().equals(""))
        {
            showMessage("WARNING","please enter Name");
            return true;
        }
        if(e2.getText().toString().equals(""))
        {
            showMessage("WARNING","please enter Mobile Number");
            return true;
        }
//        if(!isValidEmaillId(e2.getText().toString()))
//        {
//            showMessage("WARNING","please enter valid Email");
//            return true;
//        }


        if(e3.getText().toString().equals(""))
        {
            showMessage("WARNING","please enter Comments");
            return true;
        }
        return false;
    }

    public static boolean isValidEmaillId(String email) {

        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
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
        e1.requestFocus();
    }
}
