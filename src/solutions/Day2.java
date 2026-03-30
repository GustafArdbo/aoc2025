package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day2 {

    public static void run(){
        try(BufferedReader br = new BufferedReader(new FileReader("src/io/InputDay2"))){

            String[] ranges = br.readLine().split(",");
            long validIdsSum = 0L;

            for(String range : ranges){
                String startRange = range.split("-")[0];
                String endRange = range.split("-")[1];
                
                for(Long current = Long.parseLong(startRange); current <= Long.parseLong(endRange); current++){

                    List<Integer> divisible = new ArrayList<>();

                    for(int i = 1; i < String.valueOf(current).length(); i++){
                        if(String.valueOf(current).length() % i == 0){
                            divisible.add(i);
                        }
                    }

                    String currentID = String.valueOf(current);
                    if(currentID.startsWith("0")){
                        continue;
                    }
                    boolean isInvalidID;

                    for(int divide : divisible){
                        /* Used for partOne
                        if(divide == currentID.length()/2) {
                            if (currentID.length() % 2 != 0) {
                                continue;
                            }
                        }
                         */

                        List<String> equalParts = new ArrayList<>();
                        isInvalidID = false;

                        for(int i = 0; i < currentID.length(); i = i + divide){
                            equalParts.add(currentID.substring(i, i + divide));
                        }

                        for(int i = 1; i < equalParts.size(); i++){
                            if(!equalParts.getFirst().equals(equalParts.get(i))){
                                isInvalidID = true;
                                break;
                            }
                        }
                        if(!isInvalidID){
                            System.out.println("Invalid ID: " + currentID);
                            validIdsSum += current;
                            break;
                        }
                    }
                }
            }
            System.out.println("Answer: " + validIdsSum);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
