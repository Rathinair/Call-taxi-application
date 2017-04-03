package com.hibs.GPSRoute;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.hibs.GPSRoute.Database.SqliteBooking;
import com.hibs.GPSRoute.Pojo.BookedCar;

import java.util.ArrayList;

public class BookedCarsActivity extends AppCompatActivity {

    RecyclerView rvBookedCars;
    BookedCarsAdapter bookedCarsAdapter;
    SqliteBooking db;
    ArrayList<BookedCar> bookedCars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booked_cars);

        rvBookedCars = (RecyclerView) findViewById(R.id.rvBookedCars);

        db = new SqliteBooking(BookedCarsActivity.this);
        bookedCars = db.getBookedCars();

        bookedCarsAdapter = new BookedCarsAdapter(BookedCarsActivity.this, bookedCars);
        rvBookedCars.setAdapter(bookedCarsAdapter);
    }

    void reload() {
        bookedCars = db.getBookedCars();
        bookedCarsAdapter = new BookedCarsAdapter(BookedCarsActivity.this, bookedCars);
        rvBookedCars.setAdapter(bookedCarsAdapter);
    }

    public void cancel(int position) {
        String bookingId = bookedCars.get(position).getBooking_id();
        db.cancelBooking(bookingId);
        reload();
    }

}
