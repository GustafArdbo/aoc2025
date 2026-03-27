package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day2 {

    public static void run(){
        try(BufferedReader br = new BufferedReader(new FileReader("src/io/TestData"))){

            String[] ranges = br.readLine().split(",");
            int validIdsSum = 0;

            for(String range : ranges){
                String startRange = range.split("-")[0];
                String endRange = range.split("-")[1];

                List<Integer> divisible = new ArrayList<>();

                for(int i = 1; i < startRange.length(); i++){
                    if(startRange.length() % i == 0){
                        divisible.add(i);
                    }
                }

                for(Long current = Long.parseLong(startRange); current <= Long.parseLong(endRange); current++){
                    String currentID = String.valueOf(current);
                    if(currentID.startsWith("0")){
                        continue;
                    }
                    boolean isValidID = true;

                    for(int divide : divisible){
                        List<String> equalParts = new ArrayList<>();

                        for(int i = 0; i < currentID.length(); i = i + divide){
                            equalParts.add(currentID.substring(i, i + divide));
                        }
                        System.out.println(equalParts);
                        for(String string : equalParts){
                            if(!equalParts.getFirst().equals(string)){
                                isValidID = false;
                            }
                        }
                    }
                    if(isValidID){
                        System.out.println("Valid ID: " + currentID);
                        validIdsSum += current;
                    }
                }
            }
            System.out.println("Answer: " + validIdsSum);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
