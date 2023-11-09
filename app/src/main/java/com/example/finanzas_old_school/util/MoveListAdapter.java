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
import com.example.finanzas_old_school.model.dto.MovementDto;

import java.util.List;

public class MoveListAdapter extends RecyclerView.Adapter<MoveListAdapter.ViewHolder>{
        private List<MovementDto> movementDtoList;
        private final LayoutInflater inflater;
        private final Context context;

        public MoveListAdapter(List<MovementDto> movementDtoList, Context context) {
            this.movementDtoList = movementDtoList;
            this.inflater = LayoutInflater.from(context);
            this.context = context;
        }

    public List<MovementDto> getMoveDtoList() {
        return movementDtoList;
    }

    public void setMoveDtoList(List<MovementDto> movementDtoList) {
        this.movementDtoList = movementDtoList;
    }

    @NonNull
        @Override
        public MoveListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_category, null);
            return new MoveListAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.bindData(movementDtoList.get(position));

        }

        @Override
        public int getItemCount() {
            return movementDtoList.size();
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
            void bindData(MovementDto movementDto){
                tvClase.setText(movementDto.getClase());
                tvConcepto.setText(movementDto.getConcepto());
                tvValue.setText(movementDto.getValor());
                tvFecha.setText(movementDto.getFecha());

                btnUpdate.setText("Actualizar");
                btnDelete.setText("Eliminar");
            }
        }

}


