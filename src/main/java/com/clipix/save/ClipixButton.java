package com.clipix.save;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.clipix.save.util.Utils;

public class ClipixButton extends LinearLayout {
  private Clipix clipix;
  private Context context;

  private Style colorStyle = Style.STYLE_GREY;
  private TextView tv_save;
  private RelativeLayout rl_save;
  private ImageView iv_clipix;
  private ImageView iv_arrow;
  private CurrencyType currencyType = CurrencyType.USD;
  private ButtonText buttonText;

  public ClipixButton(Context context) {
    this(context, null);
  }

  public ClipixButton(Context context, AttributeSet attrs) {
    super(context, attrs);
    this.context = context;
    init(context, attrs);
  }

  private void init(Context context, AttributeSet attrs) {
    this.clipix = new Clipix();
    TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.Options, 0, 0);
    colorStyle = Style.values()[array.getInt(R.styleable.Options_color_style, Style.STYLE_GREY.ordinal())];
    buttonText = ButtonText.values()[array.getInt(R.styleable.Options_button_text, ButtonText.SAVE.ordinal())];
    array.recycle();
    initLayout(context);
    setupLayout();
  }

  private void setupLayout() {
    tv_save = (TextView) findViewById(R.id.tv_save);
    rl_save = (RelativeLayout) findViewById(R.id.rl_save);
    iv_clipix = (ImageView) findViewById(R.id.iv_clipix);
    iv_arrow = (ImageView) findViewById(R.id.iv_arrow);
    tv_save.setText(Utils.applyKerning(Utils.getSaveButtonText(getResources()), 1));
    setButtonStyle(colorStyle);
    setButtonText(buttonText);
    setType(ClipType.URL);
    setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        if (v != null) {
          ClipixButton.this.clipix.clip(v.getContext());
        }
      }
    });
  }

  private void setButtonStyle(Style buttonStyle) {
    switch (buttonStyle) {
      case STYLE_GREY:
        rl_save.setBackgroundResource(R.drawable.gray_rounded_bg);
        iv_arrow.setImageResource(R.drawable.ic_arrow_gray);
        break;
      case STYLE_ORANGE:
        rl_save.setBackgroundResource(R.drawable.orange_rounded_bg);
        iv_arrow.setImageResource(R.drawable.ic_arrow_orange);
        break;
      case STYLE_WHITE:
        rl_save.setBackgroundResource(R.drawable.white_rounded_bg);
        tv_save.setTextColor(context.getResources().getColor(R.color.gray));
        iv_arrow.setImageResource(R.drawable.ic_arrow_white);
        break;
    }
  }

  private void initLayout(Context context) {
    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    inflater.inflate(R.layout.clipix_button, this, true);
  }

  public void setType(ClipType type) {
    this.clipix.setType(type);
  }

  public void setNote(String note) {
    this.clipix.setNote(note);
  }

  public String getImageUrl() {
    return this.clipix.getImageUrl();
  }

  public void setImageUrl(String imageUrl) {
    this.clipix.setImageUrl(imageUrl);
  }

  public Uri getImageUri() {
    return this.clipix.getImageUri();
  }

  public void setImageUri(Uri imageUri) {
    this.clipix.setImageUri(imageUri);
  }

  public String getUrl() {
    return this.clipix.getUrl();
  }

  public void setUrl(String url) {
    this.clipix.setUrl(url);
  }

  public String getDescription() {
    return this.clipix.getDescription();
  }

  public void setDescription(String description) {
    this.clipix.setDescription(description);
  }

  public ClipListener getListener() {
    return this.clipix.getListener();
  }

  public void setListener(ClipListener listener) {
    this.clipix.setListener(listener);
  }

  public void reset() {
    this.clipix.reset();
  }

  public static void setDebugMode(boolean debugMode) {
    Clipix.setDebugMode(debugMode);
  }

  public static boolean isDebugMode() {
    return Clipix.isDebugMode();
  }

  public static boolean meetsRequirements() {
    return Clipix.meetsRequirements();
  }

  public void setPrice(double price) {
    this.clipix.setPrice(price);
  }

  public void setLanguage(Language language) {
    tv_save.setText(Utils.applyKerning(Utils.getSaveButtonText(language,getResources()), 1));
  }

  public void setButtonText(ButtonText buttonText) {
    switch (buttonText){
      case SAVE:
        tv_save.setText(Utils.applyKerning(Utils.getSaveButtonText(getResources()), 1));
        break;
      case SAVE_THIS:
        tv_save.setText(Utils.applyKerning(Utils.getSaveThisButtonText(getResources()), 1));
        break;
    }
  }

  public void setButtonText(ButtonText buttonText, Language language) {
    switch (buttonText){
      case SAVE:
        tv_save.setText(Utils.applyKerning(Utils.getSaveButtonText(language,getResources()), 1));
        break;
      case SAVE_THIS:
        tv_save.setText(Utils.applyKerning(Utils.getSaveThisButtonText(language,getResources()), 1));
        break;
    }
  }

  public void setColor(Style style) {
    setButtonStyle(style);
  }


  public void setCurrencyType(CurrencyType currencyType) {
    this.clipix.currencyType = currencyType;
  }

  public enum CurrencyType {
    ARS(7),
    AUD(9),
    BND(17),
    CAD(22),
    CHF(23),
    CLP(24),
    CNY(25),
    COP(26),
    CRC(27),
    CZK(29),
    DOP(32),
    DZD(33),
    EEK(34),
    EGP(35),
    EUR(37),
    GBP(41),
    GTQ(44),
    HKD(45),
    HRK(46),
    HUF(47),
    IDR(48),
    ILS(50),
    INR(51),
    ISK(52),
    JMD(54),
    JOD(55),
    JPY(56),
    KES(57),
    KRW(58),
    KWD(59),
    LBP(60),
    LKR(61),
    LTL(62),
    LVL(63),
    MAD(64),
    MVR(67),
    MXN(68),
    MYR(69),
    NOK(73),
    NPR(74),
    NZD(75),
    OMR(76),
    PAB(77),
    PEN(78),
    PHP(79),
    PKR(80),
    PLN(81),
    PYG(84),
    RUB(86),
    SAR(88),
    SEK(89),
    SGD(90),
    THB(94),
    TND(95),
    TRY(96),
    TTD(97),
    TWD(98),
    USD(99),
    UYU(100),
    VND(102),
    XOF(103),
    ZAR(104);
    public final int currency;

    CurrencyType(int currency) {
      this.currency = currency;
    }
  }

  public enum Style {
    STYLE_GREY,
    STYLE_WHITE,
    STYLE_ORANGE
  };

  public enum ButtonText {
    SAVE,
    SAVE_THIS,
  };

  public enum ClipType {
    URL,
    NOTE,
    IMAGE
  };

  public enum Language {
    English,
    Spanish,
    French,
    Hebrew,
    Chinese,
    Italiano,
    Turkish,
    Deutsch,
    Portugues,
    Korean,
    Japanese,
    Russian,
    Arabic,
  };
}