package com.example.chessopenings;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.cardview.widget.CardView;

public class AboutUsPage extends Dialog {
    public AboutUsPage(@NonNull Context context) {
        super(context);
    }
    private float userRate=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_about);
        AppCompatRatingBar Star=findViewById(R.id.RatingBar);
        AppCompatButton LaterBtn = findViewById(R.id.laterBtn);
        LaterBtn.setVisibility(View.VISIBLE);
        Star.setVisibility(View.VISIBLE);
        ImageView WhatsApp=findViewById(R.id.WhatsApp);

        ImageView LinkedIn=findViewById(R.id.LinkedIn);
        ImageView Email=findViewById(R.id.Email);

        WhatsApp.setVisibility(View.GONE);
//        Instagram.setVisibility(View.GONE);
        LinkedIn.setVisibility(View.GONE);
        Email.setVisibility(View.GONE);

        CardView cc=findViewById(R.id.CardViewToBeRemoved);
        cc.setVisibility(View.GONE);
        final AppCompatButton rateNowBtn=findViewById(R.id.rateNowBtn);
        final AppCompatButton laterBtn=findViewById(R.id.laterBtn);
        final RatingBar ratingBar=findViewById(R.id.RatingBar);
        final ImageView ratingImage=findViewById(R.id.ratingImage);
        rateNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Thank you for your rating!", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
        laterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser){
                if(rating<=1){
                    ratingImage.setImageResource(R.drawable.icons8_pawn_64);
                }
                else if(rating<=2){
                    ratingImage.setImageResource(R.drawable.icons8_knight_64);
                }
                else if(rating<=3){
                    ratingImage.setImageResource(R.drawable.icons8_bishop_64);
                }
                else if(rating<=4){
                    ratingImage.setImageResource(R.drawable.icons8_queen_64);
                }
                else if(rating<=5){
                    ratingImage.setImageResource(R.drawable.icons8_king_64);
                }
                animateImage(ratingImage);
                userRate=rating;

            }
        });
    }


    private void animateImage(ImageView ratingImage){
        ScaleAnimation scaleAnimation=new ScaleAnimation(0,1f,0,1f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(200);
        ratingImage.startAnimation(scaleAnimation);
    }



}
