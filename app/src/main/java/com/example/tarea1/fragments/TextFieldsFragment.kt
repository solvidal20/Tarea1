package com.example.tarea1.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.tarea1.MainActivity
import com.example.tarea1.R
import com.example.tarea1.UISharedViewModel

class TextFieldsFragment : Fragment(R.layout.fragment_textfields) {

    private val vm: UISharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val et = view.findViewById<EditText>(R.id.etNombre)
        val btn = view.findViewById<Button>(R.id.btnGuardar)

        btn.setOnClickListener {
            val texto = et.text.toString().trim()
            vm.setTextoUsuario(texto)
            Toast.makeText(requireContext(), "Guardado: $texto", Toast.LENGTH_SHORT).show()
            (activity as? MainActivity)?.goToInfo()
        }

        // Título de la Toolbar
        (activity as? MainActivity)?.setTitleBar("TextFields (EditText)")
    }
}
