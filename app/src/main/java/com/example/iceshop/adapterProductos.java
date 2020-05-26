package com.example.iceshop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.iceshop.model.Producto;

import java.util.ArrayList;

public class adapterProductos extends BaseAdapter {

    private ArrayList<Producto> productos;

    public adapterProductos() {
        productos = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return productos.size();
    }

    @Override
    public Object getItem(int i) {
        return productos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.renglonproductos, null);
        ImageView fotoProducto = row.findViewById(R.id.fotoProducto);
        TextView nombrePro = row.findViewById(R.id.nombrePro);
        TextView precioPro = row.findViewById(R.id.precioPro);

        fotoProducto.setImageResource(productos.get(i).getUrl());
        nombrePro.setText(productos.get(i).getNombrePro());
        precioPro.setText(productos.get(i).getPrecio());
        return row;

    }
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        this.notifyDataSetChanged();
    }

    public void clear() {
        productos.clear();
        this.notifyDataSetChanged();
    }

}
