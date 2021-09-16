package com.example.mvvm_example.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm_example.R
import com.example.mvvm_example.adapter.MovieAdapter
import com.example.mvvm_example.databinding.FragmentSearchResultBinding
import com.example.mvvm_example.mvvm.MovieViewModel

class SearchResultFragment : Fragment() {
    val TAG: String = "로그"
    private var _binding: FragmentSearchResultBinding? = null
    private val binding get() = _binding!!

    private lateinit var movieAdapter: MovieAdapter
    private val viewModel: MovieViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindRecyclerView()
    }

    private fun bindRecyclerView() {
        movieAdapter = MovieAdapter { }
        binding.recyclerView.apply {
            adapter = movieAdapter
            layoutManager = GridLayoutManager(this@SearchResultFragment.context, 2)
        }

        viewModel.getMovieData().observe(viewLifecycleOwner, {
            movieAdapter.submitList(it)
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}