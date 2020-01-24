package com.made06.karyawan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class KaryawanAdapter extends RecyclerView.Adapter<KaryawanAdapter.ViewHolder> {

    List<Karyawan> data;

    public KaryawanAdapter(List<Karyawan> data) {
        this.data = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nama,email,alamat,nohp;
        CardView parentLayout;
        ImageButton btnUpd, btnDel;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nama = itemView.findViewById(R.id.xnamaKaryawan);
            email = itemView.findViewById(R.id.xemailKaryawan);
            alamat = itemView.findViewById(R.id.xalamat);
            nohp = itemView.findViewById(R.id.xnohp);
            parentLayout = itemView.findViewById(R.id.xCardViewe);
            btnUpd = itemView.findViewById(R.id.xupdateBtn);
            btnDel = itemView.findViewById(R.id.xdelBtn);
        }
    }

    @NonNull
    @Override
    public KaryawanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_view__isi,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);
        data = MainActivity.karyawanDB.karyawanDAO().getKaryawan();
        System.out.println("masuk");
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull KaryawanAdapter.ViewHolder holder, int position) {

        final Karyawan karyawan = data.get(position);
        holder.nama.setText(karyawan.getNama());
        holder.email.setText(karyawan.getEmail());
        holder.alamat.setText(karyawan.getAlamat());
        holder.nohp.setText(karyawan.getNo_hp());

        holder.btnUpd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context cont = v.getContext();
               // View viewInflated = LayoutInflater.from(v.getContext()).inflate(R.layout.activity_card_view__isi, null);
                System.out.println("update id: "+karyawan.getId());
                Intent intent = new Intent(cont, karyawan_update.class).putExtra("id",karyawan.getId());
                cont.startActivity(intent);
            }
        });

        holder.btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("delete id: "+ karyawan.getId());
                MainActivity.karyawanDB.karyawanDAO().deleteKaryawan(karyawan);
                removeKaryawan(position);
            }
        });
    }

    private void removeKaryawan(int position) {
        data.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,getItemCount());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }



}
