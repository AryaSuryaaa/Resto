package com.dicoding.tourismapp.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.tourismapp.core.ui.RestaurantAdapter
import com.dicoding.tourismapp.databinding.FragmentFavoriteBinding
import com.dicoding.tourismapp.detail.DetailRestaurantActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {

//    @Inject
//    lateinit var factory: ViewModelFactory

    private val favoriteViewModel: FavoriteViewModel by viewModels()

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        (requireActivity().application as MyApplication).appComponent.inject(this)
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

//            val tourismAdapter = TourismAdapter()
//            tourismAdapter.onItemClick = { selectedData ->
//                val intent = Intent(activity, DetailTourismActivity::class.java)
//                intent.putExtra(DetailTourismActivity.EXTRA_DATA, selectedData)
//                startActivity(intent)
//            }
            val restaurantAdapter = RestaurantAdapter()
            restaurantAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailRestaurantActivity::class.java)
                intent.putExtra(DetailRestaurantActivity.EXTRA_DATA, selectedData)
                startActivity(intent)
            }


//            favoriteViewModel.favoriteTourism.observe(viewLifecycleOwner) { dataTourism ->
//                tourismAdapter.setData(dataTourism)
//                binding.viewEmpty.root.visibility =
//                    if (dataTourism.isNotEmpty()) View.GONE else View.VISIBLE
//            }
            favoriteViewModel.favoriteRestaurant.observe(viewLifecycleOwner) { dataRestaurant ->
                restaurantAdapter.setData(dataRestaurant)
                binding.viewEmpty.root.visibility =
                    if (dataRestaurant.isNotEmpty()) View.GONE else View.VISIBLE
            }

            with(binding.rvTourism) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = restaurantAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
