package com.clipix.save;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClipixInstallActivity extends Activity {
  private static String marketUrl = "market://details?id=com.clipix.clipix";

  @Override protected void onCreate(Bundle savedInstanceState) {
    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_clipix_install);
    Button btn_install = (Button) findViewById(R.id.btn_install);
    btn_install.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        try{
          Intent play = new Intent("android.intent.action.VIEW").setData(Uri.parse(marketUrl));
          startActivity(play);
        }
        catch (Exception ex){

        }
        finish();
      }
    });
  }

  @Override public void onBackPressed() {
    super.onBackPressed();
    overridePendingTransition(R.anim.fade_out, 0);
  }
}
