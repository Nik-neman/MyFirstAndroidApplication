package com.example.myfirstandroidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        private EditText text_from_user;
        private TextView result;
        private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnBtnClick();
    }

    public void OnBtnClick(){
         text_from_user = findViewById(R.id.editText);
         result = findViewById(R.id.result_field);
         btn = findViewById(R.id.button_convert);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = text_from_user.getText().toString();
                if(isDigit(text)){
                    float num = Float.parseFloat(text_from_user.getText().toString());
                    num *= 1.61;
                    result.setText(Float.toString(num));
                    btn.setText("Готово");
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        btn.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    } else {
                        btn.setBackgroundColor(Color.BLUE);
                    }
                }else {
//                    result.setText("Число введено не корректно");
                    Toast.makeText(MainActivity.this, "Число введено не корректно",
                            Toast.LENGTH_LONG).show();
                    text_from_user.setText("");
                }
            }
        });

    }
    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}