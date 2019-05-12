package com.example.johnnyswitnesses.projectlodii_step1;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class DagdagActivity extends AppCompatActivity {
    FirebaseDatabase kainandb = FirebaseDatabase.getInstance();
    EditText txtRestauName;
    EditText numMinBudget;
    EditText numMaxBudget;
    EditText txtRestauDesc;
    ListAdapter listAdapter;
    ListView listView;
    FirebaseFirestore db;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagdag);
        txtRestauName = findViewById(R.id.txtRestauName);
        kainandb = FirebaseDatabase.getInstance();
        numMinBudget =  findViewById(R.id.numMinBudget);
        numMaxBudget =  findViewById(R.id.numMaxBudget);
        txtRestauDesc =  findViewById(R.id.txtRestauDesc);
        db = MainMenuActivity.db;
        db.getInstance();
    }
    public void dagdagKainan(View v){
      final RestaurantBean newResto = new RestaurantBean(txtRestauName.getText().toString(), Double.parseDouble(numMinBudget.getText().toString()), Double.parseDouble(numMaxBudget.getText().toString()), txtRestauDesc.getText().toString());
      db.collection("Restaurants").add(newResto).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
          @Override
          public void onSuccess(DocumentReference documentReference) {
            Toast.makeText(DagdagActivity.this, "Naidagdag ang " + newResto.getName() + "! Apir!", Toast.LENGTH_SHORT).show();

          }
      }).addOnFailureListener(new OnFailureListener() {
          @Override
          public void onFailure(@NonNull Exception e) {
              String error = e.getMessage();
              Toast.makeText(DagdagActivity.this, "Error: " + error, Toast.LENGTH_SHORT).show();
          }
      });
    }
    public void balik(View v){
        finish();
    }
}
