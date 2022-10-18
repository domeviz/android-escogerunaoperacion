package com.example.escogeroperacionesbasicas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private Spinner spinner;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText) findViewById(R.id.txt_valor1);
        et2=(EditText) findViewById(R.id.txt_valor2);
        tv=(TextView) findViewById(R.id.tv_resultado);
        spinner=(Spinner) findViewById(R.id.spinner);

        //Uso de arreglos
        String [] opciones={"Sumar","Restar","Multiplicar","Dividir"};

        //Adaptador de arreglo
        //Modificamos el spinner con el xml que creamos
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, R.layout.spinner_item_dome,opciones);

        //Dentro del objeto spinner ponemos el adapter para tener las opciones
        spinner.setAdapter(adapter);
    }

    public void calcular(View view){
        String valor1_S=et1.getText().toString();
        String valor2_S=et2.getText().toString();

        double valor1=Double.parseDouble(valor1_S);
        double valor2=Double.parseDouble(valor2_S);

        //Vemos la opcion seleccionada
        //La pasamos a String para poder comparar luego
        String seleccion=spinner.getSelectedItem().toString();

        //Equals compara cadenas de texto
        if(seleccion.equals("Sumar")){
            double suma=valor1+valor2;
            String resultado=String.valueOf(suma);
            tv.setText(resultado);
        } else if(seleccion.equals("Restar")){
            double resta=valor1-valor2;
            String resultado=String.valueOf(resta);
            tv.setText(resultado);
        } else if(seleccion.equals("Multiplicar")){
            double mult=valor1*valor2;
            String resultado=String.valueOf(mult);
            tv.setText(resultado);
        } else if(seleccion.equals("Dividir")){
            if(valor2 !=0){
                double div=valor1/valor2;
                String resultado=String.valueOf(div);
                tv.setText(resultado);
            } else {
                Toast.makeText(this, "No es posible dividir para 0", Toast.LENGTH_SHORT).show();
            }

        }
    }
}