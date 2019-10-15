package br.com.fabio.puppy

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

open class DebugActivity : AppCompatActivity() {

    private val TAG = "Puppy"
    private val className: String
        get() {
            val s = javaClass.name
            return  s.substring(s.lastIndexOf("."))
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "$className.onCreate()")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "$className.onStart()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"$className.onRestart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "$className.onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "$className.onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "$className.onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "$className.onDestroy()")
    }



}
