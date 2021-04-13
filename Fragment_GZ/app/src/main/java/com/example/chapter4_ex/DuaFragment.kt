package com.example.chapter4_ex

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class DuaFragment : Fragment() {

    private var txt: TextView? = null
    private var button: Button? = null
    private var edt: EditText? = null
    private var listener: CallBackFragment2? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dua, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txt = view.findViewById<TextView>(R.id.msg)
        edt = view.findViewById<EditText>(R.id.etChat)
        button = view.findViewById<Button>(R.id.btnKirimPesan)
        button?.setOnClickListener {
            val message = "kedua : ${edt?.text.toString()}"
            edt?.setText("")
            txt?.text = txt?.text?.toString().plus("\n" + message)
            listener?.messageDariFragment2(message)
        }
    }

    fun showMessageDariFragment1(msg: String) {
        val lastMessage = txt?.text?.toString()
        txt?.text = lastMessage.plus("\n" + msg)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as CallBackFragment2
        } catch (e: Exception) {
            Log.d("Dua Fragment", "Gak terhubung Broo!!! sama Activity")
            e.printStackTrace()
        }
    }

}
