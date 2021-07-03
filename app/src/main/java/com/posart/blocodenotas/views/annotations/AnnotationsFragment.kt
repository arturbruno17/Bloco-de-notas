package com.posart.blocodenotas.views.annotations

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.posart.blocodenotas.R
import com.posart.blocodenotas.databinding.FragmentAnnotationsBinding
import com.posart.blocodenotas.model.asModel
import com.posart.blocodenotas.viewmodels.AnnotationsViewModel

class AnnotationsFragment : Fragment() {

    private lateinit var viewModel: AnnotationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentAnnotationsBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this).get(AnnotationsViewModel::class.java)

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_annotationFragment_to_createAnnotationFragment)
        }

        val gridLayoutManager = GridLayoutManager(context, 2)
        binding.recyclerView.layoutManager = gridLayoutManager
        val adapter = AnnotationsAdapter {
            val action = AnnotationsFragmentDirections
                .actionAnnotationFragmentToUpdateAnnotationFragment(it.asModel())
            findNavController().navigate(action)
        }
        binding.recyclerView.adapter = adapter


        viewModel.readAllData.observe(viewLifecycleOwner, {
            it?.let {
                adapter.submitList(it)
            }
        })

        return binding.root

    }

}
