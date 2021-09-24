package com.example.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textoPorcentagem;
    private TextView textoGorjeta;
    private TextView textoTotal;
    private SeekBar seekBarGorjeta;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor = findViewById(R.id.editValor);
        textoGorjeta = findViewById(R.id.textoGorjeta);
        textoPorcentagem = findViewById(R.id.textoPorcentagem);
        textoTotal = findViewById(R.id.textoTotal);
        seekBarGorjeta = findViewById(R.id.seekBarGorgeta);

        //Adicionar listener SeekBar
        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                //Math round arrendendo o numero

                porcentagem = i;
                textoPorcentagem.setText(Math.round(porcentagem) + "%");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
        public void calcular() {

        String valorRecuperado = editValor.getText().toString();
        if (valorRecuperado == null || valorRecuperado.equals("")) {

            Toast.makeText(
                    getApplicationContext(),
                    "Digite um valor primeiro!",
                    Toast.LENGTH_LONG

            ).show();
        }
        else
        {

            // converter string para double
            double valorDigitado = Double.parseDouble(valorRecuperado);

            // calcula a gorjeta total
            double gorjeta = valorDigitado * (porcentagem/100);

            //total
            double total = gorjeta + valorDigitado;


            // exibe a gorjeta e total
            textoGorjeta.setText("R$" + Math.round(gorjeta));
            textoTotal.setText("R$" + total);



        }
        }
    }
