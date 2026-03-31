package solutions;

import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Day4 {
    private static final int MAX_SURROUNDING_PAPER_ROLLS = 4;
    private static final String FILE_NAME = "src/io/TestData";
    private static final int OFFSET = 2;
    private static int numberOfLines = 0;
    private static int numberOfSpots = 0;
    private static int[][] matrix;

    public static void runPartOne(){
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
            counterForMatrix();
            matrix = new int[numberOfSpots][numberOfLines];
            String line;
            int accessablePaperRollCounter = 0;
            int lineCounter = 1;

            while((line = br.readLine()) != null){
                matrix[lineCounter][0] = 0;
                for(int i = 1; i < line.length(); i++){
                    if(line.charAt(i) == '@'){
                        matrix[lineCounter][i] = 1;
                    }else{
                        matrix[lineCounter][i] = 0;
                    }
                }
                matrix[lineCounter++][line.length() + 1] = 0;
            }

            for(int i = 1; i < numberOfLines - 1; i++){
                for(int x = 1; x < numberOfSpots - 1; x++){
                    System.out.print(matrix[i][x]);
                    if(countFromPosition(i, x) < MAX_SURROUNDING_PAPER_ROLLS){
                        accessablePaperRollCounter++;
                    }

                }
                System.out.println();
            }

            for(int i = 0; i < numberOfLines; i++){
                for(int x = 0; x < numberOfSpots; x++){
                    System.out.print(matrix[i][x]);
                }
                System.out.println();
            }
            System.out.println(accessablePaperRollCounter);

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static int countFromPosition(int x, int y){
        int counter = 0;
        for(int row = -1; row <= 1; row++){
            for(int line = -1; line <= 1; line++){
                if(row == 0 && line == 0){
                    continue;
                }
                if(matrix[x + line][y + row] == 1){
                    counter++;
                }

            }
        }
        System.out.println(counter);
        return counter;
    }

    public static void counterForMatrix(){
        try(LineNumberReader lr = new LineNumberReader(new FileReader(FILE_NAME))){
            numberOfSpots = lr.readLine().length() + OFFSET;
            while(lr.readLine() != null);
            numberOfLines = lr.getLineNumber() + OFFSET;
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
