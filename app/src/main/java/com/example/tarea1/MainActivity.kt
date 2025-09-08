package com.example.tarea1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.tarea1.fragments.*
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1) Configurar Toolbar como ActionBar
        val toolbar = findViewById<MaterialToolbar>(R.id.topAppBar)
        setSupportActionBar(toolbar)

        // 2) Navegación inferior
        bottomNav = findViewById(R.id.bottom_nav)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_textfields -> open(TextFieldsFragment())
                R.id.nav_buttons    -> open(ButtonsFragment())
                R.id.nav_selection  -> open(SelectionFragment())
                R.id.nav_list       -> open(ListFragment())
                R.id.nav_info       -> open(InfoFragment())
            }
            true
        }

        // Fragment inicial
        if (savedInstanceState == null) {
            bottomNav.selectedItemId = R.id.nav_textfields
        }
    }

    // Reemplaza el fragment en el contenedor
    private fun open(f: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, f)
            .commit()
    }

    // Navegar programáticamente a Info (ej: desde TextFields)
    fun goToInfo() {
        bottomNav.selectedItemId = R.id.nav_info
    }

    // 3) Helper: cambia el título de la Toolbar desde cualquier fragment
    fun setTitleBar(title: String) {
        supportActionBar?.title = title
    }
}
