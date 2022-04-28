package com;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.control.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FrontPage extends Application{
    //This is the declaration of the Nodes and Variables.
    //The declaration is done in the class so that it all can ve accessed from all the functions of the class.
    Group pane;
    Button back;
    Label heading;
    Scene scene;
    File file;
    Stage stage;
    Button play;
    Button options;
    Button credits;
    Button help;
    Button exit;
    Group Scoring;
    String temp = new String();
    File musicfile;
    @Override
    public void start(Stage stage) {
        //This is the start function which excecutes all the javafx components.
        letsgo();
    }
    MediaPlayer musicplayer;
    public static void main(String args[]){
        launch(args);
    }
    public void letsgo(){
        //The letsgo() functions performs all the javafx components operations.
        stage = new Stage();
        stage.setResizable(false);
        pane = new Group();
        file = new File("src/com/video/background3.mp4");
        Media media = new Media(file.toURI().toString());
        MediaPlayer mediaplayer = new MediaPlayer(media);
        mediaplayer.play();

        mediaplayer.setMute(true);
        mediaplayer.setCycleCount(MediaPlayer.INDEFINITE);
        MediaView mediaview = new MediaView(mediaplayer);
        mediaview.setMediaPlayer(mediaplayer);
        mediaplayer.setAutoPlay(true);
        pane.getChildren().add(mediaview);
        scene = new Scene(pane, 1260, 700);
        scene.getStylesheets().add("com/style.css");
        stage.setScene(scene);
        //The HEADING of the game.
        heading = new Label("SHAPE CRUSH");
        heading.setLayoutX(50);
        heading.setLayoutY(30);
        Scoring = new Group();
        DropShadow shadow = new DropShadow();
        pane.getChildren().add(heading);
        heading.getStyleClass().add("heading");
        heading.setEffect(new Bloom(0));
        //The Play Button
        play = new Button("PLAY");
        play.setEffect(new Bloom());
        play.getStyleClass().add("play");
        play.setLayoutX(551);
        play.setLayoutY(290);
        play.setText("PLAY");
        play.setPrefSize(180,80);
        play.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                musicplayer.stop();
                ShapeCrush crush = new ShapeCrush();
                stage.hide();
            }
        });
        //The Back Icon Button
        back = new Button();
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pane.getChildren().clear();
                pane.getChildren().addAll(mediaview, heading, play, options, credits, help, exit);
            }
        });
        back.setGraphic(new ImageView("com/back.png"));
        //The H.Score button
        options = new Button("H.SCORE");
        options.setEffect(new Bloom());
        options.getStyleClass().add("options");
        options.setLayoutX(551);
        options.setLayoutY(370);
        options.setPrefSize(180,80);
        options.setOnAction(new EventHandler<ActionEvent>()

        {
            @Override
            public void handle(ActionEvent event){
                try {
                    File myfile = new File("highscore.txt");
                    Scanner input = new Scanner(myfile);
                    while(input.hasNext()){
                        temp = input.next();
                    }
                }
                catch (FileNotFoundException e){
                    e.printStackTrace();
                }
                pane.getChildren().clear();
                pane.getChildren().add(mediaview);
                Label highscore = new Label("HIGHSCORE " + temp);
                highscore.getStylesheets().add("com/style.css");
                highscore.getStyleClass().add("HIGHSCORE");
                highscore.setLayoutX(230);
                highscore.setLayoutY(270);
                highscore.setEffect(new Bloom());
                highscore.getStyleClass().add("HIGHSCORE");
                pane.getChildren().add(highscore);
                highscore.setTextFill(Color.GREENYELLOW);
                highscore.setEffect(new Bloom());
                pane.getChildren().add(back);
                pane.setStyle("-fx-background-color: #383838");
                back.setLayoutX(0);
                back.setLayoutY(0);
            }
        });
        //The credits button
        credits = new Button();
        credits.setText("CREDITS");
        credits.setEffect(new Bloom());
        credits.getStyleClass().add("credits");
        credits.setLayoutX(551);
        credits.setLayoutY(450);
        credits.setPrefSize(180,80);
        credits.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Label names = new Label("MADE BY \nMr ALI AMMAR");
                names.setLayoutX(360);
                names.setLayoutY(220);
                names.getStyleClass().add("names");
                names.setEffect(new Bloom());
                pane.getChildren().clear();
                pane.getChildren().addAll(mediaview, names, back);
            }
        });
        //The help button
        help = new Button();
        help.setText("HELP");
        help.setEffect(new Bloom());
        help.getStyleClass().add("help");
        help.setLayoutX(551);
        help.setLayoutY(530);
        help.setPrefSize(180,80);
        help.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                pane.getChildren().clear();
                Label HELP = new Label("You are to switch between the shapes by clicking on the two shapes\nEither vertical or horizontal\nIf the three shapes are the same then the shapes change and score is added\nYou can also move one shape on the whole board\nMoves are limited\nThe levels change when you reach Score 50 and 100");
                HELP.setEffect(new Bloom());
                HELP.getStyleClass().add("manual");
                HELP.setLayoutX(0);
                HELP.setLayoutY(180);
                HELP.setTextAlignment(TextAlignment.JUSTIFY);
                HELP.setWrapText(true);
                pane.getChildren().addAll(mediaview, HELP, back);
            }
        });
        //The exit button
        exit = new Button();
        exit.setText("EXIT");
        exit.setEffect(new Bloom());
        exit.getStyleClass().add("exit");
        exit.setLayoutX(551);
        exit.setLayoutY(610);
        exit.setPrefSize(180,80);
        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        //Adding all the buttons to the pane.
        pane.getChildren().add(exit);
        pane.getChildren().add(options);
        pane.getChildren().add(play);
        pane.getChildren().add(credits);
        pane.getChildren().add(help);
        Music(); //Calling the Music Function
        stage.show();
        stage.setTitle("SHAPE_CRUSH.exe");
        File iconFile = new File("src/com/icon.png");
        Image icon = new Image(iconFile.toURI().toString());
        stage.getIcons().add(new Image(iconFile.toURI().toString())); //Adding the icon to the stage.
    }
    public void Music(){ //The music function.
        musicfile = new File("src/com/music/back on track.mp3");
        Media music = new Media(musicfile.toURI().toString());
        musicplayer = new MediaPlayer(music);
        musicplayer.play();
        musicplayer.setCycleCount(MediaPlayer.INDEFINITE);
        }
}