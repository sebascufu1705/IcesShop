package com.example.iceshop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.iceshop.model.Producto;

import java.util.ArrayList;

public class AdapterComProductos extends BaseAdapter {

    private ArrayList<Producto> comprarProductos;

    public AdapterComProductos() {
        comprarProductos = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return comprarProductos.size();
    }
    @Override
    public Object getItem(int i) {
        return comprarProductos.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.rengloncomproductos, null);
        ImageView fotoProductoCom = row.findViewById(R.id.fotoProductoCom);
        TextView nombreComPro = row.findViewById(R.id.nombreComPro);
        TextView precioComPro = row.findViewById(R.id.precioComPro);

        fotoProductoCom.setImageResource(comprarProductos.get(i).getUrl());
        nombreComPro.setText(comprarProductos.get(i).getNombrePro());
        precioComPro.setText(comprarProductos.get(i).getPrecio());

        return row;
    }
    public void agregarProductoCom(Producto producto) {
        comprarProductos.add(producto);
        this.notifyDataSetChanged();
    }

    public void clear() {
        comprarProductos.clear();
        this.notifyDataSetChanged();
    }
}
