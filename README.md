# Description Overlay Demo

This demo project shows how to describe a menu item.


### Library

https://github.com/ashwindmk/Android-Description-Overlay-Library


### Setup

Add the library

```gradle
implementation 'com.github.ashwindmk:Android-Description-Overlay-Library:0.1
```

Get TextView

```gradle
TextView mTextView;
...
mTextView = (TextView) findViewById(R.id.textView);
```

Get View from Menu Item

```gradle
private View mInfoView;

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu, menu);
    new Handler().post(new Runnable() {
        @Override
        public void run() {
            mInfoView = findViewById(R.id.info);
        }
    });
    return true;
}
```


### Show sequence of Description Overlays

Call showDescription() when all of views are ready and not null.

```gradle
private void showDescription() {
    DescriptionOverlayConfig descriptionConfig = new DescriptionOverlayConfig();
    descriptionConfig.setDelay(200);
    descriptionConfig.setShape(new CircleShape());
    descriptionConfig.setMaskColor(Color.parseColor("#888888"));

    DescriptionOverlaySequence descriptionSequence = new DescriptionOverlaySequence(this);
    descriptionSequence.setConfig(descriptionConfig);
    descriptionSequence.addSequenceItem(mInfoView, "Info", "This will give you more information", "GOT IT");
    descriptionSequence.addSequenceItem(mTextView, "Text", "This is a simple text", "DONE");
    descriptionSequence.start();
}
```
