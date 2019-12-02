package com.msmasters.housewife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Sobre extends AppCompatActivity {
    private String contacto, descricao;
    private TextView txt_desc, txt_contacto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        getId();
        descricao = "Este programa vai ajudá-la(o) com a prepaaração do menu da alimentação de casa, da maneira mais eficaz possível. Conta com uma guia nutricionista e liberdade para criar ou registar receitas e listas de compras que desejar necessário com base em sua frequência de uso. \n" +
                "\n" +
                "Você pode programar o menu de acordo com as receitas cadastradas e/ou de forma livre.";
        contacto = "\nPara contactar, indicar um bug, ou propor uma ideia para melhorar meu programa pode contactar-me via email: adyvemba@gmail.com";
        txt_desc.setText(descricao);
        txt_contacto.setText(contacto);
    }

    public void getId(){
         txt_desc = (TextView) findViewById(R.id.txt_desc_app);
         txt_contacto = (TextView) findViewById(R.id.txt_contacto);
    }
}
