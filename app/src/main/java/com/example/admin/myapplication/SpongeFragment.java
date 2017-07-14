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



public class SpongeFragment extends Fragment {
    View rootView;
    private ArrayList<Cake> cakes;
    Cake cake ;
    ListView gvList;
    SharedPreferences prefs;
    int idName ;
    int totalItem ;
    String recite;//t



    public SpongeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_cupcake_fragment, container, false);
        // Inflate the layout for this fragment
        gvList =(ListView)rootView.findViewById(R.id.gvList);
        cakes =new ArrayList<>() ;

         prefs = getActivity().getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        final ImageView ivAddCart =(ImageView) rootView.findViewById(R.id.ivAddCart);



        final TextView tvTotPrice = (TextView)rootView.findViewById(R.id.tvTotPrice);
        final TextView tvView = (TextView)rootView.findViewById(R.id.tvView);
        final TextView tvTotQuantity = (TextView)rootView.findViewById(R.id.tvTotQuantity);

         idName = prefs.getInt("idName", 0);
         totalItem= prefs.getInt("total", 0);


        cake = new Cake(R.drawable.sponge_one,"Pandan cake","3g",200);
        cakes.add(cake);
        cake = new Cake(R.drawable.sponge_two,"Victoria sponge cake","1kg",150);
        cakes.add(cake);
        cake = new Cake(R.drawable.sponge_three,"Sea sponge cake","500g",120);
        cakes.add(cake);
        cake = new Cake(R.drawable.sponge_four,"Pain au chocolat","250g",130);
        cakes.add(cake);
        cake = new Cake(R.drawable.sponge_five,"Charlotte ","500g",150);
        cakes.add(cake);
            cake = new Cake(R.drawable.sponge_sixe,"Plain","3g",200);
        cakes.add(cake);
        final String information = prefs.getString("info","");


        //  String restoredText = prefs.getString("text", null);
        tvTotPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumberFormat format = NumberFormat.getCurrencyInstance();
                SharedPreferences prefs = getActivity().getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

                tvTotPrice.setText("Total cost"+ format.format(idName));
                tvTotQuantity.setText(totalItem+" Items");
            }
        });
        tvView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumberFormat format = NumberFormat.getCurrencyInstance();


                tvTotPrice.setText("Total cost"+ format.format(idName));
                if(totalItem==1) {
                    tvTotQuantity.setText(totalItem + " Item");
                }else {
                    tvTotQuantity.setText(totalItem + " Items");
                }
            }
        });
        NumberFormat format = NumberFormat.getCurrencyInstance();

        recite = "Order info \n******************************\n"+information+"\n\n\nTotal Cost "+ format.format(idName);
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



        tvTotPrice.setText(""+CakeAdapter.total);
        CakeAdapter adapter = new CakeAdapter(this.getContext(),cakes);


        gvList.setAdapter(adapter);


        return rootView;
    }


}
