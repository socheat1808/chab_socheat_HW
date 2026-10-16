package com.example.loginscreen;

import java.util.List;

public class MovieRepository {

    public static List<MovieModel> getMovies() {
        return List.of(
                new MovieModel(4.8, "Premium", "Inception", 2010, 148, "NC-15", "Sci-Fi", R.drawable.movie_1),
                new MovieModel(0, "Free", "The Dark Knight", 2008, 152, "NC-15", "Action", R.drawable.movie_2),
                new MovieModel(1.5, "Premium", "Pulp Fiction", 1994, 154, "R-18", "Crime", R.drawable.movie_1),
                new MovieModel(4.1, "Free", "Interstellar", 2014, 169, "NC-15", "Sci-Fi", R.drawable.movie_2),
                new MovieModel(0, "Premium", "Spider-Man: Into the Spider-Verse", 2018, 117, "G", "Animation", R.drawable.movie_1),
                new MovieModel(0.8, "Free", "Parasite", 2019, 132, "R-18", "Thriller", R.drawable.movie_2),
                new MovieModel(5.0, "Premium", "The Lord of the Rings: The Fellowship of the Ring", 2001, 178, "NC-15", "Fantasy", R.drawable.movie_1),
                new MovieModel(3.7, "Free", "Spirited Away", 2001, 125, "G", "Animation", R.drawable.movie_2),
                new MovieModel(4.3, "Premium", "The Matrix", 1999, 136, "NC-15", "Sci-Fi", R.drawable.movie_1),
                new MovieModel(2.1, "Free", "Whiplash", 2014, 106, "NC-15", "Drama", R.drawable.movie_2),
                new MovieModel(3.9, "Premium", "Iron Man", 2008, 126, "NC-15", "Action", R.drawable.movie_1),
                new MovieModel(4.6, "Free", "Coco", 2017, 105, "G", "Animation", R.drawable.movie_2),
                new MovieModel(1.2, "Premium", "Blade Runner 2049", 2017, 164, "R-18", "Sci-Fi", R.drawable.movie_1),
                new MovieModel(3.4, "Free", "Grand Budapest Hotel", 2014, 99, "NC-15", "Comedy", R.drawable.movie_2),
                new MovieModel(4.9, "Premium", "The Silence of the Lambs", 1991, 118, "R-18", "Horror", R.drawable.movie_1),
                new MovieModel(2.5, "Free", "Get Out", 2017, 104, "R-18", "Horror", R.drawable.movie_2),
                new MovieModel(3.8, "Premium", "Knives Out", 2019, 130, "NC-15", "Mystery", R.drawable.movie_1),
                new MovieModel(4.4, "Free", "Toy Story", 1995, 81, "G", "Animation", R.drawable.movie_2),
                new MovieModel(1.9, "Premium", "Alien", 1979, 117, "R-18", "Sci-Fi", R.drawable.movie_1),
                new MovieModel(3.0, "Free", "Avatar", 2009, 162, "NC-15", "Action", R.drawable.movie_2)
        );
    }
}
