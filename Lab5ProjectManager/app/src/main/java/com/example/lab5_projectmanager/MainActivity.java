package com.example.lab5_projectmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_PROFILE = 1;
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
        imageAvatar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivityForResult(intent, REQUEST_CODE_PROFILE);
        });
        editTeamName = findViewById(R.id.editTeamName);
        editPostalCode = findViewById(R.id.editPostalCode);
        buttonOpenMaps = findViewById(R.id.buttonOpenMaps);

        // We’ll add onClick logic later
    }

    public void OnOpenInGoogleMaps(View view) {
        // Get the postal code from the EditText
        String postalCode = editPostalCode.getText().toString().trim();

        if (postalCode.isEmpty()) {
            editPostalCode.setError("Please enter a postal code");
            return;
        }

        // Build a URI for a Google Maps search
        Uri gmmIntentUri = Uri.parse("https://www.google.com/maps/search/?api=1&query="
                + Uri.encode(postalCode));

        // Create an intent to view this URI
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

        // Start the activity if there is an app that can handle it
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_PROFILE && resultCode == RESULT_OK && data != null) {
            int avatarResId = data.getIntExtra("avatarResId", -1);
            if (avatarResId != -1) {
                imageAvatar.setImageResource(avatarResId);
            }
        }
    }
}