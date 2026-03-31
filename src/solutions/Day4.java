package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class Day4 {
    private static final int MAX_SURROUNDING_PAPER_ROLLS = 4;
    private static final int OFFSET = 2;

    private static final String FILE_NAME = "src/io/InputDay4";

    private static int numberOfLines = 0;
    private static int numberOfSpots = 0;
    private static int totalRemovedPaperRolls = 0;

    private static boolean changesMade = false;

    private static int[][] matrix;

    public static void runPartTwo(){
        do{
            runPartOne();
        }while(changesMade);
        System.out.println("Total removed paper rolls: " + totalRemovedPaperRolls);
    }

    public static void runPartOne(){
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
            counterForMatrix();
            List<String> removablePaperRolls = new ArrayList<>();
            int accessablePaperRollCounter = 0;
            int lineCounter = 1;

            if(matrix == null){
                matrix = new int[numberOfSpots][numberOfLines];
                String line;
                while((line = br.readLine()) != null){
                    matrix[lineCounter][0] = 0;
                    for(int i = 1; i < line.length() + 1; i++){
                        if(line.charAt(i - 1) == '@'){
                            matrix[lineCounter][i] = 1;
                        }else{
                            matrix[lineCounter][i] = 0;
                        }
                    }
                    lineCounter++;
                }
            }
            boolean anyChangesMade = false;
            for(int i = 1; i < numberOfLines - 1; i++){
                for(int x = 1; x < numberOfSpots - 1; x++){
                    if(countFromPosition(i, x) < MAX_SURROUNDING_PAPER_ROLLS && matrix[i][x] == 1){
                        accessablePaperRollCounter++;
                        totalRemovedPaperRolls++;
                        removablePaperRolls.add(i + "," + x);
                        anyChangesMade = true;
                    }
                }
            }
            changesMade = anyChangesMade;

            System.out.println(accessablePaperRollCounter);
            removeAccessiblePaperRolls(removablePaperRolls);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private static int countFromPosition(int x, int y){
        int counter = 0;
        for(int row = -1; row <= 1; row++){
            for(int line = -1; line <= 1; line++){
                if(row == 0 && line == 0){
                    continue;
                }
                if(matrix[x + line][y + row] == 1){
                    counter += 1;
                }
            }
        }
        return counter;
    }

    private static void counterForMatrix(){
        try(LineNumberReader lr = new LineNumberReader(new FileReader(FILE_NAME))){
            numberOfSpots = lr.readLine().length() + OFFSET;
            while(lr.readLine() != null);
            numberOfLines = lr.getLineNumber() + OFFSET;
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private static void removeAccessiblePaperRolls(List<String> removablePaperRolls){
        for(int i = 0; i < removablePaperRolls.size(); i++){
            int row = Integer.parseInt(removablePaperRolls.get(i).split(",")[0]);
            int col = Integer.parseInt(removablePaperRolls.get(i).split(",")[1]);
            matrix[row][col] = 0;
        }
    }
}
