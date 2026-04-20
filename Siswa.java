public class Siswa {
    private String nis, nama, alamat;

    public Siswa(String nis, String nama, String alamat) {
        this.nis = nis;
        this.nama = nama;
        this.alamat = alamat;
    }

    public String toFile() {
        return nis + "," + nama + "," + alamat;
    }

    public static Siswa fromFile(String data) {
        String[] d = data.split(",");
        return new Siswa(d[0], d[1], d[2]);
    }

    public String getNis() { return nis; }
    public String getNama() { return nama; }

    public void tampil() {
        System.out.println(nis + " | " + nama + " | " + alamat);
    }
}