package com.example.tarea1.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tarea1.MainActivity
import com.example.tarea1.R
import com.google.android.material.snackbar.Snackbar

class ButtonsFragment : Fragment(R.layout.fragment_buttons) {

    private var toggled = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val btnToast = view.findViewById<Button>(R.id.btnToast)
        val btnImage = view.findViewById<ImageButton>(R.id.btnImage)
        val fab = view.findViewById<com.google.android.material.floatingactionbutton.FloatingActionButton>(R.id.fab)

        btnToast.setOnClickListener {
            Toast.makeText(requireContext(), getString(R.string.app_name) + ": Hola desde un Button", Toast.LENGTH_SHORT).show()
        }

        btnImage.setOnClickListener {
            toggled = !toggled
            Toast.makeText(requireContext(), if (toggled) "Activado" else "Desactivado", Toast.LENGTH_SHORT).show()
        }

        fab.setOnClickListener {
            Snackbar.make(view, "Acción rápida con FAB", Snackbar.LENGTH_SHORT).show()
        }

        // Título en la Toolbar
        (activity as? MainActivity)?.setTitleBar("Botones")
    }
}
