package com.pardeep.list_and_spiner_assignment

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.pardeep.list_and_spiner_assignment.databinding.FragmentItemBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ItemFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ItemFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var binding : FragmentItemBinding? = null
    var item = arrayListOf<MyData>()
    var recyclerAdapter = MyAdapter(item)

    //to show data on screen use linear layout manager
    lateinit var linearLayoutManager: LinearLayoutManager



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentItemBinding.inflate(layoutInflater)
        return binding?.root

       // return inflater.inflate(R.layout.fragment_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        linearLayoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding?.ListView?.layoutManager = linearLayoutManager




        binding?.fab?.setOnClickListener {
            Dialog(requireContext()).apply {

                setContentView(R.layout.add_item)

                window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )

                val new_item_name = findViewById<EditText>(R.id.ItemName)
                val new_item_qty = findViewById<EditText>(R.id.Qty)
                val add_button = findViewById<Button>(R.id.addButton)

                add_button.setOnClickListener {
                    if (new_item_name.text.trim().isNullOrEmpty()) {
                        new_item_name.error = "please enter the item name"
                    } else if (new_item_qty.text.trim().isNullOrEmpty()) {
                        new_item_qty.error = "please enter the qty"
                    } else {
                        var new_name = new_item_name.text.toString()
                        val new_qty =new_item_qty.text
                        addData(new_name,new_qty)
                        item.add(MyData(item_name = new_item_name.toString(), 2))
                    }
                }

            }.show()
        }

        item.add(MyData("Burger",40))
        item.add(MyData("Pizza",20))
        item.add(MyData("Salad",10))


        binding?.ListView?.adapter = recyclerAdapter






        }

    private fun addData(newName: String, newQty: Int) {
        item.add(MyData(newName,newQty))

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ItemFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ItemFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}