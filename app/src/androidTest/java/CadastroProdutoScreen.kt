import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext

@Composable
fun CadastroProdutoScreen(onNavigateToLista: () -> Unit) {
    var nome by remember { mutableStateOf("") }
    var categoria by remember { mutableStateOf("") }
    var preco by remember { mutableStateOf("") }
    var quantidade by remember { mutableStateOf("") }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(value = nome, onValueChange = { nome = it }, label = { Text("Nome do Produto") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = categoria, onValueChange = { categoria = it }, label = { Text("Categoria") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = preco, onValueChange = { preco = it }, label = { Text("Preço") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = quantidade, onValueChange = { quantidade = it }, label = { Text("Quantidade em Estoque") })
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (nome.isBlank() || categoria.isBlank() || preco.isBlank() || quantidade.isBlank()) {
                Toast.makeText(context, "Todos os campos são obrigatórios", Toast.LENGTH_SHORT).show()
            } else {
                val produto = Produto(
                    nome = nome,
                    categoria = categoria,
                    preco = preco.toDouble(),
                    quantidade = quantidade.toInt()
                )
                ProdutoList.produtos.add(produto)
                onNavigateToLista()
            }
        }) {
            Text("Cadastrar")
        }
    }
}
