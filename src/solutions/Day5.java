package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day5 {
    private static final String FILE_NAME = "src/io/TestData";
    private static final List<Range> allIds = new ArrayList<>();


    private record Range(long startID, long endID){
        boolean containsID(long id){
            return id >= startID && id <= endID;
        }

        int getAmountOfIDsInRange(){
            return (int) (endID - startID);
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
            int sum = 0;
            allIds.sort(Comparator.comparing(Range::startID).thenComparing(Range::endID));
            System.out.println(allIds);

            sum += allIds.getFirst().getAmountOfIDsInRange();
            for(int i = 1; i < allIds.size(); i++){

                Range current = allIds.get(i);

                if(current.startID < allIds.get(i - 1).endID){
                    sum += (int) (allIds.get(i - 1).endID - current.endID);
                }else{
                    sum += current.getAmountOfIDsInRange();
                }

            }
            System.out.println(sum);
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
