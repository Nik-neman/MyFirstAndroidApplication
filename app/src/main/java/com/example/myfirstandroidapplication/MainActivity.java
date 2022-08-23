package com.example.myfirstandroidapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

        private EditText text_from_user;
        private TextView result;
        private Button btn;
        private float num;
        private Button nextPageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnBtnClick();
    }

    public void OnBtnClick(){
         this.text_from_user = findViewById(R.id.editText);
         this.result = findViewById(R.id.result_field);
         this.btn = findViewById(R.id.button_convert);
         this.nextPageBtn = findViewById(R.id.nextPageBtn);

         nextPageBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
//                 Intent intent = new Intent("com.example.myfirstandroidapplication.LoginPageActivity");
                 Intent intent = new Intent(MainActivity.this, LoginPageActivity.class);
                 startActivity(intent);
                 result.setText("Переходим на другую страницу");
             }
         });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = text_from_user.getText().toString();
                if(isDigit(text)){
                    num = Float.parseFloat(text_from_user.getText().toString());

                   //Задаём настройки всплывающего окна
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Хотите умножить значение на 2?");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            num *= 1.61* 2f;
                            result.setText(Float.toString(num));
                            btn.setText("Готово");
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                btn.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                            } else {
                                btn.setBackgroundColor(Color.BLUE);
                            }
                        }
                    });

                    builder.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            num *= 1.61;
                            result.setText(Float.toString(num));
                            btn.setText("Готово");
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                btn.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                            } else {
                                btn.setBackgroundColor(Color.BLUE);
                                dialog.cancel();
                            }
                        }
                    });

                    //Создаём всплывающее окно
                    AlertDialog alert = builder.create();
                    alert.setTitle("Умножение чисел");
                    alert.show();



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