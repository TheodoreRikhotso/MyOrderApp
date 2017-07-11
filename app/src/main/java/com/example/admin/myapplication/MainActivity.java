package com.example.admin.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.fOne);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frigmentOne f = new frigmentOne();
                FragmentManager manager=getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                transaction.add(R.id.fragment_placeholder,f);
                transaction.commit();
            }
        });


    }


    public void onSelectedFragment(View view)
    {
        Fragment newFragment;
        if(view == findViewById(R.id.fOne))
        {
             newFragment =  new frigmentOne();

        }else if(view == findViewById(R.id.fTwo)){
            newFragment =  new frigmentTwo();
        }else {
            newFragment =  new frigmentOne();
        }


        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_placeholder,newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
