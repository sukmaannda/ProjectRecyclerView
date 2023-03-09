package com.example.loginrecyclerview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivityRecyclerView : AppCompatActivity() {
    private lateinit var rvProduct : RecyclerView
    private var list: ArrayList<Product> = arrayListOf()
    private fun showSelectedProduct(product: Product) {
        Toast.makeText(this, "Kamu memilih " + product.name, Toast.LENGTH_SHORT).show()
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_product)
        setActionBarTitle(title)


        rvProduct = findViewById(R.id.rv_product)
        rvProduct.setHasFixedSize(true)

        list.addAll(ProductData.listData)
        showRecyclerCardView()

    }

    private fun showRecyclerGrid() {
        rvProduct.layoutManager = GridLayoutManager(this, 2)
        val gridProductAdapter = GridProductAdapter(list)
        rvProduct.adapter = gridProductAdapter

        gridProductAdapter.setOnItemClickCallback(object :GridProductAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Product) {
                showSelectedProduct(data)
            }
        })
    }
    private fun showRecyclerCardView() {
        rvProduct.layoutManager = LinearLayoutManager(this)
        val cardViewProductAdapter = CardViewProductAdapter(list)
        rvProduct.adapter = cardViewProductAdapter
    }
    private fun setActionBarTitle(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_grid -> {
                title = "Mode Grid"
                showRecyclerGrid()
            }

            R.id.action_cardview -> {
                title = "Mode CardView"
                showRecyclerCardView()
            }
        }
    }
    private var title: String = "THE RECALM"
}

