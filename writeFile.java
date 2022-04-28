package com;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class writeFile {
        public void AddRecord(int score){
            String temp = String.valueOf(score);
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("highscore.txt")); //Opening the file.
                bw.write(temp);//Writing to the file
                bw.close();//Closing the file.
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }
}

