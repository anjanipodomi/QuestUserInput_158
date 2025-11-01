package com.example.userinput

import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout


@Composable
fun FormPendaftaran(modifier : Modifier = Modifier) {
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }

    var textJK by remember { mutableStateOf("") }
    var textStatus by remember { mutableStateOf("") }

    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("") }

    val gender = listOf("Laki-laki", "Perempuan")
    val statusPerkawinan = listOf("Janda", "Lajang", "Duda")

    Column(
        modifier = Modifier
            .padding(top = 40.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Formulir Pendaftaran",
            style = MaterialTheme.typography.headlineSmall,
            color = Color(0xFF7B1FA2),
            modifier = Modifier.padding(bottom = 20.dp)

        )
    }


}
