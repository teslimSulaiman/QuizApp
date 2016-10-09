package com.example.abu.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void gradeRadioButton(int radioGroupId, int radioButtonAnswerId){

        RadioGroup optionsRadioGroup = (RadioGroup) findViewById(radioGroupId);
        int optionSelectedId = optionsRadioGroup.getCheckedRadioButtonId();
        if(optionSelectedId == radioButtonAnswerId) {
            score++;
        }
    }

    private void gradeEditText(int correctAnswer, int answerWrittenId){

        EditText editText = (EditText) findViewById(answerWrittenId);
        String textWritten = editText.getText().toString().trim();
        textWritten = textWritten.toLowerCase();
        String answer = getResources().getString(correctAnswer);
        if(answer.equals(textWritten)){
            score++;
        }
    }
    private void gradeCheckBox(int[] allcheckedBoxes, int[] allunCheckedBoxes){
        if(confirmAllCheckedBoxes(allcheckedBoxes)&& confirmAllUncheckedBoxes(allunCheckedBoxes)){
            score++;
        }
    }
    private boolean confirmAllCheckedBoxes(int[] allcheckedBoxes){

        for(int i = 0; i < allcheckedBoxes.length; i++)
        {
            CheckBox checkBox = (CheckBox) findViewById(allcheckedBoxes[i]);
            if(!checkBox.isChecked()){
                return false;
            }
        }
        return true;
    }
    private boolean confirmAllUncheckedBoxes(int[] allunCheckedBoxes){
        for (int i = 0; i < allunCheckedBoxes.length; i++){
            CheckBox checkBox = (CheckBox) findViewById(allunCheckedBoxes[i]);
            if(checkBox.isChecked()){
                return false;
            }
        }
        return true;
    }
    public void gradeQuiz(View view){
        gradeRadioButton(R.id.radio_group_question1,R.id.option_a_question1);
        gradeRadioButton(R.id.radio_group_question2,R.id.option_c_question2);
        gradeRadioButton(R.id.radio_group_question3,R.id.option_d_question3);
        gradeEditText(R.string.answer_question6, R.id.edit_text_question6);
        gradeCheckBox( new int[]{R.id.option_a_question4,R.id.option_b_question4,R.id.option_d_question4}, new int[]{R.id.option_c_question4});
        gradeCheckBox( new int[]{R.id.option_a_question5,R.id.option_b_question5}, new int[]{R.id.option_c_question5,R.id.option_d_question5});

        Toast.makeText(getApplicationContext(), "You scored "+score+" out of 6",Toast.LENGTH_LONG).show();
        score =0;
    }


}
