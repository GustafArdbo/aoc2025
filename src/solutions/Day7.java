package solutions;

import java.io.*;
import java.util.Arrays;

public class Day7 {
    private static final String FILE_NAME = "src/io/TestData";
    private static int numberOfRows;
    private static int numberOfColumns;
    private static Position[][] matrix;

    public enum Position {
        EMPTY("."),
        START("S"),
        SPLIT("^");

        public final String label;

        private Position(String label){
            this.label = label;
        }
    }

    public static void runPartOne(){
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
            counterForMatrix();
            matrix = new Position[numberOfColumns][numberOfRows];

            String line;
            int rowCounter = 0;
            while((line = br.readLine()) != null){
                for(int col = 0; col < line.length(); col++){
                    matrix[col][rowCounter++] = Position.valueOf(String.valueOf(line.charAt(col)));
                }
            }
            System.out.println(Arrays.deepToString(matrix));


        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private static void counterForMatrix(){
        try(LineNumberReader lr = new LineNumberReader(new FileReader(FILE_NAME))){
            numberOfColumns = lr.readLine().length();
            while(lr.readLine() != null);
            numberOfRows = lr.getLineNumber();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
