package com.xiaomai.ageny.utils;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class SpacesItemDecoration_left extends RecyclerView.ItemDecoration {
    private int space;

    public SpacesItemDecoration_left(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        outRect.left=space;
    }
}