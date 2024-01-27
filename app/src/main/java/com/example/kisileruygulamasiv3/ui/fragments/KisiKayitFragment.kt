package com.example.kisileruygulamasiv3.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.kisileruygulamasiv3.R
import com.example.kisileruygulamasiv3.databinding.FragmentKisiKayitBinding
import com.example.kisileruygulamasiv3.ui.viewmodels.KisiKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KisiKayitFragment : Fragment() {
    private lateinit var binding: FragmentKisiKayitBinding
    private lateinit var viewModel:KisiKayitViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel=ViewModelProvider(this).get(KisiKayitViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(layoutInflater,R.layout.fragment_kisi_kayit,container,false)
        binding.kisiKayitFragment=this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun buttonKaydet(kisi_ad:String,kisi_tel:String){
        viewModel.kaydet(kisi_ad,kisi_tel)
    }


}