package com.example.admin.Oder_app;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;
import static com.example.admin.Oder_app.CakeAdapter.PREFS_NAME;


public class CupCakeFragment extends Fragment {

    public CupCakeFragment() {
        // Required empty public constructor
    }


    private Button btnAdd,btnSub;
    private TextView tvTotal,tvTotalPrice;
    private int add= 0;
    private int sub= 0;
    private  int price;
    int idName ;
    int totalItem ;
    String information;
    String recite;//t
    SharedPreferences prefs;
    ArrayList<Cake> cakes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_cupcake_fragment, container, false);
        ListView gvList =(ListView)rootView.findViewById(R.id.gvList);

        prefs = getActivity().getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
       cakes =new ArrayList<>() ;
        final TextView tvTotPrice = (TextView)rootView.findViewById(R.id.tvTotPrice);
        final TextView tvView = (TextView)rootView.findViewById(R.id.tvView);
        final TextView tvTotQuantity = (TextView)rootView.findViewById(R.id.tvTotQuantity);
        final ImageView ivAddCart =(ImageView) rootView.findViewById(R.id.ivAddCart);

        idName = prefs.getInt("idName", 0);
        totalItem= prefs.getInt("total", 0);
        information = prefs.getString("info","");

        Cake cake = new Cake(R.drawable.cup_ten,"Red Velvet","Egg custard, chocolate",12);
        cakes.add(cake);
         cake = new Cake(R.drawable.cup_two,"Mocha Cookie Crumble Cakes","Bananas, toffee, biscuits",9);
        cakes.add(cake);
        cake = new Cake(R.drawable.cup_three,"Cheerwine Cupcakes","Coconut milk and rice flour",10);
        cakes.add(cake);
        cake = new Cake(R.drawable.cup_four,"Chocolate Mud Cakes","hi",15);
        cakes.add(cake);
        cake = new Cake(R.drawable.cup_five,"Nutella Cupcakes","hi",20);
        cakes.add(cake);
        cake = new Cake(R.drawable.cup_six,"Blueberry Cheesecakes","hi",7);
        cakes.add(cake);
        cake = new Cake(R.drawable.cup_seven,"German Chocolate","hi",7);
        cakes.add(cake);
        cake = new Cake(R.drawable.cup_eight," Fauxstess Cupcakes","hi",3);
        cakes.add(cake);
        cake = new Cake(R.drawable.cup_nine,"Black Forest Cherry Cakes","hi",3);
        cakes.add(cake);
        cake = new Cake(R.drawable.cup_one,"Spring Blossom","hi",3);
        cakes.add(cake);
        cake = new Cake(R.drawable.cup_evlen," Pudding Cupcakes","hi",3);
        cakes.add(cake);


        //  String restoredText = prefs.getString("text", null);
        tvTotPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumberFormat format = NumberFormat.getCurrencyInstance();
                SharedPreferences prefs = getActivity().getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
                int idName = prefs.getInt("idName", 0); //0 is the default value.
                int totalItem =prefs.getInt("total", 0);
                tvTotPrice.setText("Total cost"+ format.format(idName));
                tvTotQuantity.setText(totalItem+" Items");
            }
        });
        tvView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NumberFormat format = NumberFormat.getCurrencyInstance();
                SharedPreferences prefs = getActivity().getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
                int idName = prefs.getInt("idName", 0); //0 is the default value.
                int totalItem =prefs.getInt("total", 0);
                tvTotPrice.setText("Total cost"+ format.format(idName));
                if(totalItem==1) {
                    tvTotQuantity.setText(totalItem + " Item");
                }else {
                    tvTotQuantity.setText(totalItem + " Items");
                }
            }
        });
        NumberFormat format = NumberFormat.getCurrencyInstance();

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



        CakeAdapter adapter = new CakeAdapter(this.getContext(),cakes);

        gvList.setAdapter(adapter);


        return rootView;
    }



}
