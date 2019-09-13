package com.lydone.sharebillandroid

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Single.just(3)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }, {
                Log.e("TAG", it.message, it)
            })

    }


}
