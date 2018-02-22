package com.andrade.conversormoedas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    /*mapeando dos elementos manipulaveis
    vamos usar o ViewHolder ao inves de ter todos os elementos separados em variaveis, criamos uma classe statica
    e privada dentro da classe MainActivity, que vai englobar todos os atributos manipulaveis. A classe só é instanciada uma vez
     */
    private ViewHolder mViewHolder = new ViewHolder();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //pegando o elemento la do layout e colocando em variaveis para a manipulação
        this.mViewHolder.editValue = (EditText) findViewById(R.id.edit_value);
        this.mViewHolder.textDolar = (TextView) findViewById(R.id.text_dolar);
        this.mViewHolder.textEuro = (TextView) findViewById(R.id.text_euro);
        this.mViewHolder.buttonCalculate = (Button) findViewById(R.id.button_calculate);

        this.mViewHolder.buttonCalculate.setOnClickListener(this); //pegando o click do botão
        this.clearValues();

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.button_calculate){
            //lógica do botão
            double value = Double.valueOf(this.mViewHolder.editValue.getText().toString());
            this.mViewHolder.textDolar.setText(String.format("€ %.2f", value*3.24));
            this.mViewHolder.textEuro.setText(String.format("R$ %.2f", value*4.01));

        }
    }
    //método para esconder valores que não serao usados no momento
    private void clearValues(){
        this.mViewHolder.textDolar.setText("");
        this.mViewHolder.textEuro.setText("");
    }

    private static class ViewHolder{
        EditText editValue;
        TextView textDolar;
        TextView textEuro;
        Button buttonCalculate;
    }
}
