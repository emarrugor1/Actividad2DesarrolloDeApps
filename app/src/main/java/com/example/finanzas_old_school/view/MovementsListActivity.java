package com.example.finanzas_old_school.view;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import com.example.finanzas_old_school.R;


public class MovementsListActivity extends AppCompatActivity {
    Button btnFechaIni,btnFechaFin;
    EditText edtFechaIni,edtFechaFin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movements_list_activity);

        /*Captura Fecha inicial y Fecha Final*/
        edtFechaIni = findViewById(R.id.edtfechaini);
        edtFechaFin =findViewById(R.id.edtfechafin);

        /*Botones fecha inicial fecha final*/
        btnFechaIni=findViewById(R.id.btnfechaini);
        btnFechaFin=findViewById(R.id.btnfechafin);

        btnFechaIni.setOnClickListener(null);
        btnFechaFin.setOnClickListener(null);

    }



}