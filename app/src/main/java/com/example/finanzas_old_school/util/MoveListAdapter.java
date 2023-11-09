package com.example.finanzas_old_school.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finanzas_old_school.R;
import com.example.finanzas_old_school.model.dto.MoveDto;

import java.util.List;

public class MoveListAdapter extends RecyclerView.Adapter<MoveListAdapter.ViewHolder>{
        private List<MoveDto> moveDtoList;
        private final LayoutInflater inflater;
        private final Context context;

        public MoveListAdapter(List<MoveDto> moveDtoList, Context context) {
            this.moveDtoList = moveDtoList;
            this.inflater = LayoutInflater.from(context);
            this.context = context;
        }

    public List<MoveDto> getMoveDtoList() {
        return moveDtoList;
    }

    public void setMoveDtoList(List<MoveDto> moveDtoList) {
        this.moveDtoList = moveDtoList;
    }

    @NonNull
        @Override
        public MoveListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_category, null);
            return new MoveListAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.bindData(moveDtoList.get(position));

        }

        @Override
        public int getItemCount() {
            return moveDtoList.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            TextView tvClase;
            TextView tvConcepto;
            TextView tvValue;
            TextView tvFecha;
            Button btnUpdate;
            Button btnDelete;

            public ViewHolder(View itemView) {
                super(itemView);
                tvClase = itemView.findViewById(R.id.moveClasification);
                tvConcepto = itemView.findViewById(R.id.moveconcept);
                tvValue = itemView.findViewById(R.id.movevalue);
                tvFecha = itemView.findViewById(R.id.movedate);

                btnUpdate = itemView.findViewById(R.id.btn_update);
                btnDelete = itemView.findViewById(R.id.btn_delete);
            }
            void bindData(MoveDto moveDto){
                tvClase.setText(moveDto.getClase());
                tvConcepto.setText(moveDto.getConcepto());
                tvValue.setText(moveDto.getValor());
                tvFecha.setText(moveDto.getFecha());

                btnUpdate.setText("Actualizar");
                btnDelete.setText("Eliminar");
            }
        }

}


