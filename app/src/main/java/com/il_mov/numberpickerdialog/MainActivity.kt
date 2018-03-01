package com.il_mov.numberpickerdialog

import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_number_picker.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberPicker.maxValue = 10

        val bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN

        showPickerButtonView.setOnClickListener {
            toggleBottomSheet(bottomSheetBehavior)
        }
    }

    private fun toggleBottomSheet(bottomSheetBehavior: BottomSheetBehavior<out View>) {
        if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        } else {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }
    }
}