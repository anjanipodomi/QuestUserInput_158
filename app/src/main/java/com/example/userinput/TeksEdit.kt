package com.example.userinput

import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout


@Composable
fun FormDataDiri(modifier: Modifier
) {
    //variabel variabel untuk mengingat nilai masukan dari keyboard
    var textNama by remember {mutableStateOf("")}
    var textAlamat by remember {mutableStateOf("")}
    var textJK by remember {mutableStateOf("")}

    //variabel untuk menyimpan data yg diperolah dari komponen UI
    var nama by remember {mutableStateOf("")}
    var alamat by remember {mutableStateOf("")}
    var jenis by remember {mutableStateOf("")}

    val gender:List<String> = listOf("Laki-laki", "Perempuan")

    Column(modifier = Modifier.padding(top = 50.dp),
        verticalArrangement = Arrangement.Top,

        horizontalAligment = Aligment.CenterHorizontally) {
        OutlinedTextField(
            value = textNama,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.width(250.dp),

            label = {Text(text = "Nama Lengkap") },

            onValueChange = {
                textNama = it
            }
        )
        Row {
            gender.forEach {item ->
                Row(modifier = Modifier.selectable(
                    selected = textJK == item,

                    onClick = { tetJK = item}
                ), verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = textJK == item,

                        onClick = {
                            textJK = item
                        })
                    Text(item)
                }
            }
        }
        OutlinedTextField(
            value = textAlamat,
            singleLine = true,
            modifier = Modifier.width(250.dp),

            label = { Text(text = "Alamat Lengkap") },

            onValueChange = {
                textAlamat = it
            }
        )
        divider(
            modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium), top = dimensionResource(
                id = R.dimen.padding_medium
            )),
            thickness = dimensionResource(R.dimen.divider_tipis),
            color = Color.DarkGray
        )
        Button(
            modifier = Modifier.fillMaxWidth(1f),
            enabled = textAlamat.isNotEmpty(),

            onClick = {
                nama=textNama
                jenis=textJK
                alamat=textAlamat
            }
        ) {
            Text(stringResource(R.string.submit))
        }

        divider(
            modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium), top = dimensionResource(
                id = R.dimen.padding_medium
            )),
            thickness = dimensionResource(R.dimen.divider_tipis),
            color = Color.DarkGray
        )

        ElevatedCard (
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Black),
            modifier = Modifier
                .height(100.dp)
                .width(300.dp)
        ) {
            Column (modifier = Modifier.padding(horizontal = 5.dp, vertical = 15.dp),){
                Text(text = "Nama   : "+nama, color = Color.White)
                Text(text = "Gender : "+jenis, color = Color.White)
                Text(text = "Alamat : "+alamat, color = Color.White)
            }
        }
    }
}

