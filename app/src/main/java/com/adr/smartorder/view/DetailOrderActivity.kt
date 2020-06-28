package com.adr.smartorder.view

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.adr.smartorder.R
import com.adr.smartorder.adapter.RVAdapterOrder.Companion.EXTRA_DETAIL_DATA
import com.adr.smartorder.model.MockDataOrder
import kotlinx.android.synthetic.main.activity_detail_order.*
import kotlinx.android.synthetic.main.alert_dialog_change_status.*

class DetailOrderActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_order)

        if (intent.extras != null) {
            val listData = intent.getParcelableExtra<MockDataOrder.MockDataOrder>(EXTRA_DETAIL_DATA)
            if (listData != null) {
                tv_detail_order_status.text = listData.status
                tv_detail_order_no_invoice.text = listData.noInvoice
                tv_detail_order_date.text = listData.orderDate
                tv_detail_order_total.text =
                    "Total yang harus dibayar\n${listData.totalPrice}\nSegera lakukan pembayaran sebelum\n${listData.orderDate}"
                iv_detail_product.setImageResource(R.drawable.ic_baseline_email)
                tv_detail_order_name.text = listData.nameIdProduct
                tv_detail_order_unit_qty.text = listData.unitQty
                tv_detail_order_price.text = listData.price
                tv_detail_order_note.text = listData.note
                tv_detail_order_total_price.text = listData.totalPrice
                tv_detail_order_note_note.text = listData.note
                tv_detail_order_address.text = listData.address
                tv_detail_order_grand_total.text = listData.grandTotal
            }

        }

        btn_detail_order.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            val dialogView = layoutInflater.inflate(R.layout.alert_dialog_change_status, null)
            dialog.setView(dialogView)
            dialog.setCancelable(true)
            dialog.setTitle("Change Status")
            dialog.create()

            val spinner = dialogView.findViewById<Spinner>(R.id.spin_detail_order)
            ArrayAdapter.createFromResource(
                this,
                R.array.list_status,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner.adapter = adapter
            }

            spinner.onItemSelectedListener = this

            dialog.setPositiveButton("OK")
            { dialogInterface, _ -> dialogInterface.dismiss() }
            dialog.setNegativeButton("Cancel")
            { dialogInterface, _ -> dialogInterface.dismiss() }

            dialog.show()
        }


    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(this, "You haven't choose anything.", Toast.LENGTH_SHORT).show()
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val status = resources.getStringArray(R.array.list_status)
        Toast.makeText(this, status[position], Toast.LENGTH_SHORT).show()
    }
}