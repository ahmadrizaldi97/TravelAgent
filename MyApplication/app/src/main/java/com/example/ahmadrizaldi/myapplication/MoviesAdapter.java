package com.example.ahmadrizaldi.myapplication;

/**
 * Created by ahmadrizaldi on 11/6/17.
 */

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    private Context context;
    private List<Movie> movies;

    public MoviesAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.movieName.setText(movies.get(position).getMovieName());
        holder.movieGenre.setText(movies.get(position).getMovieGenre());
    }



    @Override
    public int getItemCount() {
        return movies.size();
    }

    public  class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView movieName;
        public TextView movieGenre;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            movieName = (TextView) itemView.findViewById(R.id.moviename);
            imageView = (ImageView) itemView.findViewById(R.id.image);
            movieGenre = (TextView) itemView.findViewById(R.id.genre);
            imageView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            showPopupMenu(v,position);
        }
    }

    private void showPopupMenu(View view, int poaition) {
        PopupMenu popup = new PopupMenu(context, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_context, popup.getMenu());
        popup.setOnMenuItemClickListener(new MenuClickListener(poaition));
        popup.show();
    }


    class MenuClickListener implements PopupMenu.OnMenuItemClickListener {
        Integer pos;
        public MenuClickListener(int pos) {
            this.pos=pos;
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_favourite:
                    Toast.makeText(context, movies.get(pos).getMovieName()+" is added to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_watch:
                    Toast.makeText(context, movies.get(pos).getMovieName()+" is added to watchlist", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_book:
                    Toast.makeText(context, "Booked Ticket for "+movies.get(pos).getMovieName(), Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }
}