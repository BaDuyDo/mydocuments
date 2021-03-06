class NhanVien {
    String tenNhanVien;
    double heSoLuong;
    public static final double LUONG_CO_BAN = 750000;
    public static final double LUONG_MAX = 20000000;

    public NhanVien(String ten, double heso) {
        tenNhanVien = ten;
        heSoLuong = heso;
    }

    public double tinhLuong() {
        return LUONG_CO_BAN * heSoLuong;
    }

    public boolean tangLuong(double heso) {
        heSoLuong = heSoLuong + heso;
        if (tinhLuong() > LUONG_MAX) {
            System.out.println("khong thay doi he so luong!");
            heSoLuong = heSoLuong - heso;
            return false;
        } else
            return true;
    }

    public void inTTin() {
        System.out.println(" ten cua nhan vien:" + tenNhanVien);
        System.out.println("luong cua nhan vien la:" + tinhLuong());
        System.out.println("he so luong:" + heSoLuong);

    }
}

class TruongPhong extends NhanVien {
    private double phuCap;
    private double soNamDuongChuc;

    public TruongPhong(String ten, double heso, double phucap) {
        super(ten, heso);
        this.phuCap = phucap;
    }

    public double tinhLuong() {
        return LUONG_CO_BAN * heSoLuong + phuCap;
    }

    public void inTTin() {
        System.out.println("ten cua truong phong:" + tenNhanVien);
        System.out.println("luong cua truong phongL" + tinhLuong());
        System.out.println("he so luong:" + heSoLuong);
        System.out.println("phu cap:" + phuCap);

    }

}

public class PhongBan {

    private String tenPhongBan;
    private byte soNhanVien;
    public static final byte SO_NV_MAX = 100;
    private NhanVien[] dsnv;

    public boolean themNhanVien(NhanVien nv) {
        if (soNhanVien < SO_NV_MAX) {
            dsnv[soNhanVien] = nv;
            soNhanVien++;
            return true;
        } else
            return false;
    }

    public boolean xoaNhanVien(NhanVien nv) {
        if (soNhanVien > 0) {
            for (int i = 0; i < soNhanVien; ++i) {
                if (dsnv[i] == nv) {
                    dsnv[i] = null;
                    NhanVien tmp;
                    soNhanVien--;
                    while (i < soNhanVien) {
                        dsnv[i] = dsnv[i + 1];
                        i++;
                    }
                    dsnv[soNhanVien] = null;
                    return true;
                }
            }
            System.out.println("Nhan Vien Khon co trong danh sach!");
            return false;
        } else {
            System.out.println("phong khong co nhan vien");
            return false;
        }

    }

    public double tongLuong() {
        double tong = 0.0;
        for (int i = 0; i < soNhanVien; ++i) {
            tong += dsnv[i].tinhLuong();
        }
        return tong;
    }

    public void inTTin() {

        System.out.println("Ten phong ban la:" + tenPhongBan);
        System.out.println("So nhan vien cua phog ban la:" + soNhanVien);
        for (int i = 0; i < soNhanVien; i++) {
            dsnv[i].inTTin();
        }
    }

    public PhongBan(String ten) {
        tenPhongBan = ten;
        dsnv = new NhanVien[SO_NV_MAX];

    }

    public static void main(String[] args) {
        TruongPhong tp = new TruongPhong("khanh", 6, 7);
        NhanVien nv1 = new NhanVien("khanh1",1);
        NhanVien nv2 = new NhanVien("khanh2",2);
        PhongBan vanphong = new PhongBan("van phong");
        vanphong.themNhanVien(nv1);
        vanphong.themNhanVien(nv2);
        vanphong.themNhanVien(tp);
        vanphong.inTTin();

    }

}
