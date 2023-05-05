public class Ocak {

    private String ad;
    private String tur;
    private int sicaklik;
    private boolean hazir;
    private Cooker cooker;

    public Ocak(String ad, String tur) {
        this.ad = ad;
        this.tur = tur;
        this.sicaklik = 0;
        this.hazir = false;
        this.cooker = new Cooker();
    }

    public String getAd() {
        return ad;
    }

    public String getTur() {
        return tur;
    }

    public int getSicaklik() {
        return sicaklik;
    }

    public boolean isHazir() {
        return hazir;
    }

    public void baslat() {
        System.out.println(ad + " pişirme işlemi başladı.");
        cooker.isin();
    }

    public void durdur() {
        System.out.println(ad + " pişirme işlemi durduruldu.");
        cooker.sogut();
    }

    private class Cooker {

        private boolean calisiyor;

        public Cooker() {
            this.calisiyor = false;
        }

        public void isin() {
            System.out.println(ad + " pişirici çalışıyor.");
            this.calisiyor = true;
            while (calisiyor && sicaklik < 100) {
                sicaklik += 10;
                System.out.println("pişirme"+ " sıcaklık: " + sicaklik);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            hazir = true;
            System.out.println(ad + " yemek hazır.");
        }

        public void sogut() {
            System.out.println(ad + " pişirici durduruldu.");
            this.calisiyor = false;
        }

        public boolean isCalisiyor() {
            return calisiyor;
        }
    }

    public static void main(String[] args) {
        Ocak ocak = new Ocak("Spagetti", "İtalyan");
        ocak.baslat();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ocak.durdur();
    }
}
