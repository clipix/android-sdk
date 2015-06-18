package com.clipix.save;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import com.clipix.save.exceptions.NotInstalledException;
import com.clipix.save.exceptions.SourceUrlException;
import java.util.Locale;

public class Clipix {
  private static boolean debugMode;
  private static final String INTENT_CLIP_IT = "com.clipix.action.CLIP_IT";
  private static final String CLIPIX_EXTRA_URL = "com.clipix.URL";
  private static final String CLIPIX_EXTRA_PRICE = "com.clipix.PRICE";
  private static final String CLIPIX_EXTRA_IMAGE = "com.clipix.EXTRA_IMAGE";
  private static final String CLIPIX_EXTRA_URI = "com.clipix.EXTRA_URI";
  private static final String CLIPIX_EXTRA_DESCRIPTION = "com.clipix.EXTRA_DESCRIPTION";
  private static final String CLIPIX_EXTRA_CURRENCY_TYPE = "com.clipix.EXTRA_CURRENCY_TYPE";
  private static final String CLIPIX_EXTRA_PACKAGE = "com.clipix.EXTRA_PACKAGE";
  private static final String CLIPIX_EXTRA_TYPE = "com.clipix.EXTRA_TYPE";
  private static final String TYPE_IMAGE = "TYPE_IMAGE";
  private static final String TYPE_NOTE = "TYPE_NOTE";
  private static final String TYPE_URL = "TYPE_URL";
  private static final int MIN_CLIPIX_VERSION = 43;

  private String imageUrl;
  private Uri imageUri;
  private String url;
  private String description;
  private ClipListener listener;
  private double price = 0;
  private String note = "";
  private ClipixButton.ClipType type;
  private Context context;
  public ClipixButton.CurrencyType currencyType = ClipixButton.CurrencyType.USD;

  public void clip(Context context) {
    this.context = context;
    if (!meetsRequirements()) {
      Locale.getDefault().getLanguage();
      return;
    }
    Intent intent = new Intent();
    intent.setAction(INTENT_CLIP_IT);
    addType(intent);
    addUrl(intent);
    addPrice(intent);
    addImage(intent);
    addDescription(intent);
    addCurrencyType(intent);
    addExtras(context, intent);
    if (handleAppInstall()) return;
    startClipix(intent);
  }

  private void startClipix(Intent intent) {
    if (this.listener != null) {
      this.listener.onStart();
    }
    try {
      this.context.startActivity(intent);
      if (this.listener != null) {
        this.listener.onComplete(true);
      }
    } catch (Exception e) {
      if (this.listener != null) {
        this.listener.onComplete(false);
      }
    }
  }

  private boolean handleAppInstall() {
    if (!clipixInstalled(this.context)) {
      if (this.listener != null) {
        this.listener.onException(new NotInstalledException());
      }
      forceInstallClipix(context);
      return true;
    }
    return false;
  }

  private void addExtras(Context context, Intent intent) {
    intent.putExtra(CLIPIX_EXTRA_PACKAGE, context.getPackageName());
  }

  private void addType(Intent intent) {
    switch (type) {
      case IMAGE:
        intent.putExtra(CLIPIX_EXTRA_TYPE, TYPE_IMAGE);
        break;
      case NOTE:
        intent.putExtra(CLIPIX_EXTRA_TYPE, TYPE_IMAGE);
        break;
      case URL:
        intent.putExtra(CLIPIX_EXTRA_TYPE, TYPE_IMAGE);
        break;
    }
  }

  private void addCurrencyType(Intent intent) {
    if (this.currencyType != ClipixButton.CurrencyType.USD) {
      intent.putExtra(CLIPIX_EXTRA_CURRENCY_TYPE, this.currencyType.currency);
    }
  }

  private void addDescription(Intent intent) {
    if (this.description != null) {
      intent.putExtra(CLIPIX_EXTRA_DESCRIPTION, this.description);
    }
  }

  private void addImage(Intent intent) {
    if ((this.imageUrl != null) && (this.imageUrl.length() > 0)) {
      intent.putExtra(CLIPIX_EXTRA_IMAGE, this.imageUrl);
    } else if (this.imageUri != null) {
      intent.putExtra(CLIPIX_EXTRA_URI, this.imageUri);
    }
  }

  private void addPrice(Intent intent) {
    if (this.price > 0) {
      intent.putExtra(CLIPIX_EXTRA_PRICE, this.price);
    }
  }

  private void addUrl(Intent intent) {
    if (this.url == null) {
      if (this.listener != null) {
        this.listener.onException(new SourceUrlException());
      }
    } else {
      if (!url.startsWith("http://") && !url.startsWith("https://")) {
        url = "http://" + url;
      }
      intent.putExtra(CLIPIX_EXTRA_URL, this.url);
    }
  }

  private boolean forceInstallClipix(Context context) {
    try {
      openMarketActivity(context);
      return true;
    } catch (Exception e) {
    }
    return false;
  }

  private void openMarketActivity(Context context) {
    context.startActivity(new Intent(context,ClipixInstallActivity.class));
  }

  public static boolean meetsRequirements() {
    return Build.VERSION.SDK_INT >= 8;
  }

  private static boolean clipixInstalled(Context context) {
    if (!meetsRequirements()) {
      return false;
    }
    boolean installed = false;
    try {
      PackageInfo info = context.getPackageManager().getPackageInfo("com.clipix.clipix", 0);
      if (info != null) {
        installed = info.versionCode >= MIN_CLIPIX_VERSION;
      }
    } catch (Exception e) {
      try {
        PackageInfo info = context.getPackageManager().getPackageInfo("com.clipix.clipix.test", 0);
        if (info != null) {
          installed = info.versionCode >= MIN_CLIPIX_VERSION;
        }
      } catch (Exception ex) {
        if (debugMode) {
          e.printStackTrace();
        }
        installed = false;
      }
    }
    return installed;
  }

  public void reset() {
    this.url = null;
    this.imageUri = null;
    this.imageUrl = null;
    this.description = null;
    this.listener = null;
  }

  public static boolean isDebugMode() {
    return debugMode;
  }

  public static void setDebugMode(boolean debugMode) {
    debugMode = debugMode;
  }

  public String getImageUrl() {
    return this.imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUri = null;
    this.imageUrl = imageUrl;
  }

  public Uri getImageUri() {
    return this.imageUri;
  }

  public void setImageUri(Uri imageUri) {
    this.imageUrl = null;
    this.imageUri = imageUri;
  }

  public String getUrl() {
    return this.url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ClipListener getListener() {
    return this.listener;
  }

  public void setListener(ClipListener listener) {
    this.listener = listener;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public ClipixButton.ClipType getType() {
    return type;
  }

  public void setType(ClipixButton.ClipType type) {
    this.type = type;
  }
}
