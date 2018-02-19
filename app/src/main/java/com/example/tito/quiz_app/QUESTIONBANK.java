package com.example.tito.quiz_app;

/**
 * Created by Tito on 10/09/2017.
 */

public class QUESTIONBANK {
    private int question;
    private boolean answer;
    public QUESTIONBANK(int question,boolean answer){
        this.question=question;
        this.answer=answer;
    }
    public void setQuestion(int question){
        this.question=question;
    }
    public int getQuestion(){
        return question;
    }
    public boolean isAnswer(){
        return answer;
    }
    public void setAnswer(boolean answer){
        this.answer=answer;
    }
}
