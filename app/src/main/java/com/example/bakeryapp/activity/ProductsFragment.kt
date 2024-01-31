package com.example.bakeryapp.activity

import android.app.ActionBar.LayoutParams
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableRow
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.bakeryapp.databinding.FragmentProductsBinding
import com.example.bakeryapp.dto.Product
import com.example.bakeryapp.repository.ProductsRepositoryImpl

class ProductsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentProductsBinding.inflate(layoutInflater, container, false)

        var products = emptyList<Product>()

        try {
            products = ProductsRepositoryImpl().getAllProducts()
            println("продукты: $products")
        } catch (e: Exception) {
            println("загрузка не удалась")
        }

        // таблица из layout по id
        val table = binding.tableOfProducts

        // перевод dp (16) в px для установки свойства padding в таблице
        val scale = getResources().getDisplayMetrics().density;
        val padding16 = (16 * scale + 0.5f).toInt()
        val padding2 = (2 * scale + 0.5f).toInt()

        // параметры текста (колонок), initWeight - соотношение на экране
        val param1 =
            TableRow.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 0.6f)
        val param2 = TableRow.LayoutParams(
            LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT,
            0.4f
        )

        // заполнение таблицы
        for (product in products) {
            // создание ряда
            val tableRow = TableRow(context)
            table.addView(tableRow)

            // создание двух текстовых столбцов
            //val id = TextView(context)
            val name = TextView(context)
            val price = TextView(context)

            // наполнение значениями из БД
            //id.setText(product.id)
            name.setText(product.productName)
            price.setText(product.price.toString())

            // установка параметров TextView
            name.setLayoutParams(param1)
            name.setPadding (padding16, padding2, padding16, padding2)
            price.setLayoutParams(param2)
            price.setPadding (0, padding2, padding16, padding2)

            // добавление TextView в ряд
            //tableRow.addView(id)
            tableRow.addView(name)
            tableRow.addView(price)
        }


//        val viewModel: ProductViewModel by activityViewModels()
//
//        viewModel.data.observe(viewLifecycleOwner) { state ->
//            state.products
//            binding.progress.isVisible = state.loading
//            binding.errorGroup.isVisible = state.error
//            binding.emptyText.isVisible = state.empty
//        }

        return binding.root
    }
}