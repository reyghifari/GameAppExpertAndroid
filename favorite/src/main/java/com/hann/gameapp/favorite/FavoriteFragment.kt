package com.hann.gameapp.favorite

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.hann.core.ui.GameAdapter
import com.hann.core.utils.Constants
import com.hann.gameapp.detail.DetailGameActivity
import com.hann.gameapp.favorite.databinding.FragmentFavoriteBinding
import com.hann.gameapp.favorite.di.FavoriteModule.favoriteviewModelModule
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.GlobalContext.loadKoinModules


class FavoriteFragment : Fragment() {

    private  val favoriteViewModel: FavoriteViewModel by viewModel()

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        loadKoinModules(favoriteviewModelModule)

        if (activity != null) {

            val gameAdapter = GameAdapter()
            gameAdapter.onItemClick = {
                    selectedData ->
                val intent = Intent(activity, DetailGameActivity::class.java)
                intent.putExtra(Constants.PARAM_GAME_ID, selectedData.gameId)
                intent.putExtra(Constants.EXTRA_DATA, selectedData)
                startActivity(intent)
            }


            favoriteViewModel.favoriteGame.observe(viewLifecycleOwner) { favoriteGame ->
                gameAdapter.setData(favoriteGame)
            }

            with(binding.rvMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = gameAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}