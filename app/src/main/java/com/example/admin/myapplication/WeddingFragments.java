package com.example.admin.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;
import static com.example.admin.myapplication.CakeAdapter.PREFS_NAME;


public class WeddingFragments extends Fragment {
public static int to=0;

    String email;
    private ArrayList<Cake> cakes;
    Cake cake ;
    ListView gvList;
    String recite;
    SharedPreferences prefs;
    int totalItem;
    int idName;
    public WeddingFragments() {
        // Required empty public constructor
    }


    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

         rootView= inflater.inflate(R.layout.fragment_cupcake_fragment, container, false);
         gvList =(ListView)rootView.findViewById(R.id.gvList);
        cakes =new ArrayList<>() ;


        final TextView tvTotPrice = (TextView)rootView.findViewById(R.id.tvTotPrice);
        final TextView tvView = (TextView)rootView.findViewById(R.id.tvView);
        final TextView tvTotQuantity = (TextView)rootView.findViewById(R.id.tvTotQuantity);
        final ImageView ivAddCart =(ImageView) rootView.findViewById(R.id.ivAddCart);



         cake = new Cake(R.drawable.wed_elevn,"Boston cream pie","3g",200);
        cakes.add(cake);
        cake = new Cake(R.drawable.wed___two,"White Cake","1kg",150);
        cakes.add(cake);
        cake = new Cake(R.drawable.wed_two,"Pineapple","500g",120);
        cakes.add(cake);
        cake = new Cake(R.drawable.wed_three,"Layer Cake","250g",130);
        cakes.add(cake);
        cake = new Cake(R.drawable.wed_one,"Funfetti","500g",150);
        cakes.add(cake);
        cake = new Cake(R.drawable.wed_six,"Gingerbread Cake","3g",200);
        cakes.add(cake);
        cake = new Cake(R.drawable.wed_seven,"Chocolate Chip Cake","1kg",150);
        cakes.add(cake);
        cake = new Cake(R.drawable.wed_eight,"Beignet","500g",120);
        cakes.add(cake);
        cake = new Cake(R.drawable.wed_ten,"Peanut Butter","250g",130);
        cakes.add(cake);
        cake = new Cake(R.drawable.wed_one,"Tres leches","500g",150);
        cakes.add(cake);

        NumberFormat format = NumberFormat.getCurrencyInstance();
        prefs = getActivity().getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        idName = prefs.getInt("idName", 0); //0 is the default value.
        totalItem =prefs.getInt("total", 0);


      //  String restoredText = prefs.getString("text", null);
        tvTotPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumberFormat format = NumberFormat.getCurrencyInstance();


                tvTotPrice.setText("Total cost"+ format.format(idName));
                tvTotQuantity.setText(totalItem+" Items");
            }
        });
       final String information = prefs.getString("info","");


        tvView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumberFormat format = NumberFormat.getCurrencyInstance();
                SharedPreferences prefs = getActivity().getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

                tvTotPrice.setText("Total cost"+ format.format(idName));
                if(totalItem==1) {
                    tvTotQuantity.setText(totalItem + " Item");
                }else {
                    tvTotQuantity.setText(totalItem + " Items");
                }

            }
        });


        recite = "Order info \n******************************\n"+information+"Total Cost \n \n"+ format.format(idName);
        ivAddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ///Toast.makeText(getActivity(),information,Toast.LENGTH_LONG).show();
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("Conform Order");
                alertDialog.setMessage("Do really wanna Order");



                alertDialog.setIcon(R.drawable.email);

                alertDialog.setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {



//
                                        Intent i = new Intent(Intent.ACTION_SEND);
                                        i.setType("message/rfc822");
                                        i.putExtra(Intent.EXTRA_EMAIL  ,new String[]{"recipient@example.com"} );
                                        i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
                                        i.putExtra(Intent.EXTRA_TEXT   , recite);


                                    try {
                                        startActivity(Intent.createChooser(i, "Send mail..."));
                                    } catch (android.content.ActivityNotFoundException ex) {
                                        Toast.makeText(getActivity(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                                    }

//
                                }
                            }
                        );

                alertDialog.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                alertDialog.show();

            }
        });




        //
        CakeAdapter adapter = new CakeAdapter(this.getContext(),cakes);


        gvList.setAdapter(adapter);


        return rootView;
    }


}
