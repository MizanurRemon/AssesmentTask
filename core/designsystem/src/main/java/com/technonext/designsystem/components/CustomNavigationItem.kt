package com.technonext.designsystem.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.technonext.designsystem.r
import com.technonext.designsystem.rippleClickable
import com.technonext.designsystem.theme.bodyXSBoldTextStyle
import com.technonext.common.R as CommonR
import com.technonext.designsystem.R as DesignSystemR

@Composable
fun CustomNavigationItem(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    @DrawableRes icon: Int,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val selectedColor =
        if (isSelected) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSurfaceVariant.copy(
            alpha = 0.7f
        )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.rippleClickable {
            onClick()
        }
    ) {

        Image(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier.size(if (isSelected) 18.r() else 16.r()),
            colorFilter = ColorFilter.tint(color = selectedColor)
        )

        Spacer(modifier = Modifier.height(4.r()))

        Text(
            text = stringResource(title),
            style = bodyXSBoldTextStyle.copy(
                color = selectedColor
            )
        )

        Spacer(modifier = Modifier.height(4.r()))

        /*Box(
            modifier = Modifier
                .height(3.r())
                .fillMaxWidth()
                .padding(horizontal = 18.r())
                .clip(RoundedCornerShape(16.r()))
                .background(color = if (isSelected) grayScale else Color.Transparent)
        )*/

    }
}

@Composable
@Preview(showBackground = true)
fun PreviewCustomNavigationItem() {
    Column {
        CustomNavigationItem(
            title = CommonR.string.feed,
            icon = DesignSystemR.drawable.ic_feed,
            isSelected = true,
            onClick = {}
        )
    }
}