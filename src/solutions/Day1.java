package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day1 {
    private static final int DIAL_START = 50;
    private static final int DIAL_MAX = 99;
    private static final int DIAL_MIN = 0;

    private static  final String FILE_NAME = "src/io/InputDay1";

    public static void run() {
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
            int dial = DIAL_START;
            int zeroCounter = 0;
            int lineC = 0;
            String line;
            while((line = br.readLine()) != null){
                char dir = line.charAt(0);

                if(dir == 'R'){
                    for(int i = 0; i < Integer.parseInt(line.substring(1)); i++){
                        dial++;
                        if(dial > DIAL_MAX){
                            dial = 0;
                        }
                        if(dial == 0){
                            zeroCounter++;
                        }
                    }
                }else{
                    for(int i = 0; i < Integer.parseInt(line.substring(1)); i++){
                        dial--;
                        if(dial < DIAL_MIN){
                            dial = 99;
                        }
                        if(dial == 0){
                            zeroCounter++;
                        }
                    }
                }
                System.out.println("Line " + lineC++ + " = " + dial);
            }
            System.out.println(zeroCounter);

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void runSolution2(){
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
            int zeroCounter = 0;
            int dial = DIAL_START;

            String line;
            while((line = br.readLine()) != null){
                char dir = line.charAt(0);
                int number = Integer.parseInt(line.substring(1));

                if(dir == 'L') number = number * -1;
                dial = (dial + number) % 100;
                if(dial == 0) zeroCounter++;
            }
            System.out.println(zeroCounter);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void runSolution2Part2(){
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
            int zeroCounter = 0;
            int dial = DIAL_START;

            String line;
            while((line = br.readLine()) != null){
                char dir = line.charAt(0);
                int number = Integer.parseInt(line.substring(1));

                if(dir == 'L') {
                    number = number * -1;
                }

                dial = (dial + number) % 100;

                

            }
            System.out.println(zeroCounter);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
