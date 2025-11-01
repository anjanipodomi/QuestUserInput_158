package com.example.userinput

import androidx.compose.foundation.selection.selectable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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

        OutlinedTextField(
            value = textNama,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.width(300.dp),
            label = { Text(text = "Nama Lengkap") },
            onValueChange = { textNama = it }

        )

        Spacer(modifier = Modifier.height(15.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(start = 20.dp)
        ) {
            Text(text = "Jenis Kelamin")
            gender.forEach { item ->
                Row(
                    modifier = Modifier
                        .selectable(
                            selected = textJk == item,
                            onClick = { textJK = item }

                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButoon(selected = textJK == item, onClick = { textJK = item })
                    Text(text = item)
                }
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(start = 20.dp)
        ) {
            Text(text = "Status Perkawinan")
            statusPerkawinan.forEach { item ->
                Row(
                    modifier = Modifier
                        .selectable(
                            selected = textStatus == item,
                            onClick = { textStatus = item }
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = textStatus == item, onClick = { textStatus = item })
                    Text(text = item)
                }
            }
        }
        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = textAlamat,
            singleLine = true,
            modifier = Modifier.width(300.dp),
            label = { Text(text = "Alamat") },
            onValueChange = { textAlamat = it }
        )

        Divider(
            modifier = Modifier.padding(vertical = dimensionResource(R.dimen.padding_medium)),
            thickness = dimensionResource(R.dimen.Divider_tipis),
            color = Color.DarkGray
        )
    }
}
