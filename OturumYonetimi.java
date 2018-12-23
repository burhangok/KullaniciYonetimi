package ismek.kullaniciyonetimi;

import android.content.Context;
import android.content.SharedPreferences;

public class OturumYonetimi {

    SharedPreferences preferencesNesnesi;
    SharedPreferences.Editor duzenleyici;
    int PRIVATE_MODE=0;
    Context contextNesnesi;

    public static final String PREF_ADI="Login";
    public static final String KEY_LOGIN="doLogin";

    public OturumYonetimi(Context contextNesnesi) {
        this.contextNesnesi = contextNesnesi;
        this.preferencesNesnesi=contextNesnesi.getSharedPreferences(PREF_ADI,PRIVATE_MODE);
        this.duzenleyici=preferencesNesnesi.edit();
    }


    public void oturumBaslat () {

    duzenleyici.putString(KEY_LOGIN,"success");
    duzenleyici.commit();
    }

    public boolean girisKontrol() {

        String girisDurumu = preferencesNesnesi.getString(KEY_LOGIN,null);

        if(girisDurumu==null) return false;
        else return true;

    }

}
