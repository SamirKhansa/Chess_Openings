package com.example.chessopenings;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuizFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuizFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public QuizFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     *
     * @return A new instance of fragment QuizFragment.
     */

    // TODO: Rename and change types and number of parameters
    TextView totalQuestionsTextView;
    TextView QuestionTextView;
    Button ansA,andB,andC,andD;
    Button submitBtn;
    int score=0;
    int totalQuestion=QuestionAnsewr.question.length;
    int currentQuestionIndex=0;
    String SelectedAnsewr="";
    public static QuizFragment newInstance(String param1, String param2) {
        QuizFragment fragment = new QuizFragment();

        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
        totalQuestionsTextView=view.findViewById(R.id.total_question);
        QuestionTextView=view.findViewById(R.id.question);
        ansA=view.findViewById(R.id.AnsA);
        andB=view.findViewById(R.id.AnsB);
        andC=view.findViewById(R.id.AnsC);
        andD=view.findViewById(R.id.AnsD);
        submitBtn=view.findViewById(R.id.submit_btn);


        ansA.setOnClickListener(this::onClick);
        andB.setOnClickListener(this::onClick);
        andC.setOnClickListener(this::onClick);
        andD.setOnClickListener(this::onClick);
        submitBtn.setOnClickListener(this::onClick);



        totalQuestionsTextView.setText("Total questions: "+totalQuestion);
        loadnewQuestion();


        // Inflate the layout for this fragment
        return view;

    }





    void loadnewQuestion(){
        if(currentQuestionIndex==totalQuestion){
            finishQuiz();
            return;
        }
        QuestionTextView.setText(QuestionAnsewr.question[currentQuestionIndex]);
        ansA.setText(QuestionAnsewr.Choises[currentQuestionIndex][0]);
        andB.setText(QuestionAnsewr.Choises[currentQuestionIndex][1]);
        andC.setText(QuestionAnsewr.Choises[currentQuestionIndex][2]);
        andD.setText(QuestionAnsewr.Choises[currentQuestionIndex][3]);
    }

    @Override
    public void onClick(View v) {

        Button clickedButton=(Button) v;


        if(clickedButton.getId()==R.id.submit_btn){

            String[][] arr=QuestionAnsewr.Choises;
            if(SelectedAnsewr!=""&&SelectedAnsewr.equals(arr[currentQuestionIndex][0])){
                score+=25;
            }
            else if(SelectedAnsewr.equals(arr[currentQuestionIndex][1])){
                score+=50;
            }
            else if(SelectedAnsewr.equals(arr[currentQuestionIndex][2])){
                score+=75;
            }
            else{
                score+=0;
            }
            currentQuestionIndex++;
            loadnewQuestion();
        }
        else{
            SelectedAnsewr=clickedButton.getText().toString();

        }

    }
    void finishQuiz(){
        String output="";
        if(score/totalQuestion>80){
            output=QuestionAnsewr.Openings[totalQuestion-1];

        }
        else if(score/totalQuestion>60){
            output=QuestionAnsewr.Openings[1];
        }
        else{
            output=QuestionAnsewr.Openings[0];
        }
        new AlertDialog.Builder(requireContext()).setTitle(output).setMessage("The Opening is "+output).setPositiveButton("Restart",(dialogInterface,i)->restartQuiz()).setCancelable(false).show();

    }
    void restartQuiz(){
        score=0;
        currentQuestionIndex=0;
        loadnewQuestion();
    }

}