package com.huangjie.corelib.widget

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.RadioButton
import com.huangjie.corelib.R


/**
 * Created by huangjie on 2019/3/2.
 */

class NavigationRadioButton : RadioButton {

    private var drawableWidth: Int = 0
    private var drawableHeight: Int = 0

    var drawableLeft: Drawable? = null
        set(value) {
            setCompoundDrawablesWithIntrinsicBounds(value, null, null, null)
        }
    var drawableTop: Drawable? = null
        set(value) {
            setCompoundDrawablesWithIntrinsicBounds(null, value, null, null)
        }
    var drawableRight: Drawable? = null
        set(value) {
            setCompoundDrawablesWithIntrinsicBounds(null, null, value, null)
        }
    var drawableBottom: Drawable? = null
        set(value) {
            setCompoundDrawablesWithIntrinsicBounds(null, null, null, value)
        }


    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        var array: TypedArray? = null

        try {
            array = context.obtainStyledAttributes(attrs, R.styleable.NavigationRadioButton)
            drawableWidth = array.getDimension(R.styleable.NavigationRadioButton_drawableWidth,
                    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 22f, resources.displayMetrics)).toInt()
            drawableHeight = array.getDimension(R.styleable.NavigationRadioButton_drawableHeight,
                    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 22f, resources.displayMetrics)).toInt()

            drawableLeft = array.getDrawable(R.styleable.NavigationRadioButton_drawableLeft)
            drawableTop = array.getDrawable(R.styleable.NavigationRadioButton_drawableTop)
            drawableRight = array.getDrawable(R.styleable.NavigationRadioButton_drawableRight)
            drawableBottom = array.getDrawable(R.styleable.NavigationRadioButton_drawableBottom)

        } finally {
            array?.recycle()
        }
        setCompoundDrawablesWithIntrinsicBounds(drawableLeft, drawableTop, drawableRight, drawableBottom)
    }


    override fun setCompoundDrawablesWithIntrinsicBounds(left: Drawable?, top: Drawable?, right: Drawable?, bottom: Drawable?) {
        left?.setBounds(0, 0, drawableWidth, drawableHeight)
        top?.setBounds(0, 0, drawableWidth, drawableHeight)
        right?.setBounds(0, 0, drawableWidth, drawableHeight)
        bottom?.setBounds(0, 0, drawableWidth, drawableHeight)
        setCompoundDrawables(left, top, right, bottom)
    }
}
