package com.utn.myapplication.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.utn.myapplication.R

class CompanyDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = CompanyDetailsFragment()
    }

    private lateinit var viewModel: CompanyDetailsViewModel
    private val args: CompanyDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_company_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("CompanyDetailsFragment", "Company: ${args.company.name}")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CompanyDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
