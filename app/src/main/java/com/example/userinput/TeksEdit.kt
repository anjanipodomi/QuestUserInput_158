package com.example.userinput



@Composable
fun FormDataDiri(modifier: Modifier
) {
    //variabel variabel untuk mengingat nilai masukan dari keyboard
    var textNama by remember {mutableStateOf("")}
    var textAlamat by remember {mutableStateOf("")}
    var textJK by remember {mutableStateOf("")}


}