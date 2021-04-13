package com.example.chalenge3_thom.page3Fragment

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.chalenge3_thom.menu.MenuActivity
import com.example.chalenge3_thom.R


class Page3Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_page3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editText = view.findViewById<EditText>(R.id.et1)
        val nextBtn = view.findViewById<ImageView>(R.id.next)



        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.isNotEmpty() == true) {
                    nextBtn.visibility = View.VISIBLE
                } else {
                    nextBtn.visibility = View.GONE
                }
            }
            // fun afterTextChange(s: Editable?) {}
        })

        nextBtn.setOnClickListener {

            val namaPemain = editText.text.toString()
            val intent: Intent = Intent(activity, MenuActivity::class.java)
            intent.putExtra("name", namaPemain)
            activity!!.startActivity(intent)
        }
    }
}







