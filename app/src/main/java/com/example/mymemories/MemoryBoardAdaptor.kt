package com.example.mymemories

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymemories.models.BoardSize
import kotlin.math.min

class MemoryBoardAdaptor(private val context: Context, private val boardSize: BoardSize) :
    RecyclerView.Adapter<MemoryBoardAdaptor.ViewHolder>() {

  companion object {
    private const val MARGIN_SIZE = 10
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder { 
    val cardWidth: Int = parent.width / boardSize.getWidth() - (2 * MARGIN_SIZE)
    val cardHeight: Int = parent.height / boardSize.getHeight() - (2 * MARGIN_SIZE)
    val cardSideLength: Int = min(cardWidth, cardHeight)
    val view: View = LayoutInflater.from(context).inflate(R.layout.memory_card, parent, false)
    val layoutParams: ViewGroup.MarginLayoutParams =
        view.findViewById<CardView>(R.id.cardView).layoutParams as ViewGroup.MarginLayoutParams
    layoutParams.width = cardSideLength
    layoutParams.height = cardSideLength
    layoutParams.setMargins(MARGIN_SIZE, MARGIN_SIZE, MARGIN_SIZE, MARGIN_SIZE)

    return ViewHolder(view)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(position)
  }

  override fun getItemCount() = boardSize.numCard

  inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val imageButton = itemView.findViewById<ImageButton>(R.id.imageButton)
    fun bind(position: Int) {
      imageButton.setOnClickListener { println("$position") }
    }
  }
}
