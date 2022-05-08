package repository;

import entity.TodoList;

public class TodoListRepositoryImpl implements TodoListRepository{

    //Fungsi REPOSITORY : untuk mengolah data
    //jadi kita deklarasikan DATA disini sekarang, berbentuk ARRAY sepanjang 10
    //NANTI, besar kemungkinan, kita UBAH ke bentuk GENERIC. Itu semua diubah di REPOSITORY
    public TodoList[] data = new TodoList[10];
    @Override
    public TodoList[] getAll() {
        return data;
    }

    public boolean isFull(){
        //cek apakah model penuh ?
        var isFull = true;
        for(var i = 0; i< data.length; i++){
            if(data[i] == null){
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public void resizeIsFull(){
        //jika array penuh, resize array menjadi 2x lipat
        //Dicek dengan memanggil fungsi ISFULL()
        if(isFull()){
            //data array yang lama disimpan dulu di temp
            var temp = data;
            data = new TodoList[data.length * 2];

            for(int i=0; i< temp.length; i++){
                data[i] = temp[i];
            }
        }
    }

    @Override
    public void add(TodoList todoList) {
        resizeIsFull();

        //tambah data ke posisi yang data tidak kosong / data arraynya NULL
        for(var i = 0; i< data.length; i++){
            if(data[i] == null){
                data[i] = todoList;
                break;
            }
        }
    }

    @Override
    public boolean remove(Integer number) {
        if((number - 1) >= data.length){
            return false;
        }
        //indeks yang diinput itu tidak ada di array, sehingga tidak ada yang mau dihapus
        else if (data[number - 1] == null){
            return false;
        }
        else {
            for(int i = (number-1); i< data.length; i++){
                //jika indeksnya sudah sampai maximal, isi modelnya di nullkan
                if(i== data.length - 1){
                    data[i] = null;
                }
                //jika indeksnya tepat, setelah menghapus berhasil, maka indeks yang tengah dihapus, indeks yang dibawahnya langsung pindah menggantkan si tengah
                else {
                    data[i] = data[i + 1];
                }
            }
            return true;
        }
    }
}
