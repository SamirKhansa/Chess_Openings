package com.example.chessopenings;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.net.Uri;


import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.fragment.app.Fragment;


import android.sax.Element;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AboutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AboutFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AboutFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AboutFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AboutFragment newInstance(String param1, String param2) {
        AboutFragment fragment = new AboutFragment();
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
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_about, container, false);

        AboutUsPage aboutUsPage=new AboutUsPage(getContext());
        aboutUsPage.getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.background_light)));

        aboutUsPage.setCancelable(false);
        AppCompatButton RateNowBtn = view.findViewById(R.id.rateNowBtn);
        AppCompatRatingBar Star=view.findViewById(R.id.RatingBar);
        LinearLayout l1=view.findViewById(R.id.Layout2);
        l1.setBackgroundColor(Color.TRANSPARENT);
        RateNowBtn.setOnClickListener(v -> {

            aboutUsPage.show();
        });

        ImageView Email=view.findViewById(R.id.Email);
        ImageView WhatsApp=view.findViewById(R.id.WhatsApp);
        ImageView LinkedIn=view.findViewById(R.id.LinkedIn);
        LinkedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.linkedin.com/in/samir-khansa-45b255231/"));

                startActivity(intent);
            }
        });
        WhatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int PhoneNumber=71523488;
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "Hello, I would like to contact you via WhatsApp.");
                intent.setPackage("com.whatsapp");
                startActivity(Intent.createChooser(intent, "Contact me via"));

            }
        });
        Email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myEmail="samirkhansa01@gmail.com";
                String Subject="Job Opportunity";
                String message="";
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { myEmail });
                intent.putExtra(Intent.EXTRA_SUBJECT,Subject);
                intent.putExtra(Intent.EXTRA_TEXT,message);
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent, "Choose an email client"));

            }
        });


        return view;
    }
}