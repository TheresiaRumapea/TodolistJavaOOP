public class AplikasiTodolist {

    //Model = data
    //Jika menambahkan tolist >10, maka "model" akan dibuat lagi
    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
//        testShowTodoList();
//        testAddTodoList();
//        testRemoveTodoList();
//        testInput();
//        testViewShowTodoList();
//        testViewAddTodoList();
//        testViewRemoveTodoList();
        viewShowTodoList();
    }

    //================MEMBUAT BUSINESS LOGIC==================
    //SHOW TO DO LIST
    //Fungsi Menampilkan todo list
    public static void showTodoList(){
        //Butuh index jadi tidak bisa pake for each
        System.out.println("TODO LIST");
        for(var i = 0; i< model.length; i++){
            String todo = model[i];
            //number = number to do list
            var no = i+1;

            //jangan menambahkan array yang data kosong
            if(todo != null){
                System.out.println(no + ". " + model[i]);
            }
        }
    }
    public static void testShowTodoList(){
        model[0] = "Belajar Java Dasar";
        model[1] = "Senang untuk belajar java";

        showTodoList();
    }

    //Fungsi Menambah todo ke List
    public static void addTodoList(String todo){
        //cek apakah model penuh ?
        var isFull = true;
        for(var i = 0; i< model.length; i++){
            if(model[i] == null){
                isFull = false;
                break;
            }
        }
        //jika array penuh, resize array menjadi 2x lipat
        if(isFull){
            //data array yang lama disimpan dulu di temp
            var temp = model;
            model = new String[model.length * 2];

            for(int i=0; i< temp.length; i++){
                model[i] = temp[i];
            }
        }


        //tambah data ke posisi yang data tidak kosong / data arraynya NULL
        for(var i = 0; i< model.length; i++){
            if(model[i] == null){
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList(){
        for(int i=0; i < 25; i++){
            addTodoList("Contoh Todo Ke. " + i);
        }
        showTodoList();
    }

    //Fungsi Menghapus todo dari List
    //Karena hapusnya berdasarkan NOMOR TO DO LIST sehingga harus pake parameter berupa integer
    //Memberi jawaban berhasil atau gagal di hapus, sehingga bukan tipe VOID melainkan BOOLEAN
    public static boolean removeTodoList(Integer number){
        //di cek (number - 1) karena : awalnya array dimulai dari 0, dan number todo list yang sudah dideklrasikan itu number = i + 1, jadi jika ingin di cek harus knumber - 1
        //indeks yang diinput lebih besar atau sama dengan panjan maksimal array
        if((number - 1) >= model.length){
            return false;
        }
        //indeks yang diinput itu tidak ada di array, sehingga tidak ada yang mau dihapus
        else if (model[number - 1] == null){
            return false;
        }
        else {
            // model[number - 1] = null;
            // return true;
            //jika indeksnya tepat, setelah menghapus berhasil, maka indeks yang tengah dihapus, indeks yang dibawahnya langsung pindah menggantkan si tengah
            // 1. satu
            // 2. tiga
            // null
            for(int i = (number-1); i< model.length; i++){
                //jika indeksnya sudah sampai maximal, isi modelnya di nullkan
                if(i== model.length - 1){
                    model[i] = null;
                }
                //jika indeksnya tepat, setelah menghapus berhasil, maka indeks yang tengah dihapus, indeks yang dibawahnya langsung pindah menggantkan si tengah
                else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void  testRemoveTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        //Test dengan indek number > array.length : FALSE
        var result = removeTodoList(20);
        System.out.println(result);
        //Test dengan indeks number yang isi arraynya null
        //karena isi array saat ini hanya ada 3 yaitu Satu, Dua, Tiga
        result = removeTodoList(4);
        System.out.println(result);
        //Test dengan indeks number yang isi arraynya ada di list
        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    //Fungsi Menginput data ke todo List
    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var name = input("Nama");
        System.out.println("Hi " + name);

        var channel = input("Channel");
        System.out.println(channel);
    }


    //================MEMBUAT VIEW==================
    //Membuat view todo List
    public static void viewShowTodoList(){
        label:
        while (true){
            showTodoList();

            //menerima input
            System.out.println("==MENU==");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");

            switch (input) {
                case "1":
                    viewAddTodoList();
                    break;
                case "2":
                    viewRemoveTodoList();
                    break;
                case "x":
                    break label;
                default:
                    System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    public static void testViewShowTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");
        viewShowTodoList();
    }

    //Membuat view menambahkan todo List
    public static void viewAddTodoList(){
        System.out.println("MENAMBAH TODOLIST");

        var todo = input("Todo (x Jika Batal)");

        if(todo.equals("x")){
            //batal
        } else{
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");

        viewAddTodoList();

        showTodoList();
    }

    //Membuat view menghapus todo List
    public static void viewRemoveTodoList(){
        System.out.println("MENGHAPUS TODO LIST");

        var number = input("Nomor yang dihapus (x Jika Batal )");

        if(number.equals("x")){
            //batal
        } else{
            boolean success = removeTodoList(Integer.valueOf(number));
            if(!success){
                System.out.println("Gagal menghapus todolist " + number);
            }
        }
    }

    public static void testViewRemoveTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }











}
