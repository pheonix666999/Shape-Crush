package com;
import javafx.application.Platform;
public class ShapeCrush extends Background{
    public ShapeCrush(){
        //Changing the thread to the fx thread
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                initLayout();
            }
        });
    }
}