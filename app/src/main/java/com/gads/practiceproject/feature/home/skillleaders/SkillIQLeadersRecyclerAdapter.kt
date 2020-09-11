package com.gads.practiceproject.feature.home.skillleaders

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.gads.practiceproject.R
import com.gads.practiceproject.shared.store.models.SkillIQLeaderModel
import com.gads.practiceproject.shared.store.ui.setImageUrl

class SkillIQLeadersRecyclerAdapter(
    private val items: List<SkillIQLeaderModel>
) :
    RecyclerView.Adapter<SkillIQLeadersRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_skill_leader, parent, false)
        )
    }

    override fun getItemCount(): Int = items.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])

    }

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private var icon: ImageView? = null
        private var name: TextView? = null
        private var skillCountry: TextView? = null

        init {
            icon = view.findViewById(R.id.icon_iv)
            name = view.findViewById(R.id.name_tv)
            skillCountry = view.findViewById(R.id.score_country_tv)
        }

        fun bind(item: SkillIQLeaderModel) {
            name?.text = item.name
            skillCountry?.text = String.format(
                name?.context?.getString(R.string.score_country_placeholder)!!,
                item.score,
                item.country
            )
            icon?.setImageUrl(item.badgeUrl)
        }
    }


}