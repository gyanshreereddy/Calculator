package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private Button one,two,three,four,five,six,seven,eight,nine,decimal,zero,isEqual,add,sub,mul,divide,ac,del;
    TextView history;
    TextView res;
    String number=null;
    Double firno=0.0,secno=0.0;
    String status=null;
    Boolean operator=false;
    DecimalFormat format=new DecimalFormat("####.####");
    String historyres,curres;
    Boolean dot=true;
    Boolean ACcheck=true;
    Boolean eqCpntrol=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        decimal=findViewById(R.id.decimal);
        zero=findViewById(R.id.mul10);
        isEqual=findViewById(R.id.isEqual);
        add=findViewById(R.id.add);
        sub=findViewById(R.id.sub);
        mul=findViewById(R.id.multiply);
        divide=findViewById(R.id.divide);
        ac=findViewById(R.id.ac);
        del=findViewById(R.id.del);

        history=findViewById(R.id.history);
        res=findViewById(R.id.result);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClicked(""+1);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClicked(""+2);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClicked(""+3);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClicked(""+4);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClicked(""+5);
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClicked(""+6);
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClicked(""+7);
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClicked(""+8);
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClicked(""+9);
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClicked(""+0);
            }
        });

        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dot){
                    if(number==null){
                        number="0.";
                    }
                    else{
                        number=number+".";
                    }
                    res.setText(number);
                }
                dot=false;

            }
        });

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                status=null;
                number=null;
                res.setText(""+0);
                history.setText("");
                firno=secno=0.0;
                dot=true;
                ACcheck=true;

            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ACcheck){
                    res.setText("0");
                }

                else{
                    number=number.substring(0,number.length()-1);
                    if(number.length()==0){
                        del.setClickable(false);
                    }
                    if(number.contains(".")){
                        dot=false;
                    }
                    else{
                        dot=true;
                    }
                    res.setText(number);
                }

            }
        });

        mul.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                historyres=history.getText().toString();
                curres=res.getText().toString();
                history.setText(historyres+curres+"*");

                if(operator){
                    if(status=="add"){
                        addition();
                    }
                    else if(status=="subs"){
                        substraction();
                    }
                    else if(status=="divide"){
                        division();
                    }
                    else{
                        multiply();
                    }
                }
                status="nultiply";
                operator=false;
                number=null;

            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                historyres=history.getText().toString();
                curres=res.getText().toString();
                history.setText(historyres+curres+"/");
                if(operator){
                    if(status=="add"){
                        addition();
                    }
                    else if(status=="subs"){
                        substraction();
                    }
                    else if(status=="multiply"){
                        multiply();
                    }
                    else{
                        division();
                    }
                }
                status="divide";
                operator=false;
                number=null;


            }
        });

        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                historyres=history.getText().toString();
                curres=res.getText().toString();
                history.setText(historyres+curres+"+");

                if(operator){
                    if(status=="divide"){
                        division();
                    }
                    else if(status=="subs"){
                        substraction();
                    }
                    else if(Objects.equals(status, "multiply")){
                        multiply();
                    }
                    else{
                        addition();
                    }
                }
                status="add";
                operator=false;
                number=null;



            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                historyres=history.getText().toString();
                curres=res.getText().toString();
                history.setText(historyres+curres+"-");
                if(operator){
                    if(status=="add"){
                        addition();
                    }
                    else if(status=="divide"){
                        division();
                    }
                    else if(status=="multiply"){
                        multiply();
                    }
                    else{
                        substraction();
                    }
                }
                status="subs";
                operator=false;
                number=null;



            }
        });

        isEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(operator){
                    if(status=="add"){
                        addition();
                    }
                    else if(status=="divide"){
                        division();
                    }
                    else if(status=="multiply"){
                        multiply();
                    }
                    else if(status=="subs"){
                        substraction();
                    }
                    else{
                        firno=Double.parseDouble(res.getText().toString());
                    }
                }
                operator=false;
                eqCpntrol=true;

            }
        });


    }
    void numberClicked(String view){

        if(number==null){
            number=view;
        }
        else if(eqCpntrol){
            firno=0.0;
            secno=0.0;
            number=view;

        }
        else{
            number=number+view;
        }
        res.setText(number);
        operator=true;
        eqCpntrol=false;
    }

    void addition(){
        secno=Double.parseDouble(res.getText().toString());
        firno=firno+secno;

        res.setText(""+format.format(firno));
        dot=true;
        ACcheck=false;
        del.setClickable(true);
    }

    void substraction(){
        secno=Double.parseDouble(res.getText().toString());
        firno=firno-secno;

        res.setText(""+format.format(Math.abs(firno)));
        dot=true;
    }

    void multiply(){
        if(firno==0){
            firno=1.0;
            secno=Double.parseDouble(res.getText().toString());
            firno=firno*secno;
        }
        else{
            secno=Double.parseDouble(res.getText().toString());
            firno=secno*firno;
        }
        res.setText(""+format.format(firno));
        dot=true;
    }
    void division(){
        if(firno==0){
            secno=Double.parseDouble(res.getText().toString());
            firno=secno/1;
        }
        else{
            secno=Double.parseDouble(res.getText().toString());
            firno=firno/secno;
        }
        res.setText(""+format.format(firno));
        dot=true;
    }
}