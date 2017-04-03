package com.hibs.GPSRoute;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.hibs.GPSRoute.Database.SqliteBooking;
import com.hibs.GPSRoute.Database.SqliteContacts;

import java.util.Calendar;

public class Bookcar extends AppCompatActivity {


    EditText e1, e2, e3, e4, e5, e6, e7;
    Button b1;
    SqliteBooking db;
    private EditText edt_date;
    private int mYear, mMonth, mDay, mHour, mMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookcar);

        e1 = (EditText) findViewById(R.id.bke1);
        e2 = (EditText) findViewById(R.id.bke2);
        e3 = (EditText) findViewById(R.id.bke3);
        e4 = (EditText) findViewById(R.id.bke4);
        e5 = (EditText) findViewById(R.id.bke5);
        e6 = (EditText) findViewById(R.id.bke6);
        e7 = (EditText) findViewById(R.id.bke7);
        b1 = (Button) findViewById(R.id.bkb1);
        edt_date = (EditText) findViewById(R.id.edt_date);

        db = new SqliteBooking(this);
        e4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(Bookcar.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                e4.setText(hourOfDay + ":" + minute);
                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();
            }
        });

        edt_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(Bookcar.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                edt_date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (e1.getText().toString().equals("") && e2.getText().toString().equals("") && e3.getText().toString().equals("") && edt_date.getText().toString().equals("") && e4.getText().toString().equals("") && e5.getText().toString().equals("") && e6.getText().toString().equals("") && e7.getText().toString().equals("")) {
                    showMessage("WARNING", "please enter the all values");
                    return;
                }
                if (e1.getText().toString().equals("")) {
                    showMessage("WARNING", "please enter your Name");
                    return;
                }
                if (e2.getText().toString().equals("")) {
                    showMessage("WARNING", "please enter your Source");
                    return;
                }
                if (e3.getText().toString().equals("")) {
                    showMessage("WARNING", "please enter your Destination");
                    return;
                }
                if (edt_date.getText().toString().equals("")) {
                    showMessage("WARNING", "please enter your Date of Journey");
                    return;
                }
                if (e4.getText().toString().equals("")) {
                    showMessage("WARNING", "please enter your Time of Journey");
                    return;
                }
                if (e5.getText().toString().equals("")) {
                    showMessage("WARNING", "please enter No of Persons to Travel");
                    return;
                }
//                if (e6.getText().toString().equals(""))
//                {
//                    showMessage("WARNING", "please enter your TrackNo");
//                    return;
//                }
                if (e7.getText().toString().equals("")) {
                    showMessage("WARNING", "please enter your Mobile Number");
                    return;
                }

                db.book(e1.getText().toString(), e2.getText().toString(), e3.getText().toString(), e4.getText().toString(), e5.getText().toString(), e6.getText().toString(), e7.getText().toString());

/*                db.execSQL("INSERT INTO " + SqliteBooking.tBooking + " VALUES('" + e1.getText() + "','" + e2.getText() + "','" + e3.getText() + "','" + e4.getText() + "','" + e5.getText() + "','" + e6.getText() + "','" + e7.getText() + "')");
                showMessage("SUCCESS", "Record added Successfully");
                clearText();*/

                showMessage("SUCCESS", "Record added Successfully");
                clearText();

            }
        });

    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }

    public static final int MENU_VIEW = Menu.FIRST;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, MENU_VIEW, Menu.NONE, "View");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_VIEW:
                Intent intent = new Intent(Bookcar.this, BookedCarsActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void clearText() {
        e1.setText("");
        e2.setText("");
        e3.setText("");
        e4.setText("");
        e5.setText("");
        e6.setText("");
        e7.setText("");
        e1.requestFocus();
    }
}
