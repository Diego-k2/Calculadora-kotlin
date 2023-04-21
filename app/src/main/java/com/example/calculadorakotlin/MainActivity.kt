package com.example.calculadorakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import org.w3c.dom.Text
import kotlin.math.exp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportActionBar!!.hide();

        //Eventos Nnumeros
        var numeroZero = findViewById<TextView>(R.id.numero_zero);
        numeroZero.setOnClickListener {acrescentarUmaExpressao("0", true)}
        var numeroUm = findViewById<TextView>(R.id.numero_um);
        numeroUm.setOnClickListener {acrescentarUmaExpressao("1", true)}
        var numeroDois = findViewById<TextView>(R.id.numero_dois);
        numeroDois.setOnClickListener {acrescentarUmaExpressao("2", true)}
        var numeroTres = findViewById<TextView>(R.id.numero_tres);
        numeroTres.setOnClickListener {acrescentarUmaExpressao("3", true)}
        var numeroQuatro = findViewById<TextView>(R.id.numero_quatro);
        numeroQuatro.setOnClickListener {acrescentarUmaExpressao("4", true)}
        var numeroCinco = findViewById<TextView>(R.id.numero_cinco);
        numeroCinco.setOnClickListener {acrescentarUmaExpressao("5", true)}
        var numeroSeis= findViewById<TextView>(R.id.numero_seis);
        numeroSeis.setOnClickListener {acrescentarUmaExpressao("6", true)}
        var numeroSete = findViewById<TextView>(R.id.numero_sete);
        numeroSete.setOnClickListener {acrescentarUmaExpressao("7", true)}
        var numeroOito = findViewById<TextView>(R.id.numero_oito);
        numeroOito.setOnClickListener {acrescentarUmaExpressao("8", true)}
        var numeroNove = findViewById<TextView>(R.id.numero_nove);
        numeroNove.setOnClickListener {acrescentarUmaExpressao("9", true)}
        var ponto = findViewById<TextView>(R.id.ponto);
        ponto.setOnClickListener { acrescentarUmaExpressao(".", true) }

        //Eventos Operadores
        var soma = findViewById<TextView>(R.id.soma);
        soma.setOnClickListener { acrescentarUmaExpressao("+",false) }
        var subtracao = findViewById<TextView>(R.id.subtracao);
        subtracao.setOnClickListener { acrescentarUmaExpressao("-",false) }
        var multiplicacao = findViewById<TextView>(R.id.multiplicacao);
        multiplicacao.setOnClickListener { acrescentarUmaExpressao("*",false) }
        var divisao = findViewById<TextView>(R.id.divisao);
        divisao.setOnClickListener { acrescentarUmaExpressao("/",false) }
        var limpar = findViewById<TextView>(R.id.limpar);
        limpar.setOnClickListener {
            var resultado = findViewById<TextView>(R.id.resultado);
            var expressao = findViewById<TextView>(R.id.expressao);
            resultado.text = "";
            expressao.text = "";
        }
        var backspace = findViewById<TextView>(R.id.backspace);
        backspace.setOnClickListener {
            var expressao = findViewById<TextView>(R.id.expressao);
            val string = expressao.text.toString();

            if(string.isNotBlank()){
                expressao.text = string.substring(0, string.length-1,);
            }
            var resultado = findViewById<TextView>(R.id.resultado);
            resultado.text = "";
        }
        var igual = findViewById<TextView>(R.id.igual);
        igual.setOnClickListener {
            try {
                var expressao = findViewById<TextView>(R.id.expressao);
                val construtorExpressao = ExpressionBuilder(expressao.text.toString()).build();

                val retornoResultado = construtorExpressao.evaluate();
                val longResult = retornoResultado.toLong();

                var resultado = findViewById<TextView>(R.id.resultado);
                if(retornoResultado == longResult.toDouble()){
                    resultado.text = longResult.toString() ;
                } else {
                    resultado.text = retornoResultado.toString();
                }
            } catch (error:Exception){

            }
        }



    }


    fun acrescentarUmaExpressao(string:String, limparDados:Boolean){

        var resultado = findViewById<TextView>(R.id.resultado);
        var expressao = findViewById<TextView>(R.id.expressao);

        if(resultado.text.isNotEmpty()){
            expressao.text = "";
        }

        if(limparDados){
            resultado.text = "";
            expressao.append(string);
        } else {
            expressao.append(resultado.text);
            expressao.append(string);
            resultado.text = ""
        }


    }
}