package com.example.finanzas_old_school.view;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finanzas_old_school.R;
import com.example.finanzas_old_school.model.dto.MovementDto;
import com.example.finanzas_old_school.util.MoveListAdapter;
import com.example.finanzas_old_school.util.Mapper;
import com.example.finanzas_old_school.viewmodel.MovementViewModel;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class MovementsListActivity extends AppCompatActivity {

    Toolbar toolbar;
    private MovementViewModel moveViewModel;
    private final Executor executor = Executors.newSingleThreadExecutor();


     Button btnFechaIni,btnFechaFin;
     EditText edtFechaIni,edtFechaFin;
    /*recyclerViewListMove*/
    /*toolbarMoveList*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movements_list_activity);

        /*Soporte a la barra de herramientas*/
        toolbar = findViewById(R.id.toolbarMoveList);
        setSupportActionBar(toolbar);

        moveViewModel = new ViewModelProvider(this).get(MovementViewModel.class);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewListMove);


        /*Captura Fecha inicial y Fecha Final*/
        edtFechaIni = findViewById(R.id.edtfechaini);
        edtFechaFin =findViewById(R.id.edtfechafin);

        /*Botones fecha inicial fecha final*/
        btnFechaIni=findViewById(R.id.btnfechaini);
        btnFechaFin=findViewById(R.id.btnfechafin);

        /*btnFechaIni.setOnClickListener(null);*/
        /*btnFechaFin.setOnClickListener(null);*/

        executor.execute(()-> {
            List<MovementDto> list = moveViewModel.getAll()
                    .stream()
                    .map(Mapper::moveEntityToDto)
                    .collect(Collectors.toList());
            MoveListAdapter adapter = new MoveListAdapter(list, this);

            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(adapter);

        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.categoryItem) {
            Intent intent = new Intent(this, CategoryForm.class);
            startActivity(intent);
        } else if (id == R.id.movementsItem) {
            Intent intent = new Intent(this, MovementsForm.class);
            startActivity(intent);
        } else if (id == R.id.categoryListItem) {
            Intent intent = new Intent(this, this.getClass());
            startActivity(intent);
        }else if (id == R.id.movementsListItem) {
            Intent intent = new Intent(this, this.getClass());
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}