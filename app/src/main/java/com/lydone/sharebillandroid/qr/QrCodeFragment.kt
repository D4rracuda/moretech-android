package com.lydone.sharebillandroid.qr

import android.os.Bundle
import android.view.View
import androidx.navigation.ui.NavigationUI
import com.google.zxing.integration.android.IntentIntegrator
import com.lydone.sharebillandroid.R
import com.lydone.sharebillandroid.architecture.fragments.FragmentWithViewModelAndNavController
import kotlinx.android.synthetic.main.fragment_qr.*

class QrCodeFragment : FragmentWithViewModelAndNavController<QrCodeViewModel>() {
    override val viewModelClass: Class<QrCodeViewModel> = QrCodeViewModel::class.java
    override val layout: Int = R.layout.fragment_qr
    private var qrScanIntegrator: IntentIntegrator? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        NavigationUI.setupWithNavController(toolbar_qr, navController)

        qrScanIntegrator = IntentIntegrator(activity)
        qrScanIntegrator?.setOrientationLocked(true)
        qrScanIntegrator?.setPrompt("сканируйте qr код")
        qrScanIntegrator?.setCameraId(0)  // Use a specific camera of the device
        qrScanIntegrator?.setBeepEnabled(false)
        qrScanIntegrator?.setBarcodeImageEnabled(true)

        btnScan.setOnClickListener {
            qrScanIntegrator?.initiateScan()
        }
    }

}