package com.lydone.sharebillandroid.share_bill

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.lydone.sharebillandroid.R
import com.lydone.sharebillandroid.architecture.fragments.FragmentWithViewModelAndNavController
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_share_bill.*

class ShareBillFragment : FragmentWithViewModelAndNavController<ShareBillViewModel>() {
    override val viewModelClass: Class<ShareBillViewModel> = ShareBillViewModel::class.java
    override val layout: Int = R.layout.fragment_share_bill
    private val itemClickSubject = PublishSubject.create<Pair<Int, BillItem>>()
    private val adapter = BillItemsAdapter(itemClickSubject)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.messageLiveData.observe(this, Observer {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        })
        //TODO remove

        val json = "{\n" +
                "  \"internal_id\": \"1293871047192\",\n" +
                "  \"organisation_name\": \"More.Tech.Rest\",\n" +
                "  \"organisation_tax_id\": \"776541173482\",\n" +
                "  \"items\": [\n" +
                "    {\"title\":\"Салат Цезарь с курицей\", \"quanity\":2, \"price\":430, \"description\": \"Caesar salad\"}\n" +
                "    ,{\"title\":\"Салат Греческий\", \"quanity\":1, \"price\":550, \"description\":\"Greek salad\"}\n" +
                "    ,{\"title\":\"Паста Карбонара\", \"quanity\":1, \"price\":2000, \"description\": \"Pasta alla carbonara\"}\n" +
                "    ,{\"title\":\"Рибай Стейк\", \"quanity\":1, \"price\":1100, \"description\": \"Rib-eye Steaks\"}\n" +
                "    ,{\"title\":\"Вино Chianti Classico\", \"quanity\":2, \"price\":1500, \"description\": \"Chianti Classico Riserva\"}\n" +
                "    ,{\"title\":\"Вода Borjomi\", \"quanity\":1, \"price\":250, \"description\": \"Borjomi\"}\n" +
                "    ,{\"title\":\"Торт Наполеон\", \"quanity\":3, \"price\":1260, \"description\": \"Mille-feuille\"}\n" +
                "    ,{\"title\":\"Каппучино\", \"quanity\":2, \"price\":700, \"description\": \"Cappuccino\"}\n" +
                "    ,{\"title\":\"Чай Лорд Грей\", \"quanity\":1, \"price\":400, \"description\": \"Earl Grey\"}\n" +
                "  ],\n" +
                "  \"datetime\": \"2018-18-03T18:18:18.181\"\n" +
                "}"

        adapter.setItems(Gson().fromJson(json, Bill::class.java).items)
        initRecycler()
    }

    private fun initRecycler() {
        items_recycler.adapter = adapter
        items_recycler.layoutManager = LinearLayoutManager(context)
        items_recycler.setHasFixedSize(true)

        itemClickSubject.subscribe {
            adapter.clickItem(it.first)
        }.disposeOnDestroyView()
    }
}