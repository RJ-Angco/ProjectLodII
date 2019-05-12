package com.example.johnnyswitnesses.projectlodii_step1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Random;

public class KahitAnoActivity extends AppCompatActivity {
    ImageView img;
    TextView output;
    Random rnd;
    TextView pangalan;
    private FirebaseFirestore db;
    private ArrayList<RestaurantBean> RESTAURANTS;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kahit_ano);
        this.setTitle("Project Lodi");
        output =(TextView) findViewById(R.id.txtPangalan);
        pangalan = (TextView) findViewById(R.id.txtSaan);
        RESTAURANTS = MainMenuActivity.RESTAURANTS;
        output.setText("Saan tayo lodi?");
        db = MainMenuActivity.db;
      /*  db.collection("Restaurants").addSnapshotListener(new EventListener<QuerySnapshot>() {
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
        });*/

    }
    public void taraLodi(View v)
    {
        Toast.makeText(this, "Tara, enka!", Toast.LENGTH_LONG).show();
     //   img = (ImageView) findViewById(R.id.imgResto);
        rnd = new Random();
        int num = rnd.nextInt(RESTAURANTS.size());
        //img.setImageResource(RESTAURANTS.get(num).getImageID());

        pangalan.setText(RESTAURANTS.get(num).getName());
        output.setText(RESTAURANTS.get(num).getDescription());
    }
    public void balikMenu(View v)
    {
        i = new Intent(this, MainMenuActivity.class);
        startActivity(i);
    }
    public void dagdagBago(View v)
    {
        i = new Intent(this, DagdagActivity.class);
        startActivity(i);
    }
    public  void seeList(View v){
        i = new Intent(this, ListahanActivity.class);
        startActivity(i);
    }
}
