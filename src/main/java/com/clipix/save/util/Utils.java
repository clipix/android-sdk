package com.clipix.save.util;

import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ScaleXSpan;
import com.clipix.save.ClipixButton;
import com.clipix.save.R;
import java.util.Locale;

public class Utils {

  public static String getSaveButtonText(Resources resources) {
    String defaultText = "Save"; //en
    String defaultLanguage = Locale.getDefault().getLanguage();
    if (defaultLanguage.equalsIgnoreCase("es")) {
      defaultText = resources.getString(R.string.Spanish);
    } else if (defaultLanguage.equalsIgnoreCase("fr")) {
      defaultText = resources.getString(R.string.French);
    } else if (defaultLanguage.equalsIgnoreCase("he")) {
      defaultText = resources.getString(R.string.Hebrew);
    } else if (defaultLanguage.equalsIgnoreCase("zh")) {
      defaultText = resources.getString(R.string.Chinese);
    } else if (defaultLanguage.equalsIgnoreCase("it")) {
      defaultText = resources.getString(R.string.Italiano);
    } else if (defaultLanguage.equalsIgnoreCase("tr")) {
      defaultText = resources.getString(R.string.Turkish);
    } else if (defaultLanguage.equalsIgnoreCase("de")) {
      defaultText = resources.getString(R.string.Deutsch);
    } else if (defaultLanguage.equalsIgnoreCase("pt")) {
      defaultText = resources.getString(R.string.Portugues);
    } else if (defaultLanguage.equalsIgnoreCase("ko")) {
      defaultText = resources.getString(R.string.Korean);
    } else if (defaultLanguage.equalsIgnoreCase("ja")) {
      defaultText = resources.getString(R.string.Japanese);
    } else if (defaultLanguage.equalsIgnoreCase("ru")) {
      defaultText = resources.getString(R.string.Russian);
    } else if (defaultLanguage.equalsIgnoreCase("ar")) {
      defaultText = resources.getString(R.string.Arabic);
    }
    return defaultText.toUpperCase();
  }

  public static Spannable applyKerning(CharSequence src, float kerning) {
    if (src == null) return null;
    final int srcLength = src.length();
    if (srcLength < 2) return src instanceof Spannable ? (Spannable) src : new SpannableString(src);

    final String nonBreakingSpace = "\u00A0";
    final SpannableStringBuilder builder =
        src instanceof SpannableStringBuilder ? (SpannableStringBuilder) src : new SpannableStringBuilder(src);
    for (int i = src.length() - 1; i >= 1; i--) {
      builder.insert(i, nonBreakingSpace);
      builder.setSpan(new ScaleXSpan(kerning), i, i + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    return builder;
  }

  public static CharSequence getSaveButtonText(ClipixButton.Language language,Resources resources) {
    String defaultText = "Save"; //en
    switch (language){
      case Spanish:
        defaultText = resources.getString(R.string.Spanish);
        break;
      case French:
        defaultText = resources.getString(R.string.French);
        break;
      case Hebrew:
        defaultText = resources.getString(R.string.Hebrew);
        break;
      case Chinese:
        defaultText = resources.getString(R.string.Chinese);
        break;
      case Italiano:
        defaultText = resources.getString(R.string.Italiano);
        break;
      case Turkish:
        defaultText = resources.getString(R.string.Turkish);
        break;
      case Portugues:
        defaultText = resources.getString(R.string.Portugues);
        break;
      case Deutsch:
        defaultText = resources.getString(R.string.Deutsch);
        break;
      case Korean:
        defaultText = resources.getString(R.string.Korean);
        break;
      case Japanese:
        defaultText = resources.getString(R.string.Japanese);
        break;
      case Russian:
        defaultText = resources.getString(R.string.Russian);
        break;
      case Arabic:
        defaultText = resources.getString(R.string.Arabic);
        break;
    }
    return defaultText;
  }

  public static CharSequence getSaveThisButtonText(ClipixButton.Language language,Resources resources) {
    String defaultText = "Save This"; //en
    switch (language){
      case Spanish:
        defaultText = resources.getString(R.string.Spanish_SaveThis);
        break;
      case French:
        defaultText = resources.getString(R.string.French_SaveThis);
        break;
      case Hebrew:
        defaultText = resources.getString(R.string.Hebrew_SaveThis);
        break;
      case Chinese:
        defaultText = resources.getString(R.string.Chinese_SaveThis);
        break;
      case Italiano:
        defaultText = resources.getString(R.string.Italiano_SaveThis);
        break;
      case Turkish:
        defaultText = resources.getString(R.string.Turkish_SaveThis);
        break;
      case Portugues:
        defaultText = resources.getString(R.string.Portugues_SaveThis);
        break;
      case Deutsch:
        defaultText = resources.getString(R.string.Deutsch_SaveThis);
        break;
      case Korean:
        defaultText = resources.getString(R.string.Korean_SaveThis);
        break;
      case Japanese:
        defaultText = resources.getString(R.string.Japanese_SaveThis);
        break;
      case Russian:
        defaultText = resources.getString(R.string.Russian_SaveThis);
        break;
      case Arabic:
        defaultText = resources.getString(R.string.Arabic_SaveThis);
        break;
    }
    return defaultText;
  }

  public static CharSequence getSaveThisButtonText(Resources resources) {
    String defaultText = "Save This"; //en
    String defaultLanguage = Locale.getDefault().getLanguage();
    if (defaultLanguage.equalsIgnoreCase("es")) {
      defaultText = resources.getString(R.string.Spanish_SaveThis);
    } else if (defaultLanguage.equalsIgnoreCase("fr")) {
      defaultText = resources.getString(R.string.French_SaveThis);
    } else if (defaultLanguage.equalsIgnoreCase("he")) {
      defaultText = resources.getString(R.string.Hebrew_SaveThis);
    } else if (defaultLanguage.equalsIgnoreCase("zh")) {
      defaultText = resources.getString(R.string.Chinese_SaveThis);
    } else if (defaultLanguage.equalsIgnoreCase("it")) {
      defaultText = resources.getString(R.string.Italiano_SaveThis);
    } else if (defaultLanguage.equalsIgnoreCase("tr")) {
      defaultText = resources.getString(R.string.Turkish_SaveThis);
    } else if (defaultLanguage.equalsIgnoreCase("de")) {
      defaultText = resources.getString(R.string.Deutsch_SaveThis);
    } else if (defaultLanguage.equalsIgnoreCase("pt")) {
      defaultText = resources.getString(R.string.Portugues_SaveThis);
    } else if (defaultLanguage.equalsIgnoreCase("ko")) {
      defaultText = resources.getString(R.string.Korean_SaveThis);
    } else if (defaultLanguage.equalsIgnoreCase("ja")) {
      defaultText = resources.getString(R.string.Japanese_SaveThis);
    } else if (defaultLanguage.equalsIgnoreCase("ru")) {
      defaultText = resources.getString(R.string.Russian_SaveThis);
    } else if (defaultLanguage.equalsIgnoreCase("ar")) {
      defaultText = resources.getString(R.string.Arabic_SaveThis);
    }
    return defaultText.toUpperCase();
  }
}
