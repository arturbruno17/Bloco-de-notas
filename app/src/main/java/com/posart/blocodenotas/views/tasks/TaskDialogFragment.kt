package com.posart.blocodenotas.views.tasks

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.posart.blocodenotas.R
import com.posart.blocodenotas.database.entities.Task
import com.posart.blocodenotas.viewmodels.TaskViewModel

class TaskDialogFragment : DialogFragment() {

    private lateinit var nameTask: TextInputEditText
    private lateinit var viewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(TaskViewModel::class.java)

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.task_input_dialog, null)
        nameTask = view.findViewById(R.id.text_field_name_task)
        builder.setTitle(getString(R.string.create_task))
            .setView(view)
            .setPositiveButton(R.string.create_dialog_text) { _, _ ->
                if(nameTask.text!!.isNotBlank()) {
                    viewModel.insertTask(Task(0, nameTask.text.toString(), false))
                }
            }
            .setNegativeButton(getString(R.string.cancel_dialog_text)) { dialogInterface, _ ->
                dialogInterface.cancel()
            }


        return builder.create()
    }

}