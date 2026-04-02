package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day5 {
    private static final String FILE_NAME = "src/io/InputDay5";
    private static final List<Range> allIds = new ArrayList<>();


    private record Range(long startID, long endID){
        boolean containsID(long id){
            return id >= startID && id <= endID;
        }

        long getAmountOfIDsInRange(){
            return endID - startID + 1;
        }
    }

    public static void runPartOne(){
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
            loadListOfRanges(br);
            int sum = 0;
            String line;

            while((line = br.readLine()) != null){
                long current = Long.parseLong(line);

                for (Range range : allIds) {
                    if (range.containsID(current)) {
                        sum++;
                        break;
                    }
                }
            }
            System.out.println(sum);

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void runPartTwo(){
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
            loadListOfRanges(br);
            long sum = 0;
            allIds.sort(Comparator.comparing(Range::startID).thenComparing(Range::endID));
            long largestCurrentID = 0;
            System.out.println(allIds);

            //sum += allIds.getFirst().getAmountOfIDsInRange();
            for(int i = 0; i < allIds.size(); i++){
                Range current = allIds.get(i);

                if(largestCurrentID > current.endID){
                    System.out.println("Skipping because: " + largestCurrentID + " > " + current.endID);
                    continue;
                }

                if(current.startID < largestCurrentID){
                    System.out.print(sum + " + " + (current.endID - largestCurrentID) + " | ");
                    sum += current.endID - largestCurrentID;
                }else{
                    System.out.print(sum + " + " + current.getAmountOfIDsInRange() + " | ");
                    sum += current.getAmountOfIDsInRange();
                }
                largestCurrentID = current.endID;
                System.out.println(current.startID + "-" + current.endID);
                System.out.println("largest current: " + largestCurrentID);
            }
            System.out.println("sum: " + sum);

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private static void loadListOfRanges(BufferedReader br) throws IOException {
        String line;

        while(!Objects.equals(line = br.readLine(), "")){
            long startID = Long.parseLong(line.split("-")[0]);
            long endID = Long.parseLong(line.split("-")[1]);
            allIds.add(new Range(startID, endID));
        }
    }
}
