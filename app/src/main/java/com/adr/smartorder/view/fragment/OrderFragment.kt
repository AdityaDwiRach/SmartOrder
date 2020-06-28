package com.adr.smartorder.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adr.smartorder.R
import com.adr.smartorder.adapter.RVAdapterOrder
import com.adr.smartorder.adapter.RVAdapterProduct
import com.adr.smartorder.model.MockDataChat
import com.adr.smartorder.model.MockDataOrder
import com.adr.smartorder.model.PayloadProdGroupRes

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class OrderFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val rvAdapter by lazy { RVAdapterOrder() }
    private var listData: List<MockDataOrder.MockDataOrder> = ArrayList()
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        listData = MockDataOrder().listDataOrder
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_order, container, false)

        recyclerView = view.findViewById(R.id.rv_order)
        recyclerView.layoutManager = LinearLayoutManager(context)
        rvAdapter.setListData(listData)
        recyclerView.adapter = rvAdapter

        return view
    }
}