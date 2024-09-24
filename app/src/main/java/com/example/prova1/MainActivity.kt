package com.example.gerenciamentodeinventario
import com.example.gerenciamentodeinventario.CadastroProdutoScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Surface(color = MaterialTheme.colorScheme.background) {
                NavHost(navController, startDestination = "cadastro") {
                    composable("cadastro") {
                        CadastroProdutoScreen(onNavigateToLista = { navController.navigate("lista") })
                    }
                    composable("lista") {
                        ListaProdutosScreen(onNavigateToDetalhes = { produto ->
                        })
                    }
                }
            }
        }
    }
}
