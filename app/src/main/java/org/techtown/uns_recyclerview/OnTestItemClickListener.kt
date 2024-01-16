package org.techtown.uns_recyclerview

import android.view.View

interface OnTestItemClickListener {
    fun onItemClick(holder: TestAdapter.ViewHolder?, view: View?, position: Int)
}