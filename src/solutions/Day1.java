package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day1 {
    private static final int DIAL_START = 50;
    private static final int DIAL_MAX = 99;
    private static final int DIAL_MIN = 0;

    private static  final String FILE_NAME = "src/io/TestData";

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
            int lineC = 0;

            String line;
            while((line = br.readLine()) != null){

                char dir = line.charAt(0);
                int number = Integer.parseInt(line.substring(1));
                int offset = 0;

                if(number > DIAL_MAX){
                    offset = number % (DIAL_MAX + 1);
                }

                if(dir == 'R') { // Right
                    if(dial + number > DIAL_MAX){ // Right + <99
                        if(offset > 0){ // Right ++ <99 + number>99
                            number = offset - 1;
                        } else {
                            number = (dial + number) % (DIAL_MAX + 1);

                        }
                        dial = DIAL_MIN + number;
                    } else {
                        dial = dial + number;
                    }

                } else { // Left
                    if(dial - number < DIAL_MIN) { // Left + >99
                        if(offset > 0){ // Left + >99 + number>99
                            number = offset;
                        } else {
                            number = number - dial;
                        }
                        dial = DIAL_MAX - number + 1;
                    } else {
                        dial = dial - number;
                    }

                }

                if(dial == 0){
                    zeroCounter++;
                }
                System.out.println("Line " + lineC++ + " = " + dial);
            }
            System.out.println(zeroCounter);

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
