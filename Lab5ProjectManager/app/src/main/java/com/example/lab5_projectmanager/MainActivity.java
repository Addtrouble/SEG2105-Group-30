package com.example.lab5_projectmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageAvatar;
    private EditText editTeamName;
    private EditText editPostalCode;
    private Button buttonOpenMaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link Java variables to XML views
        imageAvatar = findViewById(R.id.imageAvatar);
        editTeamName = findViewById(R.id.editTeamName);
        editPostalCode = findViewById(R.id.editPostalCode);
        buttonOpenMaps = findViewById(R.id.buttonOpenMaps);

        // We’ll add onClick logic later
    }
}