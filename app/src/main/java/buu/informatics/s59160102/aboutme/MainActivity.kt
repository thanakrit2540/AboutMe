package buu.informatics.s59160102.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import buu.informatics.s59160102.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }

        binding.nicknameText.setOnClickListener{
            updateNickname(it)
        }
    }

    private  fun updateNickname(view: View){
        binding.apply {
            nicknameEdit.visibility = View.VISIBLE
           nicknameText.visibility = View.GONE




           doneButton.visibility = View.VISIBLE

           nicknameEdit.requestFocus()
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(binding.nicknameEdit,0)
        }

    }
    private fun addNickname(view: View) {

        binding.apply {
            nicknameText.text = nicknameEdit.text
            nicknameEdit.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
            doneButton.visibility = View.GONE

            val inputMetManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMetManager.hideSoftInputFromWindow(view.windowToken,0)
        }





    }
}
