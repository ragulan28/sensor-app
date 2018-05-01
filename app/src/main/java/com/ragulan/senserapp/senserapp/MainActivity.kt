package com.ragulan.senserapp.senserapp

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

class MainActivity : AppCompatActivity() , SensorEventListener {
    var sensor: Sensor? = null
    var sensorManager: SensorManager? = null

    override fun onAccuracyChanged(sensor: Sensor? , accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event != null) {
            if (event.values[0]>10){
                Toast.makeText(this,"Light On",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this,"App Started",Toast.LENGTH_SHORT).show()
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager!!.getDefaultSensor(Sensor.TYPE_LIGHT)
    }

    override fun onResume() {
        super.onResume()
        sensorManager!!.registerListener(this , sensor , SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager!!.unregisterListener(this)
    }
}
