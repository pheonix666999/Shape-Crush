package com;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Bloom;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HIGHSCORE extends FrontPage{
    public HIGHSCORE(){
        String temp = new String();
        Stage stage = new Stage();
        Group pane = new Group();
        Button back = new Button();
        Scene scene = new Scene(pane, 500,500);
        File myfile = new File("highscore.txt");
        try {
            Scanner input = new Scanner(myfile);
            while(input.hasNext()){
                temp = input.next();
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        pane.getStylesheets().add("com/style.css");
        Label label = new Label("HIGHSCORE: " + temp);
        label.getStyleClass().add("HIGHSCORE");
        label.setLayoutX(200);
        label.setLayoutY(300);
        label.setEffect(new Bloom());
        stage.setScene(scene);
        pane.getChildren().add(label);
        stage.show();
    }
}
