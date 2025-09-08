package com.example.tarea1.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.tarea1.MainActivity
import com.example.tarea1.R
import com.example.tarea1.UISharedViewModel

class InfoFragment : Fragment(R.layout.fragment_info) {

    private val vm: UISharedViewModel by activityViewModels()
    private val handler = Handler(Looper.getMainLooper())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tv = view.findViewById<TextView>(R.id.tvNombre)
        val pb = view.findViewById<ProgressBar>(R.id.pb)
        val btn = view.findViewById<Button>(R.id.btnCargar)

        vm.textoUsuario.observe(viewLifecycleOwner) { s ->
            tv.text = "Nombre: ${if (s.isNullOrBlank()) "(vacío)" else s}"
        }

        vm.cargando.observe(viewLifecycleOwner) { c ->
            pb.visibility = if (c) View.VISIBLE else View.GONE
        }

        btn.setOnClickListener {
            vm.setCargando(true)
            handler.postDelayed({ vm.setCargando(false) }, 3000)
        }

        // Si añadiste vm.resumen en el ViewModel, puedes observarlo aquí:
        // val tvResumenInfo = view.findViewById<TextView>(R.id.tvResumenInfo)
        // vm.resumen.observe(viewLifecycleOwner) { tvResumenInfo.text = it }

        // Título en la Toolbar
        (activity as? MainActivity)?.setTitleBar("Información")
    }
}
