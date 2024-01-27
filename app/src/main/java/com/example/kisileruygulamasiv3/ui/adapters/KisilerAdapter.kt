package com.example.kisileruygulamasiv3.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.kisileruygulamasiv3.data.entity.Kisiler
import com.example.kisileruygulamasiv3.databinding.RecyclerRowBinding
import com.example.kisileruygulamasiv3.ui.fragments.AnaSayfaFragmentDirections
import com.example.kisileruygulamasiv3.ui.viewmodels.AnasayfaViewModel
import com.google.android.material.snackbar.Snackbar

class KisilerAdapter(var mContext:Context,var kisilerList: List<Kisiler>,var viewModel: AnasayfaViewModel):
    RecyclerView.Adapter<KisilerAdapter.KisilerVH>() {

    class KisilerVH(var binding: RecyclerRowBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KisilerVH {
        val binding=RecyclerRowBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return KisilerVH(binding)
    }

    override fun getItemCount(): Int {
        return kisilerList.size
    }

    override fun onBindViewHolder(holder: KisilerVH, position: Int) {
        val currentKisi=kisilerList[position]
        holder.binding.kisiAdTextView.text=currentKisi.kisi_ad
        holder.binding.kisiTelTextView.text=currentKisi.kisi_tel

        holder.binding.anasayfaCardView.setOnClickListener {
            val action=AnaSayfaFragmentDirections.toDetayFragment(currentKisi)
            Navigation.findNavController(it).navigate(action)
        }
        holder.binding.silImageView.setOnClickListener {
            Snackbar.make(it,"Kişi silinsin mi?",Snackbar.LENGTH_LONG)
                .setAction("Evet"){
                    kisiSil(currentKisi.kisi_id)
                }
                .show()
        }
    }

    fun kisiSil(kisi_id:Int){
        viewModel.kisiSil(kisi_id)
    }
}