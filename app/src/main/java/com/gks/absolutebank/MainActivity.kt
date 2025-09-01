package com.gks.absolutebank

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.gks.absolutebank.feature.detail.ui.DetailLayout
import com.gks.absolutebank.feature.detail.ui.DetailsViewModel
import com.gks.absolutebank.feature.main.ui.MainScreenViewModel
import com.gks.absolutebank.feature.main1.MainScreenLayout
import com.gks.absolutebank.ui.theme.AbsoluteBankTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.Serializable

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      val navController = rememberNavController()
      AbsoluteBankTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
          NavHost(navController = navController, startDestination = MAIN_ROUTE) {
            composable(MAIN_ROUTE) {
              MainScreenLayout(
                viewModel = hiltViewModel<MainScreenViewModel>(),
                onCardClick = { value -> navController.navigate(CardId(value)) }
              )
            }
            composable<CardId> {
              val cardId = it.toRoute<CardId>()
              DetailLayout(
                viewModel = hiltViewModel<DetailsViewModel>(),
                id = cardId.value,
                onBackClick = { navController.popBackStack() }
              )
            }
          }
        }
      }
    }
  }
}

private const val MAIN_ROUTE = "search"

@Serializable
data class CardId(val value: Int)