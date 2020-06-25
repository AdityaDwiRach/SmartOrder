package com.adr.smartorder.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adr.smartorder.R
import com.adr.smartorder.adapter.RVAdapterProduct
import com.adr.smartorder.model.PayloadProdGroupRes
import com.adr.smartorder.presenter.ProductFragmentPresenter

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ProductFragment : Fragment(), IProductView {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val presenter by lazy { ProductFragmentPresenter(this) }
    private val rvAdapter by lazy { RVAdapterProduct() }
    private var listData: List<PayloadProdGroupRes> = ArrayList()
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_product, container, false)

        searchView = view.findViewById(R.id.sv_product)

        recyclerView = view.findViewById(R.id.rv_product)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = rvAdapter

        presenter.getProductGroupList()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                if (query.isNotEmpty()) {
                    presenter.onSearchFromList(query, listData)
                }
                searchView.setQuery("", false)
                searchView.clearFocus()
                return false
            }
        })
    }

    override fun onSuccessGetList(listData: List<PayloadProdGroupRes>) {
        this.listData = listData
        rvAdapter.setListData(listData)
        rvAdapter.refreshData()
    }

    override fun onFailedGetList(error: String) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }

    override fun onSuccessSearch(listData: List<PayloadProdGroupRes>) {
        rvAdapter.setListData(listData)
        rvAdapter.refreshData()
    }

    override fun onFailedSearch(error: String) {
        //TODO this fun not run properly (Toast not showed up)
        val emptyList: List<PayloadProdGroupRes> = ArrayList()
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
        rvAdapter.setListData(emptyList)
        rvAdapter.refreshData()
    }
}