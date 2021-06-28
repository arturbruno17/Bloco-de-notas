package com.posart.blocodenotas.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.posart.blocodenotas.databinding.FragmentCreateAnnotationBinding

class CreateAnnotationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCreateAnnotationBinding.inflate(layoutInflater)

        return binding.root
    }

}