package com.il_mov.numberpickerdialog

import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_number_picker.*

class MainActivity : AppCompatActivity(), NumberPickerDialogListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberPicker.maxValue = 10

        bottom_sheet.numberPickerDialogListener = this
        val bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        bottomSheetBehavior.isHideable

        showPickerButtonView.setOnClickListener {
            toggleBottomSheet(bottomSheetBehavior)
        }
    }

    override fun onCancelClicked() {
        toggleBottomSheet(BottomSheetBehavior.from(bottom_sheet))
    }

    override fun onDoneClicked(numberPicked: Int) {
        toggleBottomSheet(BottomSheetBehavior.from(bottom_sheet))

        showPickerButtonView.text = "$numberPicked шт."
    }

    private fun toggleBottomSheet(bottomSheetBehavior: BottomSheetBehavior<out View>) {
        if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        } else {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
    }
}