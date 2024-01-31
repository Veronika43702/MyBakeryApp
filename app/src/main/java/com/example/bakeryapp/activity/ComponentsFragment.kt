package com.example.bakeryapp.activity

import android.app.ActionBar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableRow
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.bakeryapp.databinding.FragmentComponentsBinding
import com.example.bakeryapp.dto.Component
import com.example.bakeryapp.repository.ComponentRepositoryImpl

class ComponentsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentComponentsBinding.inflate(layoutInflater, container, false)

        var components = emptyList<Component>()

        try {
            components = ComponentRepositoryImpl().getAllComponents()
            println("комноненты: $components")
        } catch (e: Exception) {
            println("загрузка не удалась")
        }

        // таблица из layout по id
        val table = binding.tableOfComponents

        // перевод dp (16) в px для установки свойства padding в таблице
        val scale = getResources().getDisplayMetrics().density;
        val padding16 = (16 * scale + 0.5f).toInt()
        val padding2 = (2 * scale + 0.5f).toInt()

        // параметры текста (колонок), initWeight - соотношение на экране
        val param1 = TableRow.LayoutParams(
            0,
            ActionBar.LayoutParams.WRAP_CONTENT,
            1.0f
        )
        val param2 = TableRow.LayoutParams(
            0,
            ActionBar.LayoutParams.WRAP_CONTENT,
            0.5f
        )

        val param3 = TableRow.LayoutParams(
            0,
            ActionBar.LayoutParams.WRAP_CONTENT,
            0.3f
        )

        // заполнение таблицы
        for (component in components) {
            // создание ряда
            val tableRow = TableRow(context)
            table.addView(tableRow)

            // создание двух текстовых столбцов
            val name = TextView(context)
            val type = TextView(context)
            val weight = TextView(context)
            val price = TextView(context)

            // наполнение значениями из БД
            name.setText(component.name)
            type.setText(component.type)
            weight.setText(String.format("%,.1f", component.weight))
            price.setText(String.format("%,.1f", component.price))

            // установка параметров TextView
            name.setLayoutParams(param1)
            name.setPadding (padding16, padding2, padding16, padding2)
            type.setLayoutParams(param2)
            type.setPadding (0, padding2, padding16, padding2)
            weight.setLayoutParams(param3)
            weight.setPadding (0, padding2, padding16, padding2)
            price.setLayoutParams(param3)
            price.setPadding (0, padding2, padding16, padding2)

            // добавление TextView в ряд
            //tableRow.addView(id)
            tableRow.addView(name)
            tableRow.addView(type)
            tableRow.addView(weight)
            tableRow.addView(price)
        }

        return binding.root
    }
}