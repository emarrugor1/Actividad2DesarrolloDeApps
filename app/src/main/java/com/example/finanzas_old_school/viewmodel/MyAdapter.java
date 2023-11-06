package com.example.finanzas_old_school.viewmodel;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;

import com.example.finanzas_old_school.R;
import com.example.finanzas_old_school.model.dto.CategoryDto;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
        private String[] data;

        private List<CategoryDto> categoryDtoList;




        public MyAdapter(List<CategoryDto> categoryDtoList) {
            this.categoryDtoList = categoryDtoList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            for (CategoryDto categoryDto :
                    categoryDtoList) {
                holder.textView1.setText(categoryDto.getConcepto());
                holder.textView2.setText(categoryDto.getTipo());
                holder.button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Manejar el clic del botón aquí
                    }
                });
            }

        }

        @Override
        public int getItemCount() {
            return data.length;
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            TextView textView1;
            TextView textView2;
            Button button;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                textView1 = itemView.findViewById(R.id.textView1);
                textView2 = itemView.findViewById(R.id.textView2);
                button = itemView.findViewById(R.id.button);
            }
        }
}


