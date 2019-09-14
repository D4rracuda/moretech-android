package com.lydone.sharebillandroid.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.ui.NavigationUI
import com.lydone.sharebillandroid.architecture.fragments.FragmentWithViewModelAndNavController
import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : FragmentWithViewModelAndNavController<MainViewModel>() {
    override val viewModelClass: Class<MainViewModel> = MainViewModel::class.java
    override val layout: Int = com.lydone.sharebillandroid.R.layout.fragment_main
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        NavigationUI.setupWithNavController(toolbar_main, navController)
        fab.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        lateinit var dialog: AlertDialog
        val array = arrayOf("Русалочка", "Барракуда", "Мыльница", "Ремесло")
        val builder = context?.let { AlertDialog.Builder(it) }
        builder?.setTitle("Создать группу")

        builder?.setPositiveButton(android.R.string.no) { dialog, which ->
            Toast.makeText(
                getContext(),
                "окей", Toast.LENGTH_SHORT
            ).show()
        }

        builder?.setNegativeButton(android.R.string.no) { dialog, which ->
            Toast.makeText(
                getContext(),
                "назад", Toast.LENGTH_SHORT
            ).show()
        }

        builder?.setSingleChoiceItems(array, -1) { _, which ->
            val groupName = array[which]
            try {
                Toast.makeText(context, "$groupName color selected.", Toast.LENGTH_LONG).show()
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