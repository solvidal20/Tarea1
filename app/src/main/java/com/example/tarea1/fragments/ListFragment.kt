package com.example.tarea1.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tarea1.MainActivity
import com.example.tarea1.R
import com.example.tarea1.list.SimpleAdapter

class ListFragment : Fragment(R.layout.fragment_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val rv = view.findViewById<RecyclerView>(R.id.rv)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.setHasFixedSize(false)
        rv.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))

        val elementos = listOf(
            "TextView", "ImageView", "Button", "EditText",
            "Switch", "CheckBox", "RadioButton", "ProgressBar",
            "ImageButton", "SeekBar", "RatingBar", "Toolbar",
            "AutoCompleteTextView", "Spinner", "CalendarView", "DatePicker"
        )

        rv.adapter = SimpleAdapter(elementos) { item ->
            Toast.makeText(requireContext(), "Click: $item", Toast.LENGTH_SHORT).show()
        }

        // Título en la Toolbar
        (activity as? MainActivity)?.setTitleBar("Lista")
    }
}
