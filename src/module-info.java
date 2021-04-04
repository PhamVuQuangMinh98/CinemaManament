module Cinema {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.web;
    requires java.sql;
    requires javafx.graphics;

    opens com.green.cinema;
    opens com.green.cinema.controllers;
    opens com.green.cinema.model;
}