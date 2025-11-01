package com.example.userinput

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp


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
                            selected = textJK == item,
                            onClick = { textJK = item }

                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = textJK == item, onClick = { textJK = item })
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

        Button(
            modifier = Modifier
                .width(200.dp)
                .height(50.dp),
            enabled = textNama.isNotEmpty() && textAlamat.isNotEmpty(),
            onClick = {
                nama = textNama
                jenis = textJK
                alamat = textAlamat
                status = textStatus
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7B1FA2))
        ) {
            Text(text = stringResource(R.string.submit))
        }
        Divider(
            modifier = Modifier.padding(vertical = dimensionResource(R.dimen.padding_medium)),
            thickness = dimensionResource(R.dimen.Divider_tipis),
            color = Color.DarkGray
        )
        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Black),
            modifier = Modifier
                .height(130.dp)
                .width(320.dp)
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 15.dp)
            ) {
                Text(text = "Nama      : +nama", color = Color.White)
                Text(text = "Gender    : +jenis", color = Color.White)
                Text(text = "Status    : +status", color = Color.White)
                Text(text = "Alamat    : +alamat", color = Color.White)
            }

        }
    }
}
