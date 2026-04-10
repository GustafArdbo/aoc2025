package solutions;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.TreeSet;

public class Day7BinaryTree {
    private static final String FILE_NAME = "src/io/TestData";
    private static int numberOfRows;
    private static int numberOfColumns;
    private static String[][] matrix;
    private static TreeSet<Node> map = new TreeSet<>();

    private class Node{
        Node left;
        Node right;

        void setRight(Node node){
            this.right = node;
        }

        void setLeft(Node node){
            this.left = node;
        }

        Node getRight(){
            return right;
        }

        Node getLeft(){
            return left;
        }
    }

    public void runPartTwo(){
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
            counterForMatrix();
            matrix = new String[numberOfRows][numberOfColumns];

            int rowCounter = 0;
            String line;
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
            Node firstNode = new Node();
            map.add(firstNode);

            Node previous = firstNode;
            for(int row = 4; row < numberOfRows - 1; row++) {
                for (int col = 0; col < numberOfColumns; col++) {

                }
            }
            printMatrix();


        } catch (IOException e){
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
