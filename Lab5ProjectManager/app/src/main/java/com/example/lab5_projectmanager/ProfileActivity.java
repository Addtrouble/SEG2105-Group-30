package com.example.lab5_projectmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    public void SetTeamIcon(View view) {
        int id = view.getId();
        int avatarResId = 0;

        if (id == R.id.avatar_australia) {
            avatarResId = R.drawable.flag_of_australia;
        } else if (id == R.id.avatar_brazil) {
            avatarResId = R.drawable.flag_of_brazil;
        } else if (id == R.id.avatar_canada) {
            avatarResId = R.drawable.flag_of_canada;
        } else if (id == R.id.avatar_china) {
            avatarResId = R.drawable.flag_of_china;
        } else if (id == R.id.avatar_portugal) {
            avatarResId = R.drawable.flag_of_portugal;
        } else if (id == R.id.avatar_russia) {
            avatarResId = R.drawable.flag_of_russia;
        } else if (id == R.id.avatar_saudi_arabia) {
            avatarResId = R.drawable.flag_of_saudi_arabia;
        } else if (id == R.id.avatar_dr_congo) {
            avatarResId = R.drawable.flag_of_the_democratic_republic_of_the_congo;
        } else if (id == R.id.avatar_united_states) {
            avatarResId = R.drawable.flag_of_the_united_states;
        }

        if (avatarResId != 0) {
            Intent returnIntent = new Intent();
            returnIntent.putExtra("avatarResId", avatarResId);
            setResult(RESULT_OK, returnIntent);
            finish();
        }
    }
}