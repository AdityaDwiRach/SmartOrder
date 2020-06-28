package com.adr.smartorder.presenter

import com.adr.smartorder.model.GetProdGroupLsRes
import com.adr.smartorder.model.PayloadProdGroupRes
import com.adr.smartorder.model.api.APIClient
import com.adr.smartorder.model.api.APIInterface
import com.adr.smartorder.presenter.LoginActivityPresenter.Companion.currentToken
import com.adr.smartorder.view.fragment.IProductView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductFragmentPresenter(private val iProductView: IProductView): IProductFragmentPresenter {
    override fun getProductGroupList() {
        val headerGetProdList = HashMap<String, String>()
        headerGetProdList["Key-Signature-Post"] = "4c452e54166049f74db5c591cb78476bfc543b37"
        headerGetProdList["Key-Id"] = "210"
        headerGetProdList["Token"] = currentToken

        APIClient().client().create(APIInterface::class.java)
            .getProdGroupList(headerGetProdList, "getProdGrpList", "1", "10", "")
            .enqueue(object : Callback<GetProdGroupLsRes> {
                override fun onFailure(call: Call<GetProdGroupLsRes>, t: Throwable) {
                    iProductView.onFailedGetList(t.message.toString())
                }

                override fun onResponse(
                    call: Call<GetProdGroupLsRes>,
                    response: Response<GetProdGroupLsRes>
                ) {
                    if (response.isSuccessful){
                        if (response.body() != null) {
                            if (response.body()?.error_code == 0) {
                                if (response.body()?.payload != null) {
                                    iProductView.onSuccessGetList(response.body()?.payload!!)
                                } else {
                                    iProductView.onFailedGetList("Please check your connection.")
                                }
                            } else {
                                iProductView.onFailedGetList("Please check your connection.")
                            }
                        }
                    }
                }

            })
    }

    override fun onSearchFromList(search: String, listData: List<PayloadProdGroupRes>) {
        val searchName = listData.filter { it.product_group_name.contains(search) }
        val searchId = listData.filter { it.product_group_id.contains(search) }

        when {
            searchName.isNullOrEmpty() || searchId.isNotEmpty() -> iProductView.onSuccessSearch(searchId)
            searchId.isNullOrEmpty() || searchName.isNotEmpty() -> iProductView.onSuccessSearch(searchName)
            else -> {
                iProductView.onFailedSearch("Product group name or id not found.")
            }
        }
    }
}