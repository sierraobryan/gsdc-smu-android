package com.sierraobryan.networkexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sierraobryan.networkexample.ui.details.DetailsContent
import com.sierraobryan.networkexample.ui.details.DetailsViewModel
import com.sierraobryan.networkexample.ui.feature.FeatureContent
import com.sierraobryan.networkexample.ui.feature.FeatureViewModel
import com.sierraobryan.networkexample.ui.theme.NetworkExampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetworkExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HostNavApp()
                }
            }
        }
    }
}

@Composable
fun HostNavApp(
   modifier: Modifier = Modifier,
   navHostController: NavHostController = rememberNavController(),
   startDestination: String = "list"
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = startDestination
    ) {
        composable("list") {
            val viewModel = hiltViewModel<FeatureViewModel>()
            FeatureContent(
                viewModel = viewModel,
                onClick = { name ->
                    navHostController.navigate("details/$name")
                }
            )
        }
        composable("details/{name}") {
            val viewModel = hiltViewModel<DetailsViewModel>()
            DetailsContent(viewModel)
        }

    }
}