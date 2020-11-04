package com.ciputra.myapplication;

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Angka
        one_btn.setOnClickListener { appendOnExpresstion("1", true) }
        two_btn.setOnClickListener { appendOnExpresstion("2", true) }
        three_btn.setOnClickListener { appendOnExpresstion("3", true) }
        four_btn.setOnClickListener { appendOnExpresstion("4", true) }
        five_btn.setOnClickListener { appendOnExpresstion("5", true) }
        six_btn.setOnClickListener { appendOnExpresstion("6", true) }
        seven_btn.setOnClickListener { appendOnExpresstion("7", true) }
        eight_btn.setOnClickListener { appendOnExpresstion("8", true) }
        nine_btn.setOnClickListener { appendOnExpresstion("9", true) }
        zero_btn.setOnClickListener { appendOnExpresstion("0", true) }
        dot_btn.setOnClickListener { appendOnExpresstion(".", true) }

        //Pembilang
        addition_btn.setOnClickListener { appendOnExpresstion("+", false) }
        subtract_btn.setOnClickListener { appendOnExpresstion("-", false) }
        multipy_btn.setOnClickListener { appendOnExpresstion("*", false) }
        divide_btn.setOnClickListener { appendOnExpresstion("/", false) }
        kuadrat_btn.setOnClickListener { appendOnExpresstion("^2", false) }

        clear_everything_btn.setOnClickListener {
            result_id2.text = ""
            result_id.text = ""
        }

        root_btn.setOnClickListener{
            var akar1 = result_id2.text.toString()
            result_id.text = Math.sqrt(akar1.toDouble()).toInt().toString()
        }

        floor_btn.setOnClickListener{
            var floor1 = result_id2.text.toString()
            result_id.text = Math.floor(floor1.toDouble()).toInt().toString()
        }

        round_btn.setOnClickListener{
            var round1 = result_id2.text.toString()
            result_id.text = (Math.round(round1.toDouble()*10.0)/10.0).toString()
        }

        ceiling_btn.setOnClickListener{
            var ceil1 = result_id2.text.toString()
            result_id.text = Math.ceil(ceil1.toDouble()).toInt().toString()
        }

        backspace_btn.setOnClickListener {
            val string = result_id2.text.toString()
            if(string.isNotEmpty()){
                result_id2.text = string.substring(0,string.length-1)
            }
            result_id.text = ""
        }

        equal_btn.setOnClickListener {
            try {

                val expression = ExpressionBuilder(result_id2.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result == longResult.toDouble())
                    result_id.text = longResult.toString()
                else
                    result_id.text = result.toString()

            }catch (e:Exception){
                Log.d("Exception"," message : " + e.message )
            }
        }

    }

    fun appendOnExpresstion(string: String, canClear: Boolean) {

        if(result_id.text.isNotEmpty()){
            result_id2.text = ""
        }

        if (canClear) {
            result_id.text = ""
            result_id2.append(string)
        } else {
            result_id2.append(result_id.text)
            result_id2.append(string)
            result_id.text = ""
        }
    }
}