package com.lydone.sharebillandroid.awards

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.ui.NavigationUI
import com.lydone.sharebillandroid.R
import com.lydone.sharebillandroid.architecture.fragments.FragmentWithViewModelAndNavController
import kotlinx.android.synthetic.main.fragment_awards.*

class AwardsFragment : FragmentWithViewModelAndNavController<AwardsViewModel>() {
    override val viewModelClass: Class<AwardsViewModel> = AwardsViewModel::class.java
    override val layout: Int = R.layout.fragment_awards

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        NavigationUI.setupWithNavController(toolbar_awards, navController)
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
            navController.navigate(R.id.action_awardsFragment_to_qrFragment)
        }

        builder?.setNegativeButton("назад") { dialog, which ->
            Toast.makeText(
                getContext(),
                "назад", Toast.LENGTH_SHORT
            ).show()
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