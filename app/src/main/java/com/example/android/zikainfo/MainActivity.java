package com.example.android.zikainfo;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * Este aplicativo exibe informações sobre o vírus Zika.
 */

public class MainActivity extends AppCompatActivity {

    String mensagem;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
    * Este método é chamado quando o botão do vídeo falando da microcefalia é clicado.
     */
    public void videoButton(View v){
        //Quando o botão é clicado o vídeo especificado é aberto no app do YouTube.
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://youtu.be/kuebrK25o8A"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    /**
     * Este método é chamado quando o botão do vídeo falando da prevenção é clicado.
     */
    public void prevencaoButton(View v){
        //Quando o botão é clicado o vídeo especificado é aberto no app do YouTube.
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.youtube.com/watch?v=gziZ2y-k1gE"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    /**
     * Este método é chamado quando o botão para finalizar é clicado.
     */
    public void finalizar(View v){
        //Mostrar na tela uma mensagem de agradecimento.
        Toast.makeText(this, "Obrigado pelas respostas!", Toast.LENGTH_LONG).show();

        //Descobre o nome do usuário.
        EditText textoNome = (EditText) findViewById(R.id.texto_nome);
        name = textoNome.getText().toString();

        //Cria a mensagem do email
        String mensagem = criarMensagem(name);

        //Quando o botão é clicado o app de email é aberto com a mensagem e com o objetivo específicos
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Aplicativo Android: Zika Info");
        intent.putExtra(Intent.EXTRA_TEXT, mensagem);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    /**
     * Cria uma mensagem com o nome do usuário e do checkbox marcado por ele
     * @param nome
     * @return a mensagem
     */
    private String criarMensagem(String nome) {
        mensagem = nome +" escolheu você para indicar nosso aplicativo Zika Info. Nele você encontra as informações essesciais sobre o vírus Zika!";

        //Descobre se você não sabia sobre as informações
        CheckBox op1 = (CheckBox) findViewById(R.id.op1_checkbox);
        boolean CheOp1 = op1.isChecked();

        //Se o 1º CheckBox foi marcado então é exibida essa mensagem junto no email
        if(CheOp1){
            mensagem+= "\nNosso app foi bastante útil, pois o(a) "+nome+" não estava ciente de todas as informações passadas";
        }

        //Descobre se você precisa estar preparada
        CheckBox op2 = (CheckBox) findViewById(R.id.op2_checkbox);
        boolean CheOp2 = op2.isChecked();

        //Se o 2º CheckBox foi marcado então é exibida essa mensagem junto no email
        if(CheOp2){
            mensagem+= "\nNosso app foi bastante útil, pois o(a) "+nome+" sente que precisa estar preparado(a) contra o vírus";
        }

        //Descobre se você esta sentindo os sintomas
        CheckBox op3 = (CheckBox) findViewById(R.id.op3_checkbox);
        boolean CheOp3 = op3.isChecked();

        //Se o 3º CheckBox foi marcado então é exibida essa mensagem junto no email
        if(CheOp3){
            mensagem+= "\nNosso app foi bastante útil, pois o(a) "+nome+" acredita qua estar sentindo os sintomas do vírus";
        }

        //Descobre se você quer aprender mais sobre isso
        CheckBox op4 = (CheckBox) findViewById(R.id.op4_checkbox);
        boolean CheOp4 = op4.isChecked();

        //Se o 4º CheckBox foi marcado então é exibida essa mensagem junto no email
        if(CheOp4){
            mensagem+= "\nNosso app foi bastante útil, pois o(a) "+nome+" quer aprender mais sobre o vírus";
        }



        return mensagem;
    }


    /**
     * Este método é chamado quando o botão "O que é o vírus Zika?" é clicado.
     * Ele simplesmente mostra o conteúdo quando ele for clicado.
     * Se o conteúdo já estiver sendo mostrado é só clicar novamente para ele desaparecer.
     */
    public void mostrarConteudo1(View v){
        TextView text = (TextView) findViewById(R.id.text1);
        if (text.getVisibility() == text.GONE){
            text.setVisibility(text.VISIBLE);
        }else{
            text.setVisibility(text.GONE);
        }
    }


    /**
     * Este método é chamado quando o botão "Qual o modo de transmissão?" é clicado.
     * Ele simplesmente mostra o conteúdo quando ele for clicado.
     * Se o conteúdo já estiver sendo mostrado é só clicar novamente para ele desaparecer.
     */
    public void mostrarConteudo2(View v){
        TextView text = (TextView) findViewById(R.id.text2);
        if (text.getVisibility() == text.GONE){
            text.setVisibility(text.VISIBLE);
        }else{
            text.setVisibility(text.GONE);
        }
    }


    /**
     * Este método é chamado quando o botão "Quais são seus sintomas?" é clicado.
     * Ele simplesmente mostra o conteúdo quando ele for clicado.
     * Se o conteúdo já estiver sendo mostrado é só clicar novamente para ele desaparecer.
     */
    public void mostrarConteudo3(View v){
        TextView text = (TextView) findViewById(R.id.text3);
        if (text.getVisibility() == text.GONE){
            text.setVisibility(text.VISIBLE);
        }else{
            text.setVisibility(text.GONE);
        }
    }


    /**
     * Este método é chamado quando o botão "Relação entre a microcefalia e o vírus Zika?" é clicado.
     * Ele simplesmente mostra o conteúdo quando ele for clicado.
     * Se o conteúdo já estiver sendo mostrado é só clicar novamente para ele desaparecer.
     */
    public void mostrarConteudo4(View v){
        TextView text = (TextView) findViewById(R.id.text4);
        ImageView i = (ImageView) findViewById(R.id.imgMicro);
        Button b = (Button) findViewById(R.id.youTube1);
        if (text.getVisibility() == text.GONE){
            text.setVisibility(text.VISIBLE);
            i.setVisibility(i.VISIBLE);
            b.setVisibility(i.VISIBLE);
        }else{
            text.setVisibility(text.GONE);
            i.setVisibility(i.GONE);
            b.setVisibility(i.GONE);
        }
    }


    /**
     * Este método é chamado quando o botão "Qual o tratamento necessário?" é clicado.
     * Ele simplesmente mostra o conteúdo quando ele for clicado.
     * Se o conteúdo já estiver sendo mostrado é só clicar novamente para ele desaparecer.
     */
    public void mostrarConteudo5(View v){
        TextView text = (TextView) findViewById(R.id.text5);
        if (text.getVisibility() == text.GONE){
            text.setVisibility(text.VISIBLE);
        }else{
            text.setVisibility(text.GONE);
        }
    }


    /**
     * Este método é chamado quando o botão "Quais as formas de Prevenção?" é clicado.
     * Ele simplesmente mostra o conteúdo quando ele for clicado.
     * Se o conteúdo já estiver sendo mostrado é só clicar novamente para ele desaparecer.
     */
    public void mostrarConteudo6(View v){

        TextView text = (TextView) findViewById(R.id.text6);
        ImageView i = (ImageView) findViewById(R.id.imgPrevinir);
        Button b = (Button) findViewById(R.id.youTube2);
        if (text.getVisibility() == text.GONE){
            text.setVisibility(text.VISIBLE);
            i.setVisibility(i.VISIBLE);
            b.setVisibility(i.VISIBLE);
        }else{
            text.setVisibility(text.GONE);
            i.setVisibility(i.GONE);
            b.setVisibility(i.GONE);
        }
    }
}
