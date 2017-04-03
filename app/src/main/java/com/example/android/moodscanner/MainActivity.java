package com.example.android.moodscanner;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;



        public class MainActivity extends AppCompatActivity {

            private ImageView thumbPrint;
            private TextView result;
            private Runnable mRunnable;
            private AnimationDrawable thumbAnimation;
            private String[] moodResults;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);



                moodResults = new String[] {
                        "Someone is not in a good mood",
                        "You are very happy",
                        "No comments...",
                        "You're stressed out!",
                        "Its going to be wonderful",
                        "Not your day :(",
                        "Smile - it's good for you.",
                        "In the clouds...",
                        "Sad!",
                        "Excited!"

                };

                thumbPrint = (ImageView) findViewById(R.id.thumbPrint);
                thumbPrint.setBackgroundResource(R.drawable.thumb_animation);
                thumbAnimation = (AnimationDrawable) thumbPrint.getBackground();

                result = (TextView) findViewById(R.id.resultText);


                thumbPrint.setOnLongClickListener( new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {

                        thumbAnimation.start();

                        showResult();
                        // Toast.makeText(getApplicationContext(), "Hellooo there", Toast.LENGTH_LONG).show();

                        return true;
                    }
                });


            }


            public void showResult(){

                mRunnable = new Runnable() {
                    @Override
                    public void run() {

                        int rand = (int) (Math.random() * moodResults.length);
                        result.setText(moodResults[rand]);

                        //stop animation
                        thumbAnimation.stop();


                    }
                };

                Handler mHandler = new Handler();
                mHandler.postDelayed(mRunnable, 5000); // 5 seconds

            }
        }







