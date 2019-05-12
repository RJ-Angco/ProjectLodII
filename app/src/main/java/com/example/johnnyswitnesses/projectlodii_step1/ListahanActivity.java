package com.example.johnnyswitnesses.projectlodii_step1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class ListahanActivity extends AppCompatActivity {
    private RecyclerView mainList;
    private FirebaseFirestore mFirestore;
    private RestaurantListAdapter restaurantListAdapter;
    private ArrayList<RestaurantBean> restaurants;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listahan);

        restaurants = MainMenuActivity.RESTAURANTS;
        restaurantListAdapter = new RestaurantListAdapter(restaurants);
        mainList = (RecyclerView) findViewById(R.id.rv);
        mainList.setHasFixedSize(true);
        mainList.setLayoutManager(new LinearLayoutManager(this));
        mainList.setAdapter(restaurantListAdapter);
  /*      mFirestore = KahitAnoActivity.db;
        mFirestore.getInstance();
        mFirestore.collection("Restaurants").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(QuerySnapshot documentSnapshots, FirebaseFirestoreException e) {
                if (e!= null)
                {
                    // Log.d(TAG, e.getMessage());
                }
                for(DocumentChange doc : documentSnapshots.getDocumentChanges()){
                    if(doc.getType() == DocumentChange.Type.ADDED){
                        RestaurantBean restaurantBean = doc.getDocument().toObject(RestaurantBean.class);
                        restaurants.add(restaurantBean);

                        restaurantListAdapter.notifyDataSetChanged();
                    }

                }
            }
        });*/
    }
}
