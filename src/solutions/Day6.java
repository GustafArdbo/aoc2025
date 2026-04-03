package solutions;

import java.util.List;

public class Day6 {

    private record MathProblem(List<Integer> numbers, char mathSymbol){
        int getResult(){
            int sum = numbers.getFirst();
            if(mathSymbol == '*'){
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
    }

    public static void runPartOne(){

    }
}
