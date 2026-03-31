package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day5 {

    public static void runPartOne(){
        try(BufferedReader br = new BufferedReader(new FileReader("src/io/InputDay5"))){
            String line;
            int sum = 0;
            Set<Long> allIDs = new TreeSet<>();

            while(!Objects.equals(line = br.readLine(), "")){
                long startID = Long.parseLong(line.split("-")[0]);
                long endID = Long.parseLong(line.split("-")[1]);

                for(long i = startID; i <= endID; i++){
                    allIDs.add(i);
                }
            }
            System.out.println(allIDs);

            while((line = br.readLine()) != null){
                if(allIDs.contains(Long.parseLong(line))){
                    sum++;
                }
            }
            System.out.println(sum);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
