package br.unifor.ads.argbcalculator

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.view.KeyEvent
import android.view.View
import android.widget.*


class MainActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener, View.OnKeyListener, CompoundButton.OnCheckedChangeListener {
    private lateinit var mColorView:View

    private lateinit var mSeekbarAlpha:SeekBar
    private lateinit var mSeekbarRed:SeekBar
    private lateinit var mSeekbarGreen:SeekBar
    private lateinit var mSeekbarBlue:SeekBar

    private lateinit var mEditTextAlpha: EditText
    private lateinit var mEditTextRed: EditText
    private lateinit var mEditTextGreen: EditText
    private lateinit var mEditTextBlue: EditText

    private lateinit var mRadioButtonDec: RadioButton
    private lateinit var mRadioButtonHex: RadioButton
    private lateinit var mTextViewValues: TextView



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mColorView = findViewById(R.id.main_color_view)

        mSeekbarAlpha = findViewById(R.id.main_seekbar_alpha)
        mSeekbarRed = findViewById(R.id.main_seekbar_red)
        mSeekbarGreen = findViewById(R.id.main_seekbar_green)
        mSeekbarBlue = findViewById(R.id.main_seekbar_blue)

        mEditTextAlpha = findViewById(R.id.main_edittext_alpha)
        mEditTextRed = findViewById(R.id.main_edittext_red)
        mEditTextGreen = findViewById(R.id.main_edittext_green)
        mEditTextBlue = findViewById(R.id.main_edittext_blue)

        mRadioButtonDec = findViewById(R.id.radioButtonDec)
        mRadioButtonHex = findViewById(R.id.radioButtonHex)
        mTextViewValues = findViewById(R.id.textViewValue)

