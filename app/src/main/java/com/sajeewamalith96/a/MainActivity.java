package com.sajeewamalith96.a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView screen;
    Button Ac,Power,Back,Div,Mul,Add,Sub,One,Two,Three,Four,Five,Six,Seven,Eight,Nine,Zero,Ans,Dot,Equal;
    private String input,Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen=(TextView)findViewById(R.id.textView);
        Ac=(Button)findViewById(R.id.ac);
        Power=(Button)findViewById(R.id.p);
        Back=(Button)findViewById(R.id.b);
        Div=(Button)findViewById(R.id.div);
        Mul=(Button)findViewById(R.id.mul);
        Add=(Button)findViewById(R.id.add);
        Sub=(Button)findViewById(R.id.sub);
        One=(Button)findViewById(R.id.b1);
        Two=(Button)findViewById(R.id.b2);
        Three=(Button)findViewById(R.id.b3);
        Four=(Button)findViewById(R.id.b4);
        Five=(Button)findViewById(R.id.b5);
        Six=(Button)findViewById(R.id.b6);
        Seven=(Button)findViewById(R.id.b7);
        Eight=(Button)findViewById(R.id.b8);
        Nine=(Button)findViewById(R.id.b9);
        Zero=(Button)findViewById(R.id.b0);
        Ans=(Button)findViewById(R.id.ans);
        Dot=(Button)findViewById(R.id.dot);
        Equal=(Button)findViewById(R.id.eql);


    }
    public void ButtonClick(View view){
        Button button=(Button) view;
        String data=button.getText().toString();
        switch (data){
            case "AC":
                input="";
                break;
            case "Ans":
                input+=Answer;
                break;
            case "x":
                Solve();
                input+="*";
                break;
            case "^":
                Solve();
                input+="^";
                break;
            case "=":
                Solve();
                Answer=input;
            case "B":
                String newText=input.substring(0,input.length()-1);
                        input=newText;
                break;
            default:
                if (input==null){
                    input="";
                }
                if (data.equals("+")||data.equals("-")||data.equals("/")) {
                    Solve();
                    }
                 input+=data;

        }
        screen.setText(input);

    }
    private void Solve(){
        if (input.split("\\*").length==2){
            String number[]=input.split("\\*");
            try {
                double mul=Double.parseDouble(number[0])*Double.parseDouble(number[1]);
                input=mul+"";
            }
            catch (Exception e){
                
            }
        }
        else if (input.split("/").length==2){
            String number[]=input.split("/");
            try {
                double div=Double.parseDouble(number[0])/Double.parseDouble(number[1]);
                input=div+"";
            }
            catch (Exception e){

            }
        }

        else if (input.split("\\^").length==2){
            String number[]=input.split("\\^");
            try {
                double p=Math.pow(Double.parseDouble(number[0]),Double.parseDouble(number[1]));
                input=p+"";
            }
            catch (Exception e){

            }
        }
        else if (input.split("\\+").length==2){
            String number[]=input.split("\\+");
            try {
                double add=Double.parseDouble(number[0])+Double.parseDouble(number[1]);
                input=add+"";
            }
            catch (Exception e){

            }
        }
        else if (input.split("-").length>1){
            String number[]=input.split("-");
            if (number[0]==""&& number.length==2){
                number[0]=0+"";
            }
            try {
                double sub=0;
                if(number.length==2) {
                    sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                }else if (number.length==3){
                    sub = Double.parseDouble(number[1]) - Double.parseDouble(number[2]);
                           }
                input=sub+"";
            }
            catch (Exception e){

            }
        }

        String n[]=input.split("\\.");
        if (n.length>1){
            if(n[1].equals("0")){
                input=n[0];
            }


        }
        screen.setText(input);


    }
}