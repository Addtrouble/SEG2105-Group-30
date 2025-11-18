package com.example.lab5_projectmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // set up click listeners for each flag
        setupAvatarClick(R.id.avatarFlag1, R.drawable.flag_of_australia);
        setupAvatarClick(R.id.avatarFlag2, R.drawable.flag_of_brazil);
        setupAvatarClick(R.id.avatarFlag3, R.drawable.flag_of_canada);
        setupAvatarClick(R.id.avatarFlag4, R.drawable.flag_of_china);
        setupAvatarClick(R.id.avatarFlag5, R.drawable.flag_of_portugal);
        setupAvatarClick(R.id.avatarFlag6, R.drawable.flag_of_russia);
        setupAvatarClick(R.id.avatarFlag7, R.drawable.flag_of_saudi_arabia);
        setupAvatarClick(R.id.avatarFlag8, R.drawable.flag_of_the_democratic_republic_of_the_congo);
        setupAvatarClick(R.id.avatarFlag9, R.drawable.flag_of_the_united_states);
    }

    private void setupAvatarClick(int viewId, int drawableResId) {
        ImageView img = findViewById(viewId);
        img.setOnClickListener(v -> {
            Intent result = new Intent();
            result.putExtra("avatarResId", drawableResId);
            setResult(Activity.RESULT_OK, result);
            finish();   // go back to MainActivity
        });
    }
}