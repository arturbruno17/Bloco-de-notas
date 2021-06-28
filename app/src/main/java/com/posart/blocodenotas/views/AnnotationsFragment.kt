package com.posart.blocodenotas.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.posart.blocodenotas.R
import com.posart.blocodenotas.databinding.FragmentAnnotationsBinding

class AnnotationsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentAnnotationsBinding.inflate(layoutInflater)

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_annotationFragment_to_createAnnotationFragment)
        }

        return binding.root

    }

}
