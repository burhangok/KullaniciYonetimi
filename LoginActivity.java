package ismek.kullaniciyonetimi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    public EditText kullaniciAdi,sifre;
    public Button girisYap;

    public String girilenAd, girilenSifre;

    public OturumYonetimi oturum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        oturum = new OturumYonetimi(getApplicationContext());


        if(oturum.girisKontrol()==true){
            Intent gecis = new Intent(LoginActivity.this,ScrollingActivity.class);

            startActivity(gecis);
        }



        kullaniciAdi = findViewById(R.id.kullaniciAdi);
        sifre= findViewById(R.id.kullaniciSifre);

        girisYap= findViewById(R.id.girisButonu);

        girisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                girilenAd = kullaniciAdi.getText().toString();
                girilenSifre= sifre.getText().toString();

                if(girilenAd.equals("ismek") && girilenSifre.equals("123")) {
                    oturum.oturumBaslat();

                    Intent gecis = new Intent(LoginActivity.this,ScrollingActivity.class);

                    startActivity(gecis);
                }

            }
        });

    }
}
