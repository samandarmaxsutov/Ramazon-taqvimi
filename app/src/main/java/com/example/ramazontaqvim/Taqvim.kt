package com.example.ramazontaqvim
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat.startActivity
import com.example.ramazontaqvim.ExpandableListData.data
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_alarm.*

import kotlinx.android.synthetic.main.activity_taqvim.*

import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.sign

class Taqvim : AppCompatActivity() {
    private var expandableListView: ExpandableListView? = null
    private var adapter: ExpandableListAdapter? = null
    private var titleList: List<String>? = null

    val kun = arrayOf<String>(
        "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
        "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
        "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"
    )

    val sana = arrayOf<String>(

        "02.04.2022",
        "03.04.2022",
        "04.04.2022",
        "05.04.2022",
        "06.04.2022",
        "07.04.2022",
        "08.04.2022",
        "09.04.2022",
        "10.04.2022",
        "11.04.2022",
        "12.04.2022",
        "13.04.2022",
        "14.04.2022",
        "15.04.2022",
        "16.04.2022",
        "17.04.2022",
        "18.04.2022",
        "19.04.2022",
        "20.04.2022",
        "21.04.2022",
        "22.04.2022",
        "23.04.2022",
        "24.04.2022",
        "25.04.2022",
        "26.04.2022",
        "27.04.2022",
        "28.04.2022",
        "29.04.2022",
        "30.04.2022",
        "01.05.2022",


    )
    val shahar = arrayOf<String>("Toshkent shahri" )
        //"Parkent","Asaka(Andijon)","Rishton(Farg'ona )"

    val imagee = arrayOf<Int>(R.drawable.ic_baseline_today_24, R.drawable.ic_baseline_today_24, R.drawable.ic_baseline_today_24,R.drawable.ic_baseline_today_24,
    )
    var saharlik= arrayOf<String>(
        "04:47", "04:45", "04:43", "04:41", "04:39", "04:37", "04:35", "04:34", "04:32", "04:30",
        "04:28", "04:26", "04:25", "04:23", "04:21", "04:19","04:17", "04:15", "04:13", "04:12",
        "04:10", "04:08", "04:06", "04:05", "04:04", "04:02", "03:59", "03:57", "03:56", "03:54" )
    var iftorlik=  arrayOf<String>(
        "18:51", "18:52", "18:53", "18:54", "18:55", "18:56", "18:57", "18:58", "18:59", "19:00",
        "19:01",  "19:03", "19:04", "19:05", "19:06", "19:07", "19:08","19:09", "19:10", "19:11",
        "19:12", "19:13", "19:14", "19:15", "19:17", "19:18", "19:19", "19:20", "19:21", "19:22",
    )

    val saharlik_toshkent = arrayOf<String>(
        "04:37", "04:35", "04:33", "04:31", "04:29", "04:27", "04:26", "04:24", "04:22", "04:20",
        "04:18", "04:17", "04:15", "04:13", "04:11", "04:09", "04:07", "04:05", "04:04", "04:02",
        "04:00", "03:58", "03:57", "03:56", "03:54", "03:51", "03:49", "03:48", "03:46", "03:45"
    )
    val iftorlik_toshkent = arrayOf<String>(
        "18:45", "18:46", "18:47", "18:48", "18:49", "18:50", "18:51", "18:52", "18:53", "18:54",
        "18:56", "18:57", "18:58", "18:59", "19:00", "19:01", "19:02", "19:03", "19:04", "19:05",
        "19:06", "19:07", "19:08", "19:10", "19:11", "19:12", "19:13", "19:14", "19:15", "19:16"
    )
    val saharlik_parkent = arrayOf<String>(
        "04:43", "04:41", "04:39", "04:37", "04:35", "04:33", "04:32", "04:30", "04:28", "04:26",
        "04:24", "04:23", "04:21", "04:19", "04:17", "04:15", "04:13", "04:12", "04:11", "04:09",
        "04:07", "04:05", "04:04", "04:03", "04:01", "03:58", "03:56", "03:55", "03:53", "03:52"
    )

