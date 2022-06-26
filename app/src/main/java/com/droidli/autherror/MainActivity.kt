package com.droidli.autherror

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.droidli.autherror.presentation.MainViewModel
import com.droidli.autherror.ui.theme.AuthErrorTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AuthErrorTheme {
                val viewModel = viewModel<MainViewModel>()
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 32.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextField(
                        value = viewModel.email,
                        onValueChange = viewModel::onEmailChange,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = viewModel::submit,
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text(text = "Submit")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    viewModel.message?.let {
                        Text(text = it.asString())
                    }
                }
            }
        }
    }
}