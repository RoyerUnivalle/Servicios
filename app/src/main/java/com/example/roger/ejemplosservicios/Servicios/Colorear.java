package com.example.roger.ejemplosservicios.Servicios;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class Colorear extends Service {
    public Colorear() {
    }

    SegundoPlano obj;
    TextView campo;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Integer opcion = intent.getExtras().getInt("opcion");
        if(opcion==1){
            for(int i=0;i<=4;i++){
                try {
                    Toast.makeText(this,"Hola servicio "+opcion,Toast.LENGTH_LONG).show();
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }else{
            obj= new SegundoPlano();
            obj.execute(opcion);
        }


        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this,"Adios servicio",Toast.LENGTH_LONG).show();
        super.onDestroy();
        if(obj!=null){
            obj.cancel(true);
        }
    }

    public class SegundoPlano extends AsyncTask<Integer,Integer,Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Integer... params) {
            Integer[] d;
            if(!obj.isCancelled()){
                for(int i=0;i<=50;i++){
                    try {
                        d = new Integer[2];
                        d[0]=i;
                        d[1]=params[0];
                        publishProgress(d);
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }
        @Override
        protected void onProgressUpdate(Integer... values) {

            Toast.makeText(getApplicationContext(),"Hola servicio "+values[1]+" "+values[0],Toast.LENGTH_LONG).show();
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled() {
            obj = null;
            super.onCancelled();
        }
    }

}
