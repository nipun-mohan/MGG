package mtg.tw.nipunmohan.mtg;

/**
 * Created by NipunMohan on 03/02/2017.
 */

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class to read and process the data at the same time
 * The processing starts as soon as the input is received
 */
public class ProcessInputData {

    public static final String NO_IDEA = "I have no idea what you are talking about";

    private static Map<String, RomanLetters.Roman> interGalacticRomanMapping = new HashMap<>();
    private static Map<String, Double> objectSoldPerUnitValue = new HashMap<>();

    /**
     * reads and process the input file
     *
     * @param stream
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void readFileAndProcess(InputStream stream) throws Exception {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(stream))) {

            String line;

            while ((line = br.readLine()) != null) {
                processInput(line.trim());
            }

        } catch (IOException e) {
            System.out.println("File not found exception " + e);
        }
    }

    /**
     * Parses the input line by line and decides the type of request and appropriately forwards the request
     *
     * @param line
     * @throws Exception
     */
    private void processInput(String line) throws Exception {
        //split by whitespace
        line = line.toLowerCase();
        String[] inputs = line.split("\\s+");
        List<String> inputQuestions = ShowOutput.inputQuestions;
        List<String> outputValues = ShowOutput.outputValues;

        if (line.startsWith(Constants.HOW_MANY_CREDITS_IS)) {
            inputQuestions.add(line);

        } else if (line.startsWith(Constants.HOW_MUCH_IS)) {
            inputQuestions.add(line);

        } else if (line.contains(Constants._IS) && !line.contains(Constants.CREDITS)){

        }
        else if (line.contains(Constants._IS) && line.contains(Constants.CREDITS)){
            GetCreditValue(line);
        }
        else {
            inputQuestions.add(line);
            outputValues.add(NO_IDEA);
        }

    }

    private int GetCreditValue(String line) {
        int creditValue;
        Pattern p = Pattern.compile("(\\d+)");
        Matcher m = p.matcher(line);
        while(m.find())
        {
            System.out.println(m.group(1));
        }
        return 0;
    }

}
