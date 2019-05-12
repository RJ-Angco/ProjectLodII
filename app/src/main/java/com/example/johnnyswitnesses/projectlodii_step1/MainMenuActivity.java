package com.example.johnnyswitnesses.projectlodii_step1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MainMenuActivity extends AppCompatActivity {
   // ImageView imgLogo;
    public static FirebaseFirestore db;
    public static ArrayList<RestaurantBean> RESTAURANTS;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        this.setTitle("Project Lodi");
      //  imgLogo.setImageResource(R.drawable.logo);
        RESTAURANTS = new ArrayList<RestaurantBean>();
        db = FirebaseFirestore.getInstance();
        db.collection("Restaurants").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                if (e!= null)
                {
                    // Log.d(TAG, e.getMessage());
                }
                for(DocumentChange doc : documentSnapshots.getDocumentChanges()){
                    if(doc.getType() == DocumentChange.Type.ADDED){
                        RestaurantBean restaurantBean = doc.getDocument().toObject(RestaurantBean.class);
                        RESTAURANTS.add(restaurantBean);
                    }

                }
            }
        });



    }
    public void doSomething(View v)
    {
        switch(v.getId())
        {
            case R.id.btnKahitAno:
                i = new Intent(this, KahitAnoActivity.class);
                startActivity(i);
                break;
            case R.id.btnBudget:
                i = new Intent(this, NuBudgetActivity.class);
                startActivity(i);
                break;
        }
    }

}
