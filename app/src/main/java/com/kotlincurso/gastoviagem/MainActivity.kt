package com.kotlincurso.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val id = v.id

        if (id == R.id.buttonCalculate) {
            calculate()
        }
    }

    private fun calculate() {

        if (validationOk()) {

            try {
                val distance = editDistance.text.toString().toFloat()
                val price = editPrice.text.toString().toFloat()
                val autonomy = editAutonomy.text.toString().toFloat()

                val total = (distance * price) / autonomy

                textTotalValue.text = "R$ ${"%.2f".format(total)}"
            } catch (nfe: NumberFormatException) {
                Toast.makeText(this, "Preencha informe valores válidos", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "Preencha todos os valores", Toast.LENGTH_LONG).show()
        }
    }

    private fun validationOk(): Boolean {
        return (editDistance.text.toString() != ""
                && editPrice.text.toString() != ""
                && editAutonomy.text.toString() != ""
                && editAutonomy.text.toString() != "0")
    }


}