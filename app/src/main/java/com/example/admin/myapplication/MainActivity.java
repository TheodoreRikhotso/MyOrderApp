package com.example.admin.myapplication;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import static com.example.admin.myapplication.R.id.btnCupcake;

public class MainActivity extends FragmentActivity {

    Typeface tfc1;
    Button wedding,birthday,luxury,cupcake,sponge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(btnCupcake);

                CupCakeFragment f = new CupCakeFragment();
                FragmentManager manager=getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                transaction.add(R.id.fragment_placeholder,f);
                transaction.commit();



    }


    public void onSelectedFragment(View view)
    {

        birthday =(Button)findViewById(R.id.btnBirthday) ;
        cupcake =(Button)findViewById(btnCupcake) ;
        luxury =(Button)findViewById(R.id.btnLuxury) ;
        sponge =(Button)findViewById(R.id.btnSponge) ;
        wedding =(Button)findViewById(R.id.btnWedding) ;
        Fragment newFragment;
        if(view == findViewById(R.id.btnBirthday))
        {


              newFragment = new BirthdayFragment();
            birthday.setBackgroundColor(Color.WHITE);

            birthday.setEnabled(false);
            luxury.setEnabled(true);
            sponge.setEnabled(true);
            wedding.setEnabled(true);
            cupcake.setEnabled(true);


        }else if(view == findViewById(btnCupcake)){

            cupcake.setBackgroundColor(Color.WHITE);
            cupcake.setEnabled(false);
            luxury.setEnabled(true);
            birthday.setEnabled(true);
            sponge.setEnabled(true);
            wedding.setEnabled(true);

            newFragment =  new CupCakeFragment();

        }else if(view == findViewById(R.id.btnLuxury)){

            luxury.setEnabled(false);
            luxury.setBackgroundColor(Color.WHITE);
            birthday.setEnabled(true);
            sponge.setEnabled(true);
            wedding.setEnabled(true);
            cupcake.setEnabled(true);
            newFragment =  new LuxuryFragment();

        }else if(view == findViewById(R.id.btnSponge)){

            sponge.setBackgroundColor(Color.WHITE);
            sponge.setEnabled(false);
            luxury.setEnabled(true);
            birthday.setEnabled(true);

            wedding.setEnabled(true);
            cupcake.setEnabled(true);
            newFragment =  new SpongeFragment();

        }else if(view == findViewById(R.id.btnWedding)){


            wedding.setBackgroundColor(Color.WHITE);
            wedding.setEnabled(false);
            luxury.setEnabled(true);
            birthday.setEnabled(true);
            sponge.setEnabled(true);

            cupcake.setEnabled(true);
            newFragment =  new WeddingFragments();



        }else {
            newFragment =  new CupCakeFragment();
        }


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_placeholder,newFragment);
       // transaction.addToBackStack(null);
        transaction.commit();
    }
}
