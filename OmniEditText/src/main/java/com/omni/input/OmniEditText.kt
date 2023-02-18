package com.omni.input

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat

class OmniEditText @JvmOverloads constructor(
    context: Context, attrs: AttributeSet?
) : ConstraintLayout(context, attrs) {

    private var omniMaxValue = Int.MIN_VALUE
    private var omniMinValue = Int.MIN_VALUE
    private var errorMessage: String? = null
    private var omniHintText: String? = null
    private var omniTextColor = Int.MIN_VALUE
    private var omniHintColor = Int.MIN_VALUE

    var editText: EditText
    var errorTextView: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.omni_edit_text_layout, this, true)

        editText = findViewById<EditText>(R.id.edit_text)
        errorTextView = findViewById<TextView>(R.id.tv_error)

        attrs?.let {
            val a = context.obtainStyledAttributes(attrs, R.styleable.OmniEditText)
            omniMaxValue = a.getInt(R.styleable.OmniEditText_omniMaxValue, Int.MIN_VALUE)
            omniMinValue = a.getInt(R.styleable.OmniEditText_omniMinValue, Int.MIN_VALUE)
            omniTextColor = a.getInt(R.styleable.OmniEditText_omniTextColor, Int.MIN_VALUE)
            omniHintColor = a.getInt(R.styleable.OmniEditText_omniHintColor, Int.MIN_VALUE)
            omniHintText = a.getString(R.styleable.OmniEditText_omniHintText)
            a.recycle()
        }

        setProperties()

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val input = s.toString().toFloatOrNull()
                if (omniMaxValue > 0 && omniMinValue < 0) {
                    if (input != null && input > omniMaxValue) {
                        errorMessage = String.format(
                            resources.getString(R.string.max_error_message),
                            omniMaxValue
                        )
                        setError(errorMessage.toString())
                    } else {
                        clearError()
                    }
                }
                if (omniMinValue > 0 && omniMaxValue < 0) {
                    if (input != null && input < omniMinValue) {
                        errorMessage = String.format(
                            resources.getString(R.string.min_error_message),
                            omniMinValue
                        )
                        setError(errorMessage.toString())
                    } else {
                        clearError()
                    }
                }
                if (omniMinValue > 0 && omniMaxValue > 0) {
                    Log.d("chjd", "hh")
                    if (input != null && input < omniMinValue) {
                        errorMessage = String.format(
                            resources.getString(R.string.min_error_message),
                            omniMinValue
                        )
                        setError(errorMessage.toString())
                    } else if (input != null && input > omniMaxValue) {
                        errorMessage = String.format(
                            resources.getString(R.string.max_error_message),
                            omniMaxValue
                        )
                        setError(errorMessage.toString())
                    } else {
                        clearError()
                    }
                }
            }
        })
    }

    private fun setProperties() {
        editText.setBackgroundResource(R.drawable.default_background)
        val padding = resources.getDimensionPixelSize(R.dimen._10px)
        editText.setPadding(padding, padding, padding, padding)
        editText.setTextColor(
            when (omniTextColor > 0) {
                true -> omniTextColor
                false -> ContextCompat.getColor(context, R.color.black)
            }
        )
        editText.setHintTextColor(
            when (omniHintColor > 0) {
                true -> omniHintColor
                false -> ContextCompat.getColor(context, R.color.hint_color)
            }
        )

        editText.hint = omniHintText
    }

    private fun setError(errorMessage: String?) {
        errorTextView.text = errorMessage
        editText.setBackgroundResource(R.drawable.error_background)
    }

    private fun clearError() {
        errorTextView.text = null
        editText.setBackgroundResource(R.drawable.default_background)
    }
}