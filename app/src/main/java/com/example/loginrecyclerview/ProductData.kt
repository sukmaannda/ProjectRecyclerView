package com.example.loginrecyclerview
object ProductData {
    private val data = arrayOf(
        arrayOf(
            "AHA",
            "Fungsi utama AHA adalah untuk mengelupaskan kulit dan mengangkat sel kulit mati, sehingga regerenerasi kulit atau proses pembentukan sel kulit baru bisa terjadi lebih cepat dan kulit akan terlihat lebih sehat secara menyeluruh. Regenerasi kulit adalah hal yang penting untuk kulit wajah yang tampak segar dan awet muda." ,
            R.drawable.aha),
        arrayOf(
            "C COLLAGEN",
            "Vitamin C bisa membantu mencerahkan warna kulit, meminimalisasi peradangan, menyamarkan flek hitam, sekaligus juga membuat kulit tampak lebih muda.",
            R.drawable.c),
        arrayOf(
            "COLLAGEN",
            "Collagen sebenarnya adalah protein dalam tubuh yang ada secara alamiah yang berperan baik untuk menjaga kesehatan kulit, gigi hingga otak. Dengan manfaat yang baik untuk kulit, collagen akan membuat kulit lebih lembab tidak cepat kendur, cerah dan bersinar namun tidak untuk memutihkan.",
            R.drawable.cola),
        arrayOf(
            "UV",
            "Collagen sebenarnya adalah protein dalam tubuh yang ada secara alamiah yang berperan baik untuk menjaga kesehatan kulit, gigi hingga otak. Dengan manfaat yang baik untuk kulit, collagen akan membuat kulit lebih lembab tidak cepat kendur, cerah dan bersinar namun tidak untuk memutihkan.",
            R.drawable.uv),
        arrayOf(
            "GLUTA",
            "Glutathione merupakan antioksidan yang diproduksi secara alami oleh tubuh. Ada banyak manfaat glutathione yang penting bagi kesehatan, di antaranya mencegah kerusakan sel tubuh, memperbaiki sel dan jaringan tubuh yang rusak, serta menunjang sistem kekebalan tubuh.",
            R.drawable.gluta),
        arrayOf(
            "WINK",
            "Wink membuat kulit yang bersih dan sehat, menjaga kesehatan tulang, sendi lutut, kuku, dan rambut, serta membuat kulit yang bersih dan halus.",
            R.drawable.wink))

    val listData: ArrayList<Product>
        get() {
            val list = arrayListOf<Product>()
            for (aData in data) {
                val product = Product()
                product.name = aData[0] as String
                product.desc = aData[1] as String
                product.photo = aData[2] as Int
                list.add(product)
            }
            return list
        }
}
