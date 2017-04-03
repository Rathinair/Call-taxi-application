package com.hibs.GPSRoute;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.hibs.GPSRoute.Pojo.BookedCar;

import java.util.ArrayList;

/**
 * Created by Thanvandh on 3/2/2017.
 */
public class BookedCarsAdapter extends RecyclerView.Adapter<BookedCarsAdapter.ViewHolder> {
    BookedCarsActivity bookedCarsActivity;
    ArrayList<BookedCar> bookedCars;

    BookedCarsAdapter(BookedCarsActivity bookedCarsActivity, ArrayList<BookedCar> bookedCars) {
        this.bookedCarsActivity = bookedCarsActivity;
        this.bookedCars = bookedCars;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(bookedCarsActivity).inflate(R.layout.item_booked_cars, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        BookedCar bookedCar = bookedCars.get(position);
        holder.tvName.setText(bookedCar.getName());
        holder.tvRout.setText(bookedCar.getSource() + " - " + bookedCar.getDestination());
    }

    @Override
    public int getItemCount() {
        return bookedCars.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvName;
        TextView tvRout;
        Button btnCancel;

        ViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvRout = (TextView) itemView.findViewById(R.id.tvRout);
            btnCancel = (Button) itemView.findViewById(R.id.btnCancel);
            btnCancel.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v == btnCancel) {
                bookedCarsActivity.cancel(getAdapterPosition());
            }
        }
    }
}
