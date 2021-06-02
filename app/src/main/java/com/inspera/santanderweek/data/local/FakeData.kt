package com.inspera.santanderweek.data.local

import com.inspera.santanderweek.data.Cartao
import com.inspera.santanderweek.data.Cliente
import com.inspera.santanderweek.data.Conta

class FakeData {
    fun getLocalDate() : Conta {
        val cliente = Cliente("George Araújo")
        val cartao = Cartao("4111111111")
        return Conta(
                "445655-4",
                "6552-4",
                "R$ 2.450,00",
                "R$ 4.200,00",
                cliente,
                cartao);
    }
}