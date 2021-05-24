package com.example.crud

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_lista.view.*
import java.security.PrivilegedAction

class Adaptador(private val clickListener:(Int) -> Unit): RecyclerView.Adapter<Adaptador.ItemViewHolder>() {
    private var items: MutableList<String> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_lista,parent,false)
       return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size;

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item=items[position]
        holder.bin(item,clickListener)
    }
    fun setItems( nuevosItems: MutableList<String>){
        this.items=nuevosItems
        notifyDataSetChanged()
    }
    fun getItem(position: Int):String{
        return items[position]
    }
    fun remove(position: Int){
        items.removeAt(position)
    }
    fun getList():MutableList<String>{
        return items
    }



    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bin(item: String,lisener:(Int)->Unit)= with(itemView){
            Titulo.text=item
            setOnClickListener{lisener(adapterPosition)
            Titulo.text="Modificado"

            }
            setOnLongClickListener {
                Titulo.text = "Modificado"
                true
            }


        }

    }

}