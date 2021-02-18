package com.ferdinand.covid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SymptomActivity : AppCompatActivity() {

    lateinit var rec: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_symptom)

        rec = findViewById(R.id.recyclesymp)


        rec.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)

        val listSymptom = ArrayList<SymptomModel>()

        listSymptom.add(SymptomModel(R.drawable.touxaig,"La toux","la toux aigue symptome courant du corona "))
        listSymptom.add(SymptomModel(R.drawable.fievre,"La fièvre","la fièvre (38°C +) symptome courant du corona"))
        listSymptom.add(SymptomModel(R.drawable.tired,"La fatigue","la fatigue,les courbatures sont des symptomes du corona "))
        listSymptom.add(SymptomModel(R.drawable.nezcoul,"Ecoulement nasal"," un nez qui coule beaucoup "))
        listSymptom.add(SymptomModel(R.drawable.maltete,"Mal de tete","Mal de tete suivi d'un mal de crane "))
        listSymptom.add(SymptomModel(R.drawable.vomiting,"Vomissement","le vomissement est un symptome du corona virus "))

        val symptomAdapter = SymptomAdapter(listSymptom)
        rec.adapter = symptomAdapter


    }
}
