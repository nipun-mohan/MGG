package mtg.tw.nipunmohan.mtg;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private Button btnShowOutput;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*ProcessInputData processInputData = new ProcessInputData();
        try {
            processInputData.readFileAndProcess(getAssets().open("input.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        btnShowOutput = (Button) findViewById(R.id.btn_show_output);
        btnShowOutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ShowOutput.processOutput();


            }
        });
    }



}
