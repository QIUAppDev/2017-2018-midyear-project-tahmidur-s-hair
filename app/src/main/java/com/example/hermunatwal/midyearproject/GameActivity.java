package com.example.hermunatwal.midyearproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    private EditText guess;
    private TextView guessbox;
    private String movie;
    private String display = "";
    final String[] movies={"BRIGHT","THE DARK KNIGHT","SUPERMAN","AQUAMAN","TRANSFORMERS","DOOM","THE HANGOVER"};
    private int lives;
    String image = "o";
    private static final String TAG = "MyActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        chooseMovie();
        for (int i = 0; i<movie.length(); i++){
            char temp = movie.charAt(i);
            if(temp == ' '){
                display=display.concat(" ");
            }
            else{
                display=display.concat("_ ");
            }
        }
        Intent intent = this.getIntent();
        String strdata = intent.getExtras().getString("lives");
        lives = Integer.parseInt(strdata);
        final String weather = intent.getExtras().getString("weather");
        setDisplay();
        if (weather.equals("cold")){
            changePictureC();
        }
        else{
            changePictureH();
        }
        final Button button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                guess = (EditText)findViewById(R.id.edittext1);
                guessbox = (TextView)findViewById(R.id.textView);
                checkGuess();
                addGuess();
                setDisplay();
                if (weather.equals("cold")){
                    changePictureC();
                }
                else{
                    changePictureH();
                }
            }
        });
    }
    public void checkGuess(){
        String tempp = display;
        display="";
        for (int i = 0; i<movie.length(); i++) {
            char temp = movie.charAt(i);
            if (temp == ' ') {
                display=display.concat(" ");
            }
            else if((temp+"").equals((guess.getText()+"").toUpperCase())){
                display=display.concat((guess.getText()+"").toUpperCase());
            }
            else if(!(guessbox.getText()+"").contains(temp+"")) {
                display=display.concat( "_ ");
            }
            else{
                display=display.concat(temp+"");
            }
        }
        if(tempp.equals(display)){
            lives--;
            image.concat("c");
            if (lives==0){
                Intent l = new Intent(getApplicationContext(), GameOverActivity.class);
                startActivity(l);
            }
        }
        if(display.equals(movie)){
            Intent l = new Intent(getApplicationContext(), GameOverActivity.class);
            startActivity(l);
        }

    }
    public void setDisplay(){
        TextView displayBox = (TextView)findViewById(R.id.textView3);
        displayBox.setText(display);
    }
    public void chooseMovie(){
        int temp = (int)(Math.random()*movies.length);
        movie =  movies[temp];
    }
    public void addGuess(){
        guessbox.setText(guessbox.getText()+""+(guess.getText()+"").toUpperCase()+", ");
    }
    public void changePictureC(){
        ImageView image = (ImageView)findViewById(R.id.imageView2);
        if (lives==4){
            image.setImageResource(R.drawable.c);
        }
        else if(lives==3){
            image.setImageResource(R.drawable.cc);
        }
        else if(lives==2){
            image.setImageResource(R.drawable.ccc);
        }
        else if(lives==1){
            image.setImageResource(R.drawable.cccc);
        }
        else if(lives==0){
            image.setImageResource(R.drawable.ccccc);
        }
    }
    public void changePictureH(){
        ImageView image = (ImageView)findViewById(R.id.imageView2);
        if (lives==4){
            image.setImageResource(R.drawable.h);
        }
        else if(lives==3){
            image.setImageResource(R.drawable.hh);
        }
        else if(lives==2){
            image.setImageResource(R.drawable.hhh);
        }
        else if(lives==1){
            image.setImageResource(R.drawable.hhhh);
        }
        else if(lives==0){
            image.setImageResource(R.drawable.hhhhh);
        }
    }
}
