
package com.example.prova

class Estoque {

    companion object {
        private val produtos = mutableListOf<Produto>()

        fun adicionarProduto(produto: Produto) {
            produtos.add(produto)
        }

        fun calcularValorTotalEstoque(): Double {
            return produtos.sumOf { it.preco * it.quantidade }
        }

        fun calcularQuantidadeTotalProdutos(): Int {
            return produtos.sumOf { it.quantidade }
        }

        fun listarProdutos(): List<Produto> {
            return produtos
        }
    }
}
