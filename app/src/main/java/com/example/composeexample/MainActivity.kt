package com.example.composeexample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.composeexample.ui.theme.ComposeExampleTheme

class MainActivity : ComponentActivity() {

    private lateinit var themeViewModel: ThemeViewModel

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        themeViewModel = ViewModelProvider(this).get(ThemeViewModel::class.java)
        themeViewModel.isDarkTheme.value = ShareUtils.getInstance(this).getBoolean("long", false)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        themeViewModel.isDarkTheme.value?.let {
            ShareUtils.getInstance(this).putBoolean(
                "long",
                it
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeExampleTheme(themeViewModel) {

                // A surface container using the 'background' color from the theme
                Surface(
//                    modifier = Modifier
//                        .background(Color.Red)
//                        .fillMaxWidth()
//                        .fillMaxHeight()
                ) {
                    Greeting {
                        Log.d("hblong", "MainActivity.onCreate: change theme")
                        themeViewModel.isDarkTheme.value = !themeViewModel.isDarkTheme.value!!
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(onClick: () -> Unit) {
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

    Text(
        text = "LongHb",
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.primary)
            .clickable {
                onClick()
            },
        color = MaterialTheme.colorScheme.onPrimary,
        fontSize = MaterialTheme.typography.bodyLarge.fontSize

    )


}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    ComposeExampleTheme {
//        Surface(
//            color = White,
//            modifier = Modifier.fillMaxWidth()
//        ) {
////            Greeting()
//        }
//    }
//}