package com.example.android.biologyquizapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //  int point global variable declaration and initialization
    int point = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // This method checks whether the correct answer -> correct radio button ticked
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Correct answer question by question
        switch(view.getId()) {
            case R.id.falseRadioButtonOne:
                if (checked)
                    point = point + 1;
                    break;
            case R.id.trueRadioButtonTwo:
                if (checked)
                    point = point + 1;
                    break;
            case R.id.falseRadioButtonThree:
                if (checked)
                    point = point + 1;
                break;
            case R.id.trueRadioButtonFour:
                if (checked)
                    point = point + 1;
                break;
            case R.id.trueRadioButtonFive:
                if (checked)
                    point = point + 1;
                break;
        }
        return;
    }

    // if submit button is click, different toast messages show the result of the quiz
    public int submit (View view) {
        EditText nameField = (EditText)findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        int overallPoints = point;
        String QuizMessage = createQuizSummary(name, overallPoints);

        Context context = getApplicationContext();
        CharSequence text = QuizMessage;
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        return (overallPoints);
    }

    // this method specifies the different results in String in terms of different overall points
    private String createQuizSummary(String name, int overallPoints) {
        if (overallPoints == 5) {
        String QuizSummary = "You are just awesome!!! " + name
                    + "\nYou reached " + overallPoints + " out of 5"
                    + "\nAnswers:"
                    + "\n1. False. Chicken is the closest living relative to Tyranosaurus Rex."
                    + "\n2. True."
                    + "\n3. False. Blue whales have the slowest heart rate, beating just six times a minute."
                    + "\n4. True."
                    + "\n5. True.";
            return QuizSummary;
        }
        if (overallPoints == 4) {
            String QuizSummary = "Pretty good! " + name
                    + "\nYou reached " + overallPoints + " out of 5"
                    + "\nAnswers:"
                    + "\n1. False. Chicken is the closest living relative to Tyranosaurus Rex."
                    + "\n2. True."
                    + "\n3. False. Blue whales have the slowest heart rate, beating just six times a minute."
                    + "\n4. True."
                    + "\n5. True.";
            return QuizSummary;
        }
        if (overallPoints == 3) {
            String QuizSummary = "Not bad " + name
                    + "\nYou reached " + overallPoints + " out of 5"
                    + "\nAnswers:"
                    + "\n1. False. Chicken is the closest living relative to Tyranosaurus Rex."
                    + "\n2. True."
                    + "\n3. False. Blue whales have the slowest heart rate, beating just six times a minute."
                    + "\n4. True."
                    + "\n5. True.";
            return QuizSummary;
        }
        if (overallPoints == 2) {
            String QuizSummary = "There is room for improvement " + name
                    + "\nYou reached " + overallPoints + " out of 5"
                    + "\nAnswers:"
                    + "\n1. False. Chicken is the closest living relative to Tyranosaurus Rex."
                    + "\n2. True."
                    + "\n3. False. Blue whales have the slowest heart rate, beating just six times a minute."
                    + "\n4. True."
                    + "\n5. True.";
            return QuizSummary;
        }
        if (overallPoints == 1) {
            String QuizSummary = "Only 1 point! " + name
                    + "\nYou reached " + overallPoints + " out of 5"
                    + "\nAnswers:"
                    + "\n1. False. Chicken is the closest living relative to Tyranosaurus Rex."
                    + "\n2. True."
                    + "\n3. False. Blue whales have the slowest heart rate, beating just six times a minute."
                    + "\n4. True."
                    + "\n5. True.";
            return QuizSummary;
        }
        if (overallPoints == 0) {
            String QuizSummary = "Oh my God!!! " + name
                    + "\nYou reached " + overallPoints + " out of 5"
                    + "\nAnswers:"
                    + "\n1. False. Chicken is the closest living relative to Tyranosaurus Rex."
                    + "\n2. True."
                    + "\n3. False. Blue whales have the slowest heart rate, beating just six times a minute."
                    + "\n4. True."
                    + "\n5. True.";
            return QuizSummary;
        }
        return (name);
    }
}
