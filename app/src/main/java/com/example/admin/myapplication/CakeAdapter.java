package com.example.admin.myapplication;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 7/11/2017.
 */

public class CakeAdapter   extends BaseAdapter {
    private Context c;

    private int resource;
    private List<Cake> cakes;
    private LayoutInflater inflater;
    public static int add= 0;
    private int sub= 0;
    private  int price;
     int pos;
    int addpo =0;

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
    public View getView(int position, View view, ViewGroup parent) {

        if (inflater==null)
        {

            inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        }
        if(view == null)
        {
            view=inflater.inflate(R.layout.model,parent,false);
        }




        final TextView tvQuantity =(TextView)view.findViewById(R.id.tvQuantity);
        TextView tvDescription =(TextView)view.findViewById(R.id.tvDescription);
        final TextView tvPrice =(TextView)view.findViewById(R.id.tvPrice);
        Button btnAdd =(Button)view.findViewById(R.id.btnAdd);
        TextView btnRemove =(TextView)view.findViewById(R.id.btnRemove);
        ImageView ivCake =(ImageView)view.findViewById(R.id.ivCake);


final int p =position;
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cake cake = cakes.get(p);

                 Toast.makeText(view.getContext(),"add", android.widget.Toast.LENGTH_LONG).show();
                tvQuantity.setText(""+addpo++);
                tvPrice.setText("R "+addpo *cake.getPrice());



            }
        });


        Cake cake = cakes.get(position);
        tvDescription.setText(cake.getDescription());

        ivCake.setBackgroundResource(cake.getCake());




        return view;
    }


}
