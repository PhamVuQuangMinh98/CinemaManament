module Cinema {
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.web;
    requires java.sql;

    opens com.green.cinema;
    opens com.green.cinema.controllers;
}