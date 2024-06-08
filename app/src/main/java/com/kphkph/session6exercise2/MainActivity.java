package com.kphkph.session6exercise2;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText etAmount;
    RadioButton rdb10,rdb15,rdb20;
    TextView tvTipAmount;

    RadioGroup rdgTips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setViews();
    }

    private void setViews(){
        etAmount = (EditText) findViewById(R.id.etAmount);
        rdb10 = (RadioButton) findViewById(R.id.rdb10);
        rdb15 = (RadioButton) findViewById(R.id.rdb15);
        rdb20 = (RadioButton) findViewById(R.id.rdb20);
        tvTipAmount = (TextView) findViewById(R.id.tvTipAmount);
        rdgTips = (RadioGroup) findViewById(R.id.rdgTips);


        rdgTips.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton radioButton = findViewById(checkedId);
            calculateTips(radioButton);
        });


    }
    private void calculateTips(RadioButton checkedButton){
        String input = etAmount.getText().toString();
        if(input.isEmpty()){
            Toast.makeText(this,"Please enter amount to caclulate tip!",Toast.LENGTH_LONG).show();
        }
        else{
            try{
                int baseAmount = Integer.parseInt(input);
                double totalTips = 0;
                if(checkedButton.getText().equals("10%")){
                    totalTips = baseAmount * 0.1;
                }
                else if(checkedButton.getText().equals("15%")){
                    totalTips = baseAmount * 0.15;
                }
                else if(checkedButton.getText().equals("20%")){
                    totalTips = baseAmount * 0.2;
                }
                tvTipAmount.setText(String.valueOf(totalTips));
            }
            catch (Exception e){
                Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();
            }
        }
    }


}