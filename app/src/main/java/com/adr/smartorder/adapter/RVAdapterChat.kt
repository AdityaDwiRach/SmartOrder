package com.adr.smartorder.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.adr.smartorder.R
import com.adr.smartorder.model.MockDataChat
import kotlinx.android.synthetic.main.item_chat_fragment.view.*

class RVAdapterChat: RecyclerView.Adapter<RVAdapterChat.ViewHolder>(), IAdapterChatModel, IAdapterChatView {
    private var listData: List<List<MockDataChat.MockDataChat>> = ArrayList()
    private var context: Context? = null

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val chatName: TextView = itemView.item_chat_name
        val chatLastMess: TextView = itemView.item_chat_content
        val chatDate: TextView = itemView.item_chat_date
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_chat_fragment, parent, false))
    }

    override fun getItemCount(): Int = getSizeData()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bindData = getListData()

        holder.chatName.text = bindData[position].last().idFrom
        holder.chatLastMess.text = bindData[position].last().message
        holder.chatDate.text = bindData[position].last().date
    }

    override fun setListData(listData: List<List<MockDataChat.MockDataChat>>) {
        this.listData = listData
    }

    override fun getSizeData(): Int {
        return listData.size
    }

    override fun getListData(): List<List<MockDataChat.MockDataChat>> {
        return listData
    }

    override fun refreshData() {
        notifyDataSetChanged()
    }
}