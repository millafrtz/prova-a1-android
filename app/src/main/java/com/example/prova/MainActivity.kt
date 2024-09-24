
package com.example.prova

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController

object ProdutoRepository {
    val produtos = mutableListOf<Produto>()
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutMain()
        }
    }
}

@Composable
fun LayoutMain() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "telaprincipal") {
        composable("telaprincipal") { TelaMain(navController) }
        composable("cadastrar") { CadastrarProdutos(navController) }
        composable("listar") { ListaProdutos(navController) }
        composable("estatisticas") { EstatisticasScreen() }
    }
}

@Composable
fun TelaMain(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Bem-vindo ao Gerenciador de Estoque", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("cadastrar") }) {
            Text(text = "Cadastrar Produto")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("listar") }) {
            Text(text = "Ver Lista de Produtos")
        }
    }
}

@Composable
fun CadastrarProdutos(navController: NavHostController) {
    var nome by remember { mutableStateOf("") }
    var categoria by remember { mutableStateOf("") }
    var preco by remember { mutableStateOf("") }
    var quantidade by remember { mutableStateOf("") }


    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Cadastrar Produto", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        @OptIn(ExperimentalMaterial3Api::class)
        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome") }
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = categoria,
            onValueChange = { categoria = it },
            label = { Text("Categoria") }
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = preco,
            onValueChange = { preco = it },
            label = { Text("Preço") },
            keyboardOptions = androidx.compose.ui.text.input.KeyboardOptions.Default.copy(keyboardType = androidx.compose.ui.text.input.KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = quantidade,
            onValueChange = { quantidade = it },
            label = { Text("Quantidade") },
            keyboardOptions = androidx.compose.ui.text.input.KeyboardOptions.Default.copy(keyboardType = androidx.compose.ui.text.input.KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (nome.isEmpty() || categoria.isEmpty() || preco.isEmpty() || quantidade.isEmpty()) {
                Toast.makeText(context, "Todos os campos são obrigatórios", Toast.LENGTH_SHORT).show()
            } else if (preco.toDouble() < 0 || quantidade.toInt() < 1) {
                Toast.makeText(context, "Preço deve ser maior que 0 e quantidade maior que 1", Toast.LENGTH_SHORT).show()
            } else {
                val produto = Produto(nome, categoria, preco.toDouble(), quantidade.toInt())
                Estoque.adicionarProduto(produto)
                navController.navigate("listar")
            }
        }) {
            Text(text = "Cadastrar")
        }
    }
}

@Composable
fun ListaProdutos(navController: NavHostController) {
    val produtos = remember { Estoque.listarProdutos() }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Lista de Produtos", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(produtos) { produto ->
                Row(
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "${produto.nome} (${produto.quantidade} unidades)")
                    Button(onClick = {
                        // Navigate to product details (assuming this functionality exists)
                    }) {
                        Text(text = "Detalhes")
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Button to navigate to the statistics screen
        Button(onClick = {
            navController.navigate("estatisticas")
        }) {
            Text(text = "Ver Estatísticas")
        }
    }
}

@Composable
fun EstatisticasScreen() {
    val valorTotalEstoque = remember { Estoque.calcularValorTotalEstoque() }
    val quantidadeTotalProdutos = remember { Estoque.calcularQuantidadeTotalProdutos() }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Estatísticas do Estoque", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Valor Total do Estoque: R$ $valorTotalEstoque")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Quantidade Total de Produtos: $quantidadeTotalProdutos")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /* Add navigation back or further functionality here */ }) {
            Text(text = "Voltar")
        }
    }
}
