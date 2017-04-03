package com.hibs.GPSRoute;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    Button b1,b2,b3,b4,b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        b1=(Button)findViewById(R.id.tb1);
        b2=(Button)findViewById(R.id.tb2);
        b3=(Button)findViewById(R.id.tb3);
        b4=(Button)findViewById(R.id.tb4);
        b5=(Button)findViewById(R.id.tb5);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in=new Intent(Home.this,Bookcar.class);
                startActivity(in);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in3=new Intent(Home.this,Feedback.class);
                startActivity(in3);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in2=new Intent(Home.this,Enquery.class);
                startActivity(in2);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in1=new Intent(Home.this,Location.class);
                startActivity(in1);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in4=new Intent(Home.this,Rent.class);
                startActivity(in4);
            }
        });
    }
}
