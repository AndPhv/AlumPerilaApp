package com.example.alumperilaapp.ui.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.alumperilaapp.R
import com.example.alumperilaapp.databinding.FragmentAccountBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class AccountFragment : Fragment() {

    private lateinit var binding: FragmentAccountBinding
    private val vm: AccountViewModel by viewModels()
    private lateinit var dialog: BottomSheetDialog
    private lateinit var selectItem: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAccountBinding.inflate(inflater, container, false)

        //нажатие на "Контакты"
        selectItem = binding.root.findViewById(R.id.txtCallAcc)
        selectItem.setOnClickListener{
            showBottomSheet()
        }

        return binding.root
    }

    private fun showBottomSheet() {
        val dialogView = layoutInflater.inflate(R.layout.bottom_sheet_phone, null)
        dialog = BottomSheetDialog(this.requireContext(), R.style.BottomSheetDialogTheme)
        dialog.setContentView(dialogView)
        dialog.show()
    }
}