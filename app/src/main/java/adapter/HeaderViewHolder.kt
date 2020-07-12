package adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_recycler_header.view.*

class HeaderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bindView(){
        itemView.textHeader.text="Header Section"
    }
}