        configureWidgets()

    }

    private fun configureWidgets() {

        mColorView.setBackgroundColor(Color.WHITE)

        mSeekbarAlpha.max = 255
        mSeekbarRed.max = 255
        mSeekbarGreen.max = 255
        mSeekbarBlue.max = 255

        mSeekbarAlpha.progress = 0
        mSeekbarRed.progress = 0
        mSeekbarGreen.progress = 0
        mSeekbarBlue.progress = 0

        mEditTextAlpha.setText("0")
        mEditTextRed.setText("0")
        mEditTextGreen.setText("0")
        mEditTextBlue.setText("0")

        mSeekbarAlpha.setOnSeekBarChangeListener(this)
        mSeekbarRed.setOnSeekBarChangeListener(this)
        mSeekbarGreen.setOnSeekBarChangeListener(this)
        mSeekbarBlue.setOnSeekBarChangeListener(this)

        mEditTextAlpha.setOnKeyListener(this)
        mEditTextRed.setOnKeyListener(this)
        mEditTextGreen.setOnKeyListener(this)
        mEditTextBlue.setOnKeyListener(this)

        mRadioButtonDec.setOnCheckedChangeListener(this)
        mRadioButtonHex.setOnCheckedChangeListener(this)

    }

    override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {

        when(seekBar.id){

            R.id.main_seekbar_alpha -> {
                if (this.mRadioButtonDec.isChecked)
                    mEditTextAlpha.setText(seekBar.progress.toString())
                else
                    mEditTextAlpha.setText(Integer.toHexString(seekBar.progress))
            }

            R.id.main_seekbar_red -> {
                if (this.mRadioButtonDec.isChecked)
                    mEditTextRed.setText(seekBar.progress.toString())
                else
                    mEditTextRed.setText(Integer.toHexString(seekBar.progress))
            }

            R.id.main_seekbar_green -> {
                if (this.mRadioButtonDec.isChecked)
                    mEditTextGreen.setText(seekBar.progress.toString())
                else
                    mEditTextGreen.setText(Integer.toHexString(seekBar.progress))
            }

            R.id.main_seekbar_blue -> {
                if (this.mRadioButtonDec.isChecked)
                    mEditTextBlue.setText(seekBar.progress.toString())
                else
                    mEditTextBlue.setText(Integer.toHexString(seekBar.progress))
            }

        }


        updateTextViewValues()
        updateColorView()

    }

    override fun onStartTrackingTouch(seekBar: SeekBar) {

    }

    override fun onStopTrackingTouch(seekBar: SeekBar) {

    }

    override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {

        when(v.id){

            R.id.main_edittext_alpha ->{
                if(event.action == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_ENTER){
                    if (mRadioButtonDec.isChecked){
                        var value = mEditTextAlpha.text.toString().toInt()
                        if( value > 255 ) value = 255
                        mSeekbarAlpha.progress = value
                    }else{
                        var value = Integer.parseInt(mEditTextAlpha.text.toString(), 16)
                        if( value > 255) value = 255
                        mSeekbarBlue.progress = value
                    }

                }
            }

            R.id.main_edittext_red ->{
                if(event.action == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_ENTER){
                    if (mRadioButtonDec.isChecked){
                        var value = mEditTextRed.text.toString().toInt()
                        if( value > 255) value = 255
                        mSeekbarRed.progress = value
                    }else{
                        var value = Integer.parseInt(mEditTextRed.text.toString(), 16)
                        if( value > 255) value = 255
                        mSeekbarRed.progress = value
                    }

                }
            }

            R.id.main_edittext_green ->{
                if(event.action == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_ENTER){
                    if (mRadioButtonDec.isChecked){
                        var value = mEditTextGreen.text.toString().toInt()
                        if( value > 255) value = 255
                        mSeekbarGreen.progress = value
                    }else{
                        var value = Integer.parseInt(mEditTextGreen.text.toString(), 16)
                        if( value > 255) value = 255
                        mSeekbarGreen.progress = value
                    }

                }
            }

            R.id.main_edittext_blue ->{
                if(event.action == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_ENTER){
                    if (mRadioButtonDec.isChecked){
                        var value = mEditTextBlue.text.toString().toInt()
                        if( value > 255) value = 255
                        mSeekbarBlue.progress = value
                    }else{
                        var value = Integer.parseInt(mEditTextBlue.text.toString(), 16)
                        if( value > 255) value = 255
                        mSeekbarBlue.progress = value
                    }

                }
            }

        }

        updateColorView()

        return false
    }

    private fun updateColorView() {
        val color = Color.argb(mSeekbarAlpha.progress, mSeekbarRed.progress, mSeekbarGreen.progress, mSeekbarBlue.progress)
        mColorView.setBackgroundColor(color)
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        val decimal ={
            val inputType = InputType.TYPE_CLASS_NUMBER
            mRadioButtonHex.isChecked = false
            mEditTextAlpha.inputType = inputType
            mEditTextRed.inputType = inputType
            mEditTextGreen.inputType = inputType
            mEditTextBlue.inputType = inputType
        }
        val hexadecimal ={
            val inputType = InputType.TYPE_CLASS_TEXT
            mRadioButtonDec.isChecked = false
            mEditTextAlpha.inputType = inputType
            mEditTextRed.inputType = inputType
            mEditTextGreen.inputType = inputType
            mEditTextBlue.inputType = inputType
        }
        if(isChecked){
            if(buttonView!!.id == R.id.radioButtonDec)decimal() else hexadecimal()

        }else{
            if(buttonView!!.id == R.id.radioButtonDec)hexadecimal() else decimal()
        }

        configureWidgets()
    }

    private fun updateOnChange(){
        var alpha:String = mEditTextAlpha.text.toString()
        var red = mEditTextRed.text.toString()
        var green = mEditTextGreen.text.toString()
        var blue = mEditTextBlue.text.toString()

        if (mRadioButtonDec.isChecked) {
            alpha = alpha.toInt().toString()
            red = red.toInt().toString()
            green = green.toInt().toString()
            blue = blue.toInt().toString()
        }
        else{
            alpha = Integer.toHexString(alpha.toInt())
            red = Integer.toHexString(red.toInt())
            green = Integer.toHexString(green.toInt())
            blue = Integer.toHexString(blue.toInt())
        }

        mEditTextAlpha.setText(alpha)
        mEditTextRed.setText(red)
        mEditTextGreen.setText(green)
        mEditTextBlue.setText(blue)

        //updateTextViewValues()
    }

    private fun updateTextViewValues(){
        mTextViewValues.text = "${mEditTextAlpha.text.toString()}, ${mEditTextRed.text.toString()}, " +
                "${mEditTextGreen.text.toString()}, ${mEditTextBlue.text.toString()}"

    }

}
