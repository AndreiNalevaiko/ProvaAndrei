package com.example.ti.provaandrei;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText edtReal;
    private TextView valorEuro, valorDolar, valorPeso;
    private Button btnCalcular, btnLimparDados;
    private ImageView imgCifrao;
    private Double valor1, resultado1, resultado2, resultado3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valorDolar = findViewById(R.id.valorDolar);
        valorEuro = findViewById(R.id.valorEuro);
        valorPeso = findViewById(R.id.valorPeso);
        edtReal = findViewById(R.id.edtReal);
        imgCifrao = findViewById(R.id.imgCifrao);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimparDados = findViewById(R.id.btnLimparDados);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s1 = edtReal.getText().toString();

                if(!s1.isEmpty()){

                    valor1 = Double.valueOf(s1);
                    resultado1 =  valor1 * 0.26;
                    resultado2 = valor1 * 0.23;
                    resultado3 = valor1 * 10.87;

                    imgCifrao.setImageResource(R.drawable.cifrao2);

                    valorDolar.setText(String.valueOf(resultado1));
                    valorEuro.setText(String.valueOf(resultado2));
                    valorPeso.setText(String.valueOf(resultado3));
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Nenhum número digitado.", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnLimparDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibirMensagem();
            }
        });

    }

    private void exibirMensagem(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Deseja Limpar Os Campos?");

        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                valorDolar.setText("");
                valorEuro.setText("");
                valorPeso.setText("");
                edtReal.setText("");
                imgCifrao.setImageResource(R.drawable.cifrao1);
            }
        });

        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
