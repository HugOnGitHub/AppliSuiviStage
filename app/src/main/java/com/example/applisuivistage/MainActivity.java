package com.example.applisuivistage;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //on associe à un objet java de type Button, un widget repéré physiquement par son id
        Button btnAfficherStages = findViewById(R.id.btnAfficherStages);
        Button btnFicheSuivi = findViewById(R.id.btnFicheSuivi);
        Button btnMajBDD = findViewById(R.id.btnMajBDD);
        //on place un écouteur dessus
        View.OnClickListener ecouteur = new View.OnClickListener() {
            //on implémente la méthode onclick
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnAfficherStages:

                    case R.id.btnFicheSuivi:

                    case R.id.btnMajBDD:

                }
            }
        };
        //on affecte au bouton l'écouteur
        btnAfficherStages.setOnClickListener(ecouteur);
        btnFicheSuivi.setOnClickListener(ecouteur);
        btnMajBDD.setOnClickListener(ecouteur);
        }

}