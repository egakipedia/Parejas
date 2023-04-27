package com.example.parejas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8;
    private TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv1 = findViewById(R.id.iv_1);
        iv2 = findViewById(R.id.iv_2);
        iv3 = findViewById(R.id.iv_3);
        iv4 = findViewById(R.id.iv_4);
        iv5 = findViewById(R.id.iv_5);
        iv6 = findViewById(R.id.iv_6);
        iv7 = findViewById(R.id.iv_7);
        iv8 = findViewById(R.id.iv_8);

        tv1 = findViewById(R.id.tv_1);
        tv2 = findViewById(R.id.tv_2);
        tv3 = findViewById(R.id.tv_3);
        tv4 = findViewById(R.id.tv_4);
        tv5 = findViewById(R.id.tv_5);
        tv6 = findViewById(R.id.tv_6);
        tv7 = findViewById(R.id.tv_7);
        tv8 = findViewById(R.id.tv_8);


        ArrayList<Integer> imagenes = new ArrayList<Integer>();
        ArrayList<Integer> elegidos = new ArrayList<Integer>();

        imagenes.add(R.drawable.conejo);
        imagenes.add(R.drawable.leon);
        imagenes.add(R.drawable.tortuga);
        imagenes.add(R.drawable.vaca);

        int n_img = 0;

        int ci1 = 0, ci2 = 0, ci3 = 0, ci4 = 0;

        int j = 1;
        while (j <= 8){
            n_img = numeroAleatorio(4);

            if(n_img == 0){
                if (ci1 < 2){
                    elegidos.add(0);
                    j++;
                    ci1++;
                }
            }
            if(n_img == 1){
                if (ci2 < 2){
                    elegidos.add(1);
                    j++;
                    ci2++;
                }
            }
            if(n_img == 2){
                if (ci3 < 2){
                    elegidos.add(2);
                    j++;
                    ci3++;
                }
            }
            if(n_img == 3){
                if (ci4 < 2){
                    elegidos.add(3);
                    j++;
                    ci4++;
                }
            }
        }

        tv1.setText(elegidos.get(0).toString());
        tv2.setText(elegidos.get(1).toString());
        tv3.setText(elegidos.get(2).toString());
        tv4.setText(elegidos.get(3).toString());
        tv5.setText(elegidos.get(4).toString());
        tv6.setText(elegidos.get(5).toString());
        tv7.setText(elegidos.get(6).toString());
        tv8.setText(elegidos.get(7).toString());

        iv1.setImageResource(R.drawable.reverso);
        iv2.setImageResource(R.drawable.reverso);
        iv3.setImageResource(R.drawable.reverso);
        iv4.setImageResource(R.drawable.reverso);
        iv5.setImageResource(R.drawable.reverso);
        iv6.setImageResource(R.drawable.reverso);
        iv7.setImageResource(R.drawable.reverso);
        iv8.setImageResource(R.drawable.reverso);

        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv1.setImageResource(imagenes.get(elegidos.get(0)));
            }
        });
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv2.setImageResource(imagenes.get(elegidos.get(1)));
            }
        });
        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv3.setImageResource(imagenes.get(elegidos.get(2)));
            }
        });
        iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv4.setImageResource(imagenes.get(elegidos.get(3)));
            }
        });
        iv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv5.setImageResource(imagenes.get(elegidos.get(4)));
            }
        });
        iv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv6.setImageResource(imagenes.get(elegidos.get(5)));
            }
        });
        iv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv7.setImageResource(imagenes.get(elegidos.get(6)));
            }
        });
        iv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv8.setImageResource(imagenes.get(elegidos.get(7)));
            }
        });

    }

    public static int numeroAleatorio(int size){
        int numero = 0;
        numero = (int) (Math.random() * size);
        return numero;
    }

    public void Reiniciar(View view){
        Intent next = new Intent(this, MainActivity.class);
        startActivity(next);
    }

}