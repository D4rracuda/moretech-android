package com.lydone.sharebillandroid.share_bill

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lydone.sharebillandroid.R
import io.reactivex.subjects.Subject
import kotlinx.android.synthetic.main.item_bill_product.view.*

class ShareBillItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(itemPosition: Int, billItem: BillItem, subject: Subject<Pair<Int, BillItem>>) {
        itemView.title.text = billItem.title
        itemView.subtitle.text = billItem.description
        itemView.amount.text = billItem.price.toString() + " \u20BD"
        if (billItem.isSelected) {
            itemView.check_bill_item.setBackgroundResource(R.drawable.ic_done)
        } else {
            itemView.check_bill_item.setBackgroundResource(R.drawable.ic_ellipse)
        }
        itemView.setOnClickListener {
            subject.onNext(itemPosition to billItem)
        }
    }
}