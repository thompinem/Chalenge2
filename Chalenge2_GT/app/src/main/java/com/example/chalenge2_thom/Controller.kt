

class Controller (private var callBack: CallBack) {

    private var hasil = 0

    fun operasi (pilihan: String, pilihanCom:String){
        if(pilihan==pilihanCom){
            hasil = R.drawable.draw
        }else if(pilihan == "batu"&&pilihanCom=="kertas"||
            pilihan== "kertas"&& pilihanCom == "gunting"||
            pilihan=="gunting"&& pilihanCom=="batu"){
            hasil = R.drawable.p2menang
        }else if(pilihan == "batu"&& pilihanCom=="gunting"||
            pilihan=="kertas"&&pilihanCom == "batu"||
            pilihan=="gunting"&&pilihanCom=="kertas"){
            hasil = R.drawable.p1menang
        }
        callBack.kirimLagi(pilihanCom)
        callBack.kirimBalik(hasil)
    }
}