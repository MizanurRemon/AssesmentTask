package com.technonext.auth_presentation.forgot_password

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.technonext.designsystem.components.AuthTopBar
import com.technonext.designsystem.components.AppActionButton
import com.technonext.designsystem.components.CommonTextField
import com.technonext.designsystem.r
import com.technonext.designsystem.rippleClickable
import com.technonext.designsystem.theme.BACKGROUND_COLOR
import com.technonext.designsystem.theme.appBrush
import com.technonext.designsystem.theme.bodyMediumTextStyle
import com.technonext.designsystem.theme.bodyRegularTextStyle
import com.technonext.designsystem.theme.bodyXSBoldTextStyle
import com.technonext.designsystem.theme.grayScale
import com.technonext.designsystem.theme.primaryBlue
import com.technonext.designsystem.theme.subHeading1TextStyle
import com.technonext.common.R as CommonR
import com.technonext.designsystem.R as DesignSystemR

@Composable
fun ForgotPasswordScreen(
    state: ForgotPasswordState,
    onEvent: (ForgotPasswordEvent) -> Unit,
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 24.r())
            .padding(top = 24.r()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Spacer(modifier = Modifier.height(120.r()))

        Text(text = stringResource(CommonR.string.forgot_password), style = subHeading1TextStyle)

        Spacer(modifier = Modifier.height(10.r()))

        Text(
            text = stringResource(CommonR.string.enter_your_details_to_receive_a_rest_link),
            style = bodyMediumTextStyle.copy(
                color = grayScale
            )
        )

        Spacer(modifier = Modifier.height(30.r()))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(
                    brush = appBrush(),
                    shape = RoundedCornerShape(12.r())
                )
        ) {

            Column(
                modifier = Modifier.padding(20.r()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CommonTextField(
                    value = state.email,
                    onValueChange = { onEvent(ForgotPasswordEvent.OnEmailEnter(it)) },
                    isTouched = state.isEmailTouched,
                    isValid = state.isMailValid,
                    onTouched = { onEvent(ForgotPasswordEvent.OnEmailTouchedListener) },
                    placeholder = stringResource(id = CommonR.string.your_email),
                    leadingIcon = painterResource(id = DesignSystemR.drawable.ic_mail),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )
                Spacer(modifier = Modifier.height(14.r()))
                AppActionButton(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {

                    },
                    text = CommonR.string.send
                )

                Spacer(modifier = Modifier.height(14.r()))

                Text(
                    text = stringResource(CommonR.string.back_to_sign_in),
                    style = bodyXSBoldTextStyle,
                    modifier = Modifier.rippleClickable {
                        onBack()
                    }
                )

            }
        }
    }
}


@Composable
@Preview
fun PreviewForgotPasswordScreen() {
    ForgotPasswordScreen(
        state = ForgotPasswordState(),
        onEvent = {},
        onBack = {}
    )
}