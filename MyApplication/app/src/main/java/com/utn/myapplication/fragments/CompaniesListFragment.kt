package com.utn.myapplication.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.utn.myapplication.R
import com.utn.myapplication.adapters.CompaniesAdapter
import com.utn.myapplication.models.Company

class CompaniesListFragment : Fragment() {

    companion object {
        fun newInstance() = CompaniesListFragment()
    }

    private var companiesList: MutableList<Company> = mutableListOf()

    private lateinit var v: View
    private lateinit var rvCompanies: RecyclerView
    private lateinit var viewModel: CompaniesListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        v = inflater.inflate(R.layout.fragment_companies_list, container, false)

        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        companiesList.add(Company("Apple", 100000, "https://www.apple.com/ac/structured-data/images/knowledge_graph_logo.png?202106030101", ""))
        companiesList.add(Company("Facebook", 2000, "https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/Facebook_f_logo_%282019%29.svg/2048px-Facebook_f_logo_%282019%29.svg.png", ""))
        companiesList.add(Company("Google", 2000, "https://cdn1.iconfinder.com/data/icons/google-s-logo/150/Google_Icons-09-512.png", ""))
        companiesList.add(Company("Tumblr", 2000, "https://www.apple.com/ac/structured-data/images/knowledge_graph_logo.png?202106030101", ""))

        rvCompanies = v.findViewById(R.id.rvCompanies)
        setupRecyclerView()
    }

    private fun getAcompanies() {
        val filteredCompanies = mutableListOf<Company>()
        for (company in companiesList) {
            if(company.name[0] == 'A') {
                filteredCompanies.add(company)
            }
        }

        val filteredCompanies2 = companiesList.filter { company ->
            company.name.startsWith('A')
        }

        val sortedCompanies = companiesList.sortedByDescending { company -> company.name }

        val hasFcompany = companiesList.any { company -> company.name.startsWith('F') }
    }

    private fun setupRecyclerView() {
        // Creo el adapter de la lista de companies y le paso la lista de companies junto con el callback
        val companiesAdapter = CompaniesAdapter(companiesList) { company ->
            Log.d("CompaniesListFragment", "Company: ${company.name}")
        }

        val adapter2 = CompaniesAdapter(companiesList, ::onCompanyClicked)

        with(rvCompanies) {
            adapter = companiesAdapter
            layoutManager = LinearLayoutManager(context)
        }
        rvCompanies.adapter = companiesAdapter
        rvCompanies.layoutManager = LinearLayoutManager(context)
    }

    private fun onCompanyClicked(company: Company) {
        Log.d("CompaniesListFragment", "Company: ${company.name}")
    }

}
