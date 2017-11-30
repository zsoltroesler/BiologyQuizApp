package com.example.android.biologyquizapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static com.example.android.biologyquizapp.R.id.checkbox_quiz_four_A;
import static com.example.android.biologyquizapp.R.id.checkbox_quiz_four_B;
import static com.example.android.biologyquizapp.R.id.checkbox_quiz_four_C;
import static com.example.android.biologyquizapp.R.id.checkbox_quiz_four_D;
import static com.example.android.biologyquizapp.R.id.falseRadioButtonOne;
import static com.example.android.biologyquizapp.R.id.falseRadioButtonThree;
import static com.example.android.biologyquizapp.R.id.radio_group1;
import static com.example.android.biologyquizapp.R.id.radio_group2;
import static com.example.android.biologyquizapp.R.id.radio_group3;
import static com.example.android.biologyquizapp.R.id.trueRadioButtonTwo;

public class MainActivity extends AppCompatActivity {

    private String name;
    private int point;
    private Button submit;
    private Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //If submit button is clicked, different results are shown in terms of overall points
        submit = (Button) findViewById(R.id.button_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Access to the correct RadioButtons of questions 1-3 -> if it is checked, point is increased by 1
                RadioButton radioButtonOne = (RadioButton) findViewById(falseRadioButtonOne);
                if (radioButtonOne.isChecked()) point++;
                RadioButton radioButtonTwo = (RadioButton) findViewById(trueRadioButtonTwo);
                if (radioButtonTwo.isChecked()) point++;
                RadioButton radioButtonThree = (RadioButton) findViewById(falseRadioButtonThree);
                if (radioButtonThree.isChecked()) point++;

                //Access to the CheckBoxes of question 4 -> if all are checked, point is increased by 1
                CheckBox checkboxFourA = (CheckBox) findViewById(checkbox_quiz_four_A);
                CheckBox checkboxFourB = (CheckBox) findViewById(checkbox_quiz_four_B);
                CheckBox checkboxFourC = (CheckBox) findViewById(checkbox_quiz_four_C);
                CheckBox checkboxFourD = (CheckBox) findViewById(checkbox_quiz_four_D);
                if (checkboxFourA.isChecked() && checkboxFourB.isChecked() && checkboxFourC.isChecked()
                        && checkboxFourD.isChecked()) point++;

                //Access to the EditText of question 5 -> if Titin is entered, point is increased by 1
                EditText answerField = (EditText) findViewById(R.id.edit_answer);
                String answer = answerField.getText().toString().trim();
                // Ignore case-sensitive input
                if (answer.equalsIgnoreCase("Titin")) point++;

                //Take the user's name and the overall points to generate the specific toast message
                EditText nameField = (EditText) findViewById(R.id.edit_name);
                name = nameField.getText().toString();
                int overallPoints = point;
                String QuizMessage = createQuizSummary(name, overallPoints);

                Context context = getApplicationContext();
                CharSequence text = QuizMessage;
                int duration = Toast.LENGTH_LONG;
                //Extend the Toast.LENGTH_LONG (3.5sec) up to 14 sec
                //in order the user to be able to read the answers carefully.
                for (int i = 0; i < 4; i++) {
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

                //After submission the submit is set to not enabled  -> user should reset the quiz
                submit.setEnabled(false);
            }
        });

        //If reset is clicked, overall points of quiz set back to zero and submit button is enabled again
        reset = (Button) findViewById(R.id.button_reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Reset questions 1-3 with radio buttons
                RadioGroup radioGroupOne = (RadioGroup) findViewById(radio_group1);
                radioGroupOne.clearCheck();
                RadioGroup radioGroupTwo = (RadioGroup) findViewById(radio_group2);
                radioGroupTwo.clearCheck();
                RadioGroup radioGroupThree = (RadioGroup) findViewById(radio_group3);
                radioGroupThree.clearCheck();

                //Reset question 4 with checkboxes
                CheckBox checkboxFourA = (CheckBox) findViewById(checkbox_quiz_four_A);
                checkboxFourA.setChecked(false);
                CheckBox checkboxFourB = (CheckBox) findViewById(checkbox_quiz_four_B);
                checkboxFourB.setChecked(false);
                CheckBox checkboxFourC = (CheckBox) findViewById(checkbox_quiz_four_C);
                checkboxFourC.setChecked(false);
                CheckBox checkboxFourD = (CheckBox) findViewById(checkbox_quiz_four_D);
                checkboxFourD.setChecked(false);

                //Reset question 5 with EditText field
                EditText answerField = (EditText) findViewById(R.id.edit_answer);
                answerField.setText("");

                //Result of the quiz set back to zero
                point = 0;

                //Submit button is enabled again
                submit.setEnabled(true);
            }
        });
    }

    /**
     * This method specifies the different results in String in terms of different overall points
     */
    private String createQuizSummary(String name, int overallPoints) {
        // Text with summary of the quiz
        String quizSummary;

        switch (overallPoints) {
            case 5:
                quizSummary = "You are just awesome!!! " + name
                        + "\nYou reached " + overallPoints + " out of 5"
                        + "\n"
                        + "\nAnswers:"
                        + "\n1. False. Chicken is the closest living relative to Tyrannosaurus Rex."
                        + "\n2. True."
                        + "\n3. False. Blue whales have the lowest heart rate, beating just six times a minute."
                        + "\n4. A-True, B-True, C-True, D-True."
                        + "\n5. Titin.";
                return quizSummary;
            case 4:
                quizSummary = "Pretty good! " + name
                        + "\nYou reached " + overallPoints + " out of 5"
                        + "\n"
                        + "\nAnswers:"
                        + "\n1. False. Chicken is the closest living relative to Tyrannosaurus Rex."
                        + "\n2. True."
                        + "\n3. False. Blue whales have the lowest heart rate, beating just six times a minute."
                        + "\n4. A-True, B-True, C-True, D-True."
                        + "\n5. Titin.";
                return quizSummary;
            case 3:
                quizSummary = "Not bad " + name
                        + "\nYou reached " + overallPoints + " out of 5"
                        + "\n"
                        + "\nAnswers:"
                        + "\n1. False. Chicken is the closest living relative to Tyrannosaurus Rex."
                        + "\n2. True."
                        + "\n3. False. Blue whales have the lowest heart rate, beating just six times a minute."
                        + "\n4. A-True, B-True, C-True, D-True."
                        + "\n5. Titin.";
                return quizSummary;
            case 2:
                quizSummary = "There is room for improvement " + name
                        + "\nYou reached " + overallPoints + " out of 5"
                        + "\n"
                        + "\nAnswers:"
                        + "\n1. False. Chicken is the closest living relative to Tyrannosaurus Rex."
                        + "\n2. True."
                        + "\n3. False. Blue whales have the lowest heart rate, beating just six times a minute."
                        + "\n4. A-True, B-True, C-True, D-True."
                        + "\n5. Titin.";
                return quizSummary;
            case 1:
                quizSummary = "Only 1 point! " + name
                        + "\nYou reached " + overallPoints + " out of 5"
                        + "\n"
                        + "\nAnswers:"
                        + "\n1. False. Chicken is the closest living relative to Tyrannosaurus Rex."
                        + "\n2. True."
                        + "\n3. False. Blue whales have the lowest heart rate, beating just six times a minute."
                        + "\n4. A-True, B-True, C-True, D-True."
                        + "\n5. Titin.";
                return quizSummary;
            default:
                quizSummary = "Oh my God!!! " + name
                        + "\nYou reached " + overallPoints + " out of 5"
                        + "\n"
                        + "\nAnswers:"
                        + "\n1. False. Chicken is the closest living relative to Tyrannosaurus Rex."
                        + "\n2. True."
                        + "\n3. False. Blue whales have the lowest heart rate, beating just six times a minute."
                        + "\n4. A-True, B-True, C-True, D-True."
                        + "\n5. Titin.";
                return quizSummary;
        }
    }
}

