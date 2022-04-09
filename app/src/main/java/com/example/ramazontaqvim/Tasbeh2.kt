package com.example.ramazontaqvim

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_tasbeh2.*

class Tasbeh2 : AppCompatActivity() {
    private var currentApiVersion: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasbeh2)
        val title=supportActionBar
        title?.title="Tasbeh"
        title!!.setDisplayHomeAsUpEnabled(true)

        currentApiVersion = Build.VERSION.SDK_INT
        val flags: Int = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        if (currentApiVersion >= Build.VERSION_CODES.KITKAT) {
            window.decorView.systemUiVisibility = flags
            val decorView: View = window.decorView
            decorView.setOnSystemUiVisibilityChangeListener { visibility ->
                if (visibility and View.SYSTEM_UI_FLAG_FULLSCREEN === 0) {
                    decorView.systemUiVisibility = flags
                }
            }
        }
        val b= arrayOf("«Лаа илааҳа иллаллоҳу Муҳаммадур Росуулуллоҳ»","«Ашҳаду аллаа илааҳа иллаллоҳу ва ашҳаду анна Муҳаммадан ъабдуҳу ва Росуулуҳ»",
            "«Ашҳаду аллаа илааҳа иллаллоҳу ваҳдаҳу лаа шарика лаҳ, лаҳул мулку ва лаҳул ҳамд, йуҳйии ва йумийт ва ҳува ҳаййул лаа йамуут, бийадиҳил хойр ва ҳува ъалаа кулли шайъин қодийр»."
            ,"«Аллоҳумма! Инни аъуузу бика мин ан ушрика бика шайъан ва ана аълам, ва астағфирука лима лаа аълам. Иннака анта ъалламул ғуйууб»",
            "«Астағфируллоҳ, астағфируллоҳ, астағфируллоҳа таъала мин кулли замбин азнабтаҳу ъамдан ав хотоан, сиррон ав ъаланийя, ва атуубу илайҳи миназ-замбиллазии аъламу ва миназ-замбиллазии лаа аълам, иннака анта ъалламул ғуйууб»",
            "«Субҳааналлоҳи, валҳамдулиллааҳи, ва лаа илааҳа иллаллоҳу, валлоҳу акбар. Лаа ҳавла ва лаа қуввата иллаа биллааҳил ъалиййил ъазийм.Маа шаа Аллоҳу каана ва маа лам йашаъ лам йакун»")

        val a= arrayOf("Subhanalloh","Alhamdulillah","Allohu akbar")
        val ArrayAdapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,a)

        var l=0
        var n=0
        var m=0
        var k=0
        linearLayout.setOnClickListener {
            n++
            k++
            l++
            text_tasbeh.text=n.toString()
            if (n==33){
                n=0
                m++
            }
            if (k==33){
                spinner.text="Alhamdulillah"
            }
            if (k==99) {
                k = 0
            }
            if (k==66) {
                spinner.text="Allohu akbar"
            }

            if (k==0) {
                spinner.text = "Subhanalloh"
            }
            text_hisobla.text=m.toString()
            text_hisobla2.text=l.toString()
        }
        restart.setOnClickListener {
            l=l-n
            k=k-n
            n=0
            text_hisobla2.text=l.toString()
            text_tasbeh.text=n.toString()
            if (k==33){
                spinner.text="Alhamdulillah"
            }
            if (k==99) {
                k = 0
            }
            if (k==66) {
                spinner.text="Allohu akbar"
            }

            if (k==0) {
                spinner.text = "Subhanalloh"
            }
        }
          all_restart.setOnClickListener {
            n=0
              k=0
              l=0
              m=0
              text_hisobla.text=m.toString()
              text_hisobla2.text=l.toString()
            text_tasbeh.text=n.toString()
              if (k==33){
                  spinner.text="Alhamdulillah"
              }
              if (k==99) {
                  k = 0
              }
              if (k==66) {
                  spinner.text="Allohu akbar"
              }

              if (k==0) {
                  spinner.text = "Subhanalloh"
              }
        }

    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (currentApiVersion >= Build.VERSION_CODES.KITKAT && hasFocus) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        }
    }
}