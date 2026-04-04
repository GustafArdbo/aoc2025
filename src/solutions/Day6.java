package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;

public class Day6 {
    private static final String FILE_NAME = "src/io/InputDay6";
    private static final List<MathProblem> mathProblems = new ArrayList<>();

    private static class MathProblem {
        List<Integer> numbers;
        String mathSymbol;

        public MathProblem(List<Integer> numbers){
            this.numbers = numbers;
        }

        long getResult(){
            long sum = numbers.getFirst();
            if(mathSymbol.equals("*")){
                for(int i = 1; i < numbers.size(); i++){
                    sum *= numbers.get(i);
                }
            }else{
                for(int i = 1; i < numbers.size(); i++){
                    sum += numbers.get(i);
                }
            }
            return sum;
        }

        @Override
        public String toString(){
            StringBuilder br = new StringBuilder();

            for(Integer number : numbers){
                br.append(number).append(" ").append(mathSymbol).append(" ");
            }
            br.append("= ").append(getResult());
            return br.toString();
        }
    }

    public static void runPartOne(){
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
            boolean firstLine = true;
            boolean isNumber = true;
            long sum = 0;

            String line;
            while((line = br.readLine()) != null){
                String[] fullInput = line.split(" ");
                List<String> trimmedInput = new ArrayList<>();
                for(String string : fullInput){
                    if(string.isBlank()){
                        continue;
                    }
                    trimmedInput.add(string.trim());
                }
                if(trimmedInput.getFirst().equals("*") || trimmedInput.getFirst().equals("+")){
                    isNumber = false;
                }
                System.out.println(trimmedInput);

                int indexCounter = 0;
                for(String string : trimmedInput){
                    addInformationToMathProblem(string, indexCounter++, isNumber, firstLine);
                }
                firstLine = false;
                isNumber = true;
            }
            for(MathProblem problem : mathProblems){
                System.out.println(problem);
                sum += problem.getResult();
            }
            System.out.println(sum);


        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void runPartTwo(){
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private static void addInformationToMathProblem(String string, int index, boolean isNumber, boolean isFirstNumbers){
        if(isNumber){
            if(isFirstNumbers){
                mathProblems.add(new MathProblem(new ArrayList<>(List.of(Integer.parseInt(string)))));
            } else {
                mathProblems.get(index).numbers.add(Integer.valueOf(string));
            }
        } else {
            mathProblems.get(index).mathSymbol = string;
        }
    }
}
