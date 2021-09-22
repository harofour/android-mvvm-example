package com.example.mvvm_example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.mvvm_example.R
import com.example.mvvm_example.databinding.FragmentHomeBinding
import com.example.mvvm_example.mvvm.MovieViewModel

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var navController: NavController
    private val viewModel: MovieViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        bindViews()
    }

    private fun bindViews() {
        binding.searchBtn.setOnClickListener {
            viewModel.searchMovieData(
                getString(R.string.api_key), // Enter Your API_KEY
                binding.searchTermEditText.text.toString()
            )
            viewModel.searchTerm = binding.searchTermEditText.text.toString()
            binding.searchTermEditText.setText("")
            navController.navigate(R.id.action_homeFragment_to_searchResultFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}