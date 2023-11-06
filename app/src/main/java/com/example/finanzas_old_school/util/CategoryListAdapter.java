package com.example.finanzas_old_school.util;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;

import com.example.finanzas_old_school.R;
import com.example.finanzas_old_school.model.dto.CategoryDto;

import java.util.List;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder>{
        private List<CategoryDto> categoryDtoList;
        private LayoutInflater inflater;
        private Context context;

        public CategoryListAdapter(List<CategoryDto> categoryDtoList, Context context) {
            this.categoryDtoList = categoryDtoList;
            this.inflater = LayoutInflater.from(context);
            this.context = context;
        }

        @NonNull
        @Override
        public CategoryListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_category, null);
            return new CategoryListAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.bindData(categoryDtoList.get(position));

        }

        @Override
        public int getItemCount() {
            return categoryDtoList.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            TextView concept;
            TextView type;
            Button button;

            public ViewHolder(View itemView) {
                super(itemView);
                concept = itemView.findViewById(R.id.categoryConcept);
                type = itemView.findViewById(R.id.categoryType);
                button = itemView.findViewById(R.id.button);
            }
            void bindData(CategoryDto categoryDto){
                concept.setText(categoryDto.getConcepto());
                type.setText(categoryDto.getTipo());
                button.setText("Eliminar");
            }
        }

}


