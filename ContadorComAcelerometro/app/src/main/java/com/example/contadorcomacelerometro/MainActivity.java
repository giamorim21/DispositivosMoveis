package com.example.contadorcomacelerometro;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView contadorPassos, distancia;
    private SensorManager sensorManager;
    private Sensor acelerometro;
    private SensorEventListener listener;
    private int contador;
    private double distanciaPercorrida;
    private ProgressBar barraProgresso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        inicializaContador();
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(listener, acelerometro, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(listener);
    }

    private void inicializaContador() {
        contadorPassos = findViewById(R.id.text);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        distancia = findViewById(R.id.distancia);
        barraProgresso = findViewById(R.id.barraProgresso);

        acelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        contador = 0;
        distanciaPercorrida = 1;

        listener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float eixoX = event.values[0];
                float eixoY = event.values[1];
                float eixoZ = event.values[2];

                double magnitude = Math.sqrt(eixoX *eixoX + eixoY * eixoY + eixoZ * eixoZ);

                if(magnitude > 12.2){
                    contador++;
                    distanciaPercorrida = distanciaPercorrida * 0.76;
                    contadorPassos.setText("A quantidade de passos atual é: " + contador);
                    distancia.setText("A distância percorrida foi: " + distanciaPercorrida);
                    barraProgresso.setProgress(contador);

                }
            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
    }
}