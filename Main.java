import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        if (!login()) return;

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Tambah Siswa");
            System.out.println("2. Lihat Siswa");
            System.out.println("3. Pinjam Buku");
            System.out.println("4. Pengembalian");
            System.out.println("5. Laporan");
            System.out.println("6. Exit");

            int pilih = sc.nextInt(); sc.nextLine();

            switch (pilih) {
                case 1 -> tambahSiswa();
                case 2 -> lihatSiswa();
                case 3 -> pinjam();
                case 4 -> kembali();
                case 5 -> laporan();
                case 6 -> System.exit(0);
            }
        }
    }

    static boolean login() {
        System.out.print("NIP: ");
        String nip = sc.nextLine();

        for (String s : FileHelper.read("pegawai.txt")) {
            Pegawai p = Pegawai.fromFile(s);
            if (p.getNip().equals(nip)) {
                System.out.println("Login berhasil!");
                return true;
            }
        }
        System.out.println("Login gagal!");
        return false;
    }

    static void tambahSiswa() {
        System.out.print("NIS: ");
        String nis = sc.nextLine();
        System.out.print("Nama: ");
        String nama = sc.nextLine();
        System.out.print("Alamat: ");
        String alamat = sc.nextLine();

        Siswa s = new Siswa(nis, nama, alamat);
        FileHelper.write("siswa.txt", s.toFile());
    }

    static void lihatSiswa() {
    for (String s : FileHelper.read("siswa.txt")) {
        if (s.startsWith("NIS")) continue; // skip header
        Siswa.fromFile(s).tampil();
    }
}



    static int hitungPinjam(String nis) {
    int count = 0;
    for (String t : FileHelper.read("transaksi.txt")) {
        if (t.startsWith("Kode")) continue; // skip header
        Transaksi tr = Transaksi.fromFile(t);
        if (tr.getNis().equals(nis) && tr.getStatus() == 0) count++;
    }
    return count;
}



    static void pinjam() {
        System.out.print("Kode: ");
        String kode = sc.nextLine();
        System.out.print("NIS: ");
        String nis = sc.nextLine();

        if (hitungPinjam(nis) >= 2) {
            System.out.println("Max 2 buku!");
            return;
        }

        System.out.print("Kode Buku: ");
        String kb = sc.nextLine();

        Transaksi t = new Transaksi(kode, nis, kb, "hari ini", "-", 0);
        FileHelper.write("transaksi.txt", t.toFile());
    }


    static void kembali() {
        List<String> list = FileHelper.read("transaksi.txt");

        System.out.print("Masukkan kode transaksi: ");
        String kode = sc.nextLine();

        List<String> newData = new ArrayList<>();

        for (String s : list) {
    if (s.startsWith("Kode")) {
        newData.add(s);
        continue;
    }

    Transaksi t = Transaksi.fromFile(s);
    if (t.getKode().equals(kode)) {
        t.setStatus(1);
    }
    newData.add(t.toFile());
}
        FileHelper.rewrite("transaksi.txt", newData);
    }

    static void laporan() {
    for (String s : FileHelper.read("transaksi.txt")) {
        if (s.startsWith("Kode")) continue; // skip header
        Transaksi t = Transaksi.fromFile(s);
        if (t.getStatus() == 0) {
            System.out.println("Belum kembali:");
            t.tampil();
        }
    }
}
}
