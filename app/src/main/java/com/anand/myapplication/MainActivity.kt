package com.anand.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.anand.myapplication.db.DatabaseCreator
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private val TAG = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recordingDao = DatabaseCreator().getAppDatabase(applicationContext).recordingDao()

        doAsync {
            try {
                val data = recordingDao.getAll()
                if (!data.isNullOrEmpty()) {
                    Log.e(TAG, data.toString())
                }
                textView.text = data?.size.toString()
//                uiThread {
//                    Toast.makeText(it, "data size : ${data?.size}", Toast.LENGTH_SHORT).show()
//                    textView.text = data?.size.toString()
//                }

            } catch (e: Exception) {
                Log.e(TAG, e.message.toString())

            }
        }

        doAsync {
            val recording = Recording(15, "My first recording", 12154545, 6546486464, "mp4", "/sdcard", Recording.Student(1,"Gaurav"))
            recordingDao.insert(recording)
        }

    }

}
