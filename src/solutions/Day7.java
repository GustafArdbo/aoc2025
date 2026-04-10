package solutions;

import java.io.*;

public class Day7 {
    private static final String FILE_NAME = "src/io/TestData";
    private static int numberOfRows;
    private static int numberOfColumns;
    private static String[][] matrix;

    public static void runPartOne(){
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
            counterForMatrix();
            matrix = new String[numberOfRows][numberOfColumns];

            String line;
            int rowCounter = 0;
            while((line = br.readLine()) != null){
                for(int col = 0; col < line.length(); col++){
                    matrix[rowCounter][col] = String.valueOf(line.charAt(col));
                }
                rowCounter++;
            }

            for(int i = 0; i < numberOfColumns; i++){
                if(matrix[0][i].equals("S")){
                    matrix[1][i] = "|";
                }
            }
            int sum = 0;
            int splitterCounter = 0;

            for(int row = 2; row < numberOfRows - 1; row++){
                for(int col = 0; col < numberOfColumns; col++){
                    if(matrix[row][col].equals("^")){
                        matrix[row][col - 1] = "|";
                        matrix[row][col + 1] = "|";
                        if(matrix[row - 1][col].equals("|")){
                            sum++;
                        }
                    }

                    if(matrix[row - 1][col].equals("|") && !matrix[row][col].equals("^") && !matrix[row][col].equals("|")){
                        matrix[row][col] = "|";
                    }

                }
                System.out.println("sum = " + sum + " \t| row = " + (row));
            }
            printMatrix();
            System.out.println(sum);


        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private static void printMatrix(){
        int row = 0;
        for(String[] pos : matrix){
            System.out.print(row++ + "\t");
            for(String position : pos){
                System.out.print(position);
            }
            System.out.println();
        }
        System.out.println();
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
