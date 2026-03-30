package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day3 {

    private static final int BATTERY_AMOUNT = 12;

    public static void runPartOne(){
        try(BufferedReader br = new BufferedReader(new FileReader("src/io/InputDay3"))){

            String line;
            String powerOfTen = "";
            String powerOfOne = "";
            int indexOfPowerOfTen = 0;
            int sum = 0;

            while((line = br.readLine()) != null){

                int max = 0;
                for(int i = 0; i < line.length() - 1; i++){
                    int current = Integer.parseInt(String.valueOf(line.charAt(i)));
                    if(max < current){
                        max = current;
                        indexOfPowerOfTen = i;
                    }
                }
                powerOfTen = String.valueOf(max);
                max = 0;

                for(int i = indexOfPowerOfTen + 1; i < line.length(); i++){
                    int current = Integer.parseInt(String.valueOf(line.charAt(i)));
                    if(max < current){
                        max = current;
                    }
                }
                powerOfOne = String.valueOf(max);

                sum += Integer.parseInt(powerOfTen + powerOfOne);
            }
            System.out.println("Answer: " + sum);

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void runPartTwo(){
        try(BufferedReader br = new BufferedReader(new FileReader("src/io/TestData"))){

            String line;

            long sum = 0;

            while((line = br.readLine()) != null){

                StringBuilder sb = new StringBuilder();

                for(int i = 0; i < line.length() - BATTERY_AMOUNT; i++){
                    
                }


            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
