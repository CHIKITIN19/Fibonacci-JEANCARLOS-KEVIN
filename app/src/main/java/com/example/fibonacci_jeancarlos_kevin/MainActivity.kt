package com.example.fibonacci_jeancarlos_kevin

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ScrollView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    //se crean las variables que van a contener los campos del
    //texto de la parte del xml o vista
    var txt1:EditText?=null;
    var txt2:TextView?=null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //en esta parte extraemos componentes presentes en la vista
        //para poder trabajar con ellos
        txt1 = findViewById(R.id.txtNum);
        txt2 = findViewById(R.id.textView4);
    }
    //metodo que se llama en el boton desde la vista
    fun fibonacci(view: View){
        //se realiza la conversion de los datos extraidos desde la vista
        val numString = txt1?.text.toString();
        val numero = numString.toInt();

        //las siguiebtes lineas hace que funcione el calculo de secuencia fibonacci
        //se inicaliza con la suma de 0 y 1
        //una vez hecha esa suma se guarda el resultado
        //el primer numero pasa a tener el valor del segundo numero
        //y el segundo numero pasa a tener el valor de la suma
        //con esto nuevamente se repite el proveso hasta que el usuario desee
        var n1: Long = 0;
        var n2: Long = 1;
        var resultText = "["
        for (i in 1..numero){
            val sum = n1 + n2;
            //resultText += "$n1 , $n2 = $sum\n\n"
            if ( i == numero){
                resultText += " $sum]"
            }else {
                resultText += " $sum,"
            }
            n1 = n2;
            n2 = sum;
        }
        //una vez terminada la secuencia se otorga la lista de la secuencia
        //a una caja de texto en la vista
        txt2?.setText(resultText);
    }
}