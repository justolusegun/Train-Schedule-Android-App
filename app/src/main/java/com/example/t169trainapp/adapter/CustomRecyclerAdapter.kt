package com.example.t169trainapp.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.t169trainapp.R
import com.example.t169trainapp.Ticket
import com.example.t169trainapp.models.PostModel

class CustomRecyclerAdapter(val ctx: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var item:List<PostModel> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CustomViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.traincardview,
                parent,
                false
            ),
            ctx
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CustomViewHolder -> {
                holder.bind(item[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return item.size
    }

    fun submitList(trainList: List<PostModel>){
        item = trainList
    }

    class CustomViewHolder constructor(
        itemView:View,
        val ctx: Context
    ):RecyclerView.ViewHolder(itemView){
        private val arriveTime : TextView = itemView.findViewById(R.id.arriveTime)
        private val departure : TextView = itemView.findViewById(R.id.departTime)
        private val duration : TextView = itemView.findViewById(R.id.duration)
        private val stationNO : TextView = itemView.findViewById(R.id.stationNo)
        private val stationName : TextView = itemView.findViewById(R.id.StationName)
        private val trainNO : TextView = itemView.findViewById(R.id.trainNo)
        private val to : TextView = itemView.findViewById(R.id.to)
        private val from : TextView = itemView.findViewById(R.id.from)
        private val price : TextView = itemView.findViewById(R.id.price)

        fun bind(train:PostModel){
            arriveTime.text = train.arriveTime
            departure.text = train.departTime
            duration.text = train.duration
            stationNO.text = train.stationNo
            stationName.text = train.stationName
            to.text = train.to
            trainNO.text = train.trainNo
            from.text = train.from
            price.text = train.price

            itemView.setOnClickListener { v ->
                val i = Intent(ctx, Ticket::class.java)
                i.putExtra("ticket", train)
//                Log.d("ticket", train.toString() + 0)\ll
                ctx.startActivity(i)
            }
        }
    }

}