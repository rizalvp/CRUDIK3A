package id.rizalprasetya.crudik3a.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import id.rizalprasetya.crudik3a.R;
import id.rizalprasetya.crudik3a.model.Mahasiswa;

/**
 * Created by Rizal Prasetya on 21/05/2018.
 */

public class MahasiswaAdapter extends ArrayAdapter<Mahasiswa> {


    public MahasiswaAdapter(@NonNull Context context, int resource, @NonNull List<Mahasiswa> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_mahasiswa, parent, false);
        }

        Mahasiswa mahasiswa = getItem(position);
        TextView tvNama = convertView.findViewById(R.id.tv_nama);
        TextView tvNim = convertView.findViewById(R.id.tv_nim);
        TextView tvEmail = convertView.findViewById(R.id.tv_email);
        ImageView ivFoto = convertView.findViewById(R.id.iv_foto);

        tvNama.setText(mahasiswa.getNama());
        tvNim.setText(mahasiswa.getNim());
        tvEmail.setText(mahasiswa.getEmail());
        Picasso.with(convertView.getContext()).load(mahasiswa.getFoto()).into(ivFoto);

        return convertView;
    }
}
