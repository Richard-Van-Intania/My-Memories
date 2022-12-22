package com.example.mymemories

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mymemories.models.BoardSize

class MainActivity : AppCompatActivity() {

  private lateinit var recyclerView: RecyclerView
  private lateinit var textViewMove: TextView
  private lateinit var textViewPair: TextView

  private var boardSize: BoardSize = BoardSize.EASY

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    recyclerView = findViewById(R.id.recyclerView)
    textViewMove = findViewById(R.id.textViewMove)
    textViewPair = findViewById(R.id.textViewPairs)

    recyclerView.adapter = MemoryBoardAdaptor(this, boardSize)
    recyclerView.setHasFixedSize(true)
    recyclerView.layoutManager = GridLayoutManager(this, boardSize.getWidth())
  }
}
