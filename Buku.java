public class Buku {
    private String kode, judul, jenis;

    public Buku(String kode, String judul, String jenis) {
        this.kode = kode;
        this.judul = judul;
        this.jenis = jenis;
    }

    public String toFile() {
        return kode + "," + judul + "," + jenis;
    }

    public static Buku fromFile(String data) {
        String[] d = data.split(",");
        return new Buku(d[0], d[1], d[2]);
    }

    public String getKode() { return kode; }

    public void tampil() {
        System.out.println(kode + " | " + judul + " | " + jenis);
    }
}