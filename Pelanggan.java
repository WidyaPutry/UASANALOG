
public class Pelanggan {
	String NamaPembeli;
	String JenisPakaian;
	String KodePakaian;
	String Ukuran;
	int Jumlah;
	int HargaTotal;
	
	public Pelanggan(String namaPembeli, String jenisPakaian, String kodePakaian, String ukuran, int jumlah,
			int hargaTotal) {
		super();
		NamaPembeli = namaPembeli;
		JenisPakaian = jenisPakaian;
		KodePakaian = kodePakaian;
		Ukuran = ukuran;
		Jumlah = jumlah;
		HargaTotal = hargaTotal;
	}
	
	public String getNamaPembeli() {
		return NamaPembeli;
	}
	public void setNamaPembeli(String namaPembeli) {
		NamaPembeli = namaPembeli;
	}
	public String getJenisPakaian() {
		return JenisPakaian;
	}
	public void setJenisPakaian(String jenisPakaian) {
		JenisPakaian = jenisPakaian;
	}
	public String getKodePakaian() {
		return KodePakaian;
	}
	public void setKodePakaian(String kodePakaian) {
		KodePakaian = kodePakaian;
	}
	public String getUkuran() {
		return Ukuran;
	}
	public void setUkuran(String ukuran) {
		Ukuran = ukuran;
	}
	public int getJumlah() {
		return Jumlah;
	}
	public void setJumlah(int jumlah) {
		Jumlah = jumlah;
	}
	public int getHargaTotal() {
		return HargaTotal;
	}
	public void setHargaTotal(int hargaTotal) {
		HargaTotal = hargaTotal;
	}
	
	
}
