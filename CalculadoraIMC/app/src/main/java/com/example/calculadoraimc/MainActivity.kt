package com.example.calculadoraimc

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculadoraimc.ui.theme.CalculadoraIMCTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraIMCTheme {
                //cor de fundo branco
                Scaffold {
                    //coluna com tamanho máximo
                    Column(modifier = Modifier.fillMaxSize()) {
                        //texto com a string "Hello World!"
                        Text("Hello World!")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun CalculatePreview() {
    CalculadoraIMCTheme {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)) {
            LabelTexts()
        }
    }
}

@Preview
@Composable
fun LabelTexts() {
    var nome by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var idade by remember { mutableStateOf("") }
    var resultadoIMC by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text(text = "Nome:") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            OutlinedTextField(
                value = peso,
                onValueChange = { peso = it },
                label = { Text(text = "Peso (kg):") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            OutlinedTextField(
                value = altura,
                onValueChange = { altura = it },
                label = { Text(text = "Altura (cm):") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            OutlinedTextField(
                value = idade,
                onValueChange = { idade = it },
                label = { Text("Idade:") },
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(
                onClick = {
                    nome = ""
                    peso = ""
                    altura = ""
                    idade = ""
                    resultadoIMC = ""
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.Black
                )
            ) {
                Text("Limpar")
            }
            Button(
                onClick = {
                    val pesoValue = peso.toFloatOrNull() ?: 0f
                    val alturaValue = altura.toFloatOrNull() ?: 0f / 100
                    if (pesoValue > 0 && alturaValue > 0) {
                        val imc = pesoValue / (alturaValue * alturaValue)
                        resultadoIMC = "Com peso de ${peso}kg e ${altura}m de altura você está com o IMC em %.2f".format(imc)
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Green
                )
            ) {
                Text("Calcular imc")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        if (resultadoIMC.isNotEmpty()) {
            Text(text = resultadoIMC)
        }
    }
}