    val iftorlik_parkent = arrayOf<String>(
        "18:50", "18:51", "18:52", "18:53", "18:54", "18:55", "18:56", "18:57", "18:58", "18:59",
        "19:01", "19:02", "19:03", "19:04", "19:05", "19:06", "19:07", "19:07", "19:08", "19:09",
        "19:10", "19:11", "19:12", "19:14", "19:15", "19:16", "19:17", "19:18", "19:19", "19:20"
    )

 val saharlik_anidijan_asaka = arrayOf<String>(
        "04:18", "04:16", "04:14", "04:12", "04:10", "04:08", "04:06", "04:04", "04:03", "04:01",
        "03:59", "03:57", "03:55", "03:51", "03:51", "03:49", "03:47", "03:46", "03:44", "03:42",
        "03:40", "03:38", "03:36", "03:34", "03:33", "03:31","03:29", "03:27", "03:25", "03:23"
 )

    val iftorlik_andijan_asaka = arrayOf<String>(
        "18:38", "18:39", "18:40", "18:42", "18:43", "18:44", "18:45", "18:46", "18:47", "18:48",
        "18:49", "18:50", "18:51", "18:52", "18:53", "18:54", "18:55", "18:56","18:57", "18:58",
        "18:59", "19:00", "19:01", "19:02", "19:03", "19:04", "19:06", "19:07", "19:08", "19:09"
    )
val saharlik_fargona_rishton = arrayOf<String>(
    "04:39", "04:37", "04:35", "04:33", "04:31", "04:29", "04:28", "04:26", "04:24", "04:20",
    "04:19", "04:17", "04:15", "04:13", "04:11", "04:09", "04:08", "04:09","04:07", "04:05",
    "04:03", "04:01", "04:00", "03:59", "03:57", "03:54", "03:52", "03:51","03:49", "03:48",
 )

    val iftorlik_fargona_rishton = arrayOf<String>(
         "18:44", "18:45", "18:46", "18:47", "18:48", "18:49", "18:50","18:50", "18:51", "18:52",
        "18:53", "18:54", "18:55", "18:56","18:57", "18:58", "18:59", "19:00", "19:01", "19:02",
        "19:03", "19:04","19:05", "19:06", "19:07", "19:08", "19:09","19:10", "19:11", "19:12", "19:13"
    )


    val hafta = arrayOf<String>(
        "Sha",  "Ya", "Du", "Se", "Cho", "Pa", "Ju",
        "Sha", "Ya", "Du", "Se", "Cho", "Pa", "Ju",
        "Sha", "Ya", "Du", "Se", "Cho", "Pa", "Ju",
        "Sha", "Ya", "Du", "Se", "Cho", "Pa", "Ju",
        "Sha", "Ya",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_taqvim)
        window.decorView.systemUiVisibility=View.SYSTEM_UI_FLAG_FULLSCREEN
        val bottomNavigationMenuView: BottomNavigationView = findViewById(R.id.bottomNavigation)

    hafta_kun.text=dayof_week()

        val myListAdapter = MyListAdapter(this, sana, saharlik, kun, iftorlik, hafta)
        list_View.adapter = myListAdapter
        list_View.setOnItemClickListener() { adapterView, view, position, id ->

            val intent = Intent(this, Alarm::class.java)
            intent.putExtra("saharlik_vaqti", "${saharlik[position]}")
            intent.putExtra("sana", "${sana[position]}")
            intent.putExtra("kun", "${kun[position]}")
            intent.putExtra("iftorlik", "${sana[position]}")
            intent.putExtra("kun", "${sana[position]}")
            startActivity(intent)

        }

        supportActionBar?.title = "Bugungi kun"
        kunni_anniqla()
        keyingi_()
        budulnik.setOnClickListener {
            val intent = Intent(this, Alarm::class.java)
            startActivity(intent)
        }

