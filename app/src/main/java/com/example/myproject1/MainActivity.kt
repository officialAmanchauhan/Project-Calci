package com.example.myproject1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Number Listeners
        button0.setOnClickListener{
            if(tvWrite.text != ""){
                appendOnClick(false,"0")
            }
        }
        button1.setOnClickListener{appendOnClick(true,"1")}
        button2.setOnClickListener{appendOnClick(true,"2")}
        button3.setOnClickListener{appendOnClick(true,"3")}
        button4.setOnClickListener{appendOnClick(true,"4")}
        button5.setOnClickListener{appendOnClick(true,"5")}
        button6.setOnClickListener{appendOnClick(true,"6")}
        button7.setOnClickListener{appendOnClick(true,"7")}
        button8.setOnClickListener{appendOnClick(true,"8")}
        button9.setOnClickListener{appendOnClick(true,"9")}
        buttondot.setOnClickListener{appendOnClick(true,".")}

        // Operator Listeners
        buttonSub.setOnClickListener{
            if(tvWrite.text != ""){
                appendOnClick(false,"-")
            }
        }
        buttonSum.setOnClickListener{
            if(tvWrite.text != ""){
                appendOnClick(false,"+")
            }
        }
        buttonDiv.setOnClickListener{
            if(tvWrite.text != ""){
                appendOnClick(false,"/")}
            }

        buttonMul.setOnClickListener{
            if(tvWrite.text != ""){
                appendOnClick(false,"*")
            }
        }
        buttonEqual.setOnClickListener{ calculate() }
        buttonClear.setOnClickListener{ clear() }
        buttonDel.setOnClickListener{ delete()}

    }


    private fun appendOnClick(clear: Boolean, string: String) {
        if(clear){
            tvDisplay.text = ""
            tvWrite.append(string)
            tvWrite.text
        }else{
            tvWrite.append(tvDisplay.text)
            tvWrite.append(string)
            tvDisplay.text = ""
            tvWrite.text
        }
    }

    private fun clear() {
        tvDisplay.text = ""
        tvWrite.text = ""
    }
    private fun delete() {
        val delInput = tvWrite.text.toString()
        tvWrite.text = delInput.dropLast(1)
    }

    private fun calculate() {
        try {
            val input = ExpressionBuilder(tvWrite.text.toString()).build()
            val output = input.evaluate()
            val longOutput = output.toLong()
            if(output == longOutput.toDouble()) {
                tvDisplay.text = longOutput.toString()
            } else{
                tvDisplay.text = output.toString()
            }
        }catch (e:Exception) {
            Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_LONG).show()
            tvDisplay.setText("Error")
        }
    }

}