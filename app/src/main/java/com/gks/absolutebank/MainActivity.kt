package com.gks.absolutebank

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gks.absolutebank.feature.detail.ui.DetailLayout
import com.gks.absolutebank.feature.detail.ui.DetailsViewModel
import com.gks.absolutebank.ui.theme.AbsoluteBankTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      AbsoluteBankTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
          /*MainScreenLayout(
            viewModel = MainScreenViewModel()
          )*/
          DetailLayout(
            viewModel = DetailsViewModel()
          )
        }
      }
    }
  }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name!",
    modifier = modifier
  )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  AbsoluteBankTheme {
    Greeting("Android")
  }
}