        bottomNavigationMenuView.setOnNavigationItemSelectedListener(
            BottomNavigationView.OnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.home -> {
                        layout_list.visibility = View.GONE
                        layout1.visibility = View.VISIBLE
                        layout_budulnik.visibility = View.GONE
                        layout_duolar.visibility = View.GONE
                        supportActionBar?.title = "Bugungi kun"
                        keyingi_()
                        kunni_anniqla()
                    }
                    R.id.calendar -> {
                        layout_list.visibility = View.VISIBLE
                        layout1.visibility = View.GONE
                        layout_budulnik.visibility = View.GONE
                        layout_duolar.visibility = View.GONE
                        supportActionBar?.title = "Taqvim"
                       keyingi_()
                        kunni_anniqla()
                    }
                    R.id.settings -> {
                        layout_list.visibility = View.GONE
                        layout1.visibility = View.GONE
                        layout_budulnik.visibility = View.VISIBLE
                        layout_duolar.visibility = View.GONE
                        supportActionBar?.title = "Sozlamalar"
                        keyingi_()
                        kunni_anniqla()

                    }
                    R.id.duolar -> {
                        layout_list.visibility = View.GONE
                        layout1.visibility = View.GONE
                        layout_budulnik.visibility = View.GONE
                        supportActionBar?.title = "Duolar"
                        keyingi_()
                        kunni_anniqla()
                        layout_duolar.visibility = View.VISIBLE
                        expandableListView = findViewById(R.id.expendableList)
                        if (expandableListView != null) {
                            val listData = data
                            titleList = ArrayList(listData.keys)
                            adapter = CustomExpandableListAdapter(this, titleList as ArrayList<String>, listData)
                            expandableListView!!.setAdapter(adapter)

                        }

                    }

                }
                return@OnNavigationItemSelectedListener true
            })


    }

    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        builder.setIcon(R.drawable.ic_baseline_exit_to_app_24)
        builder.setTitle("Chiqish")
        builder.setMessage("Rostan ham dasturdan chiqmoqchimisiz?")
        builder.setNegativeButton("Yo'q") { _, _ ->
        }
        builder.setPositiveButton("Ha") { _, _ ->
            finishAffinity()
        }
        builder.show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.new_w, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.option_3 -> {
                bottomNavigation.selectedItemId = R.id.settings
            }
            R.id.option_2 -> {
                val intent = Intent(this, Tasbeh2::class.java)
                startActivity(intent)
            }
            R.id.option_1 -> {
                val intent = Intent(this, Alarm::class.java)
                startActivity(intent)
            }

        }
        return super.onOptionsItemSelected(item)
    }

    private fun kunni_anniqla() {
        var textView: TextView = findViewById(R.id.bugungi_kun)
        val Oy = SimpleDateFormat("MM")
        val Kun = SimpleDateFormat("d")
        val oy: String = Oy.format(Date())
        val bugungi_k: String = Kun.format(Date())
        textView.text = oy


        if (textView.text == "01") {
            bugungi_kun.text = "$bugungi_k-yanvar"
            saharlik_vaqti1.text = "Bugun ro'za tutish kuni emas"
            iftorlik_vaqti_vaqti1.visibility = View.GONE
            saharlik_vaqti1.setBackgroundColor(Color.GREEN)
        }
        if (textView.text == "02") {
            bugungi_kun.text = "$bugungi_k-fevral"
            saharlik_vaqti1.text = "Bugun ro'za tutish kuni emas"
            iftorlik_vaqti_vaqti1.visibility = View.GONE
            saharlik_vaqti1.setBackgroundColor(Color.GREEN)
        }
        if (textView.text == "03") {
            bugungi_kun.text = "$bugungi_k-mart"

            saharlik_vaqti1.text = "Bugun ro'za tutish kuni emas"
            iftorlik_vaqti_vaqti1.visibility = View.GONE
            saharlik_vaqti1.setBackgroundColor(Color.parseColor("#ffffff"))
        }
        if (textView.text == "04") {
            bugungi_kun.text = "$bugungi_k-aprel"
            if (bugungi_k.toInt() == 2) {
                saharlik_vaqti1.text = saharlik[0]
                iftorlik_vaqti_vaqti1.text = iftorlik[0]
            }
            if (bugungi_k.toInt() == 3) {
                saharlik_vaqti1.text = saharlik[1]
                iftorlik_vaqti_vaqti1.text = iftorlik[1]
            }
            if (bugungi_k.toInt() == 4) {
                saharlik_vaqti1.text = saharlik[2]
                iftorlik_vaqti_vaqti1.text = iftorlik[2]
            }
            if (bugungi_k.toInt() == 5) {
                saharlik_vaqti1.text = saharlik[3]
                iftorlik_vaqti_vaqti1.text = iftorlik[3]
            }
            if (bugungi_k.toInt() == 6) {
                saharlik_vaqti1.text = saharlik[4]
                iftorlik_vaqti_vaqti1.text = iftorlik[4]
            }
            if (bugungi_k.toInt() == 7) {
                saharlik_vaqti1.text = saharlik[5]
                iftorlik_vaqti_vaqti1.text = iftorlik[5]
            }
            if (bugungi_k.toInt() == 8) {
                saharlik_vaqti1.text = saharlik[6]
                iftorlik_vaqti_vaqti1.text = iftorlik[6]
            }
            if (bugungi_k.toInt() == 9) {
                saharlik_vaqti1.text = saharlik[7]
                iftorlik_vaqti_vaqti1.text = iftorlik[7]
            }
            if (bugungi_k.toInt() == 10) {
                saharlik_vaqti1.text = saharlik[8]
                iftorlik_vaqti_vaqti1.text = iftorlik[8]
            }
            if (bugungi_k.toInt() == 11) {
                saharlik_vaqti1.text = saharlik[9]
                iftorlik_vaqti_vaqti1.text = iftorlik[9]
            }
            if (bugungi_k.toInt() == 12) {
                saharlik_vaqti1.text = saharlik[10]
                iftorlik_vaqti_vaqti1.text = iftorlik[10]
            }
            if (bugungi_k.toInt() == 13) {
                saharlik_vaqti1.text = saharlik[11]
                iftorlik_vaqti_vaqti1.text = iftorlik[11]
            }
            if (bugungi_k.toInt() == 14) {
                saharlik_vaqti1.text = saharlik[12]
                iftorlik_vaqti_vaqti1.text = iftorlik[12]
            }
            if (bugungi_k.toInt() == 15) {
                saharlik_vaqti1.text = saharlik[13]
                iftorlik_vaqti_vaqti1.text = iftorlik[13]
            }
            if (bugungi_k.toInt() == 16) {
                saharlik_vaqti1.text = saharlik[14]
                iftorlik_vaqti_vaqti1.text = iftorlik[14]
            }
            if (bugungi_k.toInt() == 17) {
                saharlik_vaqti1.text = saharlik[15]
                iftorlik_vaqti_vaqti1.text = iftorlik[15]
            }
            if (bugungi_k.toInt() == 18) {
                saharlik_vaqti1.text = saharlik[16]
                iftorlik_vaqti_vaqti1.text = iftorlik[16]
            }
            if (bugungi_k.toInt() == 19) {
                saharlik_vaqti1.text = saharlik[17]
                iftorlik_vaqti_vaqti1.text = iftorlik[17]
            }
            if (bugungi_k.toInt() == 20) {
                saharlik_vaqti1.text = saharlik[18]
                iftorlik_vaqti_vaqti1.text = iftorlik[18]
            }
            if (bugungi_k.toInt() == 21) {
                saharlik_vaqti1.text = saharlik[19]
                iftorlik_vaqti_vaqti1.text = iftorlik[19]
            }
            if (bugungi_k.toInt() == 22) {
                saharlik_vaqti1.text = saharlik[20]
                iftorlik_vaqti_vaqti1.text = iftorlik[20]
            }
            if (bugungi_k.toInt() == 23) {
                saharlik_vaqti1.text = saharlik[21]
                iftorlik_vaqti_vaqti1.text = iftorlik[21]
            }
            if (bugungi_k.toInt() == 24) {
                saharlik_vaqti1.text = saharlik[22]
                iftorlik_vaqti_vaqti1.text = iftorlik[22]
            }
            if (bugungi_k.toInt() == 25) {
                saharlik_vaqti1.text = saharlik[23]
                iftorlik_vaqti_vaqti1.text = iftorlik[23]
            }
            if (bugungi_k.toInt() == 26) {
                saharlik_vaqti1.text = saharlik[24]
                iftorlik_vaqti_vaqti1.text = iftorlik[24]
            }
            if (bugungi_k.toInt() == 27) {
                saharlik_vaqti1.text = saharlik[25]
                iftorlik_vaqti_vaqti1.text = iftorlik[25]
            }
            if (bugungi_k.toInt() == 28) {
                saharlik_vaqti1.text = saharlik[26]
                iftorlik_vaqti_vaqti1.text = iftorlik[26]
            }
            if (bugungi_k.toInt() == 29) {
                saharlik_vaqti1.text = saharlik[27]
                iftorlik_vaqti_vaqti1.text = iftorlik[27]
            }
            if (bugungi_k.toInt() == 30) {
                saharlik_vaqti1.text = saharlik[28]
                iftorlik_vaqti_vaqti1.text = iftorlik[28]
            }
        }
        if (textView.text == "05") {
            bugungi_kun.text = "$bugungi_k-may"
            if (bugungi_k.toInt() == 1) {
                saharlik_vaqti1.text = saharlik[29]
                iftorlik_vaqti_vaqti1.text = iftorlik[29]
            } else {
                saharlik_vaqti1.text = "Bugun ro'za tutish kuni emas"
                iftorlik_vaqti_vaqti1.visibility = View.GONE
                saharlik_vaqti1.setBackgroundColor(Color.GREEN)
            }
        }
        if (textView.text == "06") {
            bugungi_kun.text = "$bugungi_k-iyun"
            saharlik_vaqti1.text = "Bugun ro'za tutish kuni emas"
            iftorlik_vaqti_vaqti1.visibility = View.GONE
            saharlik_vaqti1.setBackgroundColor(Color.GREEN)
        }
        if (textView.text == "07") {
            bugungi_kun.text = "$bugungi_k-iyul"
            saharlik_vaqti1.text = "Bugun ro'za tutish kuni emas"
            iftorlik_vaqti_vaqti1.visibility = View.GONE
            saharlik_vaqti1.setBackgroundColor(Color.GREEN)
        }
        if (textView.text == "08") {
            bugungi_kun.text = "$bugungi_k-avgust"
            saharlik_vaqti1.text = "Bugun ro'za tutish kuni emas"
            iftorlik_vaqti_vaqti1.visibility = View.GONE
            saharlik_vaqti1.setBackgroundColor(Color.GREEN)
        }
        if (textView.text == "09") {
            bugungi_kun.text = "$bugungi_k-sentabr"
            saharlik_vaqti1.text = "Bugun ro'za tutish kuni emas"
            iftorlik_vaqti_vaqti1.visibility = View.GONE
            saharlik_vaqti1.setBackgroundColor(Color.GREEN)
        }
        if (textView.text == "10") {
            bugungi_kun.text = "$bugungi_k-oktabr"
            saharlik_vaqti1.text = "Bugun ro'za tutish kuni emas"
            iftorlik_vaqti_vaqti1.visibility = View.GONE
            saharlik_vaqti1.setBackgroundColor(Color.GREEN)
        }
        if (textView.text == "11") {
            bugungi_kun.text = "$bugungi_k-noyabr"
            saharlik_vaqti1.text = "Bugun ro'za tutish kuni emas"
            iftorlik_vaqti_vaqti1.visibility = View.GONE
            saharlik_vaqti1.setBackgroundColor(Color.GREEN)
        }
        if (textView.text == "12") {
            bugungi_kun.text = "$bugungi_k-dekabr"
            saharlik_vaqti1.text = "Bugun ro'za tutish kuni emas"
            iftorlik_vaqti_vaqti1.visibility = View.GONE
            saharlik_vaqti1.setBackgroundColor(Color.parseColor("#fff000"))
        }

    }

    private fun keyingi_() {
        val myListAdapter2 = MyAdapter2(this, shahar, imagee)
        list_view2.adapter = myListAdapter2
        list_view2.setOnItemClickListener() { adapterView, view, position, id ->
            bottomNavigation.selectedItemId = R.id.calendar
            text_shahar.text = shahar[position]
            text_shahar2.text = shahar[position]



            if (text_shahar.text.toString() == "Toshkent") {
                saharlik = saharlik_toshkent
                iftorlik=iftorlik_toshkent
                val myListAdapter = MyListAdapter(this, sana, saharlik, kun, iftorlik, hafta)
                list_View.adapter = myListAdapter
                list_View.setOnItemClickListener() { adapterView, view, position, id ->

                    val intent = Intent(this, Alarm::class.java)
                    intent.putExtra("saharlik_vaqti", "${saharlik[position]}")
                    intent.putExtra("sana", "${sana[position]}")
                    intent.putExtra("kun", "${kun[position]}")
                    intent.putExtra("iftorlik", "${sana[position]}")
                    intent.putExtra("kun", "${sana[position]}")
                    startActivity(intent)

                }
            }
             if (text_shahar.text.toString() == "Asaka(Andijon)") {
                saharlik = saharlik_anidijan_asaka
                iftorlik=iftorlik_andijan_asaka
                val myListAdapter = MyListAdapter(this, sana, saharlik, kun, iftorlik, hafta)
                list_View.adapter = myListAdapter
                list_View.setOnItemClickListener() { adapterView, view, position, id ->

                    val intent = Intent(this, Alarm::class.java)
                    startActivity(intent)

                }
            }
 if (text_shahar.text.toString() == "Rishton(Farg'ona)") {
                saharlik = saharlik_fargona_rishton
                iftorlik=iftorlik_fargona_rishton
                val myListAdapter = MyListAdapter(this, sana, saharlik, kun, iftorlik, hafta)
                list_View.adapter = myListAdapter
                list_View.setOnItemClickListener() { adapterView, view, position, id ->

                    val intent = Intent(this, Alarm::class.java)
                    startActivity(intent)

                }
            }

            if (text_shahar.text.toString() == "Parkent") {
                saharlik = saharlik_parkent
                iftorlik=iftorlik_parkent
                val myListAdapter = MyListAdapter(this, sana, saharlik, kun, iftorlik, hafta)
                list_View.adapter = myListAdapter
                list_View.setOnItemClickListener() { adapterView, view, position, id ->

                    val intent = Intent(this, Alarm::class.java)
                    startActivity(intent)


                }

            }
        }
    }
    fun dayof_week():String{
        var day=Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
var days=""
        when( day){
            1->{days=" Yakshanba"
                    hafta_kun.setBackgroundColor(Color.GREEN)}
            2->{days=" Dushanba"
                hafta_kun.setBackgroundColor(Color.GREEN)}
            3->{days=" Seshanba"

                hafta_kun.setBackgroundColor(Color.GREEN)}
            4->{days=" Chorshanba"

                hafta_kun.setBackgroundColor(Color.GREEN)}
            5->{days=" Payshanba"
                hafta_kun.setBackgroundColor(Color.GREEN)}
            6-> {
                days = " Juma"
                hafta_kun.setBackgroundColor(Color.RED)
            }
            7->{days=" Shanba"
                hafta_kun.setBackgroundColor(Color.GREEN)}
            else->"Buday kun yo'q"
        }
       return days
    }
}


