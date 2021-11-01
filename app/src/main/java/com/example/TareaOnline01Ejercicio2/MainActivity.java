package com.example.TareaOnline01Ejercicio2;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.TareaOnline01Ejercicio2.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button boton;
    TextView texto;
    TextInputEditText cuadroTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = (TextView) findViewById(R.id.resultado);
        boton = (Button) findViewById(R.id.botoncito);
        cuadroTexto = (TextInputEditText) findViewById(R.id.numero);

        boton.setOnClickListener((View.OnClickListener) this);
    }

    private void actualizar(){

        //Creamos un arraylist para almacenar los divisores
        ArrayList<Integer> divisores = new ArrayList();
        int nEscogido = 0;
        try{
            nEscogido = Integer.parseInt(cuadroTexto.getText().toString());
            //Encontraremos los divisores a través de un bucle for
            for(int i = 1; i <=nEscogido ; i++){
                if(nEscogido%i==0){
                    //añadimos la solución a nuestra arraylist
                    divisores.add(i);
                }
            }
            String resultados = "Divisores: ";
            for (int i = 0; i < divisores.size(); i++)
                if(i + 1 < divisores.size())
                    resultados += divisores.get(i) + " | ";
                else
                    resultados += divisores.get(i);

            texto.setText(resultados);
            if (divisores.size()==0){
                texto.setText("Debe introducir un número positivo mayor que 0");
            };
        } catch (Exception e){
            texto.setText("Debe introducir un número positivo");
        }

    }

    @Override
    public void onClick(View v){
        if (v == boton) {
            actualizar();
        }
    }
}