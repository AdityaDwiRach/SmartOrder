package com.adr.smartorder.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.adr.smartorder.R
import com.adr.smartorder.model.MockDataChat
import com.adr.smartorder.model.MockDataOrder
import com.adr.smartorder.view.DetailOrderActivity
import kotlinx.android.synthetic.main.item_chat_fragment.view.*
import kotlinx.android.synthetic.main.item_order_fragment.view.*

class RVAdapterOrder: RecyclerView.Adapter<RVAdapterOrder.ViewHolder>(), IAdapterOrder.IAdapterOrderView, IAdapterOrder.IAdapterOrderModel {

    companion object {
        const val EXTRA_DETAIL_DATA = "extradetaildata"
    }

    private var listData: List<MockDataOrder.MockDataOrder> = ArrayList()
    private var context: Context? = null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val noInvoice: TextView = itemView.tv_item_invoice
        val date: TextView = itemView.tv_item_date
        val nameCust: TextView = itemView.tv_item_name_cust
        val orderVal: TextView = itemView.tv_item_order_value
        val image: ImageView = itemView.iv_item_order
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_order_fragment, parent, false)
        )
    }

    override fun getItemCount(): Int = getSizeData()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bindData = getListData()

        holder.image.setImageResource(R.drawable.ic_baseline_email)
        holder.noInvoice.text = bindData[position].noInvoice
        holder.date.text = bindData[position].orderDate
        holder.nameCust.text = bindData[position].nameIdProduct
        holder.orderVal.text = bindData[position].grandTotal

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailOrderActivity::class.java)
            intent.putExtra(EXTRA_DETAIL_DATA, bindData[position])
            context?.startActivity(intent)
        }
    }

    override fun setListData(listData: List<MockDataOrder.MockDataOrder>) {
        this.listData = listData
    }

    override fun getSizeData(): Int {
        return listData.size
    }

    override fun getListData(): List<MockDataOrder.MockDataOrder> {
        return listData
    }

    override fun refreshData() {
        notifyDataSetChanged()
    }
}