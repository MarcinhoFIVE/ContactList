package br.mdan.contactlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val rvLista: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.rvList)
    }

    private val adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindView()
        updateList()
    }

    private fun bindView() {
        rvLista.adapter = adapter
        rvLista.layoutManager = LinearLayoutManager(this)
    }

    private fun updateList() {
        adapter.updateList(
            arrayListOf(
                Contact(
                    "Marcio",
                    "(00) 00000-0000",
                    "img.png"
                ),
                Contact(
                    "Darlan",
                    "(00) 00000-0000",
                    "img.png"
                )
            )
        )
    }
}