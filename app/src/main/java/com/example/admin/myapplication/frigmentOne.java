package com.example.admin.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class frigmentOne extends Fragment {

    public frigmentOne() {
        // Required empty public constructor
    }


    private Button btnAdd,btnSub;
    private TextView tvTotal,tvTotalPrice;
    private int add= 0;
    private int sub= 0;
    private  int price;
    ArrayList<Cake> cakes;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_frigment_one, container, false);
        ListView gvList =(ListView)rootView.findViewById(R.id.gvList);
       cakes =new ArrayList<>() ;

        btnAdd =(Button)rootView.findViewById(R.id.btnAdd);
        btnSub =(Button)rootView.findViewById(R.id.btnRemove );

//        btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                add++;
//                tvTotal.setText(""+add);
//                price =add*5;
//
//            }
//        });
//        btnSub.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                add--;
//                tvTotal.setText(""+add);
//                price =price-5;
//                tvTotalPrice.setText("R"+price+":00");
//
//            }
//        });


        final int[] num = new int[1];
//        gvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                btnAdd.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                       add++;
//                    Toast.makeText(frigmentOne.this.getActivity(),"add",Toast.LENGTH_LONG).show();
//                        price =add*5;
//                        add =5;
//                    }
//
//                });
//            }5
//        });
//num[0]=add;

        int i =CakeAdapter.add =CakeAdapter.add +1;
        int s= 5;

        Cake cake = new Cake(R.drawable.keke,"hi",i);
        cakes.add(cake);
         cake = new Cake(R.drawable.keke,"hi",3);
        cakes.add(cake);
        cake = new Cake(R.drawable.keke,"hi",3);
        cakes.add(cake);





        CakeAdapter adapter = new CakeAdapter(this.getContext(),cakes);

        gvList.setAdapter(adapter);


        return rootView;
    }



}
