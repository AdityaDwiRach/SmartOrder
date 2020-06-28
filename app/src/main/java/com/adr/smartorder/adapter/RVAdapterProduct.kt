package com.adr.smartorder.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.adr.smartorder.R
import com.adr.smartorder.model.PayloadProdGroupRes
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_product_fragment.view.*

class RVAdapterProduct: RecyclerView.Adapter<RVAdapterProduct.ViewHolder>(), IAdapterProductModel, IAdapterProductView {

    private var listData: List<PayloadProdGroupRes> = ArrayList()
    private var context: Context? = null

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.iv_item_product
        val productId: TextView = itemView.item_product_id
        val productName: TextView = itemView.item_product_name
        val productPrize: TextView = itemView.item_product_prize
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_product_fragment, parent, false))
    }

    override fun getItemCount(): Int = getSizeData()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bindData = getListData()

        holder.productId.text = bindData[position].product_group_id
        holder.productName.text = bindData[position].product_group_name
        // Product Price not returned yet from API
//        holder.productPrize.text = bindData[position].

        val imageProduct = holder.image
        if (context != null) {
            Glide.with(context!!).load(bindData[position].images).into(imageProduct)
        }
    }

    override fun setListData(listData: List<PayloadProdGroupRes>) {
        this.listData = listData
    }

    override fun getSizeData(): Int {
        return listData.size
    }

    override fun getListData(): List<PayloadProdGroupRes> {
        return listData
    }

    override fun refreshData() {
        notifyDataSetChanged()
    }
}