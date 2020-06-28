package com.adr.smartorder.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adr.smartorder.R
import com.adr.smartorder.adapter.RVAdapterChat
import com.adr.smartorder.adapter.RVAdapterProduct
import com.adr.smartorder.model.MockDataChat
import com.adr.smartorder.model.PayloadProdGroupRes

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ChatFragment : Fragment(), IChatView {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val rvAdapter by lazy { RVAdapterChat() }
    private var listData: List<List<MockDataChat.MockDataChat>> = ArrayList()
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        listData = MockDataChat().listChatData
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_chat, container, false)

        searchView = view.findViewById(R.id.sv_chat)

        recyclerView = view.findViewById(R.id.rv_chat)
        recyclerView.layoutManager = LinearLayoutManager(context)
        rvAdapter.setListData(listData)
        recyclerView.adapter = rvAdapter

        return view
    }

    override fun onSuccessGetList(listData: List<List<MockDataChat.MockDataChat>>) {

    }

    override fun onFailedGetList(error: String) {

    }

    override fun onSuccessSearch(listData: List<List<MockDataChat.MockDataChat>>) {

    }

    override fun onFailedSearch(error: String) {

    }
}