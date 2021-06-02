package com.inspera.santanderweek.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.inspera.santanderweek.R
import com.inspera.santanderweek.data.Conta
import java.lang.RuntimeException

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.tMainToolbar))
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        buscarContaCliente()
        //throw usado para testar firebase crashlytics
        //throw RuntimeException();

    }

    private fun buscarContaCliente(){
        mainViewModel.buscarContaCliente().observe(this, Observer { result ->
            bindOnView(result)
        })
    }

    private fun bindOnView(conta: Conta){
        findViewById<TextView>(R.id.tvAgencia).setText("Ag" + conta.agencia)
        findViewById<TextView>(R.id.tvConta).setText("Cc" + conta.numero)
        findViewById<TextView>(R.id.tvUsuario).setText("Olá, " + conta.cliente.nome)
        findViewById<TextView>(R.id.tv_saldo).setText(conta.saldo)
        findViewById<TextView>(R.id.tv_saldo_total).setText(conta.limite)
        findViewById<TextView>(R.id.tv_cartao_final_valor).setText(conta.cartao.numeroCartao.substring(conta.cartao.numeroCartao.length -4))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.main_menu, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.item_1 -> {
                Log.d("Click", "Click no item 3")
                true
            }else -> {
                true
            }
        }
    }

}