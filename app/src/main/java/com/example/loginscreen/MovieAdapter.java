package com.example.loginscreen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private final List<MovieModel> movies;

    public MovieAdapter(List<MovieModel> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder h, int position) {
        MovieModel m = movies.get(position);
        h.poster.setImageResource(m.getImageRes());
        h.rating.setText(String.format(Locale.US, "%.1f", m.getRating()));
        h.type.setText(m.getType());
        h.type.setBackgroundResource(m.isPremium() ? R.drawable.bg_premium : R.drawable.bg_free);
        h.title.setText(m.getTitle());
        h.year.setText(String.valueOf(m.getYear()));
        h.duration.setText(m.getDuration() + " Minutes");
        h.age.setText(m.getAgeRating());
        h.genre.setText(m.getGenre());
    }

    @Override
    public int getItemCount() { return movies.size(); }

    static class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView poster;
        TextView rating, type, title, year, duration, age, genre;

        MovieViewHolder(@NonNull View v) {
            super(v);
            poster = v.findViewById(R.id.imgPoster);
            rating = v.findViewById(R.id.tvRating);
            type = v.findViewById(R.id.tvType);
            title = v.findViewById(R.id.tvTitle);
            year = v.findViewById(R.id.tvYear);
            duration = v.findViewById(R.id.tvDuration);
            age = v.findViewById(R.id.tvAge);
            genre = v.findViewById(R.id.tvGenre);
        }
    }
}