package com.green.cinema.dbdao;

import com.green.cinema.model.Movie;
import com.green.cinema.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MovieDao {
    private final String CREATE_TABLE_MOVIE = "CREATE TABLE IF NOT EXISTS MOVIE" +
            "(MOVIE_ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
            " IMAGE VARCHAR(64)," +
            " TITLE VARCHAR(64),"+
            " DIRECTOR VARCHAR(64),"+
            " RELEASE_DATE DATE,"+
            " DURATION INT);";

    private final String CREATE_INIT_MOVIE = "INSERT INTO MOVIE (IMAGE, TITLE, DIRECTOR, RELEASE_DATE, DURATION)" +
            " VALUES('', 'Avenger', 'Russo', '2019/05/05', '120')," +
            " ('', 'Tom & Jerry', 'Kevin', '2021/05/05', '113')," +
            " ('', 'Justice League', 'Zack', '2020/05/05', '118');";

    private final String GET_MOVIE = "SELECT * FROM MOVIE;";

    private final String DROP_TABLE_MOVIE = "DROP TABLE IF EXISTS MOVIE;";

    public MovieDao(){}

    public int createTableMovie(Connection connection){
        int result = 0;
        Statement statement = null;
        try {
            statement = connection.createStatement();

            statement.executeUpdate(DROP_TABLE_MOVIE);
            statement.executeUpdate(CREATE_TABLE_MOVIE);

            System.out.println("Table movie created");
        }catch (SQLException ex){
            result = -1;
            System.out.println("Table created fail: "+ex.getMessage());
        }finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return result;
    }

    public int createInitMovie(Connection connection){
        int result = 0;
        Statement statement = null;
        try {
            statement = connection.createStatement();

            statement.executeUpdate(CREATE_INIT_MOVIE);

            System.out.println("Table movie created");
        }catch (SQLException ex){
            result = -1;
            System.out.println("Table created fail: "+ex.getMessage());
        }finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return result;
    }

    public ArrayList<Movie> GetMovie(Connection connection){
        ArrayList<Movie> movies = new ArrayList<>();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_MOVIE);
            while (resultSet.next()){
                Movie movie = new Movie();
                movie.setMovieId(resultSet.getInt(1));
                movie.setImage(resultSet.getString(2));
                movie.setTitle(resultSet.getString(3));
                movie.setDirector(resultSet.getString(4));
                movie.setReleaseDate(resultSet.getDate(5));
                movie.setDuration(String.valueOf(resultSet.getInt(6)));
                movies.add(movie);
            }
        }catch (SQLException ex){
            System.out.println("Data Show fail: "+ex.getMessage());
        }finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return movies;
    }

}
