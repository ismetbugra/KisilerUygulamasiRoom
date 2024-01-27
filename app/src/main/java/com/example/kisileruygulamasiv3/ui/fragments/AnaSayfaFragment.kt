package com.example.kisileruygulamasiv3.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kisileruygulamasiv3.R
import com.example.kisileruygulamasiv3.data.entity.Kisiler
import com.example.kisileruygulamasiv3.databinding.FragmentAnaSayfaBinding
import com.example.kisileruygulamasiv3.ui.adapters.KisilerAdapter
import com.example.kisileruygulamasiv3.ui.viewmodels.AnasayfaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnaSayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnaSayfaBinding
    private lateinit var viewModel: AnasayfaViewModel
    private lateinit var adapter: KisilerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel=ViewModelProvider(this).get(AnasayfaViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(layoutInflater,R.layout.fragment_ana_sayfa,container,false)
        binding.anasayfaFragment=this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //binding.recyclerView.layoutManager=LinearLayoutManager(requireContext())
        viewModel.kisilerListesi.observe(viewLifecycleOwner, Observer {
            adapter= KisilerAdapter(requireContext(),it,viewModel)
            binding.kisilerAdapter=adapter
        })




        binding.searchView.setOnQueryTextListener(object :OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String): Boolean {
                ara(p0)
                return true
            }

            override fun onQueryTextChange(p0: String): Boolean {
                ara(p0)
                return true
            }

        })
    }

    fun fabTikla(it:View){
        Navigation.findNavController(it).navigate(R.id.toKisiKayitFragment)
    }



    fun ara(aramaKelimesi:String){
        viewModel.ara(aramaKelimesi)
    }

    override fun onResume() {
        super.onResume()
        viewModel.kisileriYukle()
    }


}