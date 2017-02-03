package mtg.tw.nipunmohan.mtg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NipunMohan on 03/02/2017.
 */


public class ShowOutput {

    private ShowOutput(){

    }

    //these two lists hold question asked and out for same indexes
    //this will hold all the questions asked in the input
    public static final List<String> inputQuestions = new ArrayList<>();
    //this holds the output of the questions and special values if the question was not valid or a validation failure occurs
    public static final List<String> outputValues = new ArrayList<String>();




    /**
     * Display the output
     */
    public static void processOutput(){

        for (int i = 0; i < inputQuestions.size(); i++) {
            StringBuilder result = new StringBuilder();

            String question = inputQuestions.get(i);
            String output = outputValues.get(i);

            if(output == ProcessInputData.NO_IDEA || Double.valueOf(output).intValue() == -1){
                result.append(ProcessInputData.NO_IDEA);
            }
            else{
                if(question.startsWith(Constants.HOW_MUCH_IS)){
                    result.append(question.substring(Constants.HOW_MUCH_IS.length(), question.length()-1).trim());
                    result.append(Constants._IS);
                    result.append(Double.valueOf(output).intValue());
                }

                else if(question.startsWith(Constants.HOW_MANY_CREDITS_IS)){
                    result.append(question.substring(Constants.HOW_MANY_CREDITS_IS.length(), question.length()-1).trim());
                    result.append(Constants._IS);
                    result.append(Double.valueOf(output).intValue());
                    result.append(Constants.CREDITS);
                }
                else
                    result.append(ProcessInputData.NO_IDEA);
            }

            System.out.println(result.toString());
        }
    }

}