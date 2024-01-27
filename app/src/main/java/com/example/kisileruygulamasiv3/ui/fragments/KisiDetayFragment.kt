package com.example.kisileruygulamasiv3.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.kisileruygulamasiv3.R
import com.example.kisileruygulamasiv3.databinding.FragmentKisiDetayBinding
import com.example.kisileruygulamasiv3.ui.viewmodels.KisiDetayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KisiDetayFragment : Fragment() {
    private lateinit var binding: FragmentKisiDetayBinding
    private val args:KisiDetayFragmentArgs by navArgs<KisiDetayFragmentArgs>()
    private lateinit var viewModel: KisiDetayViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel=ViewModelProvider(this).get(KisiDetayViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(layoutInflater,R.layout.fragment_kisi_detay,container,false)
        binding.kisiDetayFragment=this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val kisi=args.kisi
        binding.gelenKisi=kisi

    }

    fun buttonGuncelle(kisi_id:Int,kisi_ad:String,kisi_tel:String){
        viewModel.guncelle(kisi_id,kisi_ad,kisi_tel)
    }


}