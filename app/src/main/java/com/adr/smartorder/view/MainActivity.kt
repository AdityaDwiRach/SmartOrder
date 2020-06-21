package com.adr.smartorder.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adr.smartorder.R
import com.adr.smartorder.view.fragment.ChatFragment
import com.adr.smartorder.view.fragment.MainFragment
import com.adr.smartorder.view.fragment.OrderFragment
import com.adr.smartorder.view.fragment.ProductFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.fl_container, MainFragment())
            .commit()

        btm_nav_main.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home_menu -> supportFragmentManager.beginTransaction()
                    .replace(R.id.fl_container, MainFragment()).commit()
                R.id.product_menu -> supportFragmentManager.beginTransaction()
                    .replace(R.id.fl_container, ProductFragment()).commit()
                R.id.order_menu -> supportFragmentManager.beginTransaction()
                    .replace(R.id.fl_container, OrderFragment()).commit()
                R.id.chat_menu -> supportFragmentManager.beginTransaction()
                    .replace(R.id.fl_container, ChatFragment()).commit()
            }
            true
        }
    }
}