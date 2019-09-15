package com.lydone.sharebillandroid.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.ui.NavigationUI
import com.lydone.sharebillandroid.R
import com.lydone.sharebillandroid.architecture.fragments.FragmentWithViewModelAndNavController
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : FragmentWithViewModelAndNavController<MainViewModel>() {
    override val viewModelClass: Class<MainViewModel> = MainViewModel::class.java
    override val layout: Int = com.lydone.sharebillandroid.R.layout.fragment_main
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        NavigationUI.setupWithNavController(toolbar_main, navController)
        fab3.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        lateinit var dialog: AlertDialog
        val array = arrayOf("Русалочка", "Барракуда", "Мыльница", "Ремесло")
        val builder = context?.let { AlertDialog.Builder(it) }
        builder?.setTitle("Создать группу")

        builder?.setPositiveButton("окей") { dialog, which ->
            navController.navigate(R.id.action_mainFragment_to_qrFragment)
        }

        builder?.setNegativeButton("назад") { dialog, which ->
        }

        builder?.setSingleChoiceItems(array, -1) { _, which ->
            val groupName = array[which]
            try {
                //nothing
            } catch (e: IllegalArgumentException) {
                Toast.makeText(context, "$groupName cannot be selected.", Toast.LENGTH_LONG).show()
            }
        }

        if (builder != null) {
            dialog = builder.create()
        }

        dialog.show()
    }
}