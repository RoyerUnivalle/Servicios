package com.example.roger.ejemplosservicios;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.roger.ejemplosservicios.Servicios.Colorear;

public class MainActivity extends AppCompatActivity {
    Intent ir;
    TextView campo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        campo = (TextView) findViewById(R.id.textView2);
        //campo.setBackgroundColor(new Color(Color.rgb(255,242,211)));
        //campo.setBackgroundColor(new Color(Color.blue(222));
    }
    public void IniciarServicio(View j){
        ir = new Intent(MainActivity.this, Colorear.class);
        Bundle datos = new Bundle();
        datos.putInt("opcion",1);
        ir.putExtras(datos);
        startService(ir);
    }
    public void IniciarServicio2(View j){
        ir = new Intent(MainActivity.this, Colorear.class);
        Bundle datos = new Bundle();
        datos.putInt("opcion",2);
        ir.putExtras(datos);
        startService(ir);
    }
    public void DetenerServicio(View j){
        stopService(ir);
    }
}