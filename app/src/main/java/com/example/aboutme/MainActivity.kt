package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var myName = MyName("Richie Oscar")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding  = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
//        findViewById<Button>(R.id.done_button).setOnClickListener {
//            displayNickname(it)
//        }

        binding.doneButton.setOnClickListener{
            displayNickname(it)
        }


    }

    private fun displayNickname(view: View?) {
//        val text: TextView = findViewById(R.id.nick_text)
//        val edit: EditText = findViewById(R.id.edit_nick)
        binding.apply {

            nickText.visibility = View.INVISIBLE
            invalidateAll()
            nickText.text = binding.editNick.text.toString()
            myName?.nickName = nickText.text.toString()
            nickText.visibility = View.VISIBLE
            editNick.text.clear()
            editNick.visibility = View.GONE
            doneButton.visibility = View.GONE
        }

        // hidekeyboard
        val keyBoard = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (view != null) {
            keyBoard.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
   }