package com.example.tito.quiz_app;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Button b1;
            private Button b2;
    private Button b3;
    private Button b4;
    int currentquestion;
    TextView textView;
    private Button cb;
    private Button hb;
    private String KEY_INDEX="currentindex";
QUESTIONBANK [] qb=new QUESTIONBANK[]{
        new QUESTIONBANK(R.string.India,true),
        new QUESTIONBANK(R.string.Pak,false),
        new QUESTIONBANK(R.string.America,true),
        new QUESTIONBANK(R.string.South,false),
        new QUESTIONBANK(R.string.Sri,true),
};
private int index=0;
            @Override
    protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                if(savedInstanceState!=null){
                    index=savedInstanceState.getInt(KEY_INDEX,0)
                }
                textView = (TextView) findViewById(R.id.tv);
                int currentquestion = qb[index].getQuestion();
                textView.setText(currentquestion);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        index=(index+1)%qb.length;
                    }
                });
                b4=(Button)findViewById(R.id.pb);
                b1 = (Button) findViewById(R.id.tb);
                b2 = (Button) findViewById(R.id.fb);
                b3 = (Button) findViewById(R.id.nb);
                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        checkAnswer(true);
                    }
                });
                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        checkAnswer(false);
                    }
                });
                b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        index = (index + 1) % qb.length;
                        updateQuestion();
                    }
                });
                b4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(index>0)
                        {index=(index-1)%qb.length;
                        updateQuestion();}
                        else {
                            index=0;
                            updateQuestion();
                        }
                    }
                });
            hb=(Button)findViewById(R.id.hb);
                cb=(Button)findViewById(R.id.cb);
                cb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i=new Intent(MainActivity.this,CheatActivity.class);
                        startActivity(i);
                    }
                });




            }

    @Override
public void onSaveInstanceState(Bundle SavedInstanceState){
    super.onSaveInstanceState(SavedInstanceState);
    SavedInstanceState.putInt(KEY_INDEX,index);
}
    private void updateQuestion(){
        int currentQuestion=qb[index].getQuestion();
        textView.setText(currentQuestion);
    }
    private void checkAnswer(boolean userpprssed) {
        boolean answeristrue = qb[index].isAnswer();
        int messageResId = 0;
        if (userpprssed == answeristrue) {
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }
Toast.makeText(this,messageResId,Toast.LENGTH_SHORT).show();

    }
}















































