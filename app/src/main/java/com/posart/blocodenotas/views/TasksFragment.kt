package com.posart.blocodenotas.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.posart.blocodenotas.databinding.FragmentTasksBinding


class TasksFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTasksBinding.inflate(layoutInflater)

        return binding.root
    }
}