package com.example.jetpackcomposepractice

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PasswordTextField() {

    var password by rememberSaveable { mutableStateOf("") }

    var passwordVisibility by remember { mutableStateOf(false) }

    val icon = if (passwordVisibility)
        painterResource(id = R.drawable.baseline_visibility_24)
    else painterResource(id = R.drawable.baseline_visibility_off_24)

    OutlinedTextField(
        value = password,
        onValueChange = {
            password = it
        },
        placeholder = { Text("password") },
        label = { Text("password") },
        trailingIcon = {
            IconButton(onClick = {
                passwordVisibility = !passwordVisibility
            }) {
                Icon(
                    painter = icon,
                    contentDescription = "Visibility icon"
                )
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (passwordVisibility) VisualTransformation.None
        else PasswordVisualTransformation()

    )

}


@Composable
@Preview(showSystemUi = true)
fun PasswordTextFieldPreview() {
    PasswordTextField()
}