package com.example.lab5_projectmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;

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

        buttonOpenMaps.setOnClickListener(this::OnOpenInGoogleMaps);
    }

    public void OnOpenInGoogleMaps(View view) {
        // Just to confirm the click is wired up
        Toast.makeText(this, "Opening location…", Toast.LENGTH_SHORT).show();

        // Get the postal code from the EditText
        String postalCode = editPostalCode.getText().toString().trim();

        if (postalCode.isEmpty()) {
            editPostalCode.setError("Please enter a postal code");
            return;
        }

        // 1) Try to open the Google Maps app directly using geo: URI
        Uri geoUri = Uri.parse("geo:0,0?q=" + Uri.encode(postalCode));
        Intent mapsAppIntent = new Intent(Intent.ACTION_VIEW, geoUri);
        mapsAppIntent.setPackage("com.google.android.apps.maps");

        if (mapsAppIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapsAppIntent);
            return;
        }

        // 2) Fallback: open Google Maps in a browser
        Uri webUri = Uri.parse(
                "https://www.google.com/maps/search/?api=1&query=" + Uri.encode(postalCode)
        );
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webUri);

        if (webIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(webIntent);
        } else {
            // 3) Nothing can handle either intent
            Toast.makeText(this,
                    "No app found to open maps or browser.",
                    Toast.LENGTH_LONG).show();
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