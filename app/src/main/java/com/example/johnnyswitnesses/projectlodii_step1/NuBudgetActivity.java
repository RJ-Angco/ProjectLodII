package com.example.johnnyswitnesses.projectlodii_step1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class NuBudgetActivity extends AppCompatActivity {
   private ArrayList<RestaurantBean> allRestaurants;
   private ArrayList<RestaurantBean> budgetRestaurants;
   Random rnd;
   TextView output;
   Intent i;
   EditText anoBudget;
   TextView pangalan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nu_budget);
        this.setTitle("Project Lodi");
        output = (TextView) findViewById(R.id.txtSaan);
        pangalan = (TextView) findViewById(R.id.txtPangalan);
        anoBudget = (EditText) findViewById(R.id.txtBudget);
        anoBudget.setText("");
        output.setText("Saan tayo lodi?");
        allRestaurants = MainMenuActivity.RESTAURANTS;
        budgetRestaurants = new ArrayList<RestaurantBean>();

    }
    public void onABudget(View v)
    {
        budgetRestaurants.removeAll(budgetRestaurants);
        try {
            double budget = (Double.parseDouble((anoBudget.getText()).toString()));
            for (int i = 0; i < MainMenuActivity.RESTAURANTS.size(); i++) {
                if (budget >= MainMenuActivity.RESTAURANTS.get(i).getMinPrice() && budget < MainMenuActivity.RESTAURANTS.get(i).getMaxPrice() || (budget > MainMenuActivity.RESTAURANTS.get(i).getMaxPrice())) {
                    budgetRestaurants.add(MainMenuActivity.RESTAURANTS.get(i));
                }
            }
            if (budgetRestaurants.isEmpty()) {
                pangalan.setText("Alaws, pre. :(");

            } else {
                rnd = new Random();
                int num = rnd.nextInt(budgetRestaurants.size());
             //   img.setImageResource(budgetRestaurants.get(num).getImageID());
                pangalan.setText(budgetRestaurants.get(num).getName());
                output.setText(budgetRestaurants.get(num).getDescription());
                Toast.makeText(NuBudgetActivity.this, "Sa " + budgetRestaurants.get(num).getName() + " tayo. Apir!", Toast.LENGTH_SHORT).show();
            }
        }
        catch(Exception e)
        {
            //output.setText("Bawal blanko, lodi </3");
            Toast.makeText(NuBudgetActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    public void clearAll(View v)
    {
        pangalan.setText("???");
        output.setText("Saan tayo lodi?");
        budgetRestaurants.removeAll(budgetRestaurants);
    }
    public void returnToMenu(View v)
    {
        i = new Intent(this, MainMenuActivity.class);
        startActivity(i);
    }
}
