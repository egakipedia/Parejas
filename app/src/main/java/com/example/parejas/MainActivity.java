package com.example.parejas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8;
    private TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, resultado1, resultado2;

    private final int duraccion = 2000;

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
        resultado1 = findViewById(R.id.tv_r1);
        resultado2 = findViewById(R.id.tv_r2);


        ArrayList<Integer> imagenes = new ArrayList<Integer>();
        ArrayList<Integer> elegidos = new ArrayList<Integer>();
        ArrayList<Integer> abiertas = new ArrayList<Integer>();

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

                if(resultado1.getText().equals("vacio")){
                    resultado1.setText(elegidos.get(0).toString());
                }else{
                    resultado2.setText(elegidos.get(0).toString());
                    if(resultado1.getText().equals(resultado2.getText())){
                        resultado1.setText("vacio");
                        resultado2.setText("vacio");
                        abiertas.add(elegidos.get(0));
                    }else{
                        Toast.makeText(MainActivity.this, "OHHH NOOO!!! Prueba otra vez!!!", Toast.LENGTH_SHORT).show();

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                int tv1Int = Integer.parseInt(tv1.getText().toString());
                                int tv2Int = Integer.parseInt(tv2.getText().toString());
                                int tv3Int = Integer.parseInt(tv3.getText().toString());
                                int tv4Int = Integer.parseInt(tv4.getText().toString());
                                int tv5Int = Integer.parseInt(tv5.getText().toString());
                                int tv6Int = Integer.parseInt(tv6.getText().toString());
                                int tv7Int = Integer.parseInt(tv7.getText().toString());
                                int tv8Int = Integer.parseInt(tv8.getText().toString());

                                if(!abiertas.contains(tv1Int)){
                                    iv1.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv2Int)) {
                                    iv2.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv3Int)){
                                    iv3.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv4Int)){
                                    iv4.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv5Int)){
                                    iv5.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv6Int)){
                                    iv6.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv7Int)){
                                    iv7.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv8Int)){
                                    iv8.setImageResource(R.drawable.reverso);
                                }
                            }
                        }, duraccion);

                        resultado1.setText("vacio");
                        resultado2.setText("vacio");
                    }
                }
            }
        });
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv2.setImageResource(imagenes.get(elegidos.get(1)));

                if(resultado1.getText().equals("vacio")){
                    resultado1.setText(elegidos.get(1).toString());
                }else{
                    resultado2.setText(elegidos.get(1).toString());
                    if(resultado1.getText().equals(resultado2.getText())){
                        Toast.makeText(MainActivity.this, "Respuesta Correcta!!!!", Toast.LENGTH_SHORT).show();
                        resultado1.setText("vacio");
                        resultado2.setText("vacio");
                        abiertas.add(elegidos.get(1));
                    }else{
                        Toast.makeText(MainActivity.this, "OHHH NOOO!!! Prueba otra vez!!!", Toast.LENGTH_SHORT).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                int tv1Int = Integer.parseInt(tv1.getText().toString());
                                int tv2Int = Integer.parseInt(tv2.getText().toString());
                                int tv3Int = Integer.parseInt(tv3.getText().toString());
                                int tv4Int = Integer.parseInt(tv4.getText().toString());
                                int tv5Int = Integer.parseInt(tv5.getText().toString());
                                int tv6Int = Integer.parseInt(tv6.getText().toString());
                                int tv7Int = Integer.parseInt(tv7.getText().toString());
                                int tv8Int = Integer.parseInt(tv8.getText().toString());

                                if(!abiertas.contains(tv1Int)){
                                    iv1.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv2Int)) {
                                    iv2.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv3Int)){
                                    iv3.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv4Int)){
                                    iv4.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv5Int)){
                                    iv5.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv6Int)){
                                    iv6.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv7Int)){
                                    iv7.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv8Int)){
                                    iv8.setImageResource(R.drawable.reverso);
                                }
                            }
                        }, duraccion);

                        resultado1.setText("vacio");
                        resultado2.setText("vacio");
                    }
                }
            }
        });
        iv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv3.setImageResource(imagenes.get(elegidos.get(2)));

                if(resultado1.getText().equals("vacio")){
                    resultado1.setText(elegidos.get(2).toString());
                }else{
                    resultado2.setText(elegidos.get(2).toString());
                    if(resultado1.getText().equals(resultado2.getText())){
                        Toast.makeText(MainActivity.this, "Respuesta Correcta!!!!", Toast.LENGTH_SHORT).show();
                        resultado1.setText("vacio");
                        resultado2.setText("vacio");
                        abiertas.add(elegidos.get(2));
                    }else{
                        Toast.makeText(MainActivity.this, "OHHH NOOO!!! Prueba otra vez!!!", Toast.LENGTH_SHORT).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                int tv1Int = Integer.parseInt(tv1.getText().toString());
                                int tv2Int = Integer.parseInt(tv2.getText().toString());
                                int tv3Int = Integer.parseInt(tv3.getText().toString());
                                int tv4Int = Integer.parseInt(tv4.getText().toString());
                                int tv5Int = Integer.parseInt(tv5.getText().toString());
                                int tv6Int = Integer.parseInt(tv6.getText().toString());
                                int tv7Int = Integer.parseInt(tv7.getText().toString());
                                int tv8Int = Integer.parseInt(tv8.getText().toString());

                                if(!abiertas.contains(tv1Int)){
                                    iv1.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv2Int)) {
                                    iv2.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv3Int)){
                                    iv3.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv4Int)){
                                    iv4.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv5Int)){
                                    iv5.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv6Int)){
                                    iv6.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv7Int)){
                                    iv7.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv8Int)){
                                    iv8.setImageResource(R.drawable.reverso);
                                }
                            }
                        }, duraccion);

                        resultado1.setText("vacio");
                        resultado2.setText("vacio");
                    }
                }
            }
        });
        iv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv4.setImageResource(imagenes.get(elegidos.get(3)));

                if(resultado1.getText().equals("vacio")){
                    resultado1.setText(elegidos.get(3).toString());
                }else{
                    resultado2.setText(elegidos.get(3).toString());
                    if(resultado1.getText().equals(resultado2.getText())){
                        Toast.makeText(MainActivity.this, "Respuesta Correcta!!!!", Toast.LENGTH_SHORT).show();
                        resultado1.setText("vacio");
                        resultado2.setText("vacio");
                        abiertas.add(elegidos.get(3));
                    }else{
                        Toast.makeText(MainActivity.this, "OHHH NOOO!!! Prueba otra vez!!!", Toast.LENGTH_SHORT).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                int tv1Int = Integer.parseInt(tv1.getText().toString());
                                int tv2Int = Integer.parseInt(tv2.getText().toString());
                                int tv3Int = Integer.parseInt(tv3.getText().toString());
                                int tv4Int = Integer.parseInt(tv4.getText().toString());
                                int tv5Int = Integer.parseInt(tv5.getText().toString());
                                int tv6Int = Integer.parseInt(tv6.getText().toString());
                                int tv7Int = Integer.parseInt(tv7.getText().toString());
                                int tv8Int = Integer.parseInt(tv8.getText().toString());

                                if(!abiertas.contains(tv1Int)){
                                    iv1.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv2Int)) {
                                    iv2.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv3Int)){
                                    iv3.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv4Int)){
                                    iv4.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv5Int)){
                                    iv5.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv6Int)){
                                    iv6.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv7Int)){
                                    iv7.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv8Int)){
                                    iv8.setImageResource(R.drawable.reverso);
                                }
                            }
                        }, duraccion);

                        resultado1.setText("vacio");
                        resultado2.setText("vacio");
                    }
                }
            }
        });
        iv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv5.setImageResource(imagenes.get(elegidos.get(4)));

                if(resultado1.getText().equals("vacio")){
                    resultado1.setText(elegidos.get(4).toString());
                }else{
                    resultado2.setText(elegidos.get(4).toString());
                    if(resultado1.getText().equals(resultado2.getText())){
                        Toast.makeText(MainActivity.this, "Respuesta Correcta!!!!", Toast.LENGTH_SHORT).show();
                        resultado1.setText("vacio");
                        resultado2.setText("vacio");
                        abiertas.add(elegidos.get(4));
                    }else{
                        Toast.makeText(MainActivity.this, "OHHH NOOO!!! Prueba otra vez!!!", Toast.LENGTH_SHORT).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                int tv1Int = Integer.parseInt(tv1.getText().toString());
                                int tv2Int = Integer.parseInt(tv2.getText().toString());
                                int tv3Int = Integer.parseInt(tv3.getText().toString());
                                int tv4Int = Integer.parseInt(tv4.getText().toString());
                                int tv5Int = Integer.parseInt(tv5.getText().toString());
                                int tv6Int = Integer.parseInt(tv6.getText().toString());
                                int tv7Int = Integer.parseInt(tv7.getText().toString());
                                int tv8Int = Integer.parseInt(tv8.getText().toString());

                                if(!abiertas.contains(tv1Int)){
                                    iv1.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv2Int)) {
                                    iv2.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv3Int)){
                                    iv3.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv4Int)){
                                    iv4.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv5Int)){
                                    iv5.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv6Int)){
                                    iv6.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv7Int)){
                                    iv7.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv8Int)){
                                    iv8.setImageResource(R.drawable.reverso);
                                }
                            }
                        }, duraccion);

                        resultado1.setText("vacio");
                        resultado2.setText("vacio");
                    }
                }
            }
        });
        iv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv6.setImageResource(imagenes.get(elegidos.get(5)));

                if(resultado1.getText().equals("vacio")){
                    resultado1.setText(elegidos.get(5).toString());
                }else{
                    resultado2.setText(elegidos.get(5).toString());
                    if(resultado1.getText().equals(resultado2.getText())){
                        Toast.makeText(MainActivity.this, "Respuesta Correcta!!!!", Toast.LENGTH_SHORT).show();
                        resultado1.setText("vacio");
                        resultado2.setText("vacio");
                        abiertas.add(elegidos.get(5));
                    }else{
                        Toast.makeText(MainActivity.this, "OHHH NOOO!!! Prueba otra vez!!!", Toast.LENGTH_SHORT).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                int tv1Int = Integer.parseInt(tv1.getText().toString());
                                int tv2Int = Integer.parseInt(tv2.getText().toString());
                                int tv3Int = Integer.parseInt(tv3.getText().toString());
                                int tv4Int = Integer.parseInt(tv4.getText().toString());
                                int tv5Int = Integer.parseInt(tv5.getText().toString());
                                int tv6Int = Integer.parseInt(tv6.getText().toString());
                                int tv7Int = Integer.parseInt(tv7.getText().toString());
                                int tv8Int = Integer.parseInt(tv8.getText().toString());

                                if(!abiertas.contains(tv1Int)){
                                    iv1.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv2Int)) {
                                    iv2.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv3Int)){
                                    iv3.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv4Int)){
                                    iv4.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv5Int)){
                                    iv5.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv6Int)){
                                    iv6.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv7Int)){
                                    iv7.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv8Int)){
                                    iv8.setImageResource(R.drawable.reverso);
                                }
                            }
                        }, duraccion);

                        resultado1.setText("vacio");
                        resultado2.setText("vacio");
                    }
                }
            }
        });
        iv7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv7.setImageResource(imagenes.get(elegidos.get(6)));

                if(resultado1.getText().equals("vacio")){
                    resultado1.setText(elegidos.get(6).toString());
                }else{
                    resultado2.setText(elegidos.get(6).toString());
                    if(resultado1.getText().equals(resultado2.getText())){
                        Toast.makeText(MainActivity.this, "Respuesta Correcta!!!!", Toast.LENGTH_SHORT).show();
                        resultado1.setText("vacio");
                        resultado2.setText("vacio");
                        abiertas.add(elegidos.get(6));
                    }else{
                        Toast.makeText(MainActivity.this, "OHHH NOOO!!! Prueba otra vez!!!", Toast.LENGTH_SHORT).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                int tv1Int = Integer.parseInt(tv1.getText().toString());
                                int tv2Int = Integer.parseInt(tv2.getText().toString());
                                int tv3Int = Integer.parseInt(tv3.getText().toString());
                                int tv4Int = Integer.parseInt(tv4.getText().toString());
                                int tv5Int = Integer.parseInt(tv5.getText().toString());
                                int tv6Int = Integer.parseInt(tv6.getText().toString());
                                int tv7Int = Integer.parseInt(tv7.getText().toString());
                                int tv8Int = Integer.parseInt(tv8.getText().toString());

                                if(!abiertas.contains(tv1Int)){
                                    iv1.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv2Int)) {
                                    iv2.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv3Int)){
                                    iv3.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv4Int)){
                                    iv4.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv5Int)){
                                    iv5.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv6Int)){
                                    iv6.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv7Int)){
                                    iv7.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv8Int)){
                                    iv8.setImageResource(R.drawable.reverso);
                                }
                            }
                        }, duraccion);

                        resultado1.setText("vacio");
                        resultado2.setText("vacio");
                    }
                }
            }
        });
        iv8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv8.setImageResource(imagenes.get(elegidos.get(7)));

                if(resultado1.getText().equals("vacio")){
                    resultado1.setText(elegidos.get(7).toString());
                }else{
                    resultado2.setText(elegidos.get(7).toString());
                    if(resultado1.getText().equals(resultado2.getText())){
                        Toast.makeText(MainActivity.this, "Respuesta Correcta!!!!", Toast.LENGTH_SHORT).show();
                        resultado1.setText("vacio");
                        resultado2.setText("vacio");
                        abiertas.add(elegidos.get(7));
                    }else{
                        Toast.makeText(MainActivity.this, "OHHH NOOO!!! Prueba otra vez!!!", Toast.LENGTH_SHORT).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                int tv1Int = Integer.parseInt(tv1.getText().toString());
                                int tv2Int = Integer.parseInt(tv2.getText().toString());
                                int tv3Int = Integer.parseInt(tv3.getText().toString());
                                int tv4Int = Integer.parseInt(tv4.getText().toString());
                                int tv5Int = Integer.parseInt(tv5.getText().toString());
                                int tv6Int = Integer.parseInt(tv6.getText().toString());
                                int tv7Int = Integer.parseInt(tv7.getText().toString());
                                int tv8Int = Integer.parseInt(tv8.getText().toString());

                                if(!abiertas.contains(tv1Int)){
                                    iv1.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv2Int)) {
                                    iv2.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv3Int)){
                                    iv3.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv4Int)){
                                    iv4.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv5Int)){
                                    iv5.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv6Int)){
                                    iv6.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv7Int)){
                                    iv7.setImageResource(R.drawable.reverso);
                                }
                                if(!abiertas.contains(tv8Int)){
                                    iv8.setImageResource(R.drawable.reverso);
                                }
                            }
                        }, duraccion);

                        resultado1.setText("vacio");
                        resultado2.setText("vacio");
                    }
                }
            }
        });

    }

    public static int numeroAleatorio(int size){
        int numero = 0;
        numero = (int) (Math.random() * size);
        return numero;
    }

    public static void esperar(int segundos){
        try {
            Thread.sleep(segundos * 1000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Reiniciar(View view){
        Intent next = new Intent(this, MainActivity.class);
        startActivity(next);
    }

}