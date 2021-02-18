package com.ferdinand.covid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class PrecautionActivity : AppCompatActivity() {

    lateinit var recp : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_precaution)


        recp = findViewById(R.id.recycleprec)
        val listPrec = ArrayList<PrecautionModel>()

        listPrec.add(PrecautionModel(R.drawable.rm,"Restez chez vous","Restez à la maison si vous n'avez rien d'extra à faire dehors."))
        listPrec.add(PrecautionModel(R.drawable.adi,"Lavez-vous les mains","lavez-vous très regulièrement les mains."))
        listPrec.add(PrecautionModel(R.drawable.distanceciation,"Distanciation sociale","Restez a au moins un mètre des aures lorsque vous les parlez ou autres."))
        listPrec.add(PrecautionModel(R.drawable.lavsurf,"Essuyez vos surfaces","Essuyez souvent les surfaces que vous touchez chaque temps."))
        listPrec.add(PrecautionModel(R.drawable.pasmain,"Ne vous serrez pas les mains","Pas de contacts physiques svp!!!."))

        val precautionAdapter = PrecautionAdapter(listPrec)
        recp.adapter = precautionAdapter
    }
}
