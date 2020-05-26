package com.example.iceshop;

import android.animation.LayoutTransition;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.iceshop.model.Empresa;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private ArrayList<Empresa> empresas;

    public CustomAdapter() {
        empresas = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return empresas.size();
    }

    @Override
    public Object getItem(int i) {
        return empresas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(R.layout.renglonempresas, null);
        TextView nombreRenglon = row.findViewById(R.id.nombreRenglon);
        ImageView imgRenglon = row.findViewById(R.id.imgRenglon);

        nombreRenglon.setText(empresas.get(i).getNombreEmp());
        imgRenglon.setImageResource(empresas.get(i).getUrl());
        return row;
    }

    public void agregarEmpresa(Empresa empresa) {
        empresas.add(empresa);
        this.notifyDataSetChanged();
    }
    public void posision(int pos) {
        empresas.get(pos);
    }
}
