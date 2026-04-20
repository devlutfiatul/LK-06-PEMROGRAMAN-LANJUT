public class Peminjaman {
    String kode, nis, kodeBuku, tglPinjam, tglKembali;
    int status;

    public Peminjaman(String kode, String nis, String kodeBuku,
                      String tglPinjam, String tglKembali, int status) {
        this.kode = kode;
        this.nis = nis;
        this.kodeBuku = kodeBuku;
        this.tglPinjam = tglPinjam;
        this.tglKembali = tglKembali;
        this.status = status;
    }

    public String toFileString() {
        return kode + "," + nis + "," + kodeBuku + "," +
               tglPinjam + "," + tglKembali + "," + status;
    }
}