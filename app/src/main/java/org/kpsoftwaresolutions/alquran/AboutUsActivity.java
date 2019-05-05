package org.kpsoftwaresolutions.alquran;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class AboutUsActivity extends AppCompatActivity {

    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-5910423341335020/2243107810");

        mAdView = findViewById(R.id.adViewKP);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }
    private void connect2web(String s) {
        Uri uri = Uri.parse(s); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void KPWebsite(View view) {
        connect2web("https://www.kpsoftwaresolutions.org/");
    }

    public void KPFacebook(View view) {
        connect2web("https://www.facebook.com/kpsoftwaresolutions/");
    }

    public void KPLinkedIn(View view) {
        connect2web("https://www.linkedin.com/in/kp-software-solutions-8455a5144/");
    }

    public void KPPlayStore(View view) {
        connect2web("https://play.google.com/store/apps/dev?id=7174269229329822451");
    }

    public void KPTwitter(View view) {
        connect2web("https://twitter.com/kpsoft_soln");
    }
}