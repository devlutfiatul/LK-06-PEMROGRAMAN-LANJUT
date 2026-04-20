public class Pegawai {
    private String nip, nama, tgl;

    public Pegawai(String nip, String nama, String tgl) {
        this.nip = nip;
        this.nama = nama;
        this.tgl = tgl;
    }

    public String toFile() {
        return nip + "," + nama + "," + tgl;
    }

    public static Pegawai fromFile(String data) {
        String[] d = data.split(",");
        return new Pegawai(d[0], d[1], d[2]);
    }

    public String getNip() { return nip; }
}