package com.example.finanzas_old_school.util;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

import com.example.finanzas_old_school.view.CategoryForm;

public class Util {
    private Util(){}

    public static void getAlertDialog(String title, String message, Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        // Configurar el título y el mensaje de la alerta
        builder.setTitle(title)
                .setMessage(message);

        // Agregar un botón "Aceptar" para cerrar la alerta
        builder.setPositiveButton("Aceptar", (dialog, which) -> {
        });
        builder.show();
    }
}
