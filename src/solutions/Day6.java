package solutions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day6 {
    private static final String FILE_NAME = "src/io/TestData";

    private static class MathProblem {
        List<Integer> numbers;
        String mathSymbol;

        public MathProblem(List<Integer> numbers){
            this.numbers = numbers;
        }

        int getResult(){
            int sum = numbers.getFirst();
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
            for(Integer integer : numbers){
                br.append(integer).append(" ").append(mathSymbol).append(" = ").append(getResult());
            }
            return br.toString();
        }
    }

    public static void runPartOne(){
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){

            List<MathProblem> mathProblems = new ArrayList<>();

            String line;
            while((line = br.readLine()) != null){
                String[] fullInput = line.split("\t");

                for(int i = 0; i < fullInput.length; i++){
                    if(mathProblems.isEmpty()){
                        mathProblems.add(new MathProblem(new ArrayList<>(Integer.parseInt(fullInput[i]))));

                    }else if(fullInput[0].equals("*") || fullInput[0].equals("+")){
                        mathProblems.get(i).mathSymbol = fullInput[i];

                    }else{
                        mathProblems.get(i).numbers.add(Integer.valueOf(fullInput[i]));
                    }
                }
            }
            for(MathProblem problem : mathProblems){
                System.out.println(problem);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
