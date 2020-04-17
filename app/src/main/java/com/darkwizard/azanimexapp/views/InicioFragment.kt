package com.darkwizard.azanimexapp.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.darkwizard.azanimexapp.viewmodels.InicioViewModel

import com.darkwizard.azanimexapp.R
import com.darkwizard.azanimexapp.adapters.InicioPostAdapter
import kotlinx.android.synthetic.main.fragment_inicio.*

/**
 * A simple [Fragment] subclass.
 */
class InicioFragment : Fragment() {

    lateinit var viewModel: InicioViewModel
    lateinit var adapter: InicioPostAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(InicioViewModel::class.java)

        viewModel.GetAnimeList().observe(viewLifecycleOwner, Observer {animes->
            Log.d("lista de animes",animes.toString())
            print(animes.toString())
            adapter = InicioPostAdapter(animes)
            rv_inicioAnimes.adapter = adapter
        })
        viewModel.IsLoading().observe(viewLifecycleOwner, Observer {
           if (it){
               mProgreesBar.visibility = View.VISIBLE
           }else{
               mProgreesBar.visibility = View.GONE
           }
        })

    }
}
