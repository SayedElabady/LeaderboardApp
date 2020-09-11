package com.gads.practiceproject.feature.home.learningleaders

import androidx.recyclerview.widget.RecyclerView
import com.gads.practiceproject.shared.store.models.LearningLeaderModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.gads.practiceproject.R
import com.gads.practiceproject.shared.store.ui.setImageUrl

class LearningLeadersRecyclerAdapter(
    private val items: List<LearningLeaderModel>
) :
    RecyclerView.Adapter<LearningLeadersRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_learning_leader, parent, false)
        )
    }

    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])

    }

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private var icon: ImageView? = null
        private var name: TextView? = null
        private var hoursCountry: TextView? = null

        init {
            icon = view.findViewById(R.id.icon_iv)
            name = view.findViewById(R.id.name_tv)
            hoursCountry = view.findViewById(R.id.hours_country_tv)
        }

        fun bind(item: LearningLeaderModel) {
            name?.text = item.name
            hoursCountry?.text = String.format(
                name?.context?.getString(R.string.hours_country_placeholder)!!,
                item.hours,
                item.country
            )
            icon?.setImageUrl(item.badgeUrl)
        }
    }


}