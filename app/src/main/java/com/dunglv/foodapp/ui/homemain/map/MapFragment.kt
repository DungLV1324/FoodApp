package com.dunglv.foodapp.ui.homemain.map

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.dunglv.foodapp.R
import com.dunglv.foodapp.databinding.FragmentMapBinding
import com.dunglv.foodapp.ui.base.BaseBindingFragment
import com.dunglv.foodapp.ui.homemain.MainViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MapFragment : BaseBindingFragment<FragmentMapBinding, MainViewModel>(), OnMapReadyCallback {
    private lateinit var mGoogleMap: GoogleMap
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_map
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        fusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(requireContext())
        fusedLocationProviderClient.lastLocation
            .addOnSuccessListener { location ->
                location?.let {
                    val currentLatLng = LatLng(it.latitude, it.longitude)
                    mGoogleMap.addMarker(
                        MarkerOptions().position(currentLatLng).title("You are here")
                    )
                    mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 15f))
                }
            }
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            fusedLocationProviderClient.lastLocation
                .addOnSuccessListener { location ->
                    location?.let {
                        val currentLatLng = LatLng(it.latitude, it.longitude)
                        mGoogleMap.addMarker(
                            MarkerOptions().position(currentLatLng).title("You are here")
                        )
                        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 15f))
                    }
                }
        } else {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
        }
        mapFragment.getMapAsync(this)
    }

//    private fun getLastLocation() {
//
//        fusedLocationProviderClient.lastLocation
//            .addOnSuccessListener { location ->
//                location?.let {
//                    val currentLatLng = LatLng(it.latitude, it.longitude)
//                    mGoogleMap.addMarker(
//                        MarkerOptions().position(currentLatLng).title("You are here")
//                    )
//                    mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 15f))
//                }
//            }
//    }

    override fun onMapReady(googleMap: GoogleMap) {
        mGoogleMap = googleMap
    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1001
    }
}

