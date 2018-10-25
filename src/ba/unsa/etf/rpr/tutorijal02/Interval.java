package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    double pocetnaTacka, krajnjaTacka;
    boolean pocetnaTackaPripada, krajnjaTackaPripada;

    public Interval() {
        this.pocetnaTacka = 0;
        this.krajnjaTacka = 0;

        this.pocetnaTackaPripada = false;
        this.krajnjaTackaPripada = false;
    }

    public Interval(double pocetnaTacka, double krajnjaTacka, boolean pocetnaTackaPripada, boolean krajnjaTackaPripada) {
        if (pocetnaTacka > krajnjaTacka)
            throw new IllegalArgumentException("Pocetna tacka treba da bude prije krajnje tacke");

        this.pocetnaTacka = pocetnaTacka;
        this.krajnjaTacka = krajnjaTacka;

        this.pocetnaTackaPripada = pocetnaTackaPripada;
        this.krajnjaTackaPripada = krajnjaTackaPripada;
    }

    public void setPocetnaTacka(double pocetnaTacka) {
        this.pocetnaTacka = pocetnaTacka;
    }

    public void setKrajnjaTacka(double krajnjaTacka) {
        this.krajnjaTacka = krajnjaTacka;
    }

    public void setPocetnaTackaPripada(boolean pocetnaTackaPripada) {
        this.pocetnaTackaPripada = pocetnaTackaPripada;
    }

    public void setKrajnjaTackaPripada(boolean krajnjaTackaPripada) {
        this.krajnjaTackaPripada = krajnjaTackaPripada;
    }

    public double getPocetnaTacka() {
        return this.pocetnaTacka;
    }

    public double getKrajnjaTacka() {
        return this.krajnjaTacka;
    }

    public boolean daLiPocetnaTackaPripada() {
        return this.pocetnaTackaPripada;
    }

    public boolean daLiKrajnjaTackaPripada() {
        return this.krajnjaTackaPripada;
    }

    public boolean isNull() {
        return this.pocetnaTacka == this.krajnjaTacka && !this.pocetnaTackaPripada && !this.krajnjaTackaPripada;
    }

    public boolean isIn(double tacka) {
        if (this.pocetnaTackaPripada && tacka == this.pocetnaTacka)
            return true;
        if (this.krajnjaTackaPripada && tacka == this.krajnjaTacka)
            return true;

        return tacka > this.pocetnaTacka && tacka < this.krajnjaTacka;
    }

    public Interval intersect(Interval interval) {
        Interval noviInterval = new Interval();

        if (this.pocetnaTacka > interval.pocetnaTacka) {
            noviInterval.pocetnaTacka = this.pocetnaTacka;
            noviInterval.pocetnaTackaPripada = this.pocetnaTackaPripada;
        }
        else if (this.pocetnaTacka < interval.pocetnaTacka) {
            noviInterval.pocetnaTacka = interval.pocetnaTacka;
            noviInterval.pocetnaTackaPripada = interval.pocetnaTackaPripada;
        }
        else {
            noviInterval.pocetnaTacka = this.pocetnaTacka;
            noviInterval.pocetnaTackaPripada = this.pocetnaTackaPripada && interval.pocetnaTackaPripada;
        }

        if (this.krajnjaTacka < interval.krajnjaTacka) {
            noviInterval.krajnjaTacka = this.krajnjaTacka;
            noviInterval.krajnjaTackaPripada = this.krajnjaTackaPripada;
        }
        else if (this.krajnjaTacka > interval.krajnjaTacka) {
            noviInterval.krajnjaTacka = interval.krajnjaTacka;
            noviInterval.krajnjaTackaPripada = interval.krajnjaTackaPripada;
        }
        else {
            noviInterval.krajnjaTacka = this.krajnjaTacka;
            noviInterval.krajnjaTackaPripada = this.krajnjaTackaPripada && interval.krajnjaTackaPripada;
        }

        if (noviInterval.pocetnaTacka > noviInterval.krajnjaTacka)
            return new Interval();

        return noviInterval;
    }

    public static Interval intersect(Interval prviInterval, Interval drugiInterval) {
        Interval noviInterval = new Interval();

        if (prviInterval.pocetnaTacka > drugiInterval.pocetnaTacka) {
            noviInterval.pocetnaTacka = prviInterval.pocetnaTacka;
            noviInterval.pocetnaTackaPripada = prviInterval.pocetnaTackaPripada;
        }
        else if (prviInterval.pocetnaTacka < drugiInterval.pocetnaTacka) {
            noviInterval.pocetnaTacka = drugiInterval.pocetnaTacka;
            noviInterval.pocetnaTackaPripada = drugiInterval.pocetnaTackaPripada;
        }
        else {
            noviInterval.pocetnaTacka = prviInterval.pocetnaTacka;
            noviInterval.pocetnaTackaPripada = prviInterval.pocetnaTackaPripada && drugiInterval.pocetnaTackaPripada;
        }

        if (prviInterval.krajnjaTacka < drugiInterval.krajnjaTacka) {
            noviInterval.krajnjaTacka = prviInterval.krajnjaTacka;
            noviInterval.krajnjaTackaPripada = prviInterval.krajnjaTackaPripada;
        }
        else if (prviInterval.krajnjaTacka > drugiInterval.krajnjaTacka) {
            noviInterval.krajnjaTacka = drugiInterval.krajnjaTacka;
            noviInterval.krajnjaTackaPripada = drugiInterval.krajnjaTackaPripada;
        }
        else {
            noviInterval.krajnjaTacka = prviInterval.krajnjaTacka;
            noviInterval.krajnjaTackaPripada = prviInterval.krajnjaTackaPripada && drugiInterval.krajnjaTackaPripada;
        }

        if (noviInterval.pocetnaTacka > noviInterval.krajnjaTacka)
            return new Interval();

        return noviInterval;
    }

    @Override
    public String toString() {
        if (this.isNull())
            return "()";

        return  (pocetnaTackaPripada ? "[" : "(") + pocetnaTacka + "," + krajnjaTacka + (krajnjaTackaPripada ? "]" : ")");
    }

    @Override
    public boolean equals(Object o) {
        Interval interval = (Interval) o;

        return this.pocetnaTacka == interval.pocetnaTacka && this.krajnjaTacka == interval.krajnjaTacka &&
            this.krajnjaTackaPripada == interval.krajnjaTackaPripada && this.pocetnaTackaPripada == interval.pocetnaTackaPripada;
    }
}
