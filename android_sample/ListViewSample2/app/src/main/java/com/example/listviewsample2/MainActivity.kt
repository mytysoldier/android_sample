package com.example.listviewsample2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lvMenu = findViewById<ListView>(R.id.lvMenu)

        var menuList = mutableListOf("唐揚げ定食１","唐揚げ定食２","唐揚げ定食３","唐揚げ定食４","唐揚げ定食５","唐揚げ定食６","唐揚げ定食７","唐揚げ定食８","唐揚げ定食９","唐揚げ定食１０")

        val adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_list_item_activated_1, menuList)

        lvMenu.adapter = adapter

        lvMenu.onItemClickListener = ListItemCllickListener()

    }

    private inner class ListItemCllickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val dialogFragment = OrderConfirmDialogFragment()

            dialogFragment.show(supportFragmentManager, "OrderConfirmDialogFragment")
        }
    }
}