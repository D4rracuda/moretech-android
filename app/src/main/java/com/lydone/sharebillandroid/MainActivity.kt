package com.lydone.sharebillandroid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        NavigationUI.setupWithNavController(navigation, findNavController(R.id.nav_host_fragment))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_options, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar menu items
        when (item.itemId) {
            R.id.action_settings -> {
                Toast.makeText(this, "sth", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.action_share -> {
                Toast.makeText(this, "sth", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.action_exit -> {
                Toast.makeText(this, "sth", Toast.LENGTH_LONG).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.i("complete", "onActivityResult")
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        Log.i("TAG", result.contents)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "Ничего не найдено", Toast.LENGTH_LONG).show()
            } else {
                try {
                    Log.i("TAG", result.contents)
                    Toast.makeText(this, result.contents.toString(), Toast.LENGTH_LONG).show()
                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                    // Data not in the expected format. So, whole object as toast message.
                    Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
