package br.mdan.contactlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val rvLista: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.rvList)
    }

    private val adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_menu)

        initDrawer()
        bindView()
        updateList()
    }

    private fun initDrawer() {
        val drawerLayout = findViewById<View>(R.id.drawLayout) as DrawerLayout
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
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

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.item_menu_1 -> {
                showToast("Item Menu 1")
                true
            }
            R.id.item_menu_2 -> {
                showToast("Item Menu 1")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}