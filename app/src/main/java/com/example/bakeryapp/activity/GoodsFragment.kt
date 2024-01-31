package com.example.bakeryapp.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bakeryapp.databinding.FragmentGoodsBinding

class GoodsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentGoodsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}