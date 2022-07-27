package com.example.composeexample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.composeexample.ui.theme.ComposeExampleTheme
import com.example.composeexample.ui.theme.White

class MainActivity : ComponentActivity() {

    private lateinit var themeViewModel: ThemeViewModel

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        themeViewModel = ViewModelProvider(this).get(ThemeViewModel::class.java)
        themeViewModel.isDarkTheme.value = ShareUtils.getInstance(this).getBoolean("long", false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeExampleTheme {

                // A surface container using the 'background' color from the theme
                Surface(
//                    modifier = Modifier
//                        .background(Color.Red)
//                        .fillMaxWidth()
//                        .fillMaxHeight()
                ) {
                    Greeting(themeViewModel) {
                        themeViewModel.isDarkTheme.postValue(!themeViewModel.isDarkTheme.value!!)
                        ShareUtils.getInstance(this).putBoolean(
                            "long",
                            themeViewModel.isDarkTheme.value!!
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(themeViewModel: ThemeViewModel, onClick: () -> Unit) {
//    val name = themeViewModel.isDarkTheme.observeAsState()
//
//    Button(onClick = onClick) {
//        Text(
//            text = "Change Theme", color = if (name.value == true) {
//                Color.Red
//            } else {
//                Color.White
//            }
//        )
//    }

    Text(text = "LongHb", modifier = Modifier.background(Color.Red))


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeExampleTheme {
        Surface(
            color = White,
            modifier = Modifier.fillMaxWidth()
        ) {
//            Greeting()
        }
    }
}