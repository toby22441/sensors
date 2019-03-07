package uk.ac.solent.sensors

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SensorEventListener {
    lateinit var accel: Sensor
    lateinit var magField: Sensor
    var accelValue = FloatArray(3)
    var magValue = FloatArray(3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        val sMgr = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        accel = sMgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        sMgr.registerListener ( this, accel, SensorManager.SENSOR_DELAY_UI )

    }

    override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {

    }

    override fun onSensorChanged(ev: SensorEvent) {

        if(ev.sensor == accel) {



            x.setText(ev.values[0].toString())
            y.setText(ev.values[1].toString())
            z.setText(ev.values[2].toString())

            accelValue = ev.values.clone()


        }
        else if(ev.sensor == magField){

            magValue = ev.values.clone()
        }
        SensorManager.getRotationMatrix (orientationMatrix, inclinationMatrix, accelerometerValues, magneticFieldValues)

    }
}