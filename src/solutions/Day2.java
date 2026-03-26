package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day2 {

    public static void run(){
        try(BufferedReader br = new BufferedReader(new FileReader("src/io/TestData"))){

            String line;

            while((line = br.readLine()) != null){

            }

        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
