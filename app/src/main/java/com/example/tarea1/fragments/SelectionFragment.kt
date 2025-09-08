package com.example.tarea1.fragments

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.tarea1.MainActivity
import com.example.tarea1.R
import com.example.tarea1.UISharedViewModel

class SelectionFragment : Fragment(R.layout.fragment_selection) {

    private val vm: UISharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val cb = view.findViewById<CheckBox>(R.id.cbExtra)
        val rg = view.findViewById<RadioGroup>(R.id.rgTamanio)
        val sw = view.findViewById<Switch>(R.id.swNotificaciones)
        val tv = view.findViewById<TextView>(R.id.tvResumen)

        fun actualizar() {
            val extra = if (cb.isChecked) "con extras" else "sin extras"
            val seleccionadoId = rg.checkedRadioButtonId
            val tamanio = view.findViewById<RadioButton?>(seleccionadoId)?.text ?: "—"
            val notif = if (sw.isChecked) "notificaciones ON" else "notificaciones OFF"
            val resumen = "Resumen: $tamanio, $extra, $notif"
            tv.text = resumen
            // (Opcional) compartir con InfoFragment vía ViewModel:
            // vm.setResumen(resumen)  // si añadiste este campo en el VM
        }

        cb.setOnCheckedChangeListener { _, _ -> actualizar() }
        rg.setOnCheckedChangeListener { _, _ -> actualizar() }
        sw.setOnCheckedChangeListener { _, _ -> actualizar() }
        actualizar()

        // Título en la Toolbar
        (activity as? MainActivity)?.setTitleBar("Selección")
    }
}
