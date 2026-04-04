package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;

public class Day6 {
    private static final String FILE_NAME = "src/io/TestData";
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
                br.append(number).append(" ").append("*").append(" ");
            }
            br.append("= ").append("x");
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
            long sum = 0;
            List<String> allLines = new ArrayList<>();

            String line;
            while((line = br.readLine()) != null){
                allLines.add(line);
            }

            int indexOfMathProblem = 0;
            boolean isNewMathProblem = false;
            for(int i = 0; i < allLines.getFirst().length(); i++){
                char symbol = allLines.getLast().charAt(i);
                MathProblem problem;

                if(symbol == '*' || symbol == '+'){
                    System.out.println("Creating a new problem:");
                    problem = new MathProblem(new ArrayList<>());
                    mathProblems.add(problem);
                    if(isNewMathProblem){
                        indexOfMathProblem = mathProblems.size() - 1;
                    } else {
                        indexOfMathProblem = i;
                    }
                } else {
                    System.out.println(mathProblems.size() + " " + mathProblems);
                    problem = mathProblems.get(indexOfMathProblem);
                }
                StringBuilder number = new StringBuilder();
                for(int x = 0; x < allLines.size() - 1; x++){
                    if(!(allLines.get(x).charAt(i) == ' ')){
                        number.append(allLines.get(x).charAt(i));
                    }
                }

                if(number.toString().isEmpty()){
                    isNewMathProblem = true;
                    continue;
                }


                problem.numbers.add(Integer.valueOf(number.toString().trim()));

            }

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
