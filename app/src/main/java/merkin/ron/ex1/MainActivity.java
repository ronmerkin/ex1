package merkin.ron.ex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button calcTip;
    private EditText amount;
    private TextView tip;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calcTip = (Button) findViewById(R.id.calculateButton);
        amount = (EditText) findViewById(R.id.amount);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        tip = (TextView) findViewById(R.id.tip);
        calcTip.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                double afterCalc;
                // if the entered amount is valid
                try{
                    afterCalc = Double.valueOf(amount.getText().toString()) * 0.12;
                }catch (Exception e){

                    amount.setError("Invalid Input");
                    return;
                }
                // if we want to round the result
                if(checkBox.isChecked()){
                        afterCalc = Math.ceil(afterCalc);
                    }
                tip.setText(String.valueOf("Tip: " + afterCalc));



            }
        });


    }
}
