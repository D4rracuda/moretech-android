package com.lydone.sharebillandroid.share_bill

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lydone.sharebillandroid.R
import io.reactivex.subjects.Subject

class BillItemsAdapter(private val itemClickSubject: Subject<Pair<Int, BillItem>>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: MutableList<BillItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ShareBillItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_bill_product, parent, false))
    }

    fun setItems(items: List<BillItem>) {
        this.items = items.toMutableList()
        notifyDataSetChanged()
    }

    fun clickItem(position: Int) {
        items[position].isSelected = !items[position].isSelected
        notifyItemChanged(position)
    }

    fun updateItem(position: Int, item: BillItem) {
        items[position] = item
        notifyItemChanged(position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ShareBillItemViewHolder).bind(position, items[position], itemClickSubject)
    }
}