package com.example.calculateurdimptslocaux;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText nomInput, adresseInput, surfaceInput, piecesInput;
    private CheckBox piscineCheckbox;
    private TextView resultView;
    private Button calculButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nomInput = findViewById(R.id.input_nom);
        adresseInput = findViewById(R.id.input_adresse);
        surfaceInput = findViewById(R.id.input_surface);
        piecesInput = findViewById(R.id.input_pieces);
        piscineCheckbox = findViewById(R.id.checkbox_piscine);
        resultView = findViewById(R.id.result);
        calculButton = findViewById(R.id.button_calcul);

        calculButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculerImpots();
            }
        });
    }

    private void calculerImpots() {

        String nom = nomInput.getText().toString().trim();
        String adresse = adresseInput.getText().toString().trim();
        String surfaceText = surfaceInput.getText().toString().trim();
        String piecesText = piecesInput.getText().toString().trim();

        if (nom.isEmpty() || adresse.isEmpty() || surfaceText.isEmpty() || piecesText.isEmpty()) {
            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            return;
        }

        double surface;
        int pieces;

        try {
            surface = Double.parseDouble(surfaceText);
            pieces = Integer.parseInt(piecesText);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Veuillez entrer des valeurs numériques valides", Toast.LENGTH_SHORT).show();
            return;
        }

        if (surface <= 0 || pieces <= 0) {
            Toast.makeText(this, "La surface et le nombre de pièces doivent être positifs", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean piscine = piscineCheckbox.isChecked();

        double impotBase = surface * 2;
        double supplement = pieces * 50;

        if (piscine) {
            supplement = supplement + 100;
        }

        double total = impotBase + supplement;

        String resultat =
                "Nom : " + nom + "\n" +
                        "Adresse : " + adresse + "\n\n" +
                        "Impôt de base : " + impotBase + " DH\n" +
                        "Supplément : " + supplement + " DH\n" +
                        "Impôt total : " + total + " DH";

        resultView.setText(resultat);
    }
}