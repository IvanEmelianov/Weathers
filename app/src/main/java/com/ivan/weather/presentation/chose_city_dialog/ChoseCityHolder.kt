package com.ivan.weather.presentation.chose_city_dialog

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ivan.weather.R

class ChoseCityHolder(view: View): RecyclerView.ViewHolder(view) {

    val tvNameCity: TextView = view.findViewById(R.id.tvNameCity)

}