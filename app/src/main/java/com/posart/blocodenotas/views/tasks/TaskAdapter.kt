package com.posart.blocodenotas.views.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.posart.blocodenotas.database.entities.Task
import com.posart.blocodenotas.databinding.TasksBinding

class TaskAdapter(
    private val onClickCheckBox: (Task, Boolean) -> Unit,
    private val onClickDelete: (Task) -> Unit
) : ListAdapter<Task, TaskAdapter.ViewHolder>(TaskItemCallBack()) {

    class ViewHolder private constructor(
        private val binding: TasksBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            item: Task,
            onClickCheckBox: (Task, Boolean) -> Unit,
            onClickDelete: (Task) -> Unit
        ) {
            binding.checkbox.isChecked = item.concluded
            binding.nameTask.text = item.name
            binding.checkbox.setOnCheckedChangeListener { _, isChecked ->
                onClickCheckBox(item, isChecked)
            }
            binding.imageButton.setOnClickListener {
                onClickDelete(item)
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = TasksBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), onClickCheckBox, onClickDelete)
    }

}

class TaskItemCallBack : DiffUtil.ItemCallback<Task>() {
    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem == newItem
    }

}