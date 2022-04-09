package com.example.ramazontaqvim

import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_alarm.*
import java.util.*


class Alarm : AppCompatActivity() {

    var timePickerDialog: TimePickerDialog? = null
    var currentHour = 0
    var currentDayofweek=0
    var currentMinute = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)
        supportActionBar?.title="Budilnik"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        btn_time.setOnClickListener(View.OnClickListener { v: View? ->
        val     calendar = Calendar.getInstance()
            currentHour = calendar.get(Calendar.HOUR_OF_DAY)
            currentMinute = calendar.get(Calendar.MINUTE)
            currentDayofweek = calendar.get(Calendar.DAY_OF_YEAR)
            timePickerDialog = TimePickerDialog(
                this,
                { timePicker: TimePicker?, hourDay: Int, minutes: Int ->
                    hour.setText(String.format("%02d", hourDay))
                    minute.setText(String.format("%02d", minutes))

                },
                currentHour,
                currentMinute,
                false
            )
            timePickerDialog!!.show()
        })
        btn_alram.setOnClickListener(View.OnClickListener {
            if (!hour.getText().toString().isEmpty() && !minute.getText().toString().isEmpty()) {
                val intent = Intent(AlarmClock.ACTION_SET_ALARM)
                intent.putExtra(AlarmClock.EXTRA_HOUR, hour.getText().toString().toInt())
                intent.putExtra(AlarmClock.EXTRA_MINUTES, minute.getText().toString().toInt())



                intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Ramazon taqivimi2022")
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this,
                        "There is no app that support this app",
                        Toast.LENGTH_LONG
                    ).show()
                }
            } else {
                Toast.makeText(this, "Iltimos vaqtni kiriting", Toast.LENGTH_LONG).show()
            }
        })
    }


}