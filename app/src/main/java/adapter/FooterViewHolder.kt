package adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_recycler_header.view.*

class FooterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindView() {
        itemView.textHeader.textHeader.text = "Footer Section"
    }
}