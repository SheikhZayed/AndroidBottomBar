/*
 * Designed and developed by 2020 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:Suppress("unused")

package com.skydoves.androidbottombar.forms

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.view.Gravity
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.Px
import androidx.annotation.StringRes
import com.skydoves.androidbottombar.animations.BadgeAnimation
import com.skydoves.androidbottombar.animations.BadgeAnimationInterpolator
import com.skydoves.androidbottombar.annotations.Dp
import com.skydoves.androidbottombar.annotations.Sp
import com.skydoves.androidbottombar.extensions.accentColor
import com.skydoves.androidbottombar.extensions.contextColor
import com.skydoves.androidbottombar.extensions.dp2Px

@DslMarker
annotation class BadgeFormDsl

/** creates an instance of [BadgeForm] from [BadgeForm.Builder] using kotlin dsl. */
@BadgeFormDsl
inline fun badgeForm(context: Context, block: BadgeForm.Builder.() -> Unit): BadgeForm.Builder =
  BadgeForm.Builder(context).apply(block)

/**
 * [BadgeForm] is an attribute class that has some attributes about text
 * for customizing menu item badge easily.
 */
data class BadgeForm(private val builder: Builder) {

  val badge: Drawable? = builder.badge
  val badgeText: CharSequence = builder.badgeText
  val badgeStyle: Int = builder.badgeStyle
  val badgeTypeface: Typeface? = builder.badgeTypeface
  val badgeGravity: Int = builder.badgeGravity
  val badgeDuration: Long = builder.badgeDuration
  val badgeAnimation: BadgeAnimation = builder.badgeAnimation
  var badgeAnimationInterpolator: BadgeAnimationInterpolator = builder.badgeAnimationInterpolator

  @ColorInt
  val badgeTextColor: Int = builder.badgeTextColor

  @Sp
  val badgeTextSize: Float = builder.badgeTextSize

  @ColorInt
  val badgeColor: Int = builder.badgeColor

  @Px
  val badgeMargin: Int = builder.badgeMargin

  @Px
  val badgePaddingLeft: Int = builder.badgePaddingLeft

  @Px
  val badgePaddingTop: Int = builder.badgePaddingTop

  @Px
  val badgePaddingRight: Int = builder.badgePaddingRight

  @Px
  val badgePaddingBottom: Int = builder.badgePaddingBottom

  @Px
  val badgeRadius: Int = builder.badgeRadius

  /** Builder class for [BadgeForm]. */
  @BadgeFormDsl
  data class Builder(private val context: Context) {

    @JvmField
    var badge: Drawable? = null

    @JvmField
    var badgeText: CharSequence = ""

    @ColorInt
    @JvmField
    var badgeTextColor: Int = Color.WHITE

    @Sp
    @JvmField
    var badgeTextSize: Float = 9f

    @ColorInt
    @JvmField
    var badgeColor: Int = context.accentColor()

    @JvmField
    var badgeStyle = Typeface.NORMAL

    @JvmField
    var badgeTypeface: Typeface? = null

    @Px
    @JvmField
    var badgeMargin: Int = context.dp2Px(8)

    @Px
    @JvmField
    var badgePaddingLeft: Int = context.dp2Px(6)

    @Px
    @JvmField
    var badgePaddingTop: Int = context.dp2Px(2)

    @Px
    @JvmField
    var badgePaddingRight: Int = context.dp2Px(6)

    @Px
    @JvmField
    var badgePaddingBottom: Int = context.dp2Px(2)

    @Px
    @JvmField
    var badgeRadius: Int = context.dp2Px(16)

    @JvmField
    var badgeGravity: Int = Gravity.CENTER

    @JvmField
    var badgeAnimation: BadgeAnimation = BadgeAnimation.NONE

    @JvmField
    var badgeAnimationInterpolator: BadgeAnimationInterpolator = BadgeAnimationInterpolator.NORMAL

    @JvmField
    var badgeDuration: Long = 300L

    /** sets a background drawable of the badge */
    fun setBadge(value: Drawable?) = apply { this.badge = value }

    /** sets the content of the badge. */
    fun setBadgeText(value: CharSequence) = apply { this.badgeText = value }

    /** sets the content of the badge using string resource. */
    fun setBadgeText(@StringRes value: Int) = apply { this.badgeText = context.getString(value) }

    /** sets the text color of the badge. */
    fun setBadgeTextColor(@ColorInt value: Int) = apply { this.badgeTextColor = value }

    /** sets the text color of the badge using resource. */
    fun setBadgeTextColorRes(@ColorRes value: Int) = apply { this.badgeTextColor = context.contextColor(value) }

    /** sets the size of the badge. */
    fun setBadgeTextSize(@Sp value: Float) = apply { this.badgeTextSize = value }

    /** sets the color of the badge. */
    fun setBadgeColor(@ColorInt value: Int) = apply { this.badgeColor = value }

    /** sets the color of the badge using resource. */
    fun setBadgeColorRes(@ColorRes value: Int) = apply { this.badgeColor = context.contextColor(value) }

    /** sets the [Typeface] of the badge. */
    fun setBadgeStyle(value: Int) = apply { this.badgeStyle = value }

    /** sets the [Typeface] of the badge. */
    fun setBadgeTypeface(value: Typeface?) = apply { this.badgeTypeface = value }

    /** sets the margin of the badge. */
    fun setBadgeMargin(@Dp value: Int) = apply { this.badgeMargin = value }

    /** sets the padding of the badge. */
    fun setBadgePadding(@Dp value: Int) = apply {
      this.badgePaddingLeft = context.dp2Px(value)
      this.badgePaddingTop = context.dp2Px(value)
      this.badgePaddingRight = context.dp2Px(value)
      this.badgePaddingBottom = context.dp2Px(value)
    }

    /** sets the left padding of the badge. */
    fun setBadgePaddingLeft(@Dp value: Int) = apply { this.badgePaddingLeft = context.dp2Px(value) }

    /** sets the top padding of the badge. */
    fun setBadgePaddingTop(@Dp value: Int) = apply { this.badgePaddingTop = context.dp2Px(value) }

    /** sets the right padding of the badge. */
    fun setBadgePaddingRight(@Dp value: Int) = apply { this.badgePaddingRight = context.dp2Px(value) }

    /** sets the bottom padding of the badge. */
    fun setBadgePaddingBottom(@Dp value: Int) = apply { this.badgePaddingBottom = context.dp2Px(value) }

    /** sets the radius of the badge. */
    fun setBadgeRadius(@Dp value: Int) = apply { this.badgeRadius = context.dp2Px(value) }

    /** sets gravity of the badge. */
    fun setBadgeGravity(value: Int) = apply { this.badgeGravity = value }

    /** sets an animation of the badge. */
    fun setBadgeAnimation(value: BadgeAnimation) = apply { this.badgeAnimation = value }

    /** sets an badge animation interpolator of the badge. */
    fun setBadgeAnimationInterpolator(value: BadgeAnimationInterpolator) = apply {
      this.badgeAnimationInterpolator = value
    }

    /** sets a duration of the badge. */
    fun setBadgeDuration(value: Long) = apply { this.badgeDuration = value }

    fun build() = BadgeForm(this)
  }
}
