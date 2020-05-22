package com.example.iceshop;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.iceshop.model.EmpresaAdapter;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private ArrayList<EmpresaAdapter> empresas;

    public CustomAdapter(){
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
        View row = inflater.inflate(R.layout.renglonempresa, null);
        TextView nombreRenglon = row.findViewById(R.id.nombreRenglon);
        ImageView fotoRenglon = row.findViewById(R.id.fotoRenglon);
        ImageView favoritoRenglon = row.findViewById(R.id.favoritoRenglon);

        nombreRenglon.setText(empresas.get(i).getNombreEmpresa());
        fotoRenglon.setImageResource(empresas.get(i).getFotoEmpresa());

        return row;

    }

    public void agregarEmpresa(EmpresaAdapter empresa) {

        empresas.add(empresa);
        this.notifyDataSetChanged();

    }
}
