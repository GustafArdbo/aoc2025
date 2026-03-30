package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day3 {

    static void run(){
        try(BufferedReader br = new BufferedReader(new FileReader("src/io/InputDay3"))){

            String line;
            int first;
            int second;
            int indexOfFirst;

            while((line = br.readLine()) != null){

                int max = 0;
                for(int i = 0; i < line.length(); i++){
                    int current = Integer.parseInt(String.valueOf(line.charAt(i)));
                    if(max < current){
                        max = current;
                        indexOfFirst = i;
                    }
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
