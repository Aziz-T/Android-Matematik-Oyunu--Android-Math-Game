package com.k.mathgame;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SeviyeAdapter extends RecyclerView.Adapter<SeviyeAdapter.ViewHolder> {

        private List<SeviyeModel> seviyeModelList;

    public SeviyeAdapter(List<SeviyeModel> seviyeModelList) {
        this.seviyeModelList = seviyeModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.seviye_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(seviyeModelList.get(position).getSeviyeAdi());
    }

    @Override
    public int getItemCount() {
        return seviyeModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.seviyeYazi);
        }

        public void setData(final String seviyeAdi) {
            this.textView.setText(seviyeAdi);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext(),SoruActivity.class);
                    intent.putExtra("zaman",10);
                    intent.putExtra("seviyeAdi",seviyeAdi);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
