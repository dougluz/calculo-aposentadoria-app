package com.douglas.aposentadoria

import android.app.Activity
import android.os.Bundle
import android.widget.*

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)

        val spinnerSex = findViewById<Spinner>(R.id.spinner_sex)
        val textAge = findViewById<EditText>(R.id.text_age)
        val buttonCalc = findViewById<Button>(R.id.btn_calc)
        val textResult = findViewById<TextView>(R.id.txt_result)

        spinnerSex.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listOf("Masculino", "Feminino"))

        buttonCalc.setOnClickListener {
            val sex = spinnerSex.selectedItem as String
            val age = textAge.text.toString().toInt()
            var result = 0

            result = if (sex == "Masculino") {
                65 - age
            } else {
                60 - age
            }

            textResult.text = "Faltam $result anos para você se aposentar"
        }
    }
}