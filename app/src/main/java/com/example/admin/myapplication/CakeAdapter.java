package com.example.admin.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Admin on 7/11/2017.
 */

public class CakeAdapter extends BaseAdapter {
    private Context c;

    private int resource;
    private List<Cake> cakes;
    private LayoutInflater inflater;
    public static int add = 0;
    private int totalQuatinty = 0;

    int pos;
    public  int qntyPotion1=0;
    public static double total=0.0;
    int qntyPotion2=0;
    int qntyPotion3=0;
    int qntyPotion4=0;
    int qntyPotion5=0;
    int qntyPotion6=0;
    int totCost =	0;

    String info =" ";


    Typeface tfc1;
    public static final String PREFS_NAME = "MyPrefsFile";



    private View.OnClickListener myButtonClickListener = new View.OnClickListener() {

        @Override

        public void onClick(View v) {

            View parentRow = (View) v.getParent();

            ListView listView = (ListView) parentRow.getParent();

            pos = listView.getPositionForView(parentRow);

        }

    };

    public CakeAdapter(Context c, ArrayList<Cake> cakes) {
        this.c = c;
        this.cakes = cakes;
    }


    @Override
    public int getCount() {
        return cakes.size();
    }

    @Override
    public Object getItem(int position) {
        return cakes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View rootView, ViewGroup parent) {

        if (inflater == null) {

            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        }
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.model, parent, false);
        }else {

            final TextView tvTotPrice = (TextView) rootView.findViewById(R.id.tvTotPrice);
        }


        final TextView tvQuantity = (TextView) rootView.findViewById(R.id.tvQuantity);
        TextView tvDescription = (TextView) rootView.findViewById(R.id.tvDescription);
        TextView tvType = (TextView) rootView.findViewById(R.id.tvType);
        final TextView tvPrice = (TextView) rootView.findViewById(R.id.tvPrice);
        final Button btnAdd = (Button) rootView.findViewById(R.id.btnAdd);
        TextView btnRemove = (TextView) rootView.findViewById(R.id.btnRemove);
        ImageView ivCake = (ImageView) rootView.findViewById(R.id.ivCake);

        final TextView tvTotQuantity = (TextView) rootView.findViewById(R.id.tvTotQuantity);
        ImageView ivAddCart = (ImageView) rootView.findViewById(R.id.ivAddCart);

        tfc1 =Typeface.DEFAULT.createFromAsset(c.getAssets(),"fonts/Precious.ttf");

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cake cake = cakes.get(position);
                if(position ==0)
                {
                    qntyPotion1=qntyPotion1+1;

                    tvQuantity.setText("" + qntyPotion1);
                    totalQuatinty = totalQuatinty+ 1;//get total items
                    info = info+"   "+ cake.getDescription()+ " "+cake.getType()+"\n";

                    totCost= (int) (cake.getPrice()*qntyPotion1);//get total
                    SharedPreferences.Editor editor = c.getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putInt("idName",  totCost);
                    editor.putInt("total",totalQuatinty);
                    editor.putString("info",info);
                    editor.apply();
//                    NumberFormat format = NumberFormat.getCurrencyInstance();
//                    Intent intent = new Intent();
//                    intent.putExtra("SELECTED_PAYMENT", tvQuantity.getText().toString());
//
//                    ((Activity) c).setResult(((Activity) c).RESULT_OK, intent);
//                    ((Activity) c).finish();

                }
                if(position ==1)
                {
                    qntyPotion2=qntyPotion2+1;
                    info =  info+ cake.getDescription()+ " "+cake.getType()+"\n";;
                    Toast.makeText(view.getContext(), "add", Toast.LENGTH_LONG).show();
                    tvQuantity.setText("" + qntyPotion2);
                    totalQuatinty = totalQuatinty+ 1;
                    totCost= (int) (cake.getPrice()*qntyPotion2);
                    SharedPreferences.Editor editor = c.getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putInt("idName",  totCost);
                    editor.putInt("total",totalQuatinty);
                    editor.putString("info",info);
                    editor.apply();
                }
                if(position ==2)
                {
                    qntyPotion3=qntyPotion3+1;
                    info =  info+cake.getDescription()+ " "+cake.getType()+"\n";;
                    Toast.makeText(view.getContext(), "add", Toast.LENGTH_LONG).show();
                    tvQuantity.setText("" + qntyPotion3);
                    totalQuatinty = totalQuatinty+ 1;
                    totCost= (int) (cake.getPrice()*qntyPotion3);
                    SharedPreferences.Editor editor = c.getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putInt("idName",  totCost);
                    editor.putInt("total",totalQuatinty);
                    editor.putString("info",info);
                    editor.apply();
                }
                if(position ==3)
                {
                    qntyPotion4=qntyPotion4+1;
                    info = cake.getDescription()+ " "+cake.getType()+"\n";
                    Toast.makeText(view.getContext(), "add", Toast.LENGTH_LONG).show();
                    tvQuantity.setText("" + qntyPotion4++);
                    totCost= (int) (cake.getPrice()*qntyPotion4);
                    totalQuatinty = totalQuatinty+ 1;
                    SharedPreferences.Editor editor = c.getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putInt("idName",  totCost);
                    editor.putInt("total",totalQuatinty);
                    editor.putString("info",info);
                    editor.apply();
                }
                if(position ==4)
                {
                    qntyPotion5=qntyPotion5+1;
                    info = info+ cake.getDescription()+ " "+cake.getType()+"\n";;
                    Toast.makeText(view.getContext(), "add", Toast.LENGTH_LONG).show();
                    tvQuantity.setText("" + qntyPotion5);
                    totCost= (int) (cake.getPrice()*qntyPotion5);
                    totalQuatinty = totalQuatinty+ 1;
                    SharedPreferences.Editor editor = c.getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putInt("idName",  totCost);
                    editor.putInt("total",totalQuatinty);
                    editor.putString("info",info);
                    editor.apply();
                } if(position ==5)
                {
                    qntyPotion6=qntyPotion6+1;
                    info =  info+"   "+cake.getDescription()+ "   "+cake.getType()+"\n";;
                    Toast.makeText(view.getContext(), "add", Toast.LENGTH_LONG).show();
                    tvQuantity.setText("" + qntyPotion6);
                    totCost= (int) (cake.getPrice()*qntyPotion6);
                    totalQuatinty = totalQuatinty+ 1;

                    SharedPreferences.Editor editor = c.getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putInt("idName",  totCost);
                    editor.putInt("total",totalQuatinty);
                    editor.putString("info",info);
                    editor.apply();
                }
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cake cake = cakes.get(position);
                if(position ==0)
                {
                    qntyPotion1=qntyPotion1-1;

                    tvQuantity.setText("" + qntyPotion1);
                    totalQuatinty = totalQuatinty- 1;//get total items
                    info = info+"   "+ cake.getDescription()+ " "+cake.getType()+"\n";

                    totCost= (int) (totCost-cake.getPrice());
                    SharedPreferences.Editor editor = c.getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putInt("idName",  totCost);
                    editor.putInt("total",totalQuatinty);
                    editor.putString("info",info);
                    editor.apply();
//

                }
                if(position ==1)
                {
                    qntyPotion2=qntyPotion2-1;
                    info =  info+ cake.getDescription()+ " "+cake.getType()+"\n";;
                    Toast.makeText(view.getContext(), "add", Toast.LENGTH_LONG).show();
                    tvQuantity.setText("" + qntyPotion2);
                    totalQuatinty = totalQuatinty-1;
                    totCost= (int) (totCost-cake.getPrice());
                    SharedPreferences.Editor editor = c.getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putInt("idName",  totCost);
                    editor.putInt("total",totalQuatinty);
                    editor.putString("info",info);
                    editor.apply();
                }
                if(position ==2)
                {
                    qntyPotion3=qntyPotion3-1;
                    info =  info+cake.getDescription()+ " "+cake.getType()+"\n";;
                    Toast.makeText(view.getContext(), "add", Toast.LENGTH_LONG).show();
                    tvQuantity.setText("" + qntyPotion3);
                    totalQuatinty = totalQuatinty- 1;
                    totCost= (int) (totCost-cake.getPrice());
                    SharedPreferences.Editor editor = c.getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putInt("idName",  totCost);
                    editor.putInt("total",totalQuatinty);
                    editor.putString("info",info);
                    editor.apply();
                }
                if(position ==3)
                {
                    qntyPotion4=qntyPotion4-1;
                    info = cake.getDescription()+ " "+cake.getType()+"\n";
                    Toast.makeText(view.getContext(), "add", Toast.LENGTH_LONG).show();
                    tvQuantity.setText("" + qntyPotion4);
                    totCost= (int) (totCost-cake.getPrice());
                    totalQuatinty = totalQuatinty-1;
                    SharedPreferences.Editor editor = c.getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putInt("idName",  totCost);
                    editor.putInt("total",totalQuatinty);
                    editor.putString("info",info);
                    editor.apply();
                }
                if(position ==4)
                {
                    qntyPotion5=qntyPotion5-1;
                    info = info+ cake.getDescription()+ " "+cake.getType()+"\n";;
                    Toast.makeText(view.getContext(), "add", Toast.LENGTH_LONG).show();
                    tvQuantity.setText("" + qntyPotion5);
                    totCost= (int) (totCost-cake.getPrice());
                    totalQuatinty = totalQuatinty-1;
                    SharedPreferences.Editor editor = c.getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putInt("idName",  totCost);
                    editor.putInt("total",totalQuatinty);
                    editor.putString("info",info);
                    editor.apply();
                } if(position ==5)
                {
                    qntyPotion6=qntyPotion6-1;
                    info =  info+"   "+cake.getDescription()+ "   "+cake.getType()+"\n";;
                    Toast.makeText(view.getContext(), "add", Toast.LENGTH_LONG).show();
                    tvQuantity.setText("" + qntyPotion6);
                    totCost= (int) (totCost-cake.getPrice());
                    totalQuatinty = totalQuatinty- 1;

                    SharedPreferences.Editor editor = c.getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
                    editor.putInt("idName",  totCost);
                    editor.putInt("total",totalQuatinty);
                    editor.putString("info",info);
                    editor.apply();
                }


            }
        });



        Cake cake = cakes.get(position);
        tvType.setText(cake.getType());
        tvType.setTypeface(tfc1);
        tvDescription.setText(cake.getDescription()+"\n");
        NumberFormat format = NumberFormat.getCurrencyInstance();
        tvPrice.setText("" + format.format(cake.getPrice()));

        ivCake.setBackgroundResource(cake.getCake());


        return rootView;

    }



}
