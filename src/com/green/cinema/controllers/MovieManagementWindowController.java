package com.green.cinema.controllers;

import com.green.cinema.dbdao.MovieDao;
import com.green.cinema.model.Movie;
import com.green.cinema.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class MovieManagementWindowController  extends BaseController implements Initializable {

    public MovieManagementWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }
    ArrayList<Movie> movies = new ArrayList<>();
    MovieDao movieDao = new MovieDao();
    @FXML
    private TableView<Movie> movieTable;

    @FXML
    private TableColumn<Movie, ImageView> imageColumn;

    @FXML
    private TableColumn<Movie, String> titleColumn;

    @FXML
    private TableColumn<Movie, String> directorColumn;

    @FXML
    private TableColumn<Movie, Date> releaseColumn;

    @FXML
    private TableColumn<Movie, String> durationColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initTable();
    }

    public void initTable(){
        imageColumn.setCellValueFactory(new PropertyValueFactory<>("image"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        directorColumn.setCellValueFactory(new PropertyValueFactory<>("director"));
        releaseColumn.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));


        movies = movieDao.GetMovie(viewFactory.getDbConnector().getDBConnection());
        for(Movie movie: movies){
            movieTable.getItems().add(movie);
        }
    }
}
