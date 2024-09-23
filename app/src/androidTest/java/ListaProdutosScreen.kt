import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ListItem
import androidx.compose.runtime.Composable

@Composable
fun ListaProdutosScreen(onNavigateToDetalhes: (Produto) -> Unit) {
    LazyColumn {
        items(ProdutoList.produtos) { produto ->
            ListItem(
                modifier = Modifier.clickable { onNavigateToDetalhes(produto) },
                text = { Text("${produto.nome} (${produto.quantidade} unidades)") },
                secondaryText = { Text("Categoria: ${produto.categoria}") }
            )
        }
    }
}
