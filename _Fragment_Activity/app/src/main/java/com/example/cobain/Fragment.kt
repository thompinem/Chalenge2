package com.example.cobain

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


class FragmentMario : Fragment() {

private lateinit var btn : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn = view.findViewById(R.id.btn)
        btn.setOnClickListener {
            val intent = Intent(activity, ActivityDau::class.java)
            intent.putExtra("Name", "Mario")
            activity!!.startActivity(intent)
        }
    }
}
