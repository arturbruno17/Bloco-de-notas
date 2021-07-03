package com.posart.blocodenotas.views.tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.posart.blocodenotas.database.entities.Task
import com.posart.blocodenotas.databinding.FragmentTasksBinding
import com.posart.blocodenotas.viewmodels.TaskViewModel


class TasksFragment : Fragment() {

    private lateinit var viewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTasksBinding.inflate(layoutInflater)

        viewModel = ViewModelProvider(this).get(TaskViewModel::class.java)

        binding.fabTask.setOnClickListener {
            val dialogFragment = TaskDialogFragment()
            dialogFragment.show(requireActivity().supportFragmentManager, "create_task_dialog")
        }

        val adapter = TaskAdapter(::onClickCheckBox, ::onClickDelete)
        val layoutManager = LinearLayoutManager(context)
        binding.taskList.adapter = adapter
        binding.taskList.layoutManager = layoutManager

        viewModel.readAllData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        return binding.root
    }

    private fun onClickCheckBox(task: Task, isChecked: Boolean) {
        viewModel.updateTask(Task(task.id, task.name, isChecked))
    }

    private fun onClickDelete(task: Task) {
        viewModel.deleteTask(task)
    }
}
