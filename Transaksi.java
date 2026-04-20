public class Transaksi {
    private String kode, nis, kodeBuku, tglPinjam, tglKembali;
    private int status;

    public Transaksi(String kode, String nis, String kodeBuku, String tglPinjam, String tglKembali, int status) {
        this.kode = kode;
        this.nis = nis;
        this.kodeBuku = kodeBuku;
        this.tglPinjam = tglPinjam;
        this.tglKembali = tglKembali;
        this.status = status;
    }

    public String toFile() {
        return kode + "," + nis + "," + kodeBuku + "," + tglPinjam + "," + tglKembali + "," + status;
    }

    public static Transaksi fromFile(String data) {
        String[] d = data.split(",");
        return new Transaksi(d[0], d[1], d[2], d[3], d[4], Integer.parseInt(d[5]));
    }

    public String getNis() { return nis; }
    public int getStatus() { return status; }

    public void setStatus(int status) {
        this.status = status;
    }

    public void tampil() {
        System.out.println(kode + " | " + nis + " | " + kodeBuku + " | " + status);
    }

    public Object getKode() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getKode'");
    }
}