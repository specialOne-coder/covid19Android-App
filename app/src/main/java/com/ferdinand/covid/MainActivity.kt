package com.ferdinand.covid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    lateinit var recycleView:RecyclerView

    lateinit var rec : RecyclerView

    lateinit var btnknow : Button
    lateinit var voirSymptom : TextView
    lateinit var voirPrecaution : TextView

    lateinit var casconfirm:TextView
    lateinit var gueris:TextView
    lateinit var deces:TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        casconfirm = findViewById(R.id.nbre_infection)
        gueris = findViewById(R.id.nbre_gueri)
        deces = findViewById(R.id.nbre_deces)

        //Symptomes Codes
        recycleView = findViewById(R.id.recycle)
        recycleView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        val listSymptom = ArrayList<SymptomModel>()

        listSymptom.add(SymptomModel(R.drawable.touxaig,"La toux","la toux aigue symptome courant du corona "))
        listSymptom.add(SymptomModel(R.drawable.fievre,"La fièvre","la fièvre (38°C +) symptome courant du corona"))
        listSymptom.add(SymptomModel(R.drawable.tired,"La fatigue","la fatigue,les courbatures sont des symptomes du corona "))
        listSymptom.add(SymptomModel(R.drawable.nezcoul,"Ecoulement nasal"," un nez qui coule beaucoup "))
        listSymptom.add(SymptomModel(R.drawable.maltete,"Mal de tete","Mal de tete suivi d'un mal de crane "))
        listSymptom.add(SymptomModel(R.drawable.vomiting,"Vomissement","le vomissement est un symptome du corona virus "))

        val symptomAdapter = SymptomAdapter(listSymptom)
        recycleView.adapter = symptomAdapter


        //Precautions Codes
        rec = findViewById(R.id.recycleprecaution)
        val listPrec = ArrayList<PrecautionModel>()

        listPrec.add(PrecautionModel(R.drawable.rm,"Restez chez vous","Restez à la maison si vous n'avez rien d'extra à faire dehors."))
        listPrec.add(PrecautionModel(R.drawable.adi,"Lavez-vous les mains","lavez-vous très regulièrement les mains."))
        listPrec.add(PrecautionModel(R.drawable.distanceciation,"Distanciation sociale","Restez a au moins un mètre des aures lorsque vous les parlez ou autres."))
        listPrec.add(PrecautionModel(R.drawable.lavsurf,"Essuyez vos surfaces","Essuyez souvent les surfaces que vous touchez chaque temps."))
        listPrec.add(PrecautionModel(R.drawable.pasmain,"Ne vous serrez pas les mains","Pas de contacts physiques svp!!!."))

        val precautionAdapter = PrecautionAdapter(listPrec)
        rec.adapter = precautionAdapter


        //Redirection vers La page SavoirPlus

        btnknow = findViewById(R.id.savoirplus_btn)
        btnknow.setOnClickListener(View.OnClickListener {
            val intent = Intent(this,SavoirPlusActivity::class.java)
            startActivity(intent)
        })

        // Les Buttons defiler

        voirSymptom = findViewById(R.id.voirsymptom)
        voirPrecaution= findViewById(R.id.voirPrecau)

        voirSymptom.setOnClickListener(View.OnClickListener {
              val intentsy = Intent(this,SymptomActivity::class.java)
              startActivity(intentsy)
        })

        voirPrecaution.setOnClickListener(View.OnClickListener {
            val intentprec = Intent(this,PrecautionActivity::class.java)
            startActivity(intentprec)
        })

        //Appel de la methode de l'API

        getGlobalInfos()

    }



    //API

    fun getGlobalInfos(){

        val url = "https://disease.sh/v2/all"

        var stringRequest = StringRequest(Request.Method.GET,
        url,
            Response.Listener<String> {

              var jsonObjects = JSONObject(it.toString())

                //remplacement des chiffres de l'appli par celui de l'appel
              casconfirm.text = jsonObjects.getString("cases")
              gueris.text = jsonObjects.getString("recovered")
              deces.text = jsonObjects.getString("deaths")

            },
            Response.ErrorListener {

                Toast.makeText(this,"Pas de connexion internet, les nombres ne sont donc actualisés",Toast.LENGTH_LONG).show()
                casconfirm.text = ("pas de connexion")
                gueris.text = ("pas de connexion")
                deces.text = ("pas de connexion")

            })

        var requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(stringRequest)

    }